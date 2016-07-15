/* 10*. Даны натуральное число n, действительная матрица А размером n x n. 
Получить последовательность элементов главной и побочной диагонали. 
 * */
 
package lesson003;

import java.util.Random;
import java.util.Scanner;

public class Part010MatrixDiagonals {

	public static void main(String[] args) {
		Random random = new Random();
		int n = 1, x, y;
		String str1 = new String();
		String str2 = new String();
		int[][] myArray;
		while (true) {
			Scanner scEnterNum = new Scanner(System.in);
			System.out.print("Введите размер матрицы n (не меньше 4х): ");
			if (scEnterNum.hasNextInt()) {
				n = scEnterNum.nextInt();
				if (n < 4) {
					System.out.println("Заданное число меньше 4");
					continue;
				}
				break;
			} else
				System.out.println("Не корректный размер. Попробуйте еще раз.");
		}

		myArray = new int[n][n];
		System.out.println("генерируем матрицу размером " + n + " на " + n);
		for (x = 0; x < n; x++) {
			for (y = 0; y < n; y++) {
				myArray[x][y] = random.nextInt(50) - 25;
				System.out.printf("%4d", myArray[x][y]);
				if (x == y) {
					str1 = str1.concat(Integer.toString(myArray[x][y]));
					str1 = str1.concat(", ");
				}

				if (y + x == n - 1) {
					str2 = str2.concat(Integer.toString(myArray[x][y]));
					str2 = str2.concat(", ");
				}
			}
			System.out.println();
		}
		System.out.println("Главная диагональ: " + str1);
		System.out.println("Побочная диагональ: " + str2);
	}

}
