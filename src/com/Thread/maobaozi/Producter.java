package com.Thread.maobaozi;

public class Producter implements Runnable {
	Penzi penzi;

	public Producter(Penzi penzi) {
		this.penzi = penzi;
	}

	@Override
	public void run() {
		System.out.println("包子铺开始做包子了。。。。");
		for (int i = 0; i <= 10; i++) {
			Baozi bz = new Baozi(i);
			penzi.push(bz);
			System.out.println("做好了包子" + bz);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
