package businessLunch;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Паттерн Builder. Разработать модель системы Комплексный обед. Написать код
 * приложения, позволяющий создавать как стандартные комплексные обеды, так и
 * обеды, в которые включены дополнительные блюда из меню. Минимум 3 типа
 * дополнительных блюд.
 */
/* Директор */
public class MainBusinessLunch {
	public static MenuBuilder mainMenu = new MenuBuilder();

	public static void main(String[] args) {
		// пример добавления в меню
		mainMenu.addMenu("beer", new Dish("Пиво", "Прокисшее пиво", (float) 8.1));

		OrderBuilder order = createExtendedLunch();
		// OrderBuilder order = createStandardLunch();
		// перебор и распечатка обеда
		Iterator<Dish> iter = order.getLunch().iterator();
		while (iter.hasNext()) {
			Dish item = iter.next();
			System.out.println(item.getName() + "/ " + item.getDescription() + "/ " + item.getPrice() + " руб.");
		}
	}

	public static OrderBuilder createStandardLunch() {
		StandardBusinessLunchBuilder denseLunch = new StandardBusinessLunchBuilder();
		denseLunch.setDenseLunch();
		ArrayList<Dish> denseLunchList = denseLunch.getLunch();
		OrderBuilder order = new OrderBuilder(denseLunchList);
		return order;
	}

	public static OrderBuilder createExtendedLunch() {
		StandardBusinessLunchBuilder lightLunch = new StandardBusinessLunchBuilder();
		lightLunch.setDenseLunch();
		ArrayList<Dish> lightLunchList = lightLunch.getLunch();
		// формируем добавку к стандартному обеду
		AdditionLunchBuilder addonLunch = new AdditionLunchBuilder(mainMenu.getMenu("beef"), mainMenu.getMenu("tea"));
		OrderBuilder order = new OrderBuilder(lightLunchList, addonLunch.getLunch());
		return order;
	}
}
