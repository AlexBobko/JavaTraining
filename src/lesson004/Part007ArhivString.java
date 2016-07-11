/*  7 Реализуйте метод, осуществляющий сжатие строки, на основе счетчика повторяющихся символов. 
 * Например, строка aabcccccaaa должна превратиться в a2b1c5a3. 
 * Если «сжатая» строка оказывается длиннее исходной, метод должен  вернуть исходную строку.
 * */

package lesson004;

public class Part007ArhivString {

	public static void main(String[] args) {
		String str = "ffddrr3DDdddddDR   ddwwwwGGf****fffx"; // dflkflsd аffff ffLl444Llfll lll";
		String newStr = new String();
		int i = 0,ii=0;
		char currentChar;
		char[] charsArray = str.toCharArray();
		currentChar = charsArray[0];
		
		for (char ch : charsArray) {
			ii++;
			if (i == 0) {
				i++;
				continue;
			}
			if (currentChar == ch) {
				i++;

			} else {
				newStr = newStr.concat(Character.toString(currentChar)).concat(Integer.toString(i));
				currentChar = ch;
				i = 1;
				
			}
			if (ii==str.length())
				newStr = newStr.concat(Character.toString(ch)).concat(Integer.toString(i));
		}				
		System.out.println("исходная строка:");
		System.out.println(str);
		if (newStr.length() < str.length()) {
			System.out.println("Сжатие оправдано. Результат:");
			System.out.println(newStr);
		} else {
			System.out.println("Сжатие не оправдано.");
			System.out.println(str);
		}

	}

}
