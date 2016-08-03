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
		// th.start();
	}

	public void run() {
		// статистика
		int i = 0;// кол. клиентов
		int cosht = 0; // общее кол. ед. товара
		// обслуживание клиентов
		while (true) {
			try {
				VisitorBuyer visitor = queueVisitorBuyer.remove();
				result = new StringBuilder();
				result = result.append(this.th.getName()).append("~");
				result = result.append(visitor.getClientNumber()).append("~");
				result = result.append(visitor.getProductId()).append("~");
				result = result.append(visitor.getCountProduct()).append("~");
				result = result.append(visitor.getPrice()).append("~");
				result = result.append(visitor.getPrice() * visitor.getCountProduct()).append("~");
				//задать паузу на шт. товара
				// Thread.sleep(5 * visitor.getCountProduct()); 

				System.out.printf("%1$-8s|%2$3s|%3$-10s|%4$3s|%5$7s|%6$7s руб\n", result.toString().split("~"));
				i++;
				cosht += visitor.getCountProduct();// считаем товары
				//задать паузу на шт. товара
				//Thread.sleep(10 * visitor.getCountProduct()); 
			} catch (Exception e) {
				System.out.println(this.th.getName() + ": обслужено " + " клиентов- " + i + ", единиц товара - " + cosht
						+ " время исполнения " + (System.currentTimeMillis() - MainCashRegister.start) + "мс");
				break;
			}
		}
	}
}
