package com.gokhantamkoc.javamultithreadinglookup.runnable;

public class Job implements Runnable {

	private int index = 0;
	
	public Job(int index) {
		this.index = index;
	}
	
	@Override
	public void run() {
		System.out.println("Runnable " + this.index + " running");
	}	
}
