1. Windows下的运行方式
   需要使用超级用户执行。
   sbin\rabbitmq-server.bat start
2. Erlang版本
   [Erlang Version Requirements](https://www.rabbitmq.com/docs/which-erlang)

   | [RabbitMQ version](https://www.rabbitmq.com/release-information) | Minimum required Erlang/OTP | Maximum supported Erlang/OTP | Notes                                                                                       |
   | ---------------------------------------------------------------- | --------------------------- | ---------------------------- | ------------------------------------------------------------------------------------------- |
   | 4.0.5 4.0.4                                                      | 26.2                        | 27.x                         | The starting with the 4.0.4 release, the 4.0.x release series is compatible with Erlang 27. |

   

   本例使用的版本是：
   - RabbitMQ
      [releases](https://github.com/rabbitmq/rabbitmq-server/releases)
      [RabbitMQ 4.0.5](https://github.com/rabbitmq/rabbitmq-server/releases/tag/v4.0.5)
   - Erlang
      [Download Erlang/OTP](https://www.erlang.org/downloads)
      [Erlang/OTP 27.2.2](https://www.erlang.org/patches/otp-27.2.2)

