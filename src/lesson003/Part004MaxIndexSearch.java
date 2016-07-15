/* 4. В массиве из 15 чисел найти наибольший элемент и его индекс в массиве 
 */
package lesson003;

import java.util.Random;

public class Part004MaxIndexSearch {

	public static void main(String[] args) {
		Random random = new Random();
		int i = 0;
		int max = -100;
		int maxIndex = 0;
		int[] myArray = new int[15];
		for (; i < 15; i++) {
			myArray[i] = random.nextInt(200) - 100;
			if (max < myArray[i]) {
				max = myArray[i];
				maxIndex = i;
			}
			System.out.print("\"" + myArray[i] + "\"" + "|");
		}
		System.out.println("max value = " + "\"" + "myArray[" + maxIndex + "]" + max + "\"");

	}

}
