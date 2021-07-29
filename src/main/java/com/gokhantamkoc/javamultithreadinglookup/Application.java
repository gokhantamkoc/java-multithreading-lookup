package com.gokhantamkoc.javamultithreadinglookup;

public class Application {
	public static void main(String[] args) {
		for (int i = 0; i < 10_000; i++) {
			try {
				System.out.print("test" + i);
				Thread.sleep(1000);
				System.out.print("\r");
			} catch(Exception e) {
				break;
			}		
		}
	}
}
