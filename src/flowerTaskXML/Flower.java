package flowerTaskXML;

public class Flower {
	public String name;
	public String soil;
	public String origin;
	public String stemColor;
	public String stemSize;
	public short temperature;
	public short watering;
	public String multiplying;

	public Flower(short temp) {
		this.temperature = temp;
	}

	public Flower(String name,String soil,String origin,String stemColor,String stemSize,short temperature,short watering,String multiplying) {
	
		this.name = name ;
		this.soil = soil;
		this.origin = origin;
		this.stemColor = stemColor;
		this.stemSize =stemSize ;
		this.temperature =temperature;
		this.watering = watering;
		this.multiplying=multiplying;
	}
	public Flower() {
	
	
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSoil() {
		return soil;
	}

	public void setSoil(String soil) {
		this.soil = soil;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getStemColor() {
		return stemColor;
	}

	public void setStemColor(String stemColor) {
		this.stemColor = stemColor;
	}

	public String getStemSize() {
		return stemSize;
	}

	public void setStemSize(String stemSize) {
		this.stemSize = stemSize;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(short temperature) {
		this.temperature = temperature;
	}

	public int getWatering() {
		return watering;
	}

	public void setWatering(short watering) {
		this.watering = watering;
	}

	public String getMultiplying() {
		return multiplying;
	}

	public void setMultiplying(String multiplying) {
		this.multiplying = multiplying;
	}

}
/*
 * <flowers> <flower> <name>Самоцветик</name> <soil>подзолистая</soil>
 * <origin>Гондурас</origin> <visualParameters> <stemColor>Зеленый</stemColor>
 * <stemSize>Маленький</stemSize> </visualParameters> <growingTips>
 * <temperature>33</temperature> <watering>500</watering> </growingTips>
 * <multiplying>черенками</multiplying> </flower> <flower> <name>Цветик</name>
 * <soil>грунтовая</soil> <origin>Германия</origin> <visualParameters>
 * <stemColor>Синий</stemColor> <stemSize>Большой</stemSize> </visualParameters>
 * <growingTips> <temperature>22</temperature> <watering>400</watering>
 * </growingTips> <multiplying>семенами</multiplying> </flower> </flowers>
 */