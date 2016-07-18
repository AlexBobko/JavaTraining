/*Вариант А
Создать классы, спецификации которых приведены ниже. 
Определить конструкторы и методы setТип(), getТип(), toString(). 
Определить дополнительно методы в классе, создающем массив объектов. 

Задать критерий выбора данных и вывести эти данные на консоль. 

+В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.
 * 11. (см класс Bus): Фамилия и инициалы водителя, Номер автобуса, Номер маршрута,
Марка, Год начала эксплуатации, Пробег.
 
Создать массив объектов. +

Вывести: (см класс Buses) +
a) список автобусов для заданного номера маршрута;
b) список автобусов, которые эксплуатируются больше заданного срока;
c) список автобусов, пробег у которых больше заданного расстояния.*/
package lesson005;

import java.io.PrintStream;
import java.util.Scanner;

public class MainBus {
	public static void main(String[] args) {
		// забиваем начальные данные для создания массива объектов через тильду.
		// 2 тильды новый item
		String str = "﻿﻿Панадоренко К.М.~1~5~Газ~1996~555154~~Иванов В.К.~2~4~Газ~1999~404875~~Кузнецов Д.Ю.~3~5~Ваз~2001~294151~~Попов С.С.~4~1~ПаЗ~2015~75412~~Соколов И.И.~5~3~Зил~2007~198541~~Лебедев Ф.Р.~6~5~Икарус~2000~345154~~Козлов Е.Е.~7~4~Газ~1998~454455~~Новиков В.С.~8~2~Ниссан~2006~164814~~Морозов Д.А.~9~1~Ниссан~2005~275412~~Петров И.И.~10~4~Икарус~2014~75501~~Волков К.Е.~11~3~Паз~2010~164587~~Соловьёв Г.П.~12~3~Зил~2011~254812~~Васильев Н.Ф.~13~5~Ваз~2009~154733~~Зайцев В.С.~14~2~БМВ~1999~652412~~Павлов А.П.~15~4~Зил~2004~125478~~Семёнов Г.В.~16~5~БМВ~2002~321554~~Голубев В.Ф.~17~4~Икарус~2014~65845~~Виноградов А.А.~18~5~Паз~2011~54875~~Богданов И.П.~19~2~Лаз~2000~124575~~Макаров В.В.~20~1~Зил~2016~12458~~";
		// паттерн формата вывода
		String formatPattern = "%1$-16s|%2$-14s|%3$-14s|%4$-8s|%5$-23s|%6$-10s|\n";
		// создаем массив объектов типа Bus из стоки
		BusPark busesPark = new BusPark(str);
		// обработчик основного меню
		menu: while (true) {
			String select = startMenu(); // вызываем основное меню
			System.out.println(select);
			switch (select) {
			case "q": {
				System.out.println("exit");
				break menu;
			}
			case "0": { // весь список
				for (String item : busesPark.toString(true).split("~~")) {
					System.out.printf(formatPattern, item.split("~"));
				}
				break;
			}
			case "1": {
				int selectBusToRout = menuBusToRout();
				if (selectBusToRout == 0) {
					System.out.println("Маршрут задан не верно");
					continue menu;
				} else { // получаем автобусы указанного маршрута
					for (String item : busesPark.getBusToRout(selectBusToRout).split("~~")) {
						System.out.printf(formatPattern, item.split("~"));
					}
				}
				break;
			}
			case "2": { // срок эксплуатации
				int selectExpirationDate = menuExpirationDate();
				if (selectExpirationDate == 0) {
					System.out.println("Не корректный срок эксплуатации");
					continue menu;
				} else {
					// System.out.print(busesPark.getExpirationDate(selectExpirationDate));
					for (String item : busesPark.getExpirationDate(selectExpirationDate).split("~~")) {
						System.out.printf(formatPattern, item.split("~"));
					}
				}
				break;
			}
			case "3": { // пробег
				int selectExpirationMileage = menuExpirationMileage(); // пробег
				if (selectExpirationMileage == 0) {
					System.out.println("Не корректный пробег");
					continue menu;
				} else {
					for (String item : busesPark.getExpirationMileage(selectExpirationMileage).split("~~")) {
						System.out.printf(formatPattern, item.split("~"));
					}
				}
				break;
			}
			default: {
				System.out.println("Не корректный выбор");
				continue menu;
			}
			}
		}
		// System.out.println("тест: " + select);
	}

	// вывод меню, возвращают индификатор выбора пользователя
	private static String startMenu() {
		@SuppressWarnings("resource") // проверить, нужно ли оставлять
		Scanner sc = new Scanner(System.in);
		System.out.println("Главное меню");
		System.out.println("q - Выйти из программы.");
		System.out.println("0 - Вывести список всех автобусов.");
		System.out.println("1 - Задать номер маршрута и вывести список автобусов для него.");
		System.out
				.println("2 - Задать срок эксплуатации и вывести список автобусов эксплуатирующихся больше заданного.");
		System.out.println("3 - Задать пробег и вывести список автобусов, пробег у которых больше заданного.");
		return sc.nextLine();
	}

	private static int menuBusToRout() {
		int select = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("В основное меню - любой другой символ");
		System.out.println("Задайте номер маршрута для которого требуется \nвывести список автобусов (1-5):");
		if (sc.hasNextInt()) {
			select = sc.nextInt();
			if (select < 1 || select > 5) {
				select = 0;
			}
		}
		return select;
	}

	private static int menuExpirationDate() {
		int select = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("В основное меню - любой другой символ");
		System.out.println("Задайте срок эксплуатации выше которого требуется \nвывести список автобусов, лет (1-20):");
		if (sc.hasNextInt()) {
			select = sc.nextInt();
			if (select < 1 || select > 20) {
				select = 0;
			}
		}
		return select;
	}

	private static int menuExpirationMileage() {
		int select = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("В основное меню - любой другой символ");
		System.out.println("Задайте пробег выше которого требуется \nвывести список автобусов, км (1-999999):");
		if (sc.hasNextInt()) {
			select = sc.nextInt();
			if (select < 1 || select > 999999) {
				select = 0;
			}
		}
		return select;
	}
}