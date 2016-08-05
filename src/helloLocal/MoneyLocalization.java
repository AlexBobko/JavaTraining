package helloLocal;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/** Пример локализации денег с запятой */
public class MoneyLocalization {
	protected Locale locale = new Locale("uk", "UA");

	public MoneyLocalization() {
		System.out.println(locale.getCountry());// код страны
		System.out.println(locale.getDisplayName());
		NumberFormat rubFormat = NumberFormat.getCurrencyInstance(locale);
		NumberFormat numFormat = NumberFormat.getNumberInstance(locale);
		Number num;
		double n = 0;
		try {
			num = numFormat.parse("10,5");
			n = num.doubleValue();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(rubFormat.format(n));
	}

}
