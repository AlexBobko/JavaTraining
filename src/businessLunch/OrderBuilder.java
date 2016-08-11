package businessLunch;

import java.util.ArrayList;

/** Заказ */
public class OrderBuilder {
	ArrayList<Dish> lunch = new ArrayList<Dish>();

	public OrderBuilder(AdditionLunchBuilder lunchAddition, StandardBusinessLunchBuilder lunchStandard) {
		lunch.addAll(lunchStandard.getLunch());
		lunch.addAll(lunchAddition.getLunch());
	}

	public OrderBuilder(ArrayList<Dish> standart) {
		lunch.addAll(standart);
	}

	public OrderBuilder(ArrayList<Dish> standart, ArrayList<Dish> addon) {
		lunch.addAll(standart);
		lunch.addAll(addon);
	}

	public synchronized ArrayList<Dish> getLunch() {
		return lunch;
	}
}