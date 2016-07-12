package lesson002;

import java.util.Scanner;

public class PartExt7Calculator {

	public static void main(String[] args) {
		double enterNum1 = 0, enterNum2 = 0, result = 0;
		String operand, str, outCalc;
		calcStart: while (true) {
			Scanner scEnterNum = new Scanner(System.in);
			System.out.print("Введите первое число (выход q): ");
			if (scEnterNum.hasNextDouble()) {
				enterNum1 = scEnterNum.nextDouble();
			} else if ((scEnterNum.hasNext()) && (((String) scEnterNum.nextLine()).equals("q"))) {
				break calcStart;
			} else {
				System.out.println("Не корректное число. Попробуйте еще раз.");
				continue;
			}
			System.out.print("Введите второе число (выход q): ");
			if (scEnterNum.hasNextDouble()) {
				enterNum2 = scEnterNum.nextDouble();
			} else if ((scEnterNum.hasNext()) && (((String) scEnterNum.nextLine()).equals("q"))) {
				break calcStart;
			} else {
				System.out.println("Не корректное число. Попробуйте еще раз.");
				continue;
			}
			Scanner scEnterNum2 = new Scanner(System.in);
			System.out.print("Какую операцию выполняем? (+-*/) (выход q) ");
			if (scEnterNum2.hasNext()) {
				operand = (String) scEnterNum2.nextLine();
				switch (operand) {
				case "*":
					result = enterNum1 * enterNum2;
					break;
				case "/":
					if (enterNum2 == 0) {
						System.out.println ("на 0 делить нельзя");
						continue calcStart;
					}
					result = enterNum1 / enterNum2;
					break;
				case "-":
					result = enterNum1 - enterNum2;
					break;
				case "+":
					result = enterNum1 + enterNum2;
					break;
				case "q":
					break calcStart;
				default:
					System.out.println ("не корректная операция");
					continue calcStart;
				}
				System.out.println(enterNum1 + operand + enterNum2 + "=" + result);
			}
		}
	}
}
