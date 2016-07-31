package flowerGirl;

import java.util.Comparator;

/** Цветок, абстрактный
 * */
abstract public class Flower{
	String name;
	int lengthFlower; // длина
	float price; // стоимость
	int freshness; // свежесть
	String color; // цвет
	
	
	
	public Flower() {
	}
	
	public String getName() {
		return name;
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
	@Override
	public String toString() {
		StringBuilder strResult = new StringBuilder();
		strResult = strResult.append(" name=").append(this.name);
		strResult = strResult.append(" lengthFlower=").append(this.lengthFlower);
		strResult = strResult.append(" price=").append(this.price);
		strResult = strResult.append(" freshness=").append(this.freshness);
		strResult = strResult.append(" color=").append(this.color);
		return strResult.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + freshness;
		result = prime * result + lengthFlower;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flower other = (Flower) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (freshness != other.freshness)
			return false;
		if (lengthFlower != other.lengthFlower)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		return true;
	}
	
	
	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + freshness;
		result = prime * result + lengthFlower;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + prime;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flower other = (Flower) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (freshness != other.freshness)
			return false;
		if (lengthFlower != other.lengthFlower)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (prime != other.prime)
			return false;
		return true;
	}*/
}
