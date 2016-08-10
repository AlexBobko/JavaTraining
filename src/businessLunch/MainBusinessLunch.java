package businessLunch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

/**
 * Паттерн Builder. Разработать модель системы Комплексный обед. Написать код
 * приложения, позволяющий создавать как стандартные комплексные обеды, так и
 * обеды, в которые включены дополнительные блюда из меню. Минимум 3 типа
 * дополнительных блюд.
 */
/* Директор */
public class MainBusinessLunch {
	public static Menu mainMenu = new Menu();

	public static void main(String[] args) {
		// пример добавления в меню
		mainMenu.addMenu("beer", new Dish("Пиво", "Светлое пиво", (float) 8.1));
		StandardBusinessLunchBuilder lunch = new StandardBusinessLunchBuilder();
		// получаем 2 комплексных обеда
		LinkedList<Dish> lightLunch = lunch.getLightLunch();
		LinkedList<Dish> denseLunch = lunch.getDenseLunch();
		

	}

	public static void createStandardLunch() {
	}

	public static void createExtendedLunch() {
	}

}
