package storeCashRegister;

import java.util.concurrent.ConcurrentLinkedQueue;

/** Касса магазина */
public class Cashbox implements Runnable {
	// Номер кассы
	int number;
	Thread th;
	ConcurrentLinkedQueue<VisitorBuyer> queueVisitorBuyer;
	StringBuilder result;

	Cashbox(int n, ConcurrentLinkedQueue<VisitorBuyer> q) {
		queueVisitorBuyer = q;
		number = n;
		th = new Thread(this, "kassaN".concat(Integer.toString(number)));
		th.start();
	}

	public void run() {
		// обслуживание клиентов
		int i = 0;
		while (true) {

			// 1 получить клиента из очереди (с удалением) синхронизировать
			// получение
			try {
				VisitorBuyer visitor = queueVisitorBuyer.remove();
				// 2 обработка
				result = new StringBuilder();
				result = result.append(this.th.getName()).append("~");
				result = result.append(visitor.getClientNumber()).append("~");
				result = result.append(visitor.getProductId()).append("~");
				result = result.append(visitor.getCountProduct()).append("~");
				result = result.append(visitor.getPrice()).append("~");
				result = result.append(visitor.getPrice() * visitor.getCountProduct()).append("~");
				Thread.sleep(10 * visitor.getCountProduct());
				System.out.printf("%1$-8s|%2$3s|%3$-10s|%4$3s|%5$7s|%6$7s руб\n", result.toString().split("~"));
				i++;
			} catch (Exception e) {
				System.out.println("на " + this.th.getName() + " обслужено " + i + " клиентов");
				break;
			}
		}
	}

}
