package lesson002;

import java.util.Scanner;

public class Part6Rub {

	public static void main(String[] args) {
		Scanner countRub = new Scanner(System.in);
		System.out.print("Введите целое число в диапазоне от 1 до 999: ");
		if (countRub.hasNextInt()) {
			int EnterCountRub,rubCase;
			EnterCountRub = countRub.nextInt();
			if ((1000>EnterCountRub)&&(EnterCountRub>0)) {
				rubCase=EnterCountRub%10;
				System.out.println("Введено число: " + EnterCountRub +" остаток:" + rubCase);
				if (rubCase == 1) {System.out.println("Получился: " + EnterCountRub +" рубль");}
				else if ((1<rubCase)&&(rubCase < 5)) {System.out.println("Получилось: " + EnterCountRub +" рубля");}
				else System.out.println("Получилось: " + EnterCountRub +" рублей");
				return;
			}
			System.out.println("Введенные данные не попадают в заданный диапазон");
			return;
		}
		System.out.println("Введенные данные не являются целым числом");
	}
}