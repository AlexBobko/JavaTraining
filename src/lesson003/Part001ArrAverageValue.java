package lesson003;

import java.util.Random;

public class Part001ArrAverageValue {

	public static void main(String[] args) {
		Random random = new Random(); // final
		int i = 0;
		float[] myArray = new float[10];
		float sumEltArray = 0, average;
		for (; i < 10; i++) {
			myArray[i] = random.nextFloat();
			System.out.print("\"" + myArray[i] + "\"" + "|");
			sumEltArray += myArray[i];
		}
		average = sumEltArray / i;
		System.out.println("\naverage value = " + "\"" + average + "\"");
	}

}
