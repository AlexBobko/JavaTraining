package businessLunch;

/**Блюдо */
public class Dish {
	private String name;
	private float price = 0;
	private String description;

	public Dish() {
	}

	public Dish(String n, String desc, float pr) {
		name = n;
		price = pr;
		description = desc;
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	public synchronized float getPrice() {
		return price;
	}

	public synchronized void setPrice(float price) {
		this.price = price;
	}

	public synchronized String getDescription() {
		return description;
	}

	public synchronized void setDescription(String description) {
		this.description = description;
	}
}
