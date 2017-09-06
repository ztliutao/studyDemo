package com.Thread.maobaozi;

public class Penzi {
	int index;
	// 盆子里可存放包子总数
	Baozi[] rongqi = new Baozi[10];

	/**
	 * 存放包子 如果盆子中包子满了,则需要等待
	 *
	 * @param addBz
	 */
	public synchronized void push(Baozi addBz) {
		if (index == rongqi.length) {
			System.out.println("盆子满了。。。。。装不下了");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();
		rongqi[index] = addBz;
		index++;

	}

	/**
	 * 减少包子
	 *
	 * @param reduceBz
	 */
	public synchronized Baozi reduce() {
		if (index == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();
		index--;
		return rongqi[index];
	}

}
