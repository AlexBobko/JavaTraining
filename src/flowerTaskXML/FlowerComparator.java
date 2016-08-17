package flowerTaskXML;

import java.util.Comparator;

public class FlowerComparator implements Comparator<Flower>{
	@Override
	public int compare(Flower  fist, Flower second) {
        return fist.getTemperature() - second.getTemperature();
    }
}
