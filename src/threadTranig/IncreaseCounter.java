package threadTranig;

/**Выводит строки
 * */
public class IncreaseCounter {
	static int i = 1;
	boolean valueSet = true;

	synchronized void goCount(String name) {
		StringBuilder str = new StringBuilder();
		str = str.append(name + ":");
		for (; i < 101; i++) {
			str = str.append(" " + i);
			if (i % 10 == 0) {
				System.out.println(str);
				i++;
				return;
			}
		}
		if (i > 100) {
			return;
		}
	}

	synchronized public void f(String name) {
		while (valueSet) {
//			 System.out.println("f1 wait " + name);
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

//		 System.out.println("f " + valueSet);
		goCount(name);
		valueSet = true;
		notify();
//		 System.out.println(name + " notify " + valueSet);
		return;
	}

	synchronized public void s(String name) {
//		 System.out.println("s1 wait " + valueSet);
		while (!valueSet) {
//			 System.out.println("s1 " + name);
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		goCount(name);
//		 System.out.println("s " + valueSet);
		valueSet = false;
		notify();
//		 System.out.println(name + " notify " + valueSet);
		return;
	}
}
