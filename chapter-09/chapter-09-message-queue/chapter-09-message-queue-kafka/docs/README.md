[TOC]

---

### Windows下的相关操作

为了方式出现路径过长的问题，可以使用`subst`命令创建一个虚拟磁盘。如下，在kafka目录下执行命令，将Kafka目录设置为虚拟分区Q。
``` cmd
subst q: .
```

- STEP 2: START THE KAFKA ENVIRONMENT
    - Kafka with KRaft
        - Generate a Cluster UUID
          [批处理(bat) 脚本将一个命令的返回结果传给一个变量](https://blog.csdn.net/qq_37858386/article/details/103048256)
          ***这种取值方式，必须在批处理（bat）下执行。***
          ``` cmd
          for /f "delims=" %%i in ('.\bin\windows\kafka-storage.bat random-uuid') do set KAFKA_CLUSTER_ID=%%i
          echo KAFKA_CLUSTER_ID=%KAFKA_CLUSTER_ID%
          ```
        - Format Log Directories
          ``` cmd
          bin\windows\kafka-storage.bat format --standalone -t %KAFKA_CLUSTER_ID% -c config\kraft\reconfig-server.properties
          ```
        - Start the Kafka Server
          ``` cmd
          bin\windows\kafka-server-start.bat config/kraft/reconfig-server.properties
          ```

- STEP 3: CREATE A TOPIC TO STORE YOUR EVENTS
  ``` cmd
  bin\windows\kafka-topics.bat --describe --topic quickstart-events --bootstrap-server localhost:9092
  ```
- STEP 4: WRITE SOME EVENTS INTO THE TOPIC
  ``` cmd
  bin\windows\kafka-console-producer.bat --topic quickstart-events --bootstrap-server localhost:9092
  ```
- STEP 5: READ THE EVENTS
  ``` cmd
  bin\windows\kafka-console-consumer.bat --topic quickstart-events --from-beginning --bootstrap-server localhost:9092
  ```

- 命令行中文乱码问题
  在执行`kafka-console-producer`和`kafka-console-consumer`命令之前，先将字符编码改为`UTF-8`。
  ``` cmd
  chcp 65001
  ```
