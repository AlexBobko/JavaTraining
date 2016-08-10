package businessLunch;

import java.util.Collection;
import java.util.LinkedList;

//комплексные обеды
public class StandardBusinessLunchBuilder {
	LinkedList<Dish> lunch;
	StandardBusinessLunchBuilder() {
	}
//легкий обед
	public LinkedList<Dish> getLightLunch() {
		lunch = new LinkedList<>();
		lunch.add(MainBusinessLunch.mainMenu.menu.get("saladOfCucumber"));
		lunch.add(MainBusinessLunch.mainMenu.menu.get("borscht"));
		lunch.add(MainBusinessLunch.mainMenu.menu.get("ragout"));
		lunch.add(MainBusinessLunch.mainMenu.menu.get("beef"));
		lunch.add(MainBusinessLunch.mainMenu.menu.get("tea"));
		return lunch;
	};
//плотный обед
	public LinkedList<Dish> getDenseLunch() {
		lunch = new LinkedList<>();
		lunch.add(MainBusinessLunch.mainMenu.menu.get("saladOfTomatoes"));
		lunch.add(MainBusinessLunch.mainMenu.menu.get("soup"));
		lunch.add(MainBusinessLunch.mainMenu.menu.get("mashedPotatoes"));
		lunch.add(MainBusinessLunch.mainMenu.menu.get("pork"));
		lunch.add(MainBusinessLunch.mainMenu.menu.get("compote"));
		return lunch;
	};

}
