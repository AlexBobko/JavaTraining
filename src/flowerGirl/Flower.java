/** Цветок, абстрактный
 * */
package flowerGirl;

abstract public class Flower {
	int lengthFlower; // длина
	float price; // стоимость
	int freshness; // свежесть
	String color; // цвет
	public Flower (){	
}

	public int getLengthFlower() {
		return lengthFlower;
	}

	public void setLengthFlower(int lengthFlower) {
		this.lengthFlower = lengthFlower;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getFreshness() {
		return freshness;
	}

	public void setFreshness(int freshness) {
		this.freshness = freshness;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
