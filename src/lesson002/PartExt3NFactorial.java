package lesson002;

import java.util.Scanner;

public class PartExt3NFactorial {

	public static void main(String[] args) {
		int FactorialUnit = 0, ResultFact = 1;
		while (true) {
			Scanner scFactorialUnit = new Scanner(System.in);
			System.out.println("Считаем факториал, введите целое положительное число");
			if (scFactorialUnit.hasNextInt()) {
				FactorialUnit = scFactorialUnit.nextInt();
				if (FactorialUnit < 0) {
					System.out.println("Заданное число меньше 1");
					continue;
				} else if (FactorialUnit == 0) {
					ResultFact = 1;
					System.out.println("!" + FactorialUnit + "=" + ResultFact);
					break;
				}
				int x;
				for (x = 1; x <= FactorialUnit; x++) {
					ResultFact = ResultFact * x;
				}
				System.out.println("!" + FactorialUnit + "=" + ResultFact);
				break;
			} else
				System.out.print("Не корректное число. Попробуйте еще раз.");
		}

	}
}
