package lesson002;

import java.util.Scanner;

public class PartExt4SumNum {

	public static void main(String[] args) {
		int enterNum = 0, resultSum = 0;
		while (true) {
			Scanner scEnterNum = new Scanner(System.in);
			System.out.println("До какого числа вычисляем сумму? Введите целое положительное число: ");
			if (scEnterNum.hasNextInt()) {
				enterNum = scEnterNum.nextInt();
				if (enterNum < 1) {
					System.out.println("Заданное число меньше 1");
					continue;
				} 
				int x;
				for (x = 1; x <= enterNum; x++) {
					resultSum += x;
				}
				System.out.println("результат:" + resultSum);
				break;
			} else System.out.println("Не корректное число. Попробуйте еще раз.");
		}

	}

}
