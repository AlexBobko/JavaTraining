package businessLunch;

import java.util.Collection;
import java.util.LinkedList;

//Добавка к стандартному обеду
public class AdditionLunchBilder {

	Collection<Dish> lunch = new LinkedList<>();

	public 	AdditionLunchBilder() {

	}

	public void createStandardLunch(Dish[] dishs) {
		for (Dish dish : dishs) {
			lunch.add(dish);
		}
	}

	public void addExtraDish(Dish dish) {
		lunch.add(dish);
	}

	public void removeDish(Dish dish) {
		lunch.remove(dish);
	}
}