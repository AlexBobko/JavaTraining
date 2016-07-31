package threadTranig;

/**Класс для несинхронизированного вывода
 * Создание нового потока */
public class HelloThread extends Thread {
	private int i = 0;
	
	HelloThread (String name) {
		super (name);
	}
	
	public void run() {
		StringBuilder str=new StringBuilder();
		/*System.out.println("Hello from a thread!" + this.getName());*/
		str=str.append(this.getName()+":");
		for (i = 1; i < 101; i++) {
			str=str.append(" "+ i);
			if (i % 10 == 0) {
				System.out.println(str);
				str=new StringBuilder();
				str=str.append(this.getName()+":");
			}
		}
	}	
}