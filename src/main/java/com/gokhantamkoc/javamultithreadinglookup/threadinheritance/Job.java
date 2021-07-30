package com.gokhantamkoc.javamultithreadinglookup.threadinheritance;

public class Job extends Thread {
	
	private int index = 0;
	
	public Job(int index) {
		this.index = index;
	}
	
	public void run() {
		System.out.println("Thread " + this.index + " running");
	}
}
