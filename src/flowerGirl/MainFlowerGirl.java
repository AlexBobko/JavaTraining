package flowerGirl;

import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Цветочница. +Определить иерархию цветов. +Создать несколько объектов-цветов.
 * +Собрать букет (используя аксессуары) с определением его стоимости. +Провести
 * сортировку цветов в букете на основе уровня свежести. +Найти цветок в букете,
 * соответствующий заданному диапазону длин стеблей.
 * 
 * Сначала нарисовать иерархию классов, т.е. спроектировать модель. Можете
 * рисовать в word, visio и даже paint :)
 * 
 * Создать консольное приложение, удовлетворяющее следующим требованиям: •
 * Использовать возможности ООП: классы, наследование, полиморфизм,
 * инкапсуляция. • Каждый класс должен иметь отражающее смысл название и
 * информативный состав. • Наследование должно применяться только тогда, когда
 * это имеет смысл. • При кодировании должны быть использованы соглашения об
 * оформлении кода java code convention. • Классы должны быть грамотно разложены
 * по пакетам. • Консольное меню должно быть минимальным. - добавить исключения
 * toString
 * 
 */
public class MainFlowerGirl {
	static Date currentDate = new Date();
	static Locale locale = new Locale("ru", "RU"); 
	// static Locale locale = new Locale("en", "EN");
	public static ResourceBundle rb = ResourceBundle.getBundle("flowerGirl.localization/Messages", locale);
	static DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);
	static String formatPattern = "%1$-25s|%2$-6s|%3$-9s|%4$-10s|%5$-5s|%6$-6s|%7$-6s|\n";
	// аксессуары
	static Accessory basket = new Accessory(rb.getString("basket"), (float) 9);
	static Accessory ribbon = new Accessory(rb.getString("ribbon"), (float) 0.8);
	static Accessory wrappingPaper = new Accessory(rb.getString("wrappingPaper"), (float) 0.4);
	static Accessory wrappingPoli = new Accessory(rb.getString("wrappingPoli"), (float) 1.2);
	// розы длина, цена, свежесть(дн), цв, размер бутона
	static Rose redShortRose = new Rose("redShortRose", 30, (float) 7, 2, rb.getString("red"), BudSize.SMALL);
	static Rose redMediumRose = new Rose("redMediumRose", 40, (float) 9, 3, rb.getString("red"), BudSize.MEDIUM);
	static Rose redGreaterRose = new Rose("redGreaterRose", 50, (float) 12, 2, rb.getString("red"), BudSize.MEDIUM);
	static Rose redEnormousRose = new Rose("redEnormousRose", 60, (float) 15, 1, rb.getString("red"), BudSize.LARGE);
	static Rose whiteShortRose = new Rose("whiteShortRose", 30, (float) 6, 2, rb.getString("white"), BudSize.SMALL);
	static Rose whiteMediumRose = new Rose("whiteMediumRose", 40, (float) 8, 4, rb.getString("white"), BudSize.MEDIUM);
	static Rose whiteGreaterRose = new Rose("whiteGreaterRose", 50, (float) 11, 3, rb.getString("white"),
			BudSize.LARGE);
	static Rose whiteEnormousRose = new Rose("whiteEnormousRose", 60, (float) 13, 4, rb.getString("white"),
			BudSize.LARGE);
	// лилии длина, цена, свежесть (дн), цв, кол. ответвлений
	static Lily whiteMediumLily = new Lily("whiteMediumLily", 45, (float) 17, 5, rb.getString("white"), 3);
	static Lily whiteGreaterLily = new Lily("whiteGreaterLily", 50, (float) 22, 2, rb.getString("white"), 3);
	static Lily whiteEnormousLily = new Lily("whiteEnormousLily", 60, (float) 25, 3, rb.getString("white"), 3);
	static Lily whiteMediumBushyLily = new Lily("whiteMediumBushyLily", 45, (float) 23, 5, rb.getString("white"), 5);
	static Lily whiteGreaterBushyLily = new Lily("whiteGreaterBushyLily", 50, (float) 27, 3, rb.getString("white"), 5);
	static Lily whiteEnormousBushyLily = new Lily("whiteEnormousBushyLily", 60, (float) 31, 2, rb.getString("white"),
			5);
	static Bouquet firstBouquet = new Bouquet(BouquetType.COMPOSITION);
	// static Bouquet firstBouquet2 = new Bouquet(BouquetType.COMPOSITION);

	public static void main(String[] args) {
		// System.out.println(whiteGreaterBushyLily.hashCode());
		// System.out.println(whiteEnormousBushyLily.hashCode());
		// System.out.println(whiteGreaterLily.hashCode());
		// составляем букет элемент, кол-во
		LogerFlowerGirl.addlog("start program");
		firstBouquet.addAccessory(ribbon, 2);
		firstBouquet.addAccessory(wrappingPaper, 1);
		firstBouquet.addAccessory(basket, 1);
		firstBouquet.addFlower(whiteEnormousLily, 1);
		firstBouquet.addFlower(whiteMediumBushyLily, 3);
		firstBouquet.addFlower(whiteGreaterLily, 5);
		firstBouquet.addFlower(whiteMediumRose, 3);
		firstBouquet.addFlower(redEnormousRose, 2);
		firstBouquet.addFlower(redShortRose, 7);
		firstBouquet.addFlower(whiteGreaterRose, 5);
		firstBouquet.addFlower(redGreaterRose, 4);
		firstBouquet.addFlower(whiteEnormousRose, 1);
		firstBouquet.addFlower(redEnormousRose, 1);

		// обработчик основного меню
		menu: while (true) {
			String select = startMenu();
			System.out.println(select);
			switch (select) {
			case "q": {
				System.out.println(rb.getString("quit"));
				LogerFlowerGirl.addlog("quit");
				break menu;
			}
			case "a": { // Вывести все элементы букета и стоимость
				System.out.println("\n" + (rb.getString("cheat.bouquet")) + ":");
				contentBouquet(firstBouquet);
				System.out.print(rb.getString("quit") + ": ");
				System.out.println(firstBouquet.getPriceBouquet());
				break;
			}
			case "s": { // s (sort) - Отсортировать цветы в букете по свежести
				System.out.println(rb.getString("sorting") + ": ");
				String formatOut = "%1$-25s|%2$-9s|%3$-6s|%4$-10s|%5$-5s|\n";
				for (String item : sortFlovers(firstBouquet).split("~~")) {
					System.out.printf(formatOut, item.split("~"));
				}
				break;
			}
			case "l": { // Найти цветы в букете, соответствующие заданному
						// диапазону длин стеблей
				System.out.println(rb.getString("out.range") + ": ");
				// задать от до через ,
				System.out.println(rb.getString("lower.bound") + ":");
				Scanner sc = new Scanner(System.in);
				int minLength = 0;
				int maxLength = 0;
				while (sc.hasNext()) {
					try {
						if (minLength <= 0) {
							minLength = sc.nextInt();
							if (minLength <= 0) {
								System.out.println(rb.getString("not.correctly"));
								LogerFlowerGirl.addlog(select + " - " + minLength + " minLength <= 0");
							} else
								System.out.println(rb.getString("top.bound") + ": ");
							continue;
						}

						if (maxLength <= 0) {
							maxLength = sc.nextInt();
							if (maxLength > 0 && maxLength > minLength) {
								break;
							} else {
								System.out.println(rb.getString("not.correctly"));
								LogerFlowerGirl.addlog(select + " - " + maxLength + " not.correctly");
								continue;
							}
						}
					} catch (Exception e) {
						System.out.println(rb.getString("not.correctly"));
						LogerFlowerGirl.addlog(e + " not.correctly");
//						continue;
						sc.next();
					}
				}
				for (String item : getStemLength(firstBouquet, minLength, maxLength).toString().split("~~")) {
					System.out.printf(formatPattern, item.split("~"));
				}
				break;
			}
			default: {
				System.out.println(rb.getString("not.correctly"));
				LogerFlowerGirl.addlog(select + " not.correctly");
				continue menu;
			}
			}
		}
	}

	// вывод меню, возвращают индификатор выбора пользователя
	private static String startMenu() {
		@SuppressWarnings("resource")
		// проверить, нужно ли оставлять
		Scanner sc = new Scanner(System.in);
		LogerFlowerGirl.addlog("main menu");
//		System.out.println(currentDate);
		System.out.println(df.format(currentDate));
		System.out.println(rb.getString("menu.main"));
		System.out.println(rb.getString("menu.quit"));
		System.out.println(rb.getString("menu.all"));
		System.out.println(rb.getString("menu.sort"));
		System.out.println(rb.getString("menu.length"));
		return sc.nextLine();
	}

	static public String sortFlovers(Bouquet bouquet) {
		StringBuilder strResult = new StringBuilder();
		Flower key;
		TreeSet<Flower> srtFlower = new TreeSet<Flower>(new SortedByFreshness());
		for (Map.Entry<? extends Flower, Integer> entry : bouquet.getFlowers().entrySet()) {
			key = (Flower) entry.getKey();
			srtFlower.add(key);
		}
		System.out.println();
		strResult = strResult.append(rb.getString("header.sort.frehness"));
		Iterator<Flower> it = srtFlower.iterator();
		while (it.hasNext()) {
			Flower currentFlowers = it.next();
			strResult = strResult.append(currentFlowers.getName()).append("~");
			strResult = strResult.append(currentFlowers.getFreshness()).append("~");
			strResult = strResult.append(currentFlowers.getLengthFlower()).append("~");
			strResult = strResult.append(currentFlowers.getColor()).append("~");
			strResult = strResult.append(currentFlowers.getPrice()).append("~");
			strResult = strResult.append("~");
		}
		return strResult.toString();
	}
	// ********************************************

	// сортировка цветов в букете по свежести
	/*
	 * static public String sortFlovers(Bouquet bouquet) { StringBuilder
	 * strResult = new StringBuilder(); int length =
	 * bouquet.getFlowers().size();
	 * 
	 * Flower[] arrFlowers = new Flower[length]; int[][] myIndexArray = new
	 * int[length][2];
	 * 
	 * int i = 0; for (Map.Entry entry : bouquet.getFlowers().entrySet()) {
	 * Flower key = (Flower) entry.getKey(); arrFlowers[i] = key;
	 * myIndexArray[i][0] = (int) key.getFreshness(); myIndexArray[i][1] = i;
	 * i++; }
	 * 
	 * for (int ii = 0; ii < length; ii++) { int min = myIndexArray[ii][0]; int
	 * minIndex = ii; for (int j = ii + 1; j < length; j++) { // Если находим,
	 * запоминаем его индекс if (myIndexArray[j][0] < min) { min =
	 * myIndexArray[j][0]; minIndex = j; } } if (ii != minIndex) { int tmp =
	 * myIndexArray[ii][0]; int tmpIndex = myIndexArray[ii][1];
	 * myIndexArray[ii][0] = myIndexArray[minIndex][0]; myIndexArray[ii][1] =
	 * myIndexArray[minIndex][1]; myIndexArray[minIndex][0] = tmp;
	 * myIndexArray[minIndex][1] = tmpIndex; } } strResult =
	 * strResult.append("Название~Cвежесть~Длина~Цвет~Цена~~"); for (int ii = 0;
	 * ii < length; ii++) { //
	 * System.out.println(arrFlowers[myIndexArray[ii][1]]); Flower
	 * currentFlowers = arrFlowers[myIndexArray[ii][1]]; strResult =
	 * strResult.append(currentFlowers.getName()).append("~"); strResult =
	 * strResult.append(currentFlowers.getFreshness()).append("~"); strResult =
	 * strResult.append(currentFlowers.getLengthFlower()).append("~"); strResult
	 * = strResult.append(currentFlowers.getColor()).append("~"); strResult =
	 * strResult.append(currentFlowers.getPrice()).append("~"); strResult =
	 * strResult.append("~"); } return strResult.toString(); }
	 */

	// Найти цветок в букете, соответствующий заданному диапазону длин стеблей.
	static public StringBuilder getStemLength(Bouquet bouquet, int minStemLength, int maxStemLength) {
		StringBuilder strResult = new StringBuilder();
		float resultSum = 0;
		int countAll = 0;
		strResult = strResult.append(Bouquet.header);
		// for (Entry<? extends Flower, Integer> entry :
		// bouquet.getFlowers().entrySet())
		for (Map.Entry entry : bouquet.getFlowers().entrySet()) {
			Flower key = (Flower) entry.getKey();
			// получаем цветы с нужной длиной
			int freshness = key.getLengthFlower();
			if ((freshness >= minStemLength) && (freshness <= maxStemLength)) {
				strResult = strResult.append(key.getName()).append("~");
				strResult = strResult.append(key.getLengthFlower()).append("~");
				strResult = strResult.append(key.getFreshness()).append("~");
				strResult = strResult.append(key.getColor()).append("~");
				strResult = strResult.append(key.getPrice()).append("~");
				countAll = (int) entry.getValue() + countAll;
				strResult = strResult.append(entry.getValue()).append("~");
				float sum = (int) entry.getValue() * (float) key.getPrice();
				resultSum = resultSum + sum;
				strResult = strResult.append(sum).append("~");
				strResult = strResult.append("~");
			}
		}
		strResult = strResult.append("-~-~-~-~sum:~").append(countAll).append("~").append(resultSum).append("~~");
		return strResult;
	}

	static public void contentBouquet(Bouquet bouquet) {
		// System.out.println ("букет:");
		String[] itemsBouquet = bouquet.toString().split("~~~");

		for (String item : itemsBouquet[0].split("~~")) {
			System.out.printf(formatPattern, item.split("~"));
		}
		for (String item : itemsBouquet[1].split("~~")) {
			System.out.printf("%1$-25s|%2$-8s|%3$-8s|%4$-8s\n", item.split("~"));
		}
	}
}
