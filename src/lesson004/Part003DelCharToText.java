/* 3. Из небольшого текста удалить все символы, кроме пробелов, не являющиеся буквами. */
package lesson004;

public class Part003DelCharToText {

	public static void main(String[] args) {
		String text = "Зде, сь длина ыsdf. ; sdf 	 dsd fs массива Ё определя\"ется числом значений, р' ас[] положенных меж]{ду";
		System.out.println(text);
		text = text.replaceAll("[ \t\n\r]+", " "); //заскоментить, если не нужно удалять лишние пробелы
		text = text.replaceAll("[^a-zA-Zа-яА-ЯЁё ]", "");
		System.out.println(text);
	}

}
