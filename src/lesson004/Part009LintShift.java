/*9**. Допустим, что существует метод isSubstring, проверяющий, является ли одно слово подстрокой другого. 
 * Для двух строк, s1 и s2, напишите код проверки, получена ли строка s2 циклическим сдвигом s1, 
 * используя только один вызов метода isSubstring 
 * (пример: слово waterbottle получено циклическим сдвигом erbottlewat).
*/
package lesson004;

public class Part009LintShift {
	public static void main(String[] args) {
		String str1 = new String();
		String str2 = new String();
		str1 = "erbottlewat";
		str2 = "waterbottle";

		System.out.print(isSubstring(str1, str2));
	}
	public static boolean isSubstring(String str1, String str2) {
		int l = str1.length();
		if (l == str2.length()) {
			String str = str1 + str1;
			str = str.replace(str2, "");
			if (str.equals(str1)) {
				return true;
			}
		}
		return false;
	}
}
