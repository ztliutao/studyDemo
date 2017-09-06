package com.Thread;
/**
 * 注意:应当考虑 java 值传递还是引用传递
 * @author liutao
 *
 */
public class SynTest {
	static int mc = 0;

	public static void main(String[] args) {
		SS s = new SS(mc);
		BB b = new BB(mc);
		new Thread(s).start();
		new Thread(b).start();

	}

	static class SS implements Runnable {
		int sno;
		public SS(int  sno) {
			this.sno = sno;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				synchronized (this) {
					sno++;
//					try {
//						Thread.sleep(2000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
				}
				System.out.println("+++++++++++++++++++++:" +sno);
			}
		}

	}

	static class BB implements Runnable {
		int sno;
		public BB(int  sno) {
			this.sno = sno;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				synchronized (this) {
					sno++;
//					try {
//						Thread.sleep(2000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
				}

				System.out.println("---------------------:" + sno);
			}
		}

	}

}
