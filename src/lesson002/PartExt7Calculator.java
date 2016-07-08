package lesson002;

import java.util.Scanner;

public class PartExt7Calculator {

	public static void main(String[] args) {
		double enterNum1 = 0, enterNum2 = 0, result = 0;
		String operand,str,outCalc;
		calcStart:
		while (true) {
			Scanner scEnterNum = new Scanner(System.in);
			System.out.print("Введите первое число: ");
			if (scEnterNum.hasNextDouble()) {
				enterNum1 = scEnterNum.nextDouble();
			} else {
				System.out.println("Не корректное число. Попробуйте еще раз.");
				continue;
			}
			System.out.print("Введите второе число: ");
			if (scEnterNum.hasNextDouble()) {
				enterNum2 = scEnterNum.nextDouble();
			} else {
				System.out.println("Не корректное число. Попробуйте еще раз.");
				continue;
			}
			Scanner scEnterNum2 = new Scanner(System.in);
			System.out.print("Какую операцию выполняем? (+-*/) ");
			if (scEnterNum2.hasNext()) {
				operand= (String) scEnterNum2.nextLine();
				switch (operand) {
				case "*":
					result = enterNum1 * enterNum2; 
					break;
				case "/":
					result = enterNum1 / enterNum2;
					break;
				case "-":
					result = enterNum1 - enterNum2;
					break;
				case "+":
					result = enterNum1 + enterNum2;
					break;
				default:
					operand = "не корректная операция";
					continue calcStart;
				}
				System.out.println(enterNum1 + operand + enterNum2 + "=" + result);
			}
			System.out.println("Введите любой символ, чтобы продолжить. Для выхода введите q.");
			if (scEnterNum2.hasNext()) {
				outCalc= (String) scEnterNum2.nextLine();
				if (outCalc.equals("q")){
					break;
				}else continue;
			}
		}
	}
}
