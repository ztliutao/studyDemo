package com.Thread;

public class SynRightTest {
	static int mc = 0;

	public static void main(String[] args) {
		Num num=new Num(mc);
		SS s = new SS(num);
		BB b = new BB(num);
		new Thread(s).start();
		new Thread(b).start();

	}
	static class Num {
		 int id;
		 public Num(int id){
			 this.id=id;
		 }

	}

	static class SS implements Runnable {
		Num num;
		int sno;
		public SS(Num num) {
			this.num = num;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				synchronized (this) {
					sno=num.id;
					num.id++;
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("+++++++++++++++++++++:" +sno);
			}
		}

	}

	static class BB implements Runnable {
		Num num;
		int sno;

		public BB(Num num) {
			this.num = num;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				synchronized (this) {
					sno=num.id;
					num.id++;
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				System.out.println("---------------------:" + sno);
			}
		}

	}

}
