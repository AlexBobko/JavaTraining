/*1. В каждом слове текста k-ю букву заменить заданным символом c клавиатуры. 
 * Если k больше длины слова, корректировку не выполнять.
*/
package lesson004;

import java.util.Scanner;

public class Part001CharReplace {

	public static void main(String[] args) {
		int k = 4; // будет заменен каждый k-ый символ
		char firstChar;
		String str = new String();
		String str2 = "This method has two variants and returns a new string that is a substring of this string. The substring begins with the character at the specified index and extends to the end of this string or up to endIndex - 1 if second argument is given.";
		String resultStr = new String();
		Scanner sc = new Scanner(System.in);
		k--;
		System.out.print("Введите символ для замены (при вводе больше одного будет использоваться только первый)");
		str = sc.nextLine();
		firstChar = str.charAt(0);
		System.out.println(str);
		String[] str2ToArray = str2.split(" "); //делим тектс на слова
		for (String value : str2ToArray) {
			int length = value.length();
			if (value.contains("."))
				length--;
			if (value.contains(","))
				length--;
			if (value.contains("?"))
				length--;
			if (value.contains("!"))
				length--;			
			if (length > k) {
				value = replaceCharAt(value, k, firstChar);
			}
			resultStr = resultStr.concat(value).concat(" ");
		}
		System.out.println(str2);
		System.out.println(resultStr);
	}

	public static String replaceCharAt(String s, int pos, char c) {

		return s.substring(0, pos) + c + s.substring(pos + 1);

	}

}
