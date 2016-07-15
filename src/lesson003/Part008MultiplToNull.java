/* 8. В массиве из 10 чисел вычислить произведение элементов массива до первого нуля.
 * */
package lesson003;

import java.util.Random;

public class Part008MultiplToNull {

	public static void main(String[] args) {
		Random random = new Random();
		boolean b = true;
		int i = 0, mulToNull = 1;
		int[] myArray = new int[10];
		for (; i < 10; i++) {
			myArray[i] = random.nextInt(12) - 6;
			System.out.print("\"" + myArray[i] + "\"" + "|");

			if ((b == true) && (myArray[i] != 0)) {
				mulToNull = mulToNull * myArray[i];

			} else {
				b = false;
				if (i == 0) mulToNull = 0;
			}
		}
		System.out.println("\nПроизведение: " + mulToNull);

	}

}
