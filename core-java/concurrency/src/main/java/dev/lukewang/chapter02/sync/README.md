> Threads communicate primarily by sharing access to fields and the objects reference fields refer to. This form of communication is extremely efficient, but makes two kinds of errors possible: **thread interference** and **memory consistency errors**. The tool needed to prevent these errors is **synchronization**.

* Thread interference, one thread's result is lost, overwritten by another thread.
* Memory consistence errors occur when different threads have inconsistent views of what should be the same data. The key to avoiding memory consistency errors is understanding the [_happens-before_](https://github.com/hiwangzi/notes/blob/34cf8470d28c52eda47060d584712a88887149ac/Java/JVM/happens-before.md) relationship.

---

* [BadBank](bank/ext/BadBank.java) 展示了没有提供同步机制的代码，会造成数据的不一致。

* [ReentrantLockBank](bank/ext/ReentrantLockBank.java) 通过
使用 `java.util.concurrent.locks.ReentrantLock`和 `java.util.concurrent.locks.Condition` 
使得数据得以同步，及满足了一定条件才执行转账。

* [SynchronizedBank](bank/ext/SynchronizedBank.java) 通过使用 `synchronized` 关键字简化同步的逻辑，
等价于用了一个仅单条件的内部锁。
