package helloLocal;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/*/**
 * Создать программу, которая может приветствовать пользователя на трех языках:
 * английском, русском, белорусском, а также 
 * выводит текущую дату с учётом текущей локали. 
 * Требуемый язык и страна должны сообщаться программе в качестве входных параметров. 
 * Если входные параметры отсутствуют, программа должна выдавать сообщение на английском
 
 * Сделать интернационализацию и локализацию вашего проекта для русского и английского языков. Кодировка UTF-8.*/

public class MainLocal {

	public static void main(String[] args) {
		// new MoneyLocalization();//деньги
		Locale locale = new Locale("en", "EN");
		// Locale locale = new Locale("ru", "Ru");
		Date currentDate = new Date();
		try {
			locale = new Locale(args[0], args[1]);
		} catch (Exception e) {
			// System.out.println("default localization");
		}
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);
		ResourceBundle rb = ResourceBundle.getBundle("hello.localization/MessagesHello", locale);
		System.out.println(rb.getString("greetings"));
		System.out.println(df.format(currentDate));
	}
}
