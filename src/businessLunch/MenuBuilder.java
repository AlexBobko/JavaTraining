package businessLunch;

import java.util.Map;
import java.util.HashMap;

public class MenuBuilder {
	Map<String, Dish> menu = new HashMap<>();

	public MenuBuilder() {
		menu.put("compote", new Dish("Компот", "Компот из волчих ягод", (float) 15));
		menu.put("saladOfTomatoes", new Dish("Салат том", "Помидоры, перец", (float) 12));
		menu.put("saladOfCucumber", new Dish("Салат огуречный", "Огурцы, сметана", (float) 11));
		menu.put("soup", new Dish("Суп", "Фрикадельки", (float) 7.5));
		menu.put("borscht", new Dish("Борщ", "Свекла", (float) 7.5));
		menu.put("ragout", new Dish("Рагу из овощей с грибами", "Запеченые овощи с поганками", (float) 12.2));
		menu.put("buckwheat", new Dish("Гречка", "Гречневая каша", (float) 7));
		menu.put("mashedPotatoes", new Dish("Пюре из картофеля", "Пюре из картофеля", (float) 8));
		menu.put("pork", new Dish("Свинина", "Свиная отбивная", (float) 15));
		menu.put("beef", new Dish("Говядина", "Говяжья поджарка", (float) 17));
		menu.put("tea", new Dish("Чай", "Зеленый чай", (float) 15));
	}

	public void addMenu(String name, Dish dish) {
		menu.put(name, dish);
	}

	public Dish getMenu(String name) {
		return menu.get(name);
	}
}