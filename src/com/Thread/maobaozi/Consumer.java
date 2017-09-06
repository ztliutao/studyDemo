package com.Thread.maobaozi;

public class Consumer implements Runnable {
	Penzi pen;

	public Consumer(Penzi penzi) {
		this.pen = penzi;
	}

	@Override
	public void run() {
		System.out.println("包子铺开始卖包子了");
		for (int i = 0; i <= 10; i++) {
			Baozi bz = pen.reduce();
			System.out.println("卖出了包子" + bz);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
