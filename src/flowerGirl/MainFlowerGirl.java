/** Цветочница.
 * +Определить иерархию цветов. 
 * +Создать несколько объектов-цветов. 
 * +Собрать букет (используя аксессуары) с определением его стоимости. 
-Провести сортировку цветов в букете на основе уровня свежести. 
+-Найти цветок в букете, соответствующий заданному диапазону 
длин стеблей.
 * 
 * 
 */


package flowerGirl;

import java.util.Map;

public class MainFlowerGirl {

	public static void main(String[] args) {


	}
	
	
	Bouquet firstBouquet=new Bouquet();
	
	//Найти цветок в букете, соответствующий заданному диапазону длин стеблей.
	public void getStemLength (int minStemLength,int maxStemLength)
	{	
		for (Map.Entry entry : firstBouquet.getFlowers().entrySet()) {
		Flower key = (Flower) entry.getKey();
		//получаем длину стебля
		int freshness = key.getLengthFlower();
		//сделать проверку на диапазон, если что добавить 
		
		int value = (int) entry.getValue();
		
		
	}
		
		return ;//поправить
	}
}
