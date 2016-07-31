package threadTranig;

import java.util.Scanner;

/**стартовый класс
 * Написать приложение, в котором используются 2 потока(класс один и тот же).
 * Класс потока задать как наследник Thread. Класс потока должен обеспечивать в
 * методе run построчный несинхронизированный вывод в консольное окно чисел от 1
 * до 100 порциями по 10 чисел в строке, разделенных пробелами, причем перед
 * каждой такой порцией должна стоять надпись: "Thread 1:" для первого потока,
 * "Thread 2:" — для второго - можно использовать название потока (есть
 * соответствующий метод). В приложении при вводе с клавиатуры "start" потоки
 * должны стартовать. * Усовершенствовать предыдущее приложение, обеспечив
 * синхронизацию, чтобы потоки выводили строки по очереди..
 */
public class MainThread {

	public static void main(String[] args) throws InterruptedException {

		// несинхронизированный вывод.
		/*
		 * HelloThread first = new HelloThread("firstThread"); 
		 * HelloThread second = new HelloThread("secondThread");
		 */

		IncreaseCounter counter = new IncreaseCounter();
		HelloThreadSynchronized first = new HelloThreadSynchronized(counter, "firstSynchThread", true);
		HelloThreadSynchronized second = new HelloThreadSynchronized(counter, "secondSynchThread", false);

		while (true) {
			String select = startMenu();
			if (select.equalsIgnoreCase("start")) {

				first.start();
				second.start();
				try {
					second.join();
					first.join();
				} catch (InterruptedException e) {
					System.out.println("Пpepвaнo ");
				}

			}
		}

	}

	private static String startMenu() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Главное меню");
		System.out.println("start - ввести для запуска.");
		return sc.nextLine();
	}

}

/*
 * 
 * HelloThread hello = new HelloThread(); hello.start(); HelloRunnable
 * helloRunnable = new HelloRunnable(); Thread thread = new
 * Thread(helloRunnable); thread.start();
 * 
 * String obj= new String("sd"); synchronized (obj) { try { obj.wait();
 * //остановить поток } catch (InterruptedException e) { e.printStackTrace(); }
 * } synchronized (obj) { //запустить поток obj.notify(); // obj.notifyAll()
 * 
 * } //wait() - //notify()
 */