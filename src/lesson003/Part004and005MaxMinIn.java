package lesson003;

import java.util.Random;

public class Part004and005MaxMinIn {

	public static void main(String[] args) {
		Random random = new Random();
		int i = 0, min = 0, max = 0, minIndex=0, maxIndex=0;
		int[] myArray = new int[15];
		for (; i < 15; i++) {
			myArray[i] = random.nextInt(200)-100;
			if (min == 0) {
				min = myArray[i];
			} else if (min > myArray[i]) {
				min = myArray[i];
				minIndex = i;
			}
			if (max == 0) {
				max = myArray[i];
			} else if (max < myArray[i]) {
				max = myArray[i];
				maxIndex = i;
			}
			System.out.print("\"" + myArray[i] + "\"" + "|");
		}
		System.out.println("\nmin value = " + "\"" +"myArray["+ minIndex +"]"+min + "\"");
		System.out.println("max value = " + "\"" +"myArray["+ maxIndex +"]"+ max + "\"");

	}

}
