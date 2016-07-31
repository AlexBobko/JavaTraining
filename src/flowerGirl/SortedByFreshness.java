package flowerGirl;

import java.util.Comparator;

public class SortedByFreshness implements Comparator<Flower>{

	@Override
	public int compare(Flower two, Flower one) {
			int result = (two.getFreshness() - one.getFreshness());
			if (result ==0) {
				result = two.getLengthFlower() - one.getLengthFlower();
			}
			if (result ==0) {
				result = (int)(Math.ceil(two.getPrice() - one.getPrice()));
			}
		return result ;
	}

}
