package businessLunch;

import java.util.ArrayList;

//Добавка к стандартному обеду
public class AdditionLunchBuilder {

	private ArrayList<Dish> lunch = new ArrayList<>();

	public AdditionLunchBuilder() {

	}

	public AdditionLunchBuilder(Dish... dishs) {
		for (Dish dish : dishs) {
			lunch.add(dish);
		}
	}

	public void addExtraDish(Dish... dishs) {
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

	public synchronized ArrayList<Dish> getLunch() {
		return lunch;
	}

}