/**Цветок Лилия */
package flowerGirl;

public class Lily extends Flower {
	int branching=1; //количество ответвлений
	
	public Lily (int lengthFlower,float price,int freshness,String color,int branching)
	{
		this.lengthFlower=lengthFlower; // длина
		this.price=price; // стоимость
		this.freshness=freshness; // свежесть
		this.color=color; //цвет
		this.branching= branching;
	}

	public int getBranching() {
		return branching;
	}

	public void setBranching(int branching) {
		this.branching = branching;
	}
	
}