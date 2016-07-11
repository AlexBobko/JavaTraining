/*6. Для двух строк напишите метод, определяющий, является ли одна строка перестановкой другой.*/
package lesson004;

import java.util.Arrays;

public class Part006SubstrCopi {

	public static void main(String[] args) {
		String str1 = "ffddrr3 DR";
		String str2 = "ddrrf f3RD";
		System.out.println(str1 + "\n" + str2);
		str1=sortChar (str1);
		str2=sortChar (str2);
		if (str1.equals(str2)) {
			System.out.println("Строка 2 является перестановкой строки 1");
		} else
			System.out.println("Строка 2 не является перестановкой строки 1");

	}
	public static String sortChar(String str) {
		char[] charsArray = str.toCharArray();
		Arrays.sort(charsArray);
		str = Arrays.toString(charsArray);
		return str;
	}

}
