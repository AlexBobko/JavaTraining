package lesson002;

import java.util.Scanner;

public class part7NumWeekDay {

	public static void main(String[] args) {
		String dayString;
		Scanner enterNumWeekDay = new Scanner(System.in);
		System.out.print("Введите номер для недели (цифра от 1 до 7), где 1 - пн.: ");
		if (enterNumWeekDay.hasNextInt()) {
			int numWeekDay;
			numWeekDay = enterNumWeekDay.nextInt();
			switch (numWeekDay) {
			case 1:
				dayString = "Понедельник";
				break;
			case 2:
				dayString = "Вторник";
				break;
			case 3:
				dayString = "Среда";
				break;
			case 4:
				dayString = "Четверг";
				break;
			case 5:
				dayString = "Пятница";
				break;
			case 6:
				dayString = "Суббота";
				break;
			case 7:
				dayString = "Воскресенье";
				break;
			default:
				dayString = "Число не попадает в диапазон от 1 до 7";
				break;
			}
		} else {
			dayString = "Введенные данные не попадают в диапазон цифр от 1 до 7";
		}
		System.out.print (dayString);
	}
}
