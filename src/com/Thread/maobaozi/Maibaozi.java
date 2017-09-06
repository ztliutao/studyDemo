package com.Thread.maobaozi;

/**
 * 理解生产者和消费者
 *
 * @author liutao
 *
 */
public class Maibaozi {
	public static void main(String[] args) {
		Penzi pen = new Penzi();
		Producter p = new Producter(pen);
		Consumer c = new Consumer(pen);
		new Thread(p).start();
		new Thread(c).start();
	}
}
