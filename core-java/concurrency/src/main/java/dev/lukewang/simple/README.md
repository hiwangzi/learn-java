* [InterruptedDemo](./InterruptedDemo.java)：通过**静态**方法 `Thread.interrupted()` 决定是否提前结束任务，这种方式会复位打断状态。
* [IsInterruptedDemo](./IsInterruptedDemo.java)：使用**对象**方法 `Thread.currentThread().isInterrupted()` 判断是否被打断，这种方式**不会**去复位打断状态。
