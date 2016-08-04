package regExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Задание 16 Написать программу, выполняющую поиск в строке всех тегов абзацев,
 * в т.ч. тех, у которых есть параметры, например <p id=”p1”>
 * , и замену их на простые теги абзацев * <p>
 * (атрибуты игнорируем).
 */
public class TagReplace {
	String text;
	private Pattern pattern;
	private Matcher matcher;
	private String strSearch = "<[pP].*?>";

	private String strReplace="<p>";
	
	public TagReplace() {
	}
	
	public String replaceAllTag(String txt) {
		text=txt;
        return Pattern.compile(strSearch).matcher(text).replaceAll(strReplace);  
	} 
}
