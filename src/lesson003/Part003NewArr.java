/*3. 
 * Объявить и инициализировать массив состоящий из 15 элементов:
а) списком инициализации
б) вводом с клавиатуры
в) случайным образом.

 * */
package lesson003;

import java.util.Random;
import java.util.Scanner;

public class Part003NewArr {

	public static void main(String[] args) {
		Random random = new Random();
		int i = 0, enterNum;
		int[] myArrayList = { 45, 42, 87, 45, 5, 54, -15, 45, 54, 10, 112, 81, 99, 41, 7 };
		int[] myArrayRandom = new int[15];
		int[] myArrayKeyEnter = new int[15];

		newElement: while (i < 15) {
			myArrayRandom[i] = random.nextInt();
			while (true) {
				Scanner scEnterNum = new Scanner(System.in);
				System.out.print("Введите значение " + i + " элемента массива:  ");
				if (scEnterNum.hasNextInt()) {
					myArrayKeyEnter[i] = scEnterNum.nextInt();
					i++;
					continue newElement;
				} else {
					System.out.println("Не корректное число. Попробуйте еще раз.");
				}
			}
		}

		System.out.println("Готово");
	}

}
