package flowerGirl;

/** Цветок Лилия */
public class Lily extends Flower {
	int branching = 1; // количество ответвлений

	public Lily(String name, int lengthFlower, float price, int freshness,
			String color, int branching) {
		this.name = name;
		this.lengthFlower = lengthFlower; // длина
		this.price = price; // стоимость
		this.freshness = freshness; // свежесть
		this.color = color; // цвет
		this.branching = branching;
	}

	public int getBranching() {
		return branching;
	}

	public void setBranching(int branching) {
		this.branching = branching;
	}
	@Override
	public String toString() {
		StringBuilder strResult = new StringBuilder();
		strResult = strResult.append(super.toString());
		strResult = strResult.append(" branching=").append(this.branching);
		return strResult.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + branching;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lily other = (Lily) obj;
		if (branching != other.branching)
			return false;
		return true;
	}
}