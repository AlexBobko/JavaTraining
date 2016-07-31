package threadTranig;

/**DeadLock
 */
public class MainThreadDeadlock {

	public static void main(String[] args) {
		
		IncreaseCounter firstCounter=new IncreaseCounter ();
		IncreaseCounter secondCounter=new IncreaseCounter ();
		HelloRunnable firstThr= new HelloRunnable("firstThr", firstCounter,secondCounter);
		HelloRunnable secondThr= new HelloRunnable("secondThr",secondCounter,firstCounter);
		try {
			firstThr.th.join();
			secondThr.th.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
