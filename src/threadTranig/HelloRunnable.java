package threadTranig;
/**Реализация потока через implements Runnable (к Deadlock)
 */
public class HelloRunnable implements Runnable {
	Thread th;
	IncreaseCounter a;
	IncreaseCounter b;

	HelloRunnable(String name, IncreaseCounter first, IncreaseCounter second) {
		th = new Thread(this, name);
		a = first;
		b = second;
		th.start();
	}

	public void run() {
		System.out.println(th.getName());
		a.f(th.getName());
		try {
			this.th.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("hello deadlock");
		b.s(th.getName());
	}

}