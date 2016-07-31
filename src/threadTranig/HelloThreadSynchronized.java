package threadTranig;

/**Создание потока */
public class HelloThreadSynchronized extends Thread {
	boolean flag;
	IncreaseCounter enlargerCounter;

	HelloThreadSynchronized(IncreaseCounter counter, String name, boolean fl) {
		super(name);
		// flag = (flag) ? false : true;
		this.flag = fl;
		enlargerCounter = counter;
//		start();
	}

	public void run() {
		if (!this.flag) {
			while (IncreaseCounter.i<100) {
//				System.out.println("start " + this.getName());
				enlargerCounter.f(this.getName());
			}
		} else {
			while (IncreaseCounter.i<100) {
//				System.out.println("start " + this.getName());
				enlargerCounter.s(this.getName());
			}
		}
	}
}

/** варинант через паузу public void run() { while (true) { synchronized
 * (enlargerCounter) { enlargerCounter.goCount(this.getName()); try {
 * sleep(150); } catch (InterruptedException e) { 
 * block e.printStackTrace(); } } try { sleep(150); } catch
 * (InterruptedException e) { 
 * e.printStackTrace(); } }
 * 
 * }
 */
