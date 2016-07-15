/* 2. В английском тексте каждую букву заменить ее порядковым номером в алфавите. 
При выводе в одной строке печатать текст с двумя пробелами между буквами, 
в следующей строке внизу под каждой буквой печатать ее номер.
*/
package lesson004; 

import java.util.Formatter;

public class Part002CharToInt {
	public static void main(String[] args) {
		String alphabet = new String("abcdefghijklmnopqrstuvwxyz");
		char[] alphabetArray = alphabet.toCharArray();
		String newText = new String();
		//Formatter f = new Formatter();
		boolean b;
		String newIntText = new String();
		String originalText = new String(
				"This method has two variants and returns a new string that is a substring of this string. The substring begins with the character at the specified index and extends to the end of this string or up to endIndex - 1 if second argument is given.");
		char[] originalTextArray = originalText.toCharArray();
		char[] textArray = originalText.toLowerCase().toCharArray();
		int ii = 0;
		for (char ch : textArray) {
			int i = 0;
			b = true;
			for (char letter : alphabetArray) { 
				i++;
				if (ch == letter) {
					
					newText+=originalTextArray[ii] + "  ";
					newIntText+=Integer.toString(i)+" ";
					if (i<10) newIntText+=" ";
					b = false;
					break;
				}
			}
			if (b && (ch!=' ')) {
				newText+=ch;
				newIntText+=" ";
			}
			
			ii++;
		}
		System.out.println(newText);
		System.out.println(newIntText);
	}

}
