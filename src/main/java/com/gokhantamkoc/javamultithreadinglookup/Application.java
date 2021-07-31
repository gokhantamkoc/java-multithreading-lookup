package com.gokhantamkoc.javamultithreadinglookup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
	public static void main(String[] args) {
		// Implements Runnable
		for (int i = 0; i < 100; i++) {
			com.gokhantamkoc.javamultithreadinglookup.runnable.Job job1 = new com.gokhantamkoc.javamultithreadinglookup.runnable.Job(i);
			Thread thread = new Thread(job1);
			thread.start();
		}
		
		// Extends Thread
		for (int i = 0; i < 100; i++) {
			com.gokhantamkoc.javamultithreadinglookup.threadinheritance.Job job2 = new com.gokhantamkoc.javamultithreadinglookup.threadinheritance.Job(i);
			Thread thread = new Thread(job2);
			thread.start();
		}

		// Callable
		for (int i = 0; i < 100; i++) {
			com.gokhantamkoc.javamultithreadinglookup.callable.Job job3 = new com.gokhantamkoc.javamultithreadinglookup.callable.Job(i);
			job3.run();
		}
		
		// Callable MultiThread
		List<Integer> indices = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			indices.add(i);
		}
		
		com.gokhantamkoc.javamultithreadinglookup.callable.Job job4 = new com.gokhantamkoc.javamultithreadinglookup.callable.Job(indices);
		try {
			job4.runAll();				
		} catch(Exception e) {
			
		}
		
		// Threads Using Lambda Expressions
		com.gokhantamkoc.javamultithreadinglookup.lambdafunctions.Job job5 = new com.gokhantamkoc.javamultithreadinglookup.lambdafunctions.Job();
		job5.run();
	}
}
