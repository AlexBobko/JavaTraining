/*6. Для двух строк напишите метод, определяющий, является ли одна строка перестановкой другой.*/
package lesson004;

import java.util.Arrays;

public class Part006SubstrCopi {

	public static void main(String[] args) {
		String str1 = "ffddrr3 DR";
		String str2 = "ddrrf f3RD";
		System.out.print(str1 + "\n" + str2 + "\n" + "результат:");
		System.out.print(sortChar(str1).equals(sortChar(str2)));
	}

	public static String sortChar(String str) {
		char[] charsArray = str.toCharArray();
		Arrays.sort(charsArray);
		str = Arrays.toString(charsArray);
		return str;
	}

}
