/*5. Реализуйте алгоритм, определяющий, все ли символы в строке встречаются один раз.*/
package lesson004;

public class Part004IsCharCopi {
	public static void main(String[] args) {
		String str = "Tfdом b,ove.cxвыampwil"; //строка для проверки
		System.out.println(str);
		char[] charsArray = str.toCharArray();
		int lengthStr, i=1,k;
		boolean b=false;
		lengthStr = str.length();
		findCopiChar:
		for (k=0;k<lengthStr;) {
			i=1;
			i=i+k;
			for (;i < lengthStr;i++) {
				if (charsArray[k]==charsArray[i]){
					System.out.println("\nКопия:" + charsArray[k]);
					b=true;
					break findCopiChar; 
				}
			}
			k++;
		}
		if (!b) 
			System.out.println("Копий не обнаружено");
	}
}
