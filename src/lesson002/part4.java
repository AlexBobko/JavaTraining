package lesson002;

import java.util.Scanner;

public class part4 {
	public static void main(String[] args) {
		Scanner comprYear = new Scanner(System.in);
		System.out.print("Введите год для проверки: ");
		if (comprYear.hasNextInt()) {
			int y=comprYear.nextInt();
			if (y % 4 != 0) {
				System.out.print(y + " - год не високостный");
			} else {
				System.out.print(y + " - год високостный");
			}
		} else
			System.out.print("Год введен не корректно");
	}
}
