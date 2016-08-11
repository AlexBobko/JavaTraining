package businessLunch;

import java.util.ArrayList;

//комплексные обеды
public class StandardBusinessLunchBuilder {
	ArrayList<Dish> lunch=new ArrayList<>();
	StandardBusinessLunchBuilder() {
	}
//легкий обед
	public void setLightLunch() {
		lunch = new ArrayList<>();
		lunch.add(MainBusinessLunch.mainMenu.menu.get("saladOfCucumber"));
		lunch.add(MainBusinessLunch.mainMenu.menu.get("borscht"));
		lunch.add(MainBusinessLunch.mainMenu.menu.get("ragout"));
		lunch.add(MainBusinessLunch.mainMenu.menu.get("beef"));
		lunch.add(MainBusinessLunch.mainMenu.menu.get("tea"));
	};
//плотный обед
	public void setDenseLunch() {
		lunch = new ArrayList<>();
		lunch.add(MainBusinessLunch.mainMenu.menu.get("saladOfTomatoes"));
		lunch.add(MainBusinessLunch.mainMenu.menu.get("soup"));
		lunch.add(MainBusinessLunch.mainMenu.menu.get("mashedPotatoes"));
		lunch.add(MainBusinessLunch.mainMenu.menu.get("pork"));
		lunch.add(MainBusinessLunch.mainMenu.menu.get("compote"));
	}
	public synchronized ArrayList<Dish> getLunch() {
		return lunch;
	};

}
