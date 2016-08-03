package storeCashRegisterThreadClient;

//import java.awt.*;
import java.io.PrintStream;
import java.awt.List;
import java.util.*;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Дано: Напишите программу, моделирующую кассы в магазине. Существует несколько
 * касс, работающих одновременно. Каждый покупатель - отдельный поток. Общее
 * количество покупателей может быть больше чем количество касс, но одновременно
 * не может обрабатываться больше покупателей чем имеется рабочих касс. У
 * каждого покупателя есть набор товаров, которые должны быть выведены в
 * процессе обслуживания.
 * 
 */
public class MainCashReg {
	static int countCashbox = 5; // задаем количество потоков-касс
	static int countVisitorBuyer = 50; // задаем количество покупателей
	static String fOut = "%1$-8s|%2$3s|%3$-10s|%4$3s|%5$7s|%6$7s руб\n";
	static int ii = 0;
	private static Random random = new Random();

	private static ArrayBlockingQueue<CashboxAlternative> queue = new ArrayBlockingQueue<CashboxAlternative>(
			countCashbox, true);
	private static ConcurrentLinkedQueue<Future<StringBuffer>> queueFuture = new ConcurrentLinkedQueue<Future<StringBuffer>>();

	// private static ConcurrentLinkedQueue<CashboxAlternative> queue = new
	// ConcurrentLinkedQueue<CashboxAlternative>();
	// private static ExecutorService threads = Executors.newCachedThreadPool();
	private static ExecutorService threads = Executors.newFixedThreadPool(countCashbox);

	// static ExecutorService pool = Executors.newFixedThreadPool(countCashbox);

	public static void main(String[] args) {
		// заголовок вывода результата
		System.out.printf("%1$-8s|%2$3s|%3$-10s|%4$3s|%5$7s|%6$7s \n", "№ кассы", "кл.", "товар", "шт", "цена",
				"сумма");

		// создаем кассы
		for (int i = 1; i <= countCashbox; i++) {
			try {
				queue.put(new CashboxAlternative(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Ошибка добавления элемента");
			}
		}
		// набиваем очередь рандомными клиентами с их нумерацией
		for (ii = 1; ii <= countVisitorBuyer; ii++) {
			Future<StringBuffer> currentFuture = threads.submit(generatorVisitorBuyer(ii));
			try {
				queueFuture.add(currentFuture);
				// System.out.printf(fOut,currentFuture.get().toString().split("~"));
			} catch (Exception e) {
				System.out.println("Результат не добавлен");
			}
		}
		threads.shutdown();
		while (true) {
			try {
//				Future<StringBuffer> currentFutureOut = queueFuture.remove();
				System.out.printf(fOut, queueFuture.remove().get().toString().split("~"));
			} catch (InterruptedException e) {
//				e.printStackTrace();
				
			} catch (ExecutionException e) {
//				e.printStackTrace();
				
			} catch (Exception e) {
				System.out.println("Обработка закончена");
				break;
			}
			finally {
//				System.out.println("Обработка закончена");
			}
		}
	}

	// генератор покупателя
	public static VisitorBuyerThead<?> generatorVisitorBuyer(int number) {
		StringBuffer currentProductId = new StringBuffer();
		currentProductId = currentProductId.append("tovar").append(random.nextInt(89999) + 10000);
		float currentPrice = (float) (random.nextInt(9800) + 199) / 100;
		// количество единиц такого товара - загруженность обработки
		int currentCountProduct = (random.nextInt(5) + 1);
		return new VisitorBuyerThead(number, currentProductId.toString(), currentPrice, currentCountProduct, queue);
	}
}
