/*Создайте массив содержащий 10 переменных типа float (заполнить любыми своими числами). 
 * Далее используя оператор "for" вывести все значения на экран в виде:
"значение" | "значение 2" | "значение 3" |  и тд.
После этого подсчитайте среднее арифметическое значение всех переменных и результат выведите на экран в виде:
 * 
 * */
package lesson003;

import java.util.Random;

public class Part001ArrAverageValue {

	public static void main(String[] args) {
		Random random = new Random();
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
