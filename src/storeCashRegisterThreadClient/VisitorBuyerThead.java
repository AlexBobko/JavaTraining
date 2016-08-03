package storeCashRegisterThreadClient;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;

import storeCashRegister.VisitorBuyer;

/* Покупатель - поток*/
public class VisitorBuyerThead<Fiture> implements Callable<StringBuffer> {

	private int clientNumber;
	private String productId;
	private float price;
	private int countProduct;
	StringBuffer tname = new StringBuffer();
	StringBuffer str=new StringBuffer();
	ArrayBlockingQueue<CashboxAlternative> cashboxs;
//	Thread th;

	/*VisitorBuyerThead() {
	}
	VisitorBuyerThead(int counter, String currentProductId, float currentPrice, int currentCountProduct) {
		clientNumber = counter;
		price = currentPrice;
		countProduct = currentCountProduct;
		productId = currentProductId;
		tname = tname.append("client - ").append(counter);
		str=toFormatString();
//		th = new Thread(this, tname.toString());
	}*/
	
	VisitorBuyerThead(int counter, String currentProductId, float currentPrice, int currentCountProduct,
			ArrayBlockingQueue<CashboxAlternative> queue) {
		clientNumber = counter;
		price = currentPrice;
		countProduct = currentCountProduct;
		productId = currentProductId;
		tname = tname.append("client - ").append(counter);
		str=toFormatString();
		cashboxs = queue;
//		th = new Thread(this, tname.toString());
	}
	
	@Override
	public StringBuffer call() throws Exception {
		while (true) {
			try {
				CashboxAlternative currentCashbox = cashboxs.take();
//				currentCashbox.lock();
				str=currentCashbox.serveVisitorBuyer(str);
				cashboxs.put(currentCashbox);
//				currentCashbox.unlock();
				return str;
			} catch (Exception e) {
				try {
					wait(200); //если не доступна очередь
					continue;
				} catch (InterruptedException e1) {
					String error = "error " + clientNumber;
					// System.out.println(error);
					e1.printStackTrace();
				}
			}
		}
	}
	
	public StringBuffer toFormatString() {
		StringBuffer result = new StringBuffer();
		result = result.append(this.getClientNumber()).append("~");
		result = result.append(this.getProductId()).append("~");
		result = result.append(this.getCountProduct()).append("~");
		result = result.append(this.getPrice()).append("~");
		result = result.append(this.getPrice() * this.getCountProduct()).append("~");
		return result;
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