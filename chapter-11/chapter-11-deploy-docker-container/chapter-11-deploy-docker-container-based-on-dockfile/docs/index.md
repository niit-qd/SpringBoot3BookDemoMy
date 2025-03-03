[TOC]

---

## 各版本Dockfile脚本

*注意，不同版本SpringBoot对应JDK可能不一样。在出错的时候，可以先看一下提示，是否存在class文件版本不符合的情况发生。*

1. 2.7.18
    [2. Dockerfiles](https://docs.spring.io/spring-boot/docs/2.7.18/reference/html/container-images.html#container-images.dockerfiles)
    ``` dockerfile
    FROM eclipse-temurin:11-jre as builder
    WORKDIR application
    ARG JAR_FILE=target/*.jar
    COPY ${JAR_FILE} application.jar
    RUN java -Djarmode=layertools -jar application.jar extract

    FROM eclipse-temurin:11-jre
    WORKDIR application
    COPY --from=builder application/dependencies/ ./
    COPY --from=builder application/spring-boot-loader/ ./
    COPY --from=builder application/snapshot-dependencies/ ./
    COPY --from=builder application/application/ ./
    ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
    ```

2. 3.0.13
    [2. Dockerfiles](https://docs.spring.io/spring-boot/docs/3.0.13/reference/html/container-images.html#container-images.dockerfiles)
    ``` dockerfile
    FROM eclipse-temurin:17-jre as builder
    WORKDIR application
    ARG JAR_FILE=target/*.jar
    COPY ${JAR_FILE} application.jar
    RUN java -Djarmode=layertools -jar application.jar extract

    FROM eclipse-temurin:17-jre
    WORKDIR application
    COPY --from=builder application/dependencies/ ./
    COPY --from=builder application/spring-boot-loader/ ./
    COPY --from=builder application/snapshot-dependencies/ ./
    COPY --from=builder application/application/ ./
    ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
    ```
3. 3.3
    [Dockerfiles](https://docs.spring.io/spring-boot/3.3/reference/packaging/container-images/dockerfiles.html)
    ``` dockerfile
    # Perform the extraction in a separate builder container
    FROM bellsoft/liberica-openjre-debian:17-cds AS builder
    WORKDIR /builder
    # This points to the built jar file in the target folder
    # Adjust this to 'build/libs/*.jar' if you're using Gradle
    ARG JAR_FILE=target/*.jar
    # Copy the jar file to the working directory and rename it to application.jar
    COPY ${JAR_FILE} application.jar
    # Extract the jar file using an efficient layout
    RUN java -Djarmode=tools -jar application.jar extract --layers --destination extracted

    # This is the runtime container
    FROM bellsoft/liberica-openjre-debian:17-cds
    WORKDIR /application
    # Copy the extracted jar contents from the builder container into the working directory in the runtime container
    # Every copy step creates a new docker layer
    # This allows docker to only pull the changes it really needs
    COPY --from=builder /builder/extracted/dependencies/ ./
    COPY --from=builder /builder/extracted/spring-boot-loader/ ./
    COPY --from=builder /builder/extracted/snapshot-dependencies/ ./
    COPY --from=builder /builder/extracted/application/ ./
    # Start the application jar - this is not the uber jar used by the builder
    # This jar only contains application code and references to the extracted jar files
    # This layout is efficient to start up and CDS friendly
    ENTRYPOINT ["java", "-jar", "application.jar"]
    ```
    [CDS](https://docs.spring.io/spring-boot/3.3/reference/packaging/container-images/dockerfiles.html#packaging.container-images.dockerfiles.cds)
    ``` dockerfile
    # Perform the extraction in a separate builder container
    FROM bellsoft/liberica-openjre-debian:17-cds AS builder
    WORKDIR /builder
    # This points to the built jar file in the target folder
    # Adjust this to 'build/libs/*.jar' if you're using Gradle
    ARG JAR_FILE=target/*.jar
    # Copy the jar file to the working directory and rename it to application.jar
    COPY ${JAR_FILE} application.jar
    # Extract the jar file using an efficient layout
    RUN java -Djarmode=tools -jar application.jar extract --layers --destination extracted

    # This is the runtime container
    FROM bellsoft/liberica-openjre-debian:17-cds
    WORKDIR /application
    # Copy the extracted jar contents from the builder container into the working directory in the runtime container
    # Every copy step creates a new docker layer
    # This allows docker to only pull the changes it really needs
    COPY --from=builder /builder/extracted/dependencies/ ./
    COPY --from=builder /builder/extracted/spring-boot-loader/ ./
    COPY --from=builder /builder/extracted/snapshot-dependencies/ ./
    COPY --from=builder /builder/extracted/application/ ./
    # Execute the CDS training run
    RUN java -XX:ArchiveClassesAtExit=application.jsa -Dspring.context.exit=onRefresh -jar application.jar
    # Start the application jar with CDS enabled - this is not the uber jar used by the builder
    # This jar only contains application code and references to the extracted jar files
    # This layout is efficient to start up and CDS friendly
    ENTRYPOINT ["java", "-XX:SharedArchiveFile=application.jsa", "-jar", "application.jar"]
    ```

---

## executable

SpringBoot 官方描述：
> The tools mode can not be used with a [fully executable Spring Boot archive](https://docs.spring.io/spring-boot/how-to/deployment/installing.html) that includes a launch script. Disable launch script configuration when building a jar file that is intended to be used with the extract tools mode command.

查看`spring-boot-maven-plugin`-`3.4.3`的默认配置来看，`executable`的默认值是`false`。 
所以，默认可以不用设置。如果非要设置，可以如下：
``` xml
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <executions>
                    <execution>
                        <goals>
                            <goal>repackage</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
		            <executable>false</executable>
	            </configuration>
            </plugin>
        </plugins>
    </build>
```

配置定义参考：
`.m2\repository\org\springframework\boot\spring-boot-maven-plugin\3.4.3\spring-boot-maven-plugin-3.4.3.jar` `\META-INF\maven\plugin.xml`
``` xml
...
    <mojo>
    ...
      <parameters>
        ...
        <parameter>
          <name>executable</name>
          <type>boolean</type>
          <since>1.3.0</since>
          <required>false</required>
          <editable>true</editable>
          <description>Make a fully executable jar for *nix machines by prepending a launch script to the
jar.
&lt;p&gt;
Currently, some tools do not accept this format so you may not always be able to
use this technique. For example, {@code jar -xf} may silently fail to extract a jar
or war that has been made fully-executable. It is recommended that you only enable
this option if you intend to execute it directly, rather than running it with
{@code java -jar} or deploying it to a servlet container.</description>
        </parameter>
        ...
      <parameters>
      <configuration>
        ...
        <executable implementation="boolean" default-value="false"/>
        ...
      </configuration>
      ...
    </mojo>
...
```
---

## 与Docker相关的知识

[Dockerfile 的 RUN 和 CMD、ENTRYPOINT](https://cloud.tencent.com/developer/article/1795329)
[多阶段构建](https://docker-practice.github.io/zh-cn/image/multistage-builds/)
[Spring Boot 分层构建容器镜像官方文档学习笔记](https://www.cnblogs.com/cbc-onne/p/15652369.html)
Guides: [Spring Boot with Docker](https://spring.io/guides/gs/spring-boot-docker)

---

## 一些错误

1. 在`spring-boot-dependencies`的`3.4.1`版本下错误引入`spring-boot-jarmode-layertools`问题
    注：由于此问题不再复现，这里无法还原错误信息。*为何不再复现，不知，不知，不知。。。*
    尽管`3.4.1`版本下只包含`spring-boot-jarmode-tools`，但是生成的jar包包含的却是`spring-boot-jarmode-layertools`，导致`docker build`命令失败。
    暂未找到原因。
    如果出现，可以强制引入`spring-boot-jarmode-tools`即可：
    ``` xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-jarmode-tools</artifactId>
            <!-- <version>3.4.1</version> -->
        </dependency>
    ```


