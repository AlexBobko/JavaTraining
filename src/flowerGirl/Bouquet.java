/**Готовый букет
*/
package flowerGirl;

import java.util.*;

public class Bouquet {
	static String header="Название~Длина~Свежесть~Цвет~Цена~Штук~Сумма~~";
	static String headerAccessory="Название~Цена~Штук~Сумма~~";
	private float priceBouquet = 0;
	private BouquetType formBouquet; // тип, форма
	// используемые аксессуары
	private Map<Accessory, Integer> accessories = new HashMap<Accessory, Integer>();;
	// использованные цветы
	private Map<Flower, Integer> flowers = new HashMap<Flower, Integer>();;

	Bouquet(){
	}
			
	Bouquet(BouquetType formBouquet) {
		//задаем тип (форму)
		this.formBouquet = formBouquet;
		// рассчет стоимости букета
		this.priceBouquet = getPriceBouquet();

	}
	// добавить аксессуар
	// добавить цветок
	// посчитать общую стоимость
	// установить/получить тип букета

	public String toString() {
		StringBuilder strResult = new StringBuilder();
		strResult=strResult.append(Bouquet.header);
		for (Map.Entry entry : this.getFlowers().entrySet()) {
			Flower key = (Flower) entry.getKey();
			int freshness = key.getLengthFlower();
				strResult=strResult.append(key.getName()).append("~");
				strResult=strResult.append(key.getLengthFlower()).append("~");
				strResult=strResult.append(key.getFreshness()).append("~");
				strResult=strResult.append(key.getColor()).append("~");
				//strResult=strResult.append(key.getColor()).append("~");
				strResult=strResult.append(key.getPrice()).append("~");
				strResult=strResult.append(entry.getValue()).append("~");
				float sum=(int) entry.getValue()*(float)key.getPrice();
				strResult=strResult.append(sum).append("~");
				strResult=strResult.append("~");
		}
		strResult=strResult.append("~");
		strResult=strResult.append(Bouquet.headerAccessory);
		for (Map.Entry entry : this.getAccessories().entrySet()) {
			Accessory key = (Accessory) entry.getKey();
			strResult=strResult.append(key.getName()).append("~");
			strResult=strResult.append(key.getPrice()).append("~");
			strResult=strResult.append(entry.getValue()).append("~");
			float sum=(int) entry.getValue()*(float)key.getPrice();
			strResult=strResult.append(sum).append("~");
			strResult=strResult.append("~");
		}
		strResult=strResult.append("~");
		
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

	public Map<Flower, Integer> getFlowers() {
		return this.flowers;
	}

	public void setFlowers(Map<Flower, Integer> flowers) {
		this.flowers = flowers;
	}

	public void setFormBouquet(BouquetType formBouquet) {
		this.formBouquet = formBouquet;
	}

	public float getPriceBouquet(){
		this.priceBouquet=this.priceFlowers() + this.priceAccessories();
		return this.priceBouquet;
	}


	public float priceAccessories() {
		float priceAccessories = 0;
		for (Map.Entry entry : this.accessories.entrySet()) {
			Accessory key = (Accessory) entry.getKey();
			float price = key.getPrice();
			int value = (int) entry.getValue();
			price = price * value;
/*
			try {

			} catch (Exception e) {
			}
			*/
			priceAccessories += price;

		}

		return priceAccessories;

	};
//отсортировать по уровню свежести ? при добавлении
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


}
