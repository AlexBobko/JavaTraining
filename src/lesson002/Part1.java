package lesson002;

public class Part1 {
	public static void main(String[] args) {
		String str1, str2, str3;
		str1 = "-=RealiCoolCtringMustHave=-";
		int lengt = str1.length();
		System.out.println("In string: " + str1 + " " + lengt + " characters");
		str2 = str1.substring(0, (int) (lengt / 2));
		str3 = str1.substring((int) (lengt / 2));
		System.out.print(str2 + " / ");
		System.out.println(str3);
	}
}
