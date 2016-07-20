/**Цветок Роза
 *  */
package flowerGirl;

public class Rose extends Flower {
	private BudSize budSize; //размер бутона 
	
	public Rose (int lengthFlower,float price,int freshness,String color,BudSize budSize)
	{
		this.lengthFlower=lengthFlower; // длина
		this.price=price; // стоимость
		this.freshness=freshness; // свежесть
		this.color=color; //цвет
		this.budSize= budSize;
	}
	public BudSize getBudSize() {
		return budSize;
	}
	public void setBudSize(BudSize budSize) {
		this.budSize = budSize;
	}
}
