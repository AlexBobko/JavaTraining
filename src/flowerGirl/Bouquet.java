/**Готовый букет
*/
package flowerGirl;

import java.util.*;

public class Bouquet {
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
		return flowers;
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
			// сюда добавить исключение. если объект не Flower
			Accessory key = (Accessory) entry.getKey();
			float price = key.getPrice();
			int value = (int) entry.getValue();
			price = price * value;
/*
			try {

			} catch (Exception e) {
				// TODO: handle exception
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
/*
			try {
			} catch (Exception e) {
				// TODO: handle exception
			}
			*/
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
