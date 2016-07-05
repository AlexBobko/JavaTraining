package lesson002;

import java.util.Scanner;

public class Part2and3 {
	public static void main(String[] args) {
		int i = 0;
		while (i < 1) {
			Scanner numbSc = new Scanner(System.in);
			System.out.print("Введите первое число: ");
			Float num1, num2;
			if (numbSc.hasNextDouble()) {
				num1 = (float) numbSc.nextDouble();
				System.out.print("Введите второе число: ");
				if (numbSc.hasNextDouble()) {
					num2 = (float) numbSc.nextDouble();
					System.out.print("Что делаем с числами? цифра  - сравниваем, буква - вычисляем частное: ");
					if (numbSc.hasNextDouble()) {
							System.out.print("Результат сравнения:");
							if (num1 < num2) {
								System.out.print(num1 + "<" + num2);
							} else if (num1 > num2) {
								System.out.print(num1 + ">" + num2);
							} else
								System.out.print(num1 + "=" + num2);
							break;
					}
					if (num2 == 0) {
						System.out.print("На ноль делить нельзя!!! Попробуйте еще раз.");
						continue;
					}
					System.out.print("Результат деления: ");
					System.out.print(num1 + "/" + num2 + "=" + (num1 / num2));
					break;
				}
			}
			System.out.println("Введенная последовательность символов не является числом, попробуйте еще раз");
		}
	}
}