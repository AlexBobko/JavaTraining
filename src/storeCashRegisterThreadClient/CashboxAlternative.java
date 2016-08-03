package storeCashRegisterThreadClient;

import java.io.PrintStream;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

//import java.util.concurrent.ConcurrentLinkedQueue;

/** Касса магазина */
public class CashboxAlternative {
	// Номер кассы
	int number;
	StringBuffer name = new StringBuffer("");


	CashboxAlternative(int n) {
//		System.out.println(n);
		number = n;
		name = name.append("kassa").append(number);
	}

	public StringBuffer serveVisitorBuyer(StringBuffer str1) {
		StringBuffer result = new StringBuffer();
		result=result.append(name).append("~").append(str1);
//		System.out.println(name);
		// PrintStream printf =
		// System.out.printf("%1$-8s|%2$3s|%3$-10s|%4$3s|%5$7s|%6$7s
		// руб\n",name, result.toString().split("~"));
		// System.out.println(name);
		return result;
	}

	/*
	 * public void run() { //статистика int i = 0;// кол. клиентов int cosht =
	 * 0; //общее кол. ед. товара // обслуживание клиентов while (true) { try {
	 * VisitorBuyerThead visitor = queueVisitorBuyer.remove(); result = new
	 * StringBuilder(); // result =
	 * result.append(this.th.getName()).append("~"); result =
	 * result.append(visitor.getClientNumber()).append("~"); result =
	 * result.append(visitor.getProductId()).append("~"); result =
	 * result.append(visitor.getCountProduct()).append("~"); result =
	 * result.append(visitor.getPrice()).append("~"); result =
	 * result.append(visitor.getPrice() *
	 * visitor.getCountProduct()).append("~"); Thread.sleep(10 *
	 * visitor.getCountProduct()); //пауза от шт. товара
	 * System.out.printf("%1$-8s|%2$3s|%3$-10s|%4$3s|%5$7s|%6$7s руб\n",
	 * result.toString().split("~")); i++; cosht +=
	 * visitor.getCountProduct();//считаем товары } catch (Exception e) { //
	 * System.out.println(this.th.getName() + ": обслужено " + " клиентов- " + i
	 * + ", единиц товара - " + cosht ); break; } } }
	 */
}
