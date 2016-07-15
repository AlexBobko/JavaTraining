/* 6. В массиве из 10 чисел подсчитать количество отрицательных элементов массива.
 */
package lesson003;

import java.util.Random;

public class Part006NegValue {

	public static void main(String[] args) {
		Random random = new Random();
		int i = 0, countNegativValue = 0;
		int[] myArray = new int[10];
		for (; i < 10; i++) {
			myArray[i] = random.nextInt(100)-50;
			if (myArray[i] < 0) {
				countNegativValue++;
			}

			System.out.print("\"" + myArray[i] + "\"" + "|");
		}
		System.out.println("\nЭлементов с отрицательными значениями в массиве: " + countNegativValue + " шт.");

	}

}
