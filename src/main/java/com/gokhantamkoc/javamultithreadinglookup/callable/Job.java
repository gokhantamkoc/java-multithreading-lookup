package com.gokhantamkoc.javamultithreadinglookup.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Job {
	// The concept of Future is similar to Promise in other languages like Javascript.
	private int index;
	private ExecutorService executorService;
	private List<Integer> indices;
	
	public Job(int index) {
		this.index = index;
	}
	
	public Job(List<Integer> indices) {
		this.indices = indices;
	}
	
	public void run() {
		try {
			Callable<String> callable = new Callable<String>() {
				@Override
			    public String call() throws Exception {
			        // Perform some computation
			        // Thread.sleep(100);
			        return "Callable " + index + " running";
			    }
			};
			executorService = Executors.newSingleThreadExecutor();
			Future<String> future = executorService.submit(callable);
			System.out.println(future.get());
			executorService.shutdown();
		} catch(Exception e) {
			
		}
	}
	
	// Callable thread'e benzer yapisi var.
	// cancel === kill
	// Thread'deki gibi pause edilemiyor!
	
	public void runAll() throws InterruptedException, ExecutionException {
		if (this.indices != null) {
			int size = this.indices.size();
			if (size > 0) {
				executorService = Executors.newFixedThreadPool(20);
				List<Callable<String>> callables = new ArrayList<Callable<String>>();
				this.indices.forEach(index -> {
					Callable<String> callable = new Callable<String>() {
						@Override
					    public String call() throws Exception {
					        // Perform some computation
					        // Thread.sleep(100);
					        return "Callable " + index + " running";
					    }
					};
					callables.add(callable);
				});
				
				List<Future<String>> futures = executorService.invokeAll(callables);
		        for(Future<String> future: futures) {
		            System.out.println(future.get());
		        }
		        executorService.shutdown();
			}
		}
	}
}
