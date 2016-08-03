package storeCashRegister;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Дано: Напишите программу, моделирующую кассы в магазине. Существует несколько
 * касс, работающих одновременно. Каждый покупатель - отдельный поток. Общее
 * количество покупателей может быть больше чем количество касс, но одновременно
 * не может обрабатываться больше покупателей чем имеется рабочих касс. У
 * каждого покупателя есть набор товаров, которые должны быть выведены в
 * процессе обслуживания.
 * 
 * задаем количество касс (потоков обработки клиента) задаем количество
 * покупателей - сгенерится у каждого по 1 типу продукта по 1-5шт. В зависимости
 * от количество - время обработки на кассе по ~10ms+ на шт.
 * 
 * алгоритм работы: 1 набирается очередь (генератор клиентов) после того как
 * наберется 20 клиентов подключаются кассы (доп потоки) когда очередь
 * обработана - кассы отключаются и выводят результат
 */
public class MainCashRegister {
	public static long start = System.currentTimeMillis(); // время выполнения
													// программы
	private static Random random = new Random();
	private static ConcurrentLinkedQueue<VisitorBuyer> queue = new ConcurrentLinkedQueue<VisitorBuyer>();
	private static ExecutorService threads = Executors.newCachedThreadPool();

	public static void main(String[] args) {

		int countCashbox = 3; // задаем количество потоков-касс
		int countVisitorBuyer = 300000; // задаем количество покупателей

		// заголовок вывода результата
		System.out.printf("%1$-8s|%2$3s|%3$-10s|%4$3s|%5$7s|%6$7s \n", "№ кассы", "кл.", "товар", "шт", "цена",
				"сумма");
		// набиваем очередь рандомными клиентами с их нумерацией
		for (int ii = 1; ii <= countVisitorBuyer; ii++) {
			// подключаем кассы после того как набралось 20 клиентов
			if (ii == 4000) {

				// передаем туда общую очередь
				for (int i = 1; i <= countCashbox; i++) {
					threads.submit(new Cashbox(i, queue));
					// new Cashbox(i, queue);
				}

			}
			queue.add(generatorVisitorBuyer(ii));
		}
		threads.shutdown();
		long end = System.currentTimeMillis() - start;
		System.out.println("время выполнения основного потока - " + end + "мс");
	}

	// генератор покупателя
	public static VisitorBuyer generatorVisitorBuyer(int number) {
		StringBuilder currentProductId = new StringBuilder();
		currentProductId = currentProductId.append("tovar").append(random.nextInt(89999) + 10000);
		float currentPrice = (float) (random.nextInt(9800) + 199) / 100;
		// количество единиц такого товара - загруженность обработки
		int currentCountProduct = (random.nextInt(5) + 1);
		return new VisitorBuyer(number, currentProductId.toString(), currentPrice, currentCountProduct);
	}

}
