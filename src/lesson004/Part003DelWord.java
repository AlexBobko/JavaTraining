/*4. Из текста удалить все слова заданной длины, начинающиеся на согласную букву. */
package lesson004;

public class Part003DelWord {

	public static void main(String[] args) {
		String text = "Трямс. Все дело в том, что компилятор в указанном above example will not check the content itself of lines, а только ссылки на них. Простой пример. Следующий код выведет сообщение “Строки не совпадают";
		String[] strArr= text.split(" ");
		String str = new String();
		System.out.println(text);
        int charCount = 5; //задаем длину слова для удаления
        String [] words = text.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String s : words) {
        	str = s.replaceAll("[^a-zA-Zа-яА-ЯЁё ]", ""); //проверяем длину слова без спецсимволов
        	if(!(isVowel(s.charAt(0)) && str.length() == charCount)) {
                builder.append(s).append(" ");
            }
        }
        String rezult = builder.toString().trim();
        System.out.println(rezult);
        
    }
 
    public static boolean isVowel(char c) {
        switch (Character.toLowerCase(c)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'y':
            case 'а':
            case 'о':
            case 'у':
            case 'е':
            case 'ё':
            case 'я':
            case 'и':
            case 'э':
            case 'ю':
            case 'й':	
                return false;
            default:
                return true;
        }
    }
    
		
}


