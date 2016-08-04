package regExp;

public class mainRegExp {

	public static void main(String[] args) {
		String text="Нестер <p id=”p1”>  * , и замену <p> * (<p id=”p1” class=\"tod\">атрибуты например <p id=”p1”>* , и абзацев * <p >* (атрибуты игнорируем).";
		TagReplace removeTag=new TagReplace();
		System.out.println (removeTag.replaceAllTag(text));
	}

}
