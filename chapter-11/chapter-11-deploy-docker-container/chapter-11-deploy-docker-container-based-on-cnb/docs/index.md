[TOC]

---

## 参考文档

1. [Packaging OCI Images](https://docs.spring.io/spring-boot/maven-plugin/build-image.html)
2. 可以打开`spring-boot-maven-plugin-3.4.3.jar`，查找`META-INF\maven\plugin.xml`查看定义，或者查看其帮助文档`META-INF\maven\org.springframework.boot\spring-boot-maven-plugin\plugin-help.xml`。

## 其它

1. 对于OCI而言，可以不用在`spring-boot-maven-plugin`中添加`<goal>repackage</goal>`。
2. `executable`的默认值就是`false`。
3. `mvn spring-boot:build-image package`命令的执行速度较慢，也容易失败。多执行几次就可以了。
4. 无法使用`docker exec -it {container-id} /bin/sh`等进入容器内部。 
    直接执行会报如下异常：
    ``` text
    OCI runtime exec failed: exec failed: unable to start container process: exec: "sh": executable file not found in $PATH: unknown
    ```