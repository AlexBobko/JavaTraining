package lesson002;

import java.util.Scanner;

public class partExt2SumRow {

	public static void main(String[] args) {
		int countUnit = 0;
		float sumRow = 0;
		while (true) {
			Scanner scContUnit = new Scanner(System.in);
			System.out.println("Сколько членов ряда нужно проссумировать?");
			if (scContUnit.hasNextInt()) {
				countUnit = scContUnit.nextInt();
				if (countUnit < 1) {
					System.out.println("Заданное количество меньше 1");
					continue;
				}
				int ii;
				for (ii = 1; ii <= countUnit; ii++) {
					sumRow = sumRow + 1 / ((float) ii);
				}
				System.out.println("Полученная сумма: " + sumRow);
				break;
			} else System.out.print("Не корректное число членов. Попробуйте еще раз.");
		}
	}
}
