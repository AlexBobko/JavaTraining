package storeCashRegister;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Дано: Напишите программу, моделирующую кассы в магазине. Существует несколько касс,
 * работающих одновременно. Каждый покупатель - отдельный поток. Общее
 * количество покупателей может быть больше чем количество касс, но одновременно
 * не может обрабатываться больше покупателей чем имеется рабочих касс. У
 * каждого покупателя есть набор товаров, которые должны быть выведены в
 * процессе обслуживания.
 * 
 * задаем количество касс (потоков обработки клиента)
 * задаем количество покупателей - сгенерится у каждого по 1 типу продукта
 * по 1-5шт. 
 * В зависимости от количество - время обработки на кассе по ~10ms+ на шт.
 * 
 * алгоритм работы: 
 * 1 набирается очередь (генератор клиентов)
 * после того как наберется 20 клиентов подключаются кассы (доп потоки) 
 * когда очередь обработана - кассы отключаются
 */
public class MainCashRegister {

	private static Random random = new Random();
	private static ConcurrentLinkedQueue<VisitorBuyer> queue = new ConcurrentLinkedQueue<VisitorBuyer>();

	public static void main(String[] args) {

		int countCashbox = 5; // количество потоков-касс
		int countVisitorBuyer = 300; // количество покупателей

		// набиваем очередь рандомными клиентами с их нумерацией
		for (int ii = 1; ii <= countVisitorBuyer; ii++) {
			if (ii == 20) {
				// подключаем кассы после того как набралось 20 клиентов 
				//передаем туда общую очередь
				for (int i = 1; i <= countCashbox; i++) {
					new Cashbox(i, queue);
				}
			}
			queue.add(generatorVisitorBuyer(ii));
		}
	}

	// генератор покупателя
	public static VisitorBuyer generatorVisitorBuyer(int number) {
		StringBuilder currentProductId = new StringBuilder();
		// генерим название/инв номер продукта
		currentProductId = currentProductId.append("invId").append(random.nextInt(89999) + 10000);
		// генерим ценник
		float currentPrice = (float) (random.nextInt(9800) + 199) / 100;
		// количество единиц такого товара
		int currentCountProduct = (random.nextInt(5) + 1);
		return new VisitorBuyer(number, currentProductId.toString(), currentPrice, currentCountProduct);
	}

}
