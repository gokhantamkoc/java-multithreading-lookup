package com.gokhantamkoc.javamultithreadinglookup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
	public static void main(String[] args) {
		
		//Implements Runnable
		for (int i = 0; i < 100; i++) {
			com.gokhantamkoc.javamultithreadinglookup.runnable.Job job = new com.gokhantamkoc.javamultithreadinglookup.runnable.Job(i);
			Thread thread = new Thread(job);
			thread.start();
		}
		
		// Extends Thread
		for (int i = 0; i < 100; i++) {
			com.gokhantamkoc.javamultithreadinglookup.threadinheritance.Job job = new com.gokhantamkoc.javamultithreadinglookup.threadinheritance.Job(i);
			Thread thread = new Thread(job);
			thread.start();
		}

		// Callable
		for (int i = 0; i < 100; i++) {
			com.gokhantamkoc.javamultithreadinglookup.callable.Job job = new com.gokhantamkoc.javamultithreadinglookup.callable.Job(i);
			job.run();
		}
		
		// Callable MultiThread
		List<Integer> indices = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			indices.add(i);
		}
		
		com.gokhantamkoc.javamultithreadinglookup.callable.Job job = new com.gokhantamkoc.javamultithreadinglookup.callable.Job(indices);
		try {
			job.runAll();				
		} catch(Exception e) {
			
		}
	}
}
