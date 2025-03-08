[TOC]

---

## GraalVM 安装

1. 下载地址
    - [Download Oracle GraalVM](https://www.graalvm.org/downloads/)
        对于`Windows`，下载 `Java 21` 或 `Java 23`。
    - [Java Downloads](https://www.oracle.com/java/technologies/downloads/)
        对于`Windows`，下载 [GraalVM for JDK 23](https://www.oracle.com/cn/java/technologies/downloads/#graalvmjava23) 或 [GraalVM for JDK 21](https://www.oracle.com/cn/java/technologies/downloads/#graalvmjava21)。
2. Installing
    [Installing](https://www.graalvm.org/latest/getting-started/#installing)

3. 先决条件
    [Prerequisites](https://www.graalvm.org/latest/reference-manual/native-image/#prerequisites)
    1. Linux
        安装`gcc`。
        > On Oracle Linux use the `yum` package manager:
        > 
        > ``` shell
        > sudo yum install gcc glibc-devel zlib-devel
        > ```
        > 
        > Some Linux distributions may additionally require `libstdc++-static`. You can install `libstdc> ++-static` if the optional repositories are enabled *(ol7_optional_latest* on Oracle Linux 7, > *ol8_codeready_builder* on Oracle Linux 8, and *ol9_codeready_builder* on Oracle Linux 9).
        > 
        > On Ubuntu Linux use the `apt-get` package manager:
        > 
        > ```shell
        > sudo apt-get install build-essential zlib1g-dev
        > ```
        > 
        > On other Linux distributions use the dnf package manager:
        > 
        > ```
        > sudo dnf install gcc glibc-devel zlib-devel libstdc++-static
        > ```
    2. MacOS
        On macOS use `xcode`:

        ``` shell
        xcode-select --install
        ```
    3. Windows
        安装`Visual Studio 2022`，并选择`使用C++的桌面应用`安装。
        > **Windows**
        > To use Native Image on Windows, install [Visual Studio 2022](https://visualstudio.microsoft.com/vs/) version 17.6.0 or later, and Microsoft Visual C++ (MSVC). There are two installation > options:
        > 
        > Install the Visual Studio Build Tools with the Windows 11 SDK (or later version)
        > Install Visual Studio with the Windows 11 SDK (or later version)
        > Native Image runs in both a PowerShell or Command Prompt and will automatically set up build > environments on Windows, given that it can find a suitable Visual Studio installation.


---

## 编译运行（示例）

### Windows

1. 环境配置
    - 操作系统：Windows 10 企业版 LTSC
    - 内存：8G
    - GraalVM：[GraalVM for JDK 23](https://www.oracle.com/cn/java/technologies/downloads/#graalvmjava23)
2. 编译过程
    ``` log
    D:\chapter-11\chapter-11-gravvlvm>  mvn -Pnative native:compile
    [INFO] Scanning for projects...
    [WARNING]
    [WARNING] Some problems were encountered while building the effective model for org.example:chapter-11-gravvlvm:jar:1.0-SNAPSHOT
    [WARNING] 'build.plugins.plugin.version' for org.graalvm.buildtools:native-maven-plugin is missing. @ line 46, column 21[WARNING] 'build.plugins.plugin.version' for org.springframework.boot:spring-boot-maven-plugin is missing. @ line 58, column 21
    [WARNING]
    [WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
    [WARNING]
    [WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
    [WARNING]
    [WARNING] The requested profile "native" could not be activated because it does not exist.
    [INFO]
    [INFO] ------------------< org.example:chapter-11-gravvlvm >-------------------
    [INFO] Building chapter-11-gravvlvm 1.0-SNAPSHOT
    [INFO]   from pom.xml
    [INFO] --------------------------------[ jar ]---------------------------------
    [INFO]
    [INFO] >>> native:0.10.5:compile (default-cli) > package @ chapter-11-gravvlvm >>>
    [INFO]
    [INFO] --- native:0.10.5:add-reachability-metadata (default) @ chapter-11-gravvlvm ---
    [INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.12]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.12]: Configuration directory is ch.qos.logback\logback-classic\1.4.9
    [INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.18.2]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.18.2]: Configuration directory is com.fasterxml.jackson.core\jackson-databind\2.15.2
    [INFO] [graalvm reachability metadata repository for org.apache.tomcat.embed:tomcat-embed-core:10.1.34]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for org.apache.tomcat.embed:tomcat-embed-core:10.1.34]: Configuration directory is org.apache.tomcat.embed\tomcat-embed-core\10.0.20
    [INFO]
    [INFO] --- resources:3.3.1:resources (default-resources) @ chapter-11-gravvlvm ---
    [INFO] Copying 0 resource from src\main\resources to target\classes
    [INFO]
    [INFO] --- compiler:3.13.0:compile (default-compile) @ chapter-11-gravvlvm ---
    [INFO] Nothing to compile - all classes are up to date.
    [INFO]
    [INFO] --- resources:3.3.1:testResources (default-testResources) @ chapter-11-gravvlvm ---
    [INFO] skip non existing resourceDirectory D:\chapter-11\chapter-11-gravvlvm\src\test\resources
    [INFO]
    [INFO] --- compiler:3.13.0:testCompile (default-testCompile) @ chapter-11-gravvlvm ---
    [INFO] Nothing to compile - all classes are up to date.
    [INFO]
    [INFO] --- surefire:3.2.5:test (default-test) @ chapter-11-gravvlvm ---
    [INFO]
    [INFO] --- spring-boot:3.4.3:process-aot (default) @ chapter-11-gravvlvm ---

    .   ____          _            __ _ _
    /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
    ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
    \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
    '  |____| .__|_| |_|_| |_\__, | / / / /
    =========|_|==============|___/=/_/_/_/

    :: Spring Boot ::                (v3.4.1)

    2025-03-07T23:30:13.488+08:00  INFO 7920 --- [           main] org.example.Application                  : Starting Application using Java 23.0.2 with PID 7920 (D:\chapter-11\chapter-11-gravvlvm\target\classes started by czx in D:\chapter-11\chapter-11-gravvlvm)
    2025-03-07T23:30:13.499+08:00  INFO 7920 --- [           main] org.example.Application                  : No active profile set, falling back to 1 default profile: "default"
    [INFO]
    [INFO] --- jar:3.4.1:jar (default-jar) @ chapter-11-gravvlvm ---
    [INFO] Building jar: D:\chapter-11\chapter-11-gravvlvm\target\chapter-11-gravvlvm-1.0-SNAPSHOT.jar
    [INFO]
    [INFO] --- native:0.10.5:compile-no-fork (default) @ chapter-11-gravvlvm ---
    [INFO] Found GraalVM installation from JAVA_HOME variable.
    [INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.12]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.12]: Configuration directory is ch.qos.logback\logback-classic\1.4.9
    [INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.18.2]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.18.2]: Configuration directory is com.fasterxml.jackson.core\jackson-databind\2.15.2
    [INFO] [graalvm reachability metadata repository for org.apache.tomcat.embed:tomcat-embed-core:10.1.34]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for org.apache.tomcat.embed:tomcat-embed-core:10.1.34]: Configuration directory is org.apache.tomcat.embed\tomcat-embed-core\10.0.20[INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.12]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.12]: Configuration directory is ch.qos.logback\logback-classic\1.4.9
    [INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.18.2]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.18.2]: Configuration directory is com.fasterxml.jackson.core\jackson-databind\2.15.2
    [INFO] [graalvm reachability metadata repository for org.apache.tomcat.embed:tomcat-embed-core:10.1.34]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for org.apache.tomcat.embed:tomcat-embed-core:10.1.34]: Configuration directory is org.apache.tomcat.embed\tomcat-embed-core\10.0.20[INFO] Executing: C:\programs\graalvm-jdk-23.0.2+7.1\bin\native-image.cmd @target\tmp\native-image-10144576584497627964.args
    Warning: Using a deprecated option --report-unsupported-elements-at-runtime from 'META-INF\native-image\org.example\chapter-11-gravvlvm\native-image.properties' in 'file:///D:/Desktop/chapter-11/chapter-11-gravvlvm/target/chapter-11-gravvlvm-1.0-SNAPSHOT.jar'. The option is deprecated and will be removed in the future. The use of unsupported elements is always reported at run time.
    ========================================================================================================================
    GraalVM Native Image: Generating 'chapter-11-gravvlvm' (executable)...
    ========================================================================================================================
    For detailed information and explanations on the build output, visit:
    https://github.com/oracle/graal/blob/master/docs/reference-manual/native-image/BuildOutput.md
    ------------------------------------------------------------------------------------------------------------------------
    [1/8] Initializing...                                                                                   (35.6s @ 0.13GB)
    Java version: 23.0.2+7, vendor version: Oracle GraalVM 23.0.2+7.1
    Graal compiler: optimization level: 2, target machine: x86-64-v3, PGO: ML-inferred
    C compiler: cl.exe (microsoft, x64, 19.43.34808)
    Garbage collector: Serial GC (max heap size: 80% of RAM)
    2 user-specific feature(s):
    - com.oracle.svm.thirdparty.gson.GsonFeature
    - org.springframework.aot.nativex.feature.PreComputeFieldFeature
    ------------------------------------------------------------------------------------------------------------------------
    Build resources:
    - 6.05GB of memory (75.6% of 8.00GB system memory, determined at start)
    - 2 thread(s) (100.0% of 2 available processor(s), determined at start)
    SLF4J(W): No SLF4J providers were found.
    SLF4J(W): Defaulting to no-operation (NOP) logger implementation
    SLF4J(W): See https://www.slf4j.org/codes.html#noProviders for further details.
    [2/8] Performing analysis...  [*****]                                                                  (168.3s @ 1.65GB)
    17,503 reachable types   (89.6% of   19,534 total)
    26,817 reachable fields  (59.3% of   45,237 total)
    92,489 reachable methods (65.2% of  141,753 total)
        6,336 types,    31 fields, and 1,465 methods registered for reflection
        78 types,    62 fields, and    68 methods registered for JNI access
            5 native libraries: crypt32, ncrypt, psapi, version, winhttp
    [3/8] Building universe...                                                                              (29.7s @ 1.59GB)
    [4/8] Parsing methods...      [*******]                                                                 (55.2s @ 1.81GB)
    [5/8] Inlining methods...     [****]                                                                    (10.4s @ 2.00GB)
    [6/8] Compiling methods...    [******************]                                                     (348.4s @ 1.98GB)
    [7/8] Laying out methods...   [*****]                                                                   (29.9s @ 2.74GB)
    [8/8] Creating image...       [****]                                                                    (14.3s @ 3.06GB)
    49.42MB (58.63%) for code area:    53,704 compilation units
    34.19MB (40.56%) for image heap:  434,854 objects and 705 resources
    697.73kB ( 0.81%) for other data
    84.29MB in total
    ------------------------------------------------------------------------------------------------------------------------
    Top 10 origins of code area:                                Top 10 object types in image heap:
    17.13MB java.base                                           12.51MB byte[] for code metadata
    5.48MB tomcat-embed-core-10.1.34.jar                        5.85MB byte[] for java.lang.String
    5.23MB svm.jar (Native Image)                               3.33MB java.lang.Class
    4.60MB java.xml                                             3.11MB java.lang.String
    2.41MB jackson-databind-2.18.2.jar                          1.17MB byte[] for reflection metadata
    1.98MB spring-core-6.2.1.jar                              939.34kB byte[] for embedded resources
    1.89MB spring-boot-3.4.1.jar                              925.76kB byte[] for general heap data
    969.07kB spring-web-6.2.1.jar                               820.45kB com.oracle.svm.core.hub.DynamicHubCompanion
    907.02kB spring-beans-6.2.1.jar                             523.95kB heap alignment
    817.75kB jackson-core-2.18.2.jar                            503.88kB c.o.svm.core.hub.DynamicHub$ReflectionMetadata
    7.68MB for 48 more packages                                 4.58MB for 3589 more object types
                                Use '--emit build-report' to create a report with more details.
    ------------------------------------------------------------------------------------------------------------------------
    Security report:
    - Binary includes Java deserialization.
    - Use '--enable-sbom' to assemble a Software Bill of Materials (SBOM).
    ------------------------------------------------------------------------------------------------------------------------
    Recommendations:
    PGO:  Use Profile-Guided Optimizations ('--pgo') for improved throughput.
    HEAP: Set max heap for improved and more predictable memory usage.
    CPU:  Enable more CPU features with '-march=native' for improved performance.
    QBM:  Use the quick build mode ('-Ob') to speed up builds during development.
    ------------------------------------------------------------------------------------------------------------------------
                        58.7s (8.3% of total time) in 4528 GCs | Peak RSS: 3.89GB | CPU load: 1.86
    ------------------------------------------------------------------------------------------------------------------------
    Build artifacts:
    D:\chapter-11\chapter-11-gravvlvm\target\chapter-11-gravvlvm.exe (executable)
    ========================================================================================================================
    Finished generating 'chapter-11-gravvlvm' in 11m 44s.
    [INFO]
    [INFO] <<< native:0.10.5:compile (default-cli) < package @ chapter-11-gravvlvm <<<
    [INFO]
    [INFO]
    [INFO] --- native:0.10.5:compile (default-cli) @ chapter-11-gravvlvm ---
    [INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.12]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.12]: Configuration directory is ch.qos.logback\logback-classic\1.4.9
    [INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.18.2]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.18.2]: Configuration directory is com.fasterxml.jackson.core\jackson-databind\2.15.2
    [INFO] [graalvm reachability metadata repository for org.apache.tomcat.embed:tomcat-embed-core:10.1.34]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for org.apache.tomcat.embed:tomcat-embed-core:10.1.34]: Configuration directory is org.apache.tomcat.embed\tomcat-embed-core\10.0.20
    [INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.12]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.12]: Configuration directory is ch.qos.logback\logback-classic\1.4.9
    [INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.18.2]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.18.2]: Configuration directory is com.fasterxml.jackson.core\jackson-databind\2.15.2
    [INFO] [graalvm reachability metadata repository for org.apache.tomcat.embed:tomcat-embed-core:10.1.34]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for org.apache.tomcat.embed:tomcat-embed-core:10.1.34]: Configuration directory is org.apache.tomcat.embed\tomcat-embed-core\10.0.20
    [INFO] Executing: C:\programs\graalvm-jdk-23.0.2+7.1\bin\native-image.cmd @target\tmp\native-image-7105567257582600622.args
    Warning: Using a deprecated option --report-unsupported-elements-at-runtime from 'META-INF\native-image\org.example\chapter-11-gravvlvm\native-image.properties' in 'file:///D:/chapter-11/chapter-11-gravvlvm/target/classes/'. The option is deprecated and will be removed in the future. The use of unsupported elements is always reported at run time.
    ========================================================================================================================
    GraalVM Native Image: Generating 'chapter-11-gravvlvm' (executable)...
    ========================================================================================================================
    For detailed information and explanations on the build output, visit:
    https://github.com/oracle/graal/blob/master/docs/reference-manual/native-image/BuildOutput.md
    ------------------------------------------------------------------------------------------------------------------------
    [1/8] Initializing...                                                                                   (27.4s @ 0.13GB)
    Java version: 23.0.2+7, vendor version: Oracle GraalVM 23.0.2+7.1
    Graal compiler: optimization level: 2, target machine: x86-64-v3, PGO: ML-inferred
    C compiler: cl.exe (microsoft, x64, 19.43.34808)
    Garbage collector: Serial GC (max heap size: 80% of RAM)
    2 user-specific feature(s):
    - com.oracle.svm.thirdparty.gson.GsonFeature
    - org.springframework.aot.nativex.feature.PreComputeFieldFeature
    ------------------------------------------------------------------------------------------------------------------------
    Build resources:
    - 6.05GB of memory (75.6% of 8.00GB system memory, determined at start)
    - 2 thread(s) (100.0% of 2 available processor(s), determined at start)
    SLF4J(W): No SLF4J providers were found.
    SLF4J(W): Defaulting to no-operation (NOP) logger implementation
    SLF4J(W): See https://www.slf4j.org/codes.html#noProviders for further details.
    [2/8] Performing analysis...  [*****]                                                                  (172.7s @ 1.37GB)
    17,503 reachable types   (89.6% of   19,534 total)
    26,817 reachable fields  (59.3% of   45,237 total)
    92,489 reachable methods (65.2% of  141,751 total)
        6,336 types,    31 fields, and 1,465 methods registered for reflection
        78 types,    62 fields, and    68 methods registered for JNI access
            5 native libraries: crypt32, ncrypt, psapi, version, winhttp
    [3/8] Building universe...                                                                              (26.1s @ 1.61GB)
    [4/8] Parsing methods...      [*******]                                                                 (55.0s @ 1.80GB)
    [5/8] Inlining methods...     [****]                                                                    (10.0s @ 1.97GB)
    [6/8] Compiling methods...    [*******************]                                                    (381.9s @ 2.02GB)
    [7/8] Laying out methods...   [******]                                                                  (33.4s @ 2.83GB)
    [8/8] Creating image...       [****]                                                                    (14.6s @ 3.07GB)
    49.42MB (58.63%) for code area:    53,704 compilation units
    34.19MB (40.56%) for image heap:  435,070 objects and 751 resources
    698.47kB ( 0.81%) for other data
    84.29MB in total
    ------------------------------------------------------------------------------------------------------------------------
    Top 10 origins of code area:                                Top 10 object types in image heap:
    17.13MB java.base                                           12.51MB byte[] for code metadata
    5.48MB tomcat-embed-core-10.1.34.jar                        5.86MB byte[] for java.lang.String
    5.23MB svm.jar (Native Image)                               3.33MB java.lang.Class
    4.60MB java.xml                                             3.11MB java.lang.String
    2.41MB jackson-databind-2.18.2.jar                          1.17MB byte[] for reflection metadata
    1.98MB spring-core-6.2.1.jar                              939.57kB byte[] for embedded resources
    1.89MB spring-boot-3.4.1.jar                              925.76kB byte[] for general heap data
    969.11kB spring-web-6.2.1.jar                               820.45kB com.oracle.svm.core.hub.DynamicHubCompanion
    906.99kB spring-beans-6.2.1.jar                             515.75kB heap alignment
    817.73kB jackson-core-2.18.2.jar                            503.88kB c.o.svm.core.hub.DynamicHub$ReflectionMetadata
    7.68MB for 73 more packages                                 4.59MB for 3589 more object types
                                Use '--emit build-report' to create a report with more details.
    ------------------------------------------------------------------------------------------------------------------------
    Security report:
    - Binary includes Java deserialization.
    - Use '--enable-sbom' to assemble a Software Bill of Materials (SBOM).
    ------------------------------------------------------------------------------------------------------------------------
    Recommendations:
    PGO:  Use Profile-Guided Optimizations ('--pgo') for improved throughput.
    HEAP: Set max heap for improved and more predictable memory usage.
    CPU:  Enable more CPU features with '-march=native' for improved performance.
    QBM:  Use the quick build mode ('-Ob') to speed up builds during development.
    ------------------------------------------------------------------------------------------------------------------------
                        61.8s (8.4% of total time) in 4519 GCs | Peak RSS: 3.92GB | CPU load: 1.89
    ------------------------------------------------------------------------------------------------------------------------
    Build artifacts:
    D:\chapter-11\chapter-11-gravvlvm\target\chapter-11-gravvlvm.exe (executable)
    ========================================================================================================================
    Finished generating 'chapter-11-gravvlvm' in 12m 14s.
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time:  25:16 min
    [INFO] Finished at: 2025-03-07T23:54:58+08:00
    [INFO] ------------------------------------------------------------------------
    [WARNING] The requested profile "native" could not be activated because it does not exist.
    ```
3. 编译生成物
    ``` shell
    -a----         2025/3/7     23:54       88379392 chapter-11-gravvlvm.exe
    ```

### Debian

1. 环境配置
    - 操作系统：Debian 12.9.0（稳定版）
    - 内存：8G
    - GraalVM：[GraalVM for JDK 23](https://www.oracle.com/cn/java/technologies/downloads/#graalvmjava23)
2. 编译过程
    ``` log
    debian@debian:~/chapter-11/chapter-11-gravvlvm$ mvn -Pnative native:compile
    [INFO] Scanning for projects...
    [WARNING]
    [WARNING] Some problems were encountered while building the effective model for org.example:chapter-11-gravvlvm:jar:1.0-SNAPSHOT
    [WARNING] 'build.plugins.plugin.version' for org.graalvm.buildtools:native-maven-plugin is missing. @ line 46, column 21
    [WARNING] 'build.plugins.plugin.version' for org.springframework.boot:spring-boot-maven-plugin is missing. @ line 58, column 21
    [WARNING]
    [WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
    [WARNING]
    [WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
    [WARNING]
    [WARNING] The requested profile "native" could not be activated because it does not exist.
    [INFO]
    [INFO] ------------------< org.example:chapter-11-gravvlvm >-------------------
    [INFO] Building chapter-11-gravvlvm 1.0-SNAPSHOT
    [INFO]   from pom.xml
    [INFO] --------------------------------[ jar ]---------------------------------
    [INFO]
    [INFO] >>> native:0.10.5:compile (default-cli) > package @ chapter-11-gravvlvm >>>
    [INFO]
    [INFO] --- native:0.10.5:add-reachability-metadata (default) @ chapter-11-gravvlvm ---
    [INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.12]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.12]: Configuration directory is ch.qos.logback/logback-classic/1.4.9
    [INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.18.2]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.18.2]: Configuration directory is com.fasterxml.jackson.core/jackson-databind/2.15.2
    [INFO] [graalvm reachability metadata repository for org.apache.tomcat.embed:tomcat-embed-core:10.1.34]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for org.apache.tomcat.embed:tomcat-embed-core:10.1.34]: Configuration directory is org.apache.tomcat.embed/tomcat-embed-core/10.0.20
    [INFO]
    [INFO] --- resources:3.3.1:resources (default-resources) @ chapter-11-gravvlvm ---
    [INFO] Copying 0 resource from src/main/resources to target/classes
    [INFO]
    [INFO] --- compiler:3.13.0:compile (default-compile) @ chapter-11-gravvlvm ---
    [INFO] Nothing to compile - all classes are up to date.
    [INFO]
    [INFO] --- resources:3.3.1:testResources (default-testResources) @ chapter-11-gravvlvm ---
    [INFO] skip non existing resourceDirectory /home/debian/chapter-11/chapter-11-gravvlvm/src/test/resources
    [INFO]
    [INFO] --- compiler:3.13.0:testCompile (default-testCompile) @ chapter-11-gravvlvm ---
    [INFO] Nothing to compile - all classes are up to date.
    [INFO]
    [INFO] --- surefire:3.2.5:test (default-test) @ chapter-11-gravvlvm ---
    [INFO]
    [INFO] --- spring-boot:3.4.3:process-aot (default) @ chapter-11-gravvlvm ---

    .   ____          _            __ _ _
    /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
    ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
    \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
    '  |____| .__|_| |_|_| |_\__, | / / / /
    =========|_|==============|___/=/_/_/_/

    :: Spring Boot ::                (v3.4.1)

    2025-03-08T00:05:39.830-05:00  INFO 5235 --- [           main] org.example.Application                  : Starting Application using Java 23.0.2 with PID 5235 (/home/debian/chapter-11/chapter-11-gravvlvm/target/classes started by debian in /home/debian/chapter-11/chapter-11-gravvlvm)
    2025-03-08T00:05:39.838-05:00  INFO 5235 --- [           main] org.example.Application                  : No active profile set, falling back to 1 default profile: "default"
    [INFO]
    [INFO] --- jar:3.4.1:jar (default-jar) @ chapter-11-gravvlvm ---
    [INFO] Building jar: /home/debian/chapter-11/chapter-11-gravvlvm/target/chapter-11-gravvlvm-1.0-SNAPSHOT.jar
    [INFO]
    [INFO] --- native:0.10.5:compile-no-fork (default) @ chapter-11-gravvlvm ---
    [INFO] Found GraalVM installation from JAVA_HOME variable.
    [INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.12]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.12]: Configuration directory is ch.qos.logback/logback-classic/1.4.9
    [INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.18.2]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.18.2]: Configuration directory is com.fasterxml.jackson.core/jackson-databind/2.15.2
    [INFO] [graalvm reachability metadata repository for org.apache.tomcat.embed:tomcat-embed-core:10.1.34]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for org.apache.tomcat.embed:tomcat-embed-core:10.1.34]: Configuration directory is org.apache.tomcat.embed/tomcat-embed-core/10.0.20
    [INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.12]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.12]: Configuration directory is ch.qos.logback/logback-classic/1.4.9
    [INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.18.2]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.18.2]: Configuration directory is com.fasterxml.jackson.core/jackson-databind/2.15.2
    [INFO] [graalvm reachability metadata repository for org.apache.tomcat.embed:tomcat-embed-core:10.1.34]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for org.apache.tomcat.embed:tomcat-embed-core:10.1.34]: Configuration directory is org.apache.tomcat.embed/tomcat-embed-core/10.0.20
    [INFO] Executing: /home/debian/graalvm-jdk-23.0.2+7.1/bin/native-image -cp /home/debian/chapter-11/chapter-11-gravvlvm/target/chapter-11-gravvlvm-1.0-SNAPSHOT.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot-starter-web/3.4.1/spring-boot-starter-web-3.4.1.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot-starter/3.4.1/spring-boot-starter-3.4.1.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot/3.4.1/spring-boot-3.4.1.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/3.4.1/spring-boot-autoconfigure-3.4.1.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot-starter-logging/3.4.1/spring-boot-starter-logging-3.4.1.jar:/home/debian/.m2/repository/ch/qos/logback/logback-classic/1.5.12/logback-classic-1.5.12.jar:/home/debian/.m2/repository/ch/qos/logback/logback-core/1.5.12/logback-core-1.5.12.jar:/home/debian/.m2/repository/org/slf4j/slf4j-api/2.0.16/slf4j-api-2.0.16.jar:/home/debian/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.24.3/log4j-to-slf4j-2.24.3.jar:/home/debian/.m2/repository/org/apache/logging/log4j/log4j-api/2.24.3/log4j-api-2.24.3.jar:/home/debian/.m2/repository/org/slf4j/jul-to-slf4j/2.0.16/jul-to-slf4j-2.0.16.jar:/home/debian/.m2/repository/jakarta/annotation/jakarta.annotation-api/2.1.1/jakarta.annotation-api-2.1.1.jar:/home/debian/.m2/repository/org/springframework/spring-core/6.2.1/spring-core-6.2.1.jar:/home/debian/.m2/repository/org/springframework/spring-jcl/6.2.1/spring-jcl-6.2.1.jar:/home/debian/.m2/repository/org/yaml/snakeyaml/2.3/snakeyaml-2.3.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot-starter-json/3.4.1/spring-boot-starter-json-3.4.1.jar:/home/debian/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.18.2/jackson-databind-2.18.2.jar:/home/debian/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.18.2/jackson-annotations-2.18.2.jar:/home/debian/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.18.2/jackson-core-2.18.2.jar:/home/debian/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.18.2/jackson-datatype-jdk8-2.18.2.jar:/home/debian/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.18.2/jackson-datatype-jsr310-2.18.2.jar:/home/debian/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.18.2/jackson-module-parameter-names-2.18.2.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/3.4.1/spring-boot-starter-tomcat-3.4.1.jar:/home/debian/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/10.1.34/tomcat-embed-core-10.1.34.jar:/home/debian/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/10.1.34/tomcat-embed-el-10.1.34.jar:/home/debian/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/10.1.34/tomcat-embed-websocket-10.1.34.jar:/home/debian/.m2/repository/org/springframework/spring-web/6.2.1/spring-web-6.2.1.jar:/home/debian/.m2/repository/org/springframework/spring-beans/6.2.1/spring-beans-6.2.1.jar:/home/debian/.m2/repository/io/micrometer/micrometer-observation/1.14.2/micrometer-observation-1.14.2.jar:/home/debian/.m2/repository/io/micrometer/micrometer-commons/1.14.2/micrometer-commons-1.14.2.jar:/home/debian/.m2/repository/org/springframework/spring-webmvc/6.2.1/spring-webmvc-6.2.1.jar:/home/debian/.m2/repository/org/springframework/spring-aop/6.2.1/spring-aop-6.2.1.jar:/home/debian/.m2/repository/org/springframework/spring-context/6.2.1/spring-context-6.2.1.jar:/home/debian/.m2/repository/org/springframework/spring-expression/6.2.1/spring-expression-6.2.1.jar:/home/debian/chapter-11/chapter-11-gravvlvm/target/chapter-11-gravvlvm-1.0-SNAPSHOT.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot-starter-web/3.4.1/spring-boot-starter-web-3.4.1.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot-starter/3.4.1/spring-boot-starter-3.4.1.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot/3.4.1/spring-boot-3.4.1.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/3.4.1/spring-boot-autoconfigure-3.4.1.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot-starter-logging/3.4.1/spring-boot-starter-logging-3.4.1.jar:/home/debian/.m2/repository/ch/qos/logback/logback-classic/1.5.12/logback-classic-1.5.12.jar:/home/debian/.m2/repository/ch/qos/logback/logback-core/1.5.12/logback-core-1.5.12.jar:/home/debian/.m2/repository/org/slf4j/slf4j-api/2.0.16/slf4j-api-2.0.16.jar:/home/debian/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.24.3/log4j-to-slf4j-2.24.3.jar:/home/debian/.m2/repository/org/apache/logging/log4j/log4j-api/2.24.3/log4j-api-2.24.3.jar:/home/debian/.m2/repository/org/slf4j/jul-to-slf4j/2.0.16/jul-to-slf4j-2.0.16.jar:/home/debian/.m2/repository/jakarta/annotation/jakarta.annotation-api/2.1.1/jakarta.annotation-api-2.1.1.jar:/home/debian/.m2/repository/org/springframework/spring-core/6.2.1/spring-core-6.2.1.jar:/home/debian/.m2/repository/org/springframework/spring-jcl/6.2.1/spring-jcl-6.2.1.jar:/home/debian/.m2/repository/org/yaml/snakeyaml/2.3/snakeyaml-2.3.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot-starter-json/3.4.1/spring-boot-starter-json-3.4.1.jar:/home/debian/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.18.2/jackson-databind-2.18.2.jar:/home/debian/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.18.2/jackson-annotations-2.18.2.jar:/home/debian/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.18.2/jackson-core-2.18.2.jar:/home/debian/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.18.2/jackson-datatype-jdk8-2.18.2.jar:/home/debian/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.18.2/jackson-datatype-jsr310-2.18.2.jar:/home/debian/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.18.2/jackson-module-parameter-names-2.18.2.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/3.4.1/spring-boot-starter-tomcat-3.4.1.jar:/home/debian/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/10.1.34/tomcat-embed-core-10.1.34.jar:/home/debian/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/10.1.34/tomcat-embed-el-10.1.34.jar:/home/debian/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/10.1.34/tomcat-embed-websocket-10.1.34.jar:/home/debian/.m2/repository/org/springframework/spring-web/6.2.1/spring-web-6.2.1.jar:/home/debian/.m2/repository/org/springframework/spring-beans/6.2.1/spring-beans-6.2.1.jar:/home/debian/.m2/repository/io/micrometer/micrometer-observation/1.14.2/micrometer-observation-1.14.2.jar:/home/debian/.m2/repository/io/micrometer/micrometer-commons/1.14.2/micrometer-commons-1.14.2.jar:/home/debian/.m2/repository/org/springframework/spring-webmvc/6.2.1/spring-webmvc-6.2.1.jar:/home/debian/.m2/repository/org/springframework/spring-aop/6.2.1/spring-aop-6.2.1.jar:/home/debian/.m2/repository/org/springframework/spring-context/6.2.1/spring-context-6.2.1.jar:/home/debian/.m2/repository/org/springframework/spring-expression/6.2.1/spring-expression-6.2.1.jar --no-fallback -o /home/debian/chapter-11/chapter-11-gravvlvm/target/chapter-11-gravvlvm -H:ConfigurationFileDirectories=/home/debian/chapter-11/chapter-11-gravvlvm/target/graalvm-reachability-metadata/e37ad5f44176fd4ca781f444d590d766e7cf5588/com.fasterxml.jackson.core/jackson-databind/2.15.2,/home/debian/chapter-11/chapter-11-gravvlvm/target/graalvm-reachability-metadata/e37ad5f44176fd4ca781f444d590d766e7cf5588/ch.qos.logback/logback-classic/1.4.9,/home/debian/chapter-11/chapter-11-gravvlvm/target/graalvm-reachability-metadata/e37ad5f44176fd4ca781f444d590d766e7cf5588/org.apache.tomcat.embed/tomcat-embed-core/10.0.20,/home/debian/chapter-11/chapter-11-gravvlvm/target/graalvm-reachability-metadata/e37ad5f44176fd4ca781f444d590d766e7cf5588/com.fasterxml.jackson.core/jackson-databind/2.15.2,/home/debian/chapter-11/chapter-11-gravvlvm/target/graalvm-reachability-metadata/e37ad5f44176fd4ca781f444d590d766e7cf5588/ch.qos.logback/logback-classic/1.4.9,/home/debian/chapter-11/chapter-11-gravvlvm/target/graalvm-reachability-metadata/e37ad5f44176fd4ca781f444d590d766e7cf5588/org.apache.tomcat.embed/tomcat-embed-core/10.0.20,/home/debian/chapter-11/chapter-11-gravvlvm/target/graalvm-reachability-metadata/e37ad5f44176fd4ca781f444d590d766e7cf5588/org.apache.tomcat.embed/tomcat-embed-core/10.0.20,/home/debian/chapter-11/chapter-11-gravvlvm/target/graalvm-reachability-metadata/e37ad5f44176fd4ca781f444d590d766e7cf5588/ch.qos.logback/logback-classic/1.4.9,/home/debian/chapter-11/chapter-11-gravvlvm/target/graalvm-reachability-metadata/e37ad5f44176fd4ca781f444d590d766e7cf5588/com.fasterxml.jackson.core/jackson-databind/2.15.2
    Warning: Using a deprecated option --report-unsupported-elements-at-runtime from 'META-INF/native-image/org.example/chapter-11-gravvlvm/native-image.properties' in 'file:///home/debian/chapter-11/chapter-11-gravvlvm/target/chapter-11-gravvlvm-1.0-SNAPSHOT.jar'. The option is deprecated and will be removed in the future. The use of unsupported elements is always reported at run time.
    ========================================================================================================================
    GraalVM Native Image: Generating 'chapter-11-gravvlvm' (executable)...
    ========================================================================================================================
    [1/8] Initializing...                                                                                   (23.4s @ 0.12GB)
    Java version: 23.0.2+7, vendor version: Oracle GraalVM 23.0.2+7.1
    Graal compiler: optimization level: 2, target machine: x86-64-v3, PGO: ML-inferred
    C compiler: gcc (linux, x86_64, 12.2.0)
    Garbage collector: Serial GC (max heap size: 80% of RAM)
    2 user-specific feature(s):
    - com.oracle.svm.thirdparty.gson.GsonFeature
    - org.springframework.aot.nativex.feature.PreComputeFieldFeature
    ------------------------------------------------------------------------------------------------------------------------
    Build resources:
    - 5.84GB of memory (75.6% of 7.72GB system memory, determined at start)
    - 2 thread(s) (100.0% of 2 available processor(s), determined at start)
    SLF4J(W): No SLF4J providers were found.
    SLF4J(W): Defaulting to no-operation (NOP) logger implementation
    SLF4J(W): See https://www.slf4j.org/codes.html#noProviders for further details.
    [2/8] Performing analysis...  [******]                                                                 (250.7s @ 1.97GB)
    17,552 reachable types   (89.4% of   19,625 total)
    26,828 reachable fields  (59.2% of   45,311 total)
    92,444 reachable methods (65.0% of  142,141 total)
        6,011 types,    31 fields, and 1,438 methods registered for reflection
        62 types,    63 fields, and    55 methods registered for JNI access
            4 native libraries: dl, pthread, rt, z
    [3/8] Building universe...                                                                              (42.5s @ 2.27GB)
    [4/8] Parsing methods...      [********]                                                                (74.5s @ 1.61GB)
    [5/8] Inlining methods...     [****]                                                                    (11.2s @ 2.68GB)
    [6/8] Compiling methods...    [**********************]                                                 (488.4s @ 2.20GB)
    [7/8] Laying out methods...   [[7/8] Laying out methods...   [*****]                                                                   (27.7s @ 2.92GB)
    [8/8] Creating image...       [[8/8] Creating image...       [****]                                                                    (17.9s @ 3.22GB)
    48.68MB (53.84%) for code area:    53,579 compilation units
    33.69MB (37.26%) for image heap:  430,398 objects and 355 resources
    8.05MB ( 8.90%) for other data
    90.42MB in total
    ------------------------------------------------------------------------------------------------------------------------
    Top 10 origins of code area:                                Top 10 object types in image heap:
    17.01MB java.base                                           12.46MB byte[] for code metadata
    5.44MB tomcat-embed-core-10.1.34.jar                        5.78MB byte[] for java.lang.String
    5.05MB svm.jar (Native Image)                               3.34MB java.lang.Class
    4.53MB java.xml                                             3.09MB java.lang.String
    2.39MB jackson-databind-2.18.2.jar                          1.17MB byte[] for reflection metadata
    1.97MB spring-core-6.2.1.jar                              877.05kB byte[] for embedded resources
    1.86MB spring-boot-3.4.1.jar                              851.82kB byte[] for general heap data
    962.10kB spring-web-6.2.1.jar                               822.75kB com.oracle.svm.core.hub.DynamicHubCompanion
    897.03kB spring-beans-6.2.1.jar                             505.13kB c.o.svm.core.hub.DynamicHub$ReflectionMetadata
    804.34kB jackson-core-2.18.2.jar                            424.15kB java.lang.String[]
    7.46MB for 47 more packages                                 4.45MB for 3618 more object types
                                Use '--emit build-report' to create a report with more details.
    ------------------------------------------------------------------------------------------------------------------------
    Security report:
    - Binary includes Java deserialization.
    - Use '--enable-sbom' to assemble a Software Bill of Materials (SBOM).
    ------------------------------------------------------------------------------------------------------------------------
    Recommendations:
    G1GC: Use the G1 GC ('--gc=G1') for improved latency and throughput.
    PGO:  Use Profile-Guided Optimizations ('--pgo') for improved throughput.
    HEAP: Set max heap for improved and more predictable memory usage.
    CPU:  Enable more CPU features with '-march=native' for improved performance.
    QBM:  Use the quick build mode ('-Ob') to speed up builds during development.
    ------------------------------------------------------------------------------------------------------------------------
                        111.5s (11.7% of total time) in 2075 GCs | Peak RSS: 4.23GB | CPU load: 1.90
    ------------------------------------------------------------------------------------------------------------------------
    Build artifacts:
    /home/debian/chapter-11/chapter-11-gravvlvm/target/chapter-11-gravvlvm (executable)
    ========================================================================================================================
    Finished generating 'chapter-11-gravvlvm' in 15m 48s.
    [INFO]
    [INFO] <<< native:0.10.5:compile (default-cli) < package @ chapter-11-gravvlvm <<<
    [INFO]
    [INFO]
    [INFO] --- native:0.10.5:compile (default-cli) @ chapter-11-gravvlvm ---
    [INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.12]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.12]: Configuration directory is ch.qos.logback/logback-classic/1.4.9
    [INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.18.2]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.18.2]: Configuration directory is com.fasterxml.jackson.core/jackson-databind/2.15.2
    [INFO] [graalvm reachability metadata repository for org.apache.tomcat.embed:tomcat-embed-core:10.1.34]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for org.apache.tomcat.embed:tomcat-embed-core:10.1.34]: Configuration directory is org.apache.tomcat.embed/tomcat-embed-core/10.0.20
    [INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.12]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.5.12]: Configuration directory is ch.qos.logback/logback-classic/1.4.9
    [INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.18.2]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.18.2]: Configuration directory is com.fasterxml.jackson.core/jackson-databind/2.15.2
    [INFO] [graalvm reachability metadata repository for org.apache.tomcat.embed:tomcat-embed-core:10.1.34]: Configuration directory not found. Trying latest version.
    [INFO] [graalvm reachability metadata repository for org.apache.tomcat.embed:tomcat-embed-core:10.1.34]: Configuration directory is org.apache.tomcat.embed/tomcat-embed-core/10.0.20
    [INFO] Executing: /home/debian/graalvm-jdk-23.0.2+7.1/bin/native-image -cp /home/debian/chapter-11/chapter-11-gravvlvm/target/classes:/home/debian/.m2/repository/org/springframework/boot/spring-boot-starter-web/3.4.1/spring-boot-starter-web-3.4.1.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot-starter/3.4.1/spring-boot-starter-3.4.1.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot/3.4.1/spring-boot-3.4.1.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/3.4.1/spring-boot-autoconfigure-3.4.1.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot-starter-logging/3.4.1/spring-boot-starter-logging-3.4.1.jar:/home/debian/.m2/repository/ch/qos/logback/logback-classic/1.5.12/logback-classic-1.5.12.jar:/home/debian/.m2/repository/ch/qos/logback/logback-core/1.5.12/logback-core-1.5.12.jar:/home/debian/.m2/repository/org/slf4j/slf4j-api/2.0.16/slf4j-api-2.0.16.jar:/home/debian/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.24.3/log4j-to-slf4j-2.24.3.jar:/home/debian/.m2/repository/org/apache/logging/log4j/log4j-api/2.24.3/log4j-api-2.24.3.jar:/home/debian/.m2/repository/org/slf4j/jul-to-slf4j/2.0.16/jul-to-slf4j-2.0.16.jar:/home/debian/.m2/repository/jakarta/annotation/jakarta.annotation-api/2.1.1/jakarta.annotation-api-2.1.1.jar:/home/debian/.m2/repository/org/springframework/spring-core/6.2.1/spring-core-6.2.1.jar:/home/debian/.m2/repository/org/springframework/spring-jcl/6.2.1/spring-jcl-6.2.1.jar:/home/debian/.m2/repository/org/yaml/snakeyaml/2.3/snakeyaml-2.3.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot-starter-json/3.4.1/spring-boot-starter-json-3.4.1.jar:/home/debian/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.18.2/jackson-databind-2.18.2.jar:/home/debian/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.18.2/jackson-annotations-2.18.2.jar:/home/debian/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.18.2/jackson-core-2.18.2.jar:/home/debian/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.18.2/jackson-datatype-jdk8-2.18.2.jar:/home/debian/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.18.2/jackson-datatype-jsr310-2.18.2.jar:/home/debian/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.18.2/jackson-module-parameter-names-2.18.2.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/3.4.1/spring-boot-starter-tomcat-3.4.1.jar:/home/debian/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/10.1.34/tomcat-embed-core-10.1.34.jar:/home/debian/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/10.1.34/tomcat-embed-el-10.1.34.jar:/home/debian/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/10.1.34/tomcat-embed-websocket-10.1.34.jar:/home/debian/.m2/repository/org/springframework/spring-web/6.2.1/spring-web-6.2.1.jar:/home/debian/.m2/repository/org/springframework/spring-beans/6.2.1/spring-beans-6.2.1.jar:/home/debian/.m2/repository/io/micrometer/micrometer-observation/1.14.2/micrometer-observation-1.14.2.jar:/home/debian/.m2/repository/io/micrometer/micrometer-commons/1.14.2/micrometer-commons-1.14.2.jar:/home/debian/.m2/repository/org/springframework/spring-webmvc/6.2.1/spring-webmvc-6.2.1.jar:/home/debian/.m2/repository/org/springframework/spring-aop/6.2.1/spring-aop-6.2.1.jar:/home/debian/.m2/repository/org/springframework/spring-context/6.2.1/spring-context-6.2.1.jar:/home/debian/.m2/repository/org/springframework/spring-expression/6.2.1/spring-expression-6.2.1.jar:/home/debian/chapter-11/chapter-11-gravvlvm/target/classes:/home/debian/.m2/repository/org/springframework/boot/spring-boot-starter-web/3.4.1/spring-boot-starter-web-3.4.1.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot-starter/3.4.1/spring-boot-starter-3.4.1.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot/3.4.1/spring-boot-3.4.1.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/3.4.1/spring-boot-autoconfigure-3.4.1.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot-starter-logging/3.4.1/spring-boot-starter-logging-3.4.1.jar:/home/debian/.m2/repository/ch/qos/logback/logback-classic/1.5.12/logback-classic-1.5.12.jar:/home/debian/.m2/repository/ch/qos/logback/logback-core/1.5.12/logback-core-1.5.12.jar:/home/debian/.m2/repository/org/slf4j/slf4j-api/2.0.16/slf4j-api-2.0.16.jar:/home/debian/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.24.3/log4j-to-slf4j-2.24.3.jar:/home/debian/.m2/repository/org/apache/logging/log4j/log4j-api/2.24.3/log4j-api-2.24.3.jar:/home/debian/.m2/repository/org/slf4j/jul-to-slf4j/2.0.16/jul-to-slf4j-2.0.16.jar:/home/debian/.m2/repository/jakarta/annotation/jakarta.annotation-api/2.1.1/jakarta.annotation-api-2.1.1.jar:/home/debian/.m2/repository/org/springframework/spring-core/6.2.1/spring-core-6.2.1.jar:/home/debian/.m2/repository/org/springframework/spring-jcl/6.2.1/spring-jcl-6.2.1.jar:/home/debian/.m2/repository/org/yaml/snakeyaml/2.3/snakeyaml-2.3.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot-starter-json/3.4.1/spring-boot-starter-json-3.4.1.jar:/home/debian/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.18.2/jackson-databind-2.18.2.jar:/home/debian/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.18.2/jackson-annotations-2.18.2.jar:/home/debian/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.18.2/jackson-core-2.18.2.jar:/home/debian/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.18.2/jackson-datatype-jdk8-2.18.2.jar:/home/debian/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.18.2/jackson-datatype-jsr310-2.18.2.jar:/home/debian/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.18.2/jackson-module-parameter-names-2.18.2.jar:/home/debian/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/3.4.1/spring-boot-starter-tomcat-3.4.1.jar:/home/debian/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/10.1.34/tomcat-embed-core-10.1.34.jar:/home/debian/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/10.1.34/tomcat-embed-el-10.1.34.jar:/home/debian/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/10.1.34/tomcat-embed-websocket-10.1.34.jar:/home/debian/.m2/repository/org/springframework/spring-web/6.2.1/spring-web-6.2.1.jar:/home/debian/.m2/repository/org/springframework/spring-beans/6.2.1/spring-beans-6.2.1.jar:/home/debian/.m2/repository/io/micrometer/micrometer-observation/1.14.2/micrometer-observation-1.14.2.jar:/home/debian/.m2/repository/io/micrometer/micrometer-commons/1.14.2/micrometer-commons-1.14.2.jar:/home/debian/.m2/repository/org/springframework/spring-webmvc/6.2.1/spring-webmvc-6.2.1.jar:/home/debian/.m2/repository/org/springframework/spring-aop/6.2.1/spring-aop-6.2.1.jar:/home/debian/.m2/repository/org/springframework/spring-context/6.2.1/spring-context-6.2.1.jar:/home/debian/.m2/repository/org/springframework/spring-expression/6.2.1/spring-expression-6.2.1.jar --no-fallback -o /home/debian/chapter-11/chapter-11-gravvlvm/target/chapter-11-gravvlvm -H:ConfigurationFileDirectories=/home/debian/chapter-11/chapter-11-gravvlvm/target/graalvm-reachability-metadata/e37ad5f44176fd4ca781f444d590d766e7cf5588/ch.qos.logback/logback-classic/1.4.9,/home/debian/chapter-11/chapter-11-gravvlvm/target/graalvm-reachability-metadata/e37ad5f44176fd4ca781f444d590d766e7cf5588/org.apache.tomcat.embed/tomcat-embed-core/10.0.20,/home/debian/chapter-11/chapter-11-gravvlvm/target/graalvm-reachability-metadata/e37ad5f44176fd4ca781f444d590d766e7cf5588/com.fasterxml.jackson.core/jackson-databind/2.15.2,/home/debian/chapter-11/chapter-11-gravvlvm/target/graalvm-reachability-metadata/e37ad5f44176fd4ca781f444d590d766e7cf5588/com.fasterxml.jackson.core/jackson-databind/2.15.2,/home/debian/chapter-11/chapter-11-gravvlvm/target/graalvm-reachability-metadata/e37ad5f44176fd4ca781f444d590d766e7cf5588/ch.qos.logback/logback-classic/1.4.9,/home/debian/chapter-11/chapter-11-gravvlvm/target/graalvm-reachability-metadata/e37ad5f44176fd4ca781f444d590d766e7cf5588/org.apache.tomcat.embed/tomcat-embed-core/10.0.20,/home/debian/chapter-11/chapter-11-gravvlvm/target/graalvm-reachability-metadata/e37ad5f44176fd4ca781f444d590d766e7cf5588/org.apache.tomcat.embed/tomcat-embed-core/10.0.20,/home/debian/chapter-11/chapter-11-gravvlvm/target/graalvm-reachability-metadata/e37ad5f44176fd4ca781f444d590d766e7cf5588/ch.qos.logback/logback-classic/1.4.9,/home/debian/chapter-11/chapter-11-gravvlvm/target/graalvm-reachability-metadata/e37ad5f44176fd4ca781f444d590d766e7cf5588/com.fasterxml.jackson.core/jackson-databind/2.15.2
    Warning: Using a deprecated option --report-unsupported-elements-at-runtime from 'META-INF/native-image/org.example/chapter-11-gravvlvm/native-image.properties' in 'file:///home/debian/chapter-11/chapter-11-gravvlvm/target/classes/'. The option is deprecated and will be removed in the future. The use of unsupported elements is always reported at run time.
    ========================================================================================================================
    GraalVM Native Image: Generating 'chapter-11-gravvlvm' (executable)...
    ========================================================================================================================
    [1/8] Initializing...                                                                                   (25.7s @ 0.12GB)
    Java version: 23.0.2+7, vendor version: Oracle GraalVM 23.0.2+7.1
    Graal compiler: optimization level: 2, target machine: x86-64-v3, PGO: ML-inferred
    C compiler: gcc (linux, x86_64, 12.2.0)
    Garbage collector: Serial GC (max heap size: 80% of RAM)
    2 user-specific feature(s):
    - com.oracle.svm.thirdparty.gson.GsonFeature
    - org.springframework.aot.nativex.feature.PreComputeFieldFeature
    ------------------------------------------------------------------------------------------------------------------------
    Build resources:
    - 5.84GB of memory (75.6% of 7.72GB system memory, determined at start)
    - 2 thread(s) (100.0% of 2 available processor(s), determined at start)
    SLF4J(W): No SLF4J providers were found.
    SLF4J(W): Defaulting to no-operation (NOP) logger implementation
    SLF4J(W): See https://www.slf4j.org/codes.html#noProviders for further details.
    [2/8] Performing analysis...  [******]                                                                 (244.2s @ 1.63GB)
    17,552 reachable types   (89.4% of   19,625 total)
    26,828 reachable fields  (59.2% of   45,311 total)
    92,444 reachable methods (65.0% of  142,143 total)
        6,011 types,    31 fields, and 1,438 methods registered for reflection
        62 types,    63 fields, and    55 methods registered for JNI access
            4 native libraries: dl, pthread, rt, z
    [3/8] Building universe...                                                                              (39.8s @ 1.51GB)
    [4/8] Parsing methods...      [*********]                                                               (84.5s @ 1.74GB)
    [5/8] Inlining methods...     [****]                                                                    (15.6s @ 1.88GB)
    [6/8] Compiling methods...    [[6/8] Compiling methods...    [************************]                                               (607.4s @ 2.23GB)
    [7/8] Laying out methods...   [[7/8] Laying out methods...   [******]                                                                  (35.0s @ 2.92GB)
    [8/8] Creating image...       [[8/8] Creating image...       [*****]                                                                   (23.0s @ 3.21GB)
    48.69MB (53.84%) for code area:    53,579 compilation units
    33.69MB (37.26%) for image heap:  430,641 objects and 401 resources
    8.05MB ( 8.90%) for other data
    90.42MB in total
    ------------------------------------------------------------------------------------------------------------------------
    Top 10 origins of code area:                                Top 10 object types in image heap:
    17.01MB java.base                                           12.46MB byte[] for code metadata
    5.44MB tomcat-embed-core-10.1.34.jar                        5.79MB byte[] for java.lang.String
    5.05MB svm.jar (Native Image)                               3.34MB java.lang.Class
    4.53MB java.xml                                             3.09MB java.lang.String
    2.39MB jackson-databind-2.18.2.jar                          1.17MB byte[] for reflection metadata
    1.97MB spring-core-6.2.1.jar                              877.03kB byte[] for embedded resources
    1.86MB spring-boot-3.4.1.jar                              851.82kB byte[] for general heap data
    962.10kB spring-web-6.2.1.jar                               822.75kB com.oracle.svm.core.hub.DynamicHubCompanion
    897.03kB spring-beans-6.2.1.jar                             505.13kB c.o.svm.core.hub.DynamicHub$ReflectionMetadata
    805.29kB jackson-core-2.18.2.jar                            424.16kB java.lang.String[]
    7.46MB for 72 more packages                                 4.45MB for 3618 more object types
                                Use '--emit build-report' to create a report with more details.
    ------------------------------------------------------------------------------------------------------------------------
    Security report:
    - Binary includes Java deserialization.
    - Use '--enable-sbom' to assemble a Software Bill of Materials (SBOM).
    ------------------------------------------------------------------------------------------------------------------------
    Recommendations:
    G1GC: Use the G1 GC ('--gc=G1') for improved latency and throughput.
    PGO:  Use Profile-Guided Optimizations ('--pgo') for improved throughput.
    HEAP: Set max heap for improved and more predictable memory usage.
    CPU:  Enable more CPU features with '-march=native' for improved performance.
    QBM:  Use the quick build mode ('-Ob') to speed up builds during development.
    ------------------------------------------------------------------------------------------------------------------------
                        94.3s (8.6% of total time) in 4447 GCs | Peak RSS: 4.24GB | CPU load: 1.90
    ------------------------------------------------------------------------------------------------------------------------
    Build artifacts:
    /home/debian/chapter-11/chapter-11-gravvlvm/target/chapter-11-gravvlvm (executable)
    ========================================================================================================================
    Finished generating 'chapter-11-gravvlvm' in 18m 10s.
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time:  34:19 min
    [INFO] Finished at: 2025-03-08T00:39:53-05:00
    [INFO] ------------------------------------------------------------------------
    [WARNING] The requested profile "native" could not be activated because it does not exist.
    ```


3. 编译生成物
    ``` shell
    -rwxr-xr-x 1 debian debian 90245368 Mar  8 00:39 target/chapter-11-gravvlvm
    ```