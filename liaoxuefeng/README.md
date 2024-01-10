学习 [廖雪峰Java教程](https://www.liaoxuefeng.com/wiki/1252599548343744) 中的一些实践代码。

* [面向对象编程](https://www.liaoxuefeng.com/wiki/1252599548343744/1255943520012800)
    * [模块化](https://www.liaoxuefeng.com/wiki/1252599548343744/1281795926523938)
        ```shell
        # 编译
        javac -d bin src/main/java/module-info.java src/main/java/c02oop/module1/*.java
        # 打包
        jar --create --file hello.jar --main-class c02oop.module1.Hello -C bin .
        # 转换jar为模块jmod
        jmod create --class-path hello.jar hello.jmod
        # 运行的两种方式
        java --module-path hello.jar --module learn.liaoxuefeng
        java -jar hello.jar
        # 打包JRE
        jlink --module-path hello.jmod --add-modules java.base,java.xml,learn.liaoxuefeng --output jre/
        # 通过打包出来的JRE运行模块
        jre/bin/java --module hello.world
        ```
* [网络编程](src/main/java/com/hiwangzi/c15_network)
* [Web开发](src/main/java/com/hiwangzi/c20_web)
