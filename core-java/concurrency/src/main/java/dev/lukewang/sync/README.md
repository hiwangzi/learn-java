* [BadBank](./bank/ext/BadBank.java) 展示了没有提供同步机制的代码，会造成数据的不一致。

* [ReentrantLockBank](./bank/ext/ReentrantLockBank.java) 通过
使用 `java.util.concurrent.locks.ReentrantLock`和 `java.util.concurrent.locks.Condition` 
使得数据得以同步，及满足了一定条件才执行转账。

* [SynchronizedBank](./bank/ext/SynchronizedBank.java) 通过使用 `synchronized` 关键字简化同步的逻辑，
等价于用了一个仅单条件的内部锁。
