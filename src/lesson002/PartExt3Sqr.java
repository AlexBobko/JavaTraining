package lesson002;

public class PartExt3Sqr {
	public static void main(String[] args) {
		int x=0,qr=0;
		while (x<10) {
			String strX;
			qr=x*x;
			strX=x + "x" + x + "=" + qr;
			System.out.printf("%6s%n",strX);
			x++;
		}
	}
}
