# Multi-Threading in Java

## Optimizing Threads

**Question:** Would manually executing Garbage Collector(GC) solve my memory problem when using multiple threads in a Java Application?

The best thing you can do is to let the `GC` do its thing without any interference. Don't try to force the `GC` to run. It is rarely helpful, and often bad for performance.

The real problem is that you have a **memory leak**. It may be happening because you are getting more and more threads ... or it may be something else.

I would recommend the following:

1. Re-factor your code so that it uses a `ExecutorService`:

	- Manage a finite thread pool, and a queue of tasks to be run on those threads. Creating a thread(`new Thread().start()`) is rather expensive in Java.
	- Do NOT shutdown the thread pool, because you will NOT know a batch of threads is finished executing. It is bad for performance. The best way to do that is to create a `List<Thread/Runnable/Callable>` and pass it to `ExecutorService.invokeAll()` and wait for all tasks to finish.

2. Use **Memory Profiling** and see how your application is leaking memory:

	- [How to find a Java Memory Leak](https://stackoverflow.com/questions/40119/how-to-find-a-java-memory-leak)
	- [How to find memory leak in java using JProfiler?](https://stackoverflow.com/questions/9781611/how-to-find-memory-leak-in-java-using-jprofiler)
	- [How to find memory leaks using visualvm?](https://stackoverflow.com/questions/9154785/how-to-find-memory-leaks-using-visualvm)
	
## Data Integrity

Let's say you have threads do a lot of read and writes. The data integrity would be problematic if read should come after a certain write. Since multi-threading does not ensure(when priorities or queue are not set) which write or read will be executed next, the data integrity CANNOT be ensured.

1. One way is to use Synchronized Blocks or methods.
2. Best way to avoid is using Queues or setting priorities.
	
## Avoiding Deadlocks

In the thread, each object has a lock. To acquire a lock, Java provides synchronization to lock a method or code block. It allows that at a time only one thread can access that method.

Nevertheless, if a thread wants to execute a synchronized method it first tries to acquire a lock. It is possible that another thread has already acquired that lock then the thread (that wants to acquire the lock) will have to wait until the previous thread does not release the lock.

Let's understand it through an example:

Suppose, there are two threads A and B. The thread A and B acquired the lock of Object-A and Object-B, respectively. Assume that thread A executing method A and wants to acquire the lock on Object-B, while thread B is already acquired a lock on Object-B.

On the other hand, thread B also tries to acquire a lock on Object-A, while thread A is acquired a lock on Object-A. In such a situation both threads will not complete their execution and wait for releasing the lock. The situation is known as, deadlock.

### How to Detect Deadlocks?

There are following ways to detect a deadlock:

1. We look and understand the code if we found nested synchronized block or trying to get a lock on a different object or calling a synchronized method from other synchronized method, these reason leads to a deadlock situation.
2. Another way to detect deadlock is to use the io portal. It allows us to upload a thread dump and analyze it.
3. We can also use jConsole or VisualVM to detect deadlock. It shows us which threads are getting locked and on which object.


	