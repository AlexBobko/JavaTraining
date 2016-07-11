/*6. Для двух строк напишите метод, определяющий, является ли одна строка перестановкой другой.*/
package lesson004;

import java.util.Arrays;

public class Part005SubstrCopi {

	public static void main(String[] args) {
		String str1 = "ffddrr3 DR";
		String str2 = "ddrrf f3RD";

		System.out.println(str1 + "\n" + str2);
		char[] charsArray = str1.toCharArray();
		char[] charsArray2 = str2.toCharArray();
		Arrays.sort(charsArray);
		Arrays.sort(charsArray2);
		str1 = Arrays.toString(charsArray);
		str2 = Arrays.toString(charsArray2);
		if (str1.equals(str2)) {
			System.out.println("Строка 2 является перестановкой строки 1");
		} else
			System.out.println("Строка 2 не является перестановкой строки 1");

	}

}
