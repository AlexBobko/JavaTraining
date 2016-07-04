package lesson001;

import java.util.Scanner;

public class EnterYouName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your first name(Введите ваше имя): ");
		String s1, s2;
		s1 = sc.nextLine();
		System.out.print("Enter your last name(Введите вашу фамилию): ");
		s2 = sc.nextLine();
		System.out.println("Nice to meet you, " + s1 + " " + s2 + "!");
	}
}