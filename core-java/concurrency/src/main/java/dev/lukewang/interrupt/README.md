* [InterruptedDemo](./InterruptedDemo.java)：通过**静态**方法 `Thread.interrupted()` 决定是否提前结束任务，这种方式会复位打断状态。
* [IsInterruptedDemo](./IsInterruptedDemo.java)：使用**对象**方法 `Thread.currentThread().isInterrupted()` 判断是否被打断，这种方式**不会**去复位打断状态。

> The interrupt mechanism is implemented using an internal flag known as the interrupt status. Invoking `Thread.interrupt` sets this flag. When a thread checks for an interrupt by invoking the static method `Thread.interrupted`, interrupt status is cleared. The non-static `isInterrupted` method, which is used by **one thread to query the interrupt status of another**, does not change the interrupt status flag.
> https://docs.oracle.com/javase/tutorial/essential/concurrency/interrupt.html

---

> By convention, any method that exits by throwing an InterruptedException clears interrupt status when it does so. However, it's always possible that interrupt status will immediately be set again, by another thread invoking interrupt.
> https://docs.oracle.com/javase/tutorial/essential/concurrency/interrupt.html

这段话描述了一个关于 Java 中处理中断的重要约定和可能出现的情况。让我来解释一下，并提供一个例子。

解释：

1. 约定：按照惯例，任何通过抛出 InterruptedException 退出的方法都会在抛出异常时清除中断状态。

2. 可能性：然而，总是存在这样的可能性，即中断状态可能会立即被再次设置。这是因为另一个线程可能会再次调用 interrupt() 方法。

这个约定的目的是为了保持一致性和可预测性。当一个方法抛出 InterruptedException 时，它已经对中断做出了响应，因此清除中断状态是合理的。但是，由于多线程的特性，其他线程可能会在任何时候再次中断该线程。

示例：

```java
public class InterruptExample {
    public static void main(String[] args) {
        Thread worker = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Worker: Working...");
                    try {
                        Thread.sleep(1000); // 可能抛出 InterruptedException
                    } catch (InterruptedException e) {
                        System.out.println("Worker: Sleep interrupted. Re-interrupting.");
                        Thread.currentThread().interrupt(); // 重新设置中断状态
                        // 注意：这里不抛出异常，而是重新设置中断状态
                    }
                }
            } finally {
                System.out.println("Worker: Interrupted status when exiting: " 
                                   + Thread.currentThread().isInterrupted());
            }
        });

        worker.start();

        // 主线程休眠一段时间后中断 worker 线程
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.interrupt();

        // 主线程再次中断 worker 线程
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.interrupt();
    }
}
```

在这个例子中：

1. worker 线程在一个循环中工作，每次迭代都会睡眠 1 秒。

2. 主线程在 3.5 秒后中断 worker 线程。

3. 当 `Thread.sleep(1000)` 被中断时，它会抛出 InterruptedException 并清除中断状态。

4. 在 catch 块中，我们遵循最佳实践，通过调用 `Thread.currentThread().interrupt()` 重新设置中断状态。

5. 主线程在短暂延迟后再次中断 worker 线程，展示了中断状态可能被立即重新设置的情况。

6. 最后，我们打印 worker 线程退出时的中断状态，以验证最终状态。

这个例子展示了如何正确处理 InterruptedException，以及如何在捕获到中断后重新设置中断状态，同时也说明了中断状态可能被其他线程随时设置的情况。

---

Q: 为什么通过调用 Thread.currentThread().interrupt() 重新设置中断状态是最佳实践？

调用 `Thread.currentThread().interrupt()` 重新设置中断状态被认为是最佳实践，原因如下：

1. 保持中断状态的一致性：
   当捕获 InterruptedException 时，中断状态已经被清除。重新设置中断状态可以确保线程的状态与预期一致，即保持被中断的状态。

2. 传播中断信号：
   重新设置中断状态允许中断信号在调用栈中向上传播。这对于实现可取消的任务或操作特别重要。

3. 支持更高层次的中断处理：
   在更高层次的代码中，可能会检查线程的中断状态来决定是否继续执行。如果不重新设置中断状态，这些检查可能会失效。

4. 遵循"中断契约"：
   许多 Java 库和框架依赖于这种中断处理模式。遵循这种做法可以确保你的代码与这些库和框架正确交互。

5. 清晰的代码意图：
   重新设置中断状态清晰地表明了代码的意图 - 你已经注意到中断，但选择将其传播而不是完全处理它。

示例：

```java
public void runTask() {
    try {
        while (!Thread.currentThread().isInterrupted()) {
            // 执行一些可能耗时的操作
            performOperation();
        }
    } catch (InterruptedException e) {
        // 重新设置中断状态
        Thread.currentThread().interrupt();
        // 可以选择在这里进行一些清理操作
    }
}

private void performOperation() throws InterruptedException {
    // 模拟一个可能抛出 InterruptedException 的操作
    Thread.sleep(1000);
}
```

在这个例子中，如果 `performOperation()` 方法被中断并抛出 InterruptedException，我们捕获异常并重新设置中断状态。这样，如果有更高层次的代码需要检查中断状态，它仍然能够检测到中断发生了。

总之，重新设置中断状态是一种维护线程状态一致性、支持可取消操作和确保与其他代码正确交互的重要实践。