/*8*. Напишите алгоритм, реализующий следующее условие: 
 * если элемент матрицы в точке M × N равен 0, 
 * то весь столбец и вся строка обнуляются.
 * (потыкать, пока не сгенерится 0 в нужном месте)
*/

package lesson004;

import java.util.Random;
import java.util.Scanner;

public class Part008MatrixStringRowToNull {

	public static void main(String[] args) {
		Random random = new Random();
		int k = 5, p = 8, x, y; // размер матрицы k-строк p-столбцов
		int n = 2, m = 5; // задаем коорд. тчк. по кот. обнуляем стр. n и столбец m
		boolean b = false;
		int[][] myArray;
		myArray = new int[k][p];

		System.out.println("генерируем матрицу размером " + k + " на " + p);
		for (x = 0; x < k; x++) {
			for (y = 0; y < p; y++) {
				myArray[x][y] = random.nextInt(3) - 1;
				System.out.printf("%3d", myArray[x][y]);
			}
			System.out.println();
		}
		if (myArray[n - 1][m - 1] == 0) {
			System.out.println("элемент матрицы a(" + m + "." + n + ")=0. Обнуляем столбец " + m + " и строку " + n);
			b = true;
		} else {
			System.out.println("элемент матрицы a(" + m + "." + n + ")!=0(not null). Матрицу не меняем.");
		}
		for (x = 0; x < k; x++) {
			for (y = 0; y < p; y++) {
				if (b && x == n - 1)
					myArray[x][y] = 0;
				if (b && y == m - 1)
					myArray[x][y] = 0;
				System.out.printf("%3d", myArray[x][y]);
			}
			System.out.println();
		}
	}
}
