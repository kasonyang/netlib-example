# [Netlib](https://github.com/kasonyang/netlib) examples

* site.kason.netlib.example.EchoServer : [ECHO protocol](https://en.wikipedia.org/wiki/Echo_Protocol) implementation.
* site.kason.netlib.example.TimeServer : [TIME protocol](https://en.wikipedia.org/wiki/Time_Protocol) implementation.

# Build and run

Build:

    > ./gradlew installDist

Run:

    > ./build/install/netlib-example/bin/netlib-example COMMAND

available commands:

* `echo` : run EchoServer
* `time` : run TimeServer