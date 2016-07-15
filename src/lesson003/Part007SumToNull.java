/* 7. В массиве из 10 чисел вычислить сумму элементов массива до первого нуля. 
 * */
package lesson003;

import java.util.Random;

public class Part007SumToNull {

	public static void main(String[] args) {
		Random random = new Random();
		int i = 0, sumToNull = 0;
		boolean b = true;
		int[] myArray = new int[10];
		for (; i < 10; i++) {
			myArray[i] = random.nextInt(16) - 8;
			System.out.print("\"" + myArray[i] + "\"" + "|");
			if ((b == true) && (myArray[i] != 0)) {
				sumToNull += myArray[i];
			} else {
				b = false;
				if (i == 0)
					sumToNull = 0;
			}
		}
		System.out.println("\nСумма: " + sumToNull);

	}

}
