/* 5. В массиве из 15 чисел найти наименьший элемент и его индекс в массиве. 

 * */
package lesson003;

import java.util.Random;

public class Part005MinIndexSearch {

	public static void main(String[] args) {
		Random random = new Random();
		int i = 0;
		int min = 100;
		int minIndex = 0;
		int[] myArray = new int[15];
		for (; i < 15; i++) {
			myArray[i] = random.nextInt(200) - 100;
			if (min > myArray[i]) {
				min = myArray[i];
				minIndex = i;
			}
			System.out.print("\"" + myArray[i] + "\"" + "|");
		}
		System.out.println("\nmin value = " + "\"" + "myArray[" + minIndex + "]" + min + "\"");
	}
}
