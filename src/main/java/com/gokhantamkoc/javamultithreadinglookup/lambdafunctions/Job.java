package com.gokhantamkoc.javamultithreadinglookup.lambdafunctions;

// reference https://www.w3schools.com/java/java_lambda.asp
public class Job {
	
	public void run() {
		theLambdaThread();
		anotherJob();
	}
	
	public void theLambdaThread() {
		new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Lambda Thread: "+ i);
			}
		}).start();
	}
	
	public void anotherJob() {
		for(int j=1; j < 5; j++) {
			System.out.println("Another Job: "+ j);
			try {
				Thread.sleep(500);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
