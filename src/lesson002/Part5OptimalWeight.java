package lesson002;

import java.util.Scanner;

public class Part5OptimalWeight {
	public static void main(String[] args) {
		Scanner optimalWHeight = new Scanner(System.in);
		int height, weight;
		System.out.print("Enter you Weight, kg: ");
		if (optimalWHeight.hasNextInt()) {
			weight = optimalWHeight.nextInt();
			System.out.print("Enter your height, cm: ");
			if (optimalWHeight.hasNextInt()) {
				height = optimalWHeight.nextInt();
				int YouOptimalWeight = height - 100;
				int needWeightCorrection = weight - YouOptimalWeight;
				System.out.println("You optimal weight " + YouOptimalWeight + "kg");
				if (needWeightCorrection > 0) {
					System.out.println("You need to lose weight at " + needWeightCorrection + " kg");
				} else if (needWeightCorrection < 0) {
					System.out.println("you need to get better at " + (-needWeightCorrection) + " kg");
				} else
					System.out.println("You have an ideal weight");
			} else
				System.out.println("The height entered is not valid");
		} else
			System.out.println("The weight entered is not valid");
	}
}
