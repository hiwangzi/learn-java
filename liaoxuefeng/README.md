学习 [廖雪峰Java教程](https://www.liaoxuefeng.com/wiki/1252599548343744) 中的一些实践代码与笔记。

## 02. 面向对象编程 [Reference](https://www.liaoxuefeng.com/wiki/1252599548343744/1255943520012800)

* class文件的版本 [Reference](https://www.liaoxuefeng.com/wiki/1252599548343744/1476084948271136)
  * 每个版本的JVM，它能执行的class文件版本也不同。例如，Java 11对应的class文件版本是55，而Java 17对应的class文件版本是61。
  * 查看class文件的版本：`javap -v Hello.class | grep version`
  * 指定编译输出有两种方式：
    * 一种是在javac命令行中用参数`--release`设置： `javac --release 11 Main.java`
    参数`--release 11`表示源码兼容Java 11，编译的class输出版本为Java 11兼容，即class版本55。
    * 第二种方式是用参数`--source`指定源码版本，用参数`--target`指定输出class版本：
    `javac --source 9 --target 11 Main.java`
      上述命令如果使用Java 17的JDK编译，它会把源码视为Java 9兼容版本，并输出class为Java 11兼容版本。
    * 注意`--release`参数和`--source --target`参数只能二选一，不能同时设置。
  * 然而，指定版本如果低于当前的JDK版本，会有一些潜在的问题。例如，我们用Java 17编译Hello.java，参数设置`--source 9`和`--target 11`：
    ```java
    public class Hello {
      public static void hello(String name) {
        System.out.println("hello".indent(4));
      }
    }
    ```
    * 用低于Java 11的JVM运行`Hello`会得到一个`LinkageError`，因为无法加载Hello.class文件，而用Java 11运行`Hello`会得到一个`NoSuchMethodError`，因为`String.indent()`方法是从Java 12才添加进来的，Java 11的String版本根本没有`indent()`方法。 
    * 如果使用`--release 11`则会在编译时检查该方法是否在Java 11中存在。
    * 因此，如果运行时的JVM版本是Java 11，则编译时也最好使用Java 11，而不是用高版本的JDK编译输出低版本的class。
* 模块化 [Reference](https://www.liaoxuefeng.com/wiki/1252599548343744/1281795926523938) [实践代码](src/main/java/module-info.java)
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
* Java核心类 [Reference](https://www.liaoxuefeng.com/wiki/1252599548343744/1260576204194144) [实践代码](src/main/java/c02oop/javabase)

## 15. 网络编程 [实践代码](src/main/java/com/hiwangzi/c15_network)
## 20. Web开发 [实践代码](src/main/java/com/hiwangzi/c20_web)
