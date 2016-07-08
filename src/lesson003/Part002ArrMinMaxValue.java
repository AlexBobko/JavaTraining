package lesson003;

import java.util.Random;

public class Part002ArrMinMaxValue {

	public static void main(String[] args) {
		Random random = new Random();
		int i = 0, min = 0, max = 0;
		int[] myArray = new int[10];
		// float sumEltArray = 0, average;
		for (; i < 10; i++) {
			myArray[i] = random.nextInt();
			if (min == 0) {
				min = myArray[i];
			} else if (min > myArray[i]) {
				min = myArray[i];
			}
			if (max == 0) {
				max = myArray[i];
			} else if (max < myArray[i]) {
				max = myArray[i];
			}
			System.out.print("\"" + myArray[i] + "\"" + "|");
		}
		System.out.println("\nmin value = " + "\"" + min + "\"");
		System.out.println("max value = " + "\"" + max + "\"");

	}

}
