package com.sanjar.threading.advanced;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * @author Sadique
 *
 *@see
 *  If you've several long running tasks that you want to load in parralel and then wait for the completion of all the tasks, it's a little bit harder to code and if you want to get the return value of all the tasks it becomes really difficult to keep a good code. But like for almost any problems, Java has a solution for you, the Executors. This simple class allows you to create thread pools and thread factories.

A thread pool is represented by an instance of the class ExecutorService. With an ExecutorService, you can submit task that will be completed in the future. Here are the type of thread pools you can create with the Executors class :
<br>
<b>Single Thread Executor</b> : A thread pool with only one thread. So all the submitted task will be executed sequentially. Method : Executors.newSingleThreadExecutor()
<br>
<b>Cached Thread Pool </b>: A thread pool that create as many threads it needs to execute the task in parralel. The old available threads will be reused for the new tasks. If a thread is not used during 60 seconds, it will be terminated and removed from the pool. Method : Executors.newCachedThreadPool()
<br>
<b>Fixed Thread Pool </b>: A thread pool with a fixed number of threads. If a thread is not available for the task, the task is put in queue waiting for an other task to ends. Method : Executors.newFixedThreadPool()
<br>
<b>Scheduled Thread Pool </b>: A thread pool made to schedule future task. Method : Executors.newScheduledThreadPool()
<br>
<b>Single Thread Scheduled Pool</b> : A thread pool with only one thread to schedule future task. Method : Executors.newSingleThreadScheduledExecutor()
 */

public class CustomExecutor {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
	//execute that task 10 times using 4 threads	
	ExecutorService executorService =	Executors.newFixedThreadPool(4);
	List<Future<String>> futures = new ArrayList<Future<String>>();
	for(int i =0;i<10;i++){
		Future<String> future = executorService.submit(new MyTask());
		futures.add(future);
	//System.out.println("future: "+future.get());
	}
	//get the result of the task
	getFutureResult(futures);
	//you must shutdown the thread pool in order to terminate all the threads of the pool
	//If you don't do that, the JVM risk to not shutdown because there is still threads not terminated.
	//You can also force the shutdown of the pool using shutdownNow, with that the currently running tasks will be interrupted and the tasks not started will not be started at all.
	executorService.shutdown();
	}

	private static void getFutureResult(List<Future<String>> futures) throws InterruptedException, ExecutionException {
		for (Future<String> future : futures) {
			System.out.println("Future Result: "+future.get());
		}
	}
}

class MyTask implements Callable<String>{

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName());
		return Thread.currentThread().getName();
	}

	
	
}