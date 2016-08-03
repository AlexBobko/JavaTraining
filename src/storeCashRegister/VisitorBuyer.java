package storeCashRegister;

/* Покупатель*/
public class VisitorBuyer {
	private int clientNumber;
	private String productId;
	private float price;
	private int countProduct;

	VisitorBuyer() {
	}

	VisitorBuyer(int counter, String currentProductId, float currentPrice, int currentCountProduct) {
		clientNumber = counter;
		price = currentPrice;
		countProduct = currentCountProduct;
		productId = currentProductId;
	}

	public int getClientNumber() {
		return clientNumber;
	}

	public String getProductId() {
		return productId;
	}

	public float getPrice() {
		return price;
	}

	public int getCountProduct() {
		return countProduct;
	}
}