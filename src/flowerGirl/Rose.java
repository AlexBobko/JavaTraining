package flowerGirl;
/**Цветок Роза
 *  */
public class Rose extends Flower {
	private BudSize budSize; //размер бутона 
	
	public Rose (String name, int lengthFlower,float price,int freshness,String color,BudSize budSize)
	{
		this.name=name;
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
	@Override
	public String toString() {
		StringBuilder strResult = new StringBuilder();
		strResult = strResult.append(super.toString());
		strResult = strResult.append(" budSize=").append(this.budSize);
		return strResult.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((budSize == null) ? 0 : budSize.hashCode());
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
		Rose other = (Rose) obj;
		if (budSize != other.budSize)
			return false;
		return true;
	}
	
	
}
