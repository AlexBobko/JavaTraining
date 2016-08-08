package flowerGirl;

/**Готовый букет
 */
import java.util.*;

public class Bouquet {
	// static String header = "Название~Длина~Свежесть~Цвет~Цена~Штук~Сумма~~";
	static String header = MainFlowerGirl.rb.getString("header");
	static String headerAccessory = MainFlowerGirl.rb.getString("header.accessory");
	private float priceBouquet = 0;
	private BouquetType formBouquet; // тип, форма
	// используемые аксессуары
	private Map<Accessory, Integer> accessories = new HashMap<Accessory, Integer>();;
	// private Map<Accessory, Integer> accessories = new TreeMap<Accessory,
	// Integer>();;
	// использованные цветы
	// private Map<Flower, Integer> flowers = new TreeMap<Flower, Integer>();;
	private Map<Flower, Integer> flowers = new HashMap<Flower, Integer>();;
	// private Map<T extends Flower , Integer> flowers = new HashMap<>();

	Bouquet() {
	}

	Bouquet(BouquetType formBouquet) {
		// задаем тип (форму)
		this.formBouquet = formBouquet;
		// рассчет стоимости букета
		this.priceBouquet = getPriceBouquet();

	}

	// добавить аксессуар
	// добавить цветок
	// посчитать общую стоимость
	// установить/получить тип букета
	public float priceAccessories() {
		float priceAccessories = 0;
		for (Map.Entry<Accessory, Integer> entry : this.accessories.entrySet()) {
			Accessory key = entry.getKey();
			float price = key.getPrice();
			int value = (int) entry.getValue();
			price = price * value;
			priceAccessories += price;
		}
		return priceAccessories;
	};

	// отсортировать по уровню свежести ? при добавлении
	public float priceFlowers() {
		float priceFlowers = 0;
		for (Map.Entry entry : this.flowers.entrySet()) {
			// сюда добавить исключение. если объект не Flower
			Flower key = (Flower) entry.getKey();
			float price = key.getPrice();
			int value = (int) entry.getValue();
			price = price * value;
			priceFlowers += price;
		}
		return priceFlowers;
	};

	// задать количество count для данного цветка
	public <T extends Flower> void addFlower(T flower, int countFlowers) {
		this.flowers.put(flower, countFlowers);
	}

	// установить кол. count для данного ааксессуара
	public <T extends Accessory> void addAccessory(T accessory, int count) {
		this.accessories.put(accessory, count);
	}

	@Override
	public String toString() {
		StringBuilder strResult = new StringBuilder();
		strResult = strResult.append(Bouquet.header);
		for (Map.Entry entry : this.getFlowers().entrySet()) {
			Flower key = (Flower) entry.getKey();
			int freshness = key.getLengthFlower();
			strResult = strResult.append(key.getName()).append("~");
			strResult = strResult.append(key.getLengthFlower()).append("~");
			strResult = strResult.append(key.getFreshness()).append("~");
			strResult = strResult.append(key.getColor()).append("~");
			// strResult=strResult.append(key.getColor()).append("~");
			strResult = strResult.append(key.getPrice()).append("~");
			strResult = strResult.append(entry.getValue()).append("~");
			float sum = (int) entry.getValue() * (float) key.getPrice();
			strResult = strResult.append(sum).append("~");
			strResult = strResult.append("~");
		}
		strResult = strResult.append("~");
		strResult = strResult.append(Bouquet.headerAccessory);
		for (Map.Entry entry : this.getAccessories().entrySet()) {
			Accessory key = (Accessory) entry.getKey();
			strResult = strResult.append(key.getName()).append("~");
			strResult = strResult.append(key.getPrice()).append("~");
			strResult = strResult.append(entry.getValue()).append("~");
			float sum = (int) entry.getValue() * (float) key.getPrice();
			strResult = strResult.append(sum).append("~");
			strResult = strResult.append("~");
		}
		strResult = strResult.append("~");

		return strResult.toString();
	}

	public BouquetType getFormBouquet() {
		return formBouquet;
	}

	public Map<Accessory, Integer> getAccessories() {
		return accessories;
	}

	public void setAccessories(Map<Accessory, Integer> accessories) {
		this.accessories = accessories;
	}

	public Map<? extends Flower, Integer> getFlowers() {
		// public Map<Flower, Integer> getFlowers() {
		return this.flowers;
	}

	public void setFlowers(Map<Flower, Integer> flowers) {
		// public void setFlowers(Map<Flower, Integer> flowers) {
		this.flowers = flowers;
	}

	public void setFormBouquet(BouquetType formBouquet) {
		this.formBouquet = formBouquet;
	}

	public float getPriceBouquet() {
		this.priceBouquet = this.priceFlowers() + this.priceAccessories();
		return this.priceBouquet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessories == null) ? 0 : accessories.hashCode());
		result = prime * result + ((flowers == null) ? 0 : flowers.hashCode());
		result = prime * result + ((formBouquet == null) ? 0 : formBouquet.hashCode());
		result = prime * result + Float.floatToIntBits(priceBouquet);
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
		Bouquet other = (Bouquet) obj;
		if (accessories == null) {
			if (other.accessories != null)
				return false;
		} else if (!accessories.equals(other.accessories))
			return false;
		if (flowers == null) {
			if (other.flowers != null)
				return false;
		} else if (!flowers.equals(other.flowers))
			return false;
		if (formBouquet != other.formBouquet)
			return false;
		if (Float.floatToIntBits(priceBouquet) != Float.floatToIntBits(other.priceBouquet))
			return false;
		return true;
	}
}