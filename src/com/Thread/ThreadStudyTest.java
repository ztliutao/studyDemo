package com.Thread;

public class ThreadStudyTest implements Runnable {
	int b = 100;

	public synchronized void m1() throws InterruptedException {
		b = 1000;
		System.out.println("woshi m1 b"+b);
		Thread.sleep(5000);
		System.out.println("m1"+b);

	}

	@Override
	public void run() {
		try {
			System.out.println("im run");
			m1();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/*public  void m2() throws InterruptedException {
		Thread.sleep(2500);
		b = 2000;
		System.out.println("m2 "+b);
	}*/
	public synchronized  void m2() throws InterruptedException {
		Thread.sleep(2500);
		b = 2000;
		System.out.println("m2 "+b);
	}

	public static void main(String[] args) throws Exception {
		ThreadStudyTest tt = new ThreadStudyTest();
		Thread t = new Thread(tt);
		t.start();
		tt.m2();
		System.out.println(tt.b);
	}
}
