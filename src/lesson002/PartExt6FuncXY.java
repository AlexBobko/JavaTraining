package lesson002;

public class PartExt6FuncXY {

	public static void main(String[] args) {
		System.out.println("Дано: y=2x^2-5x-8; -4<=y<=4; step x = 0.5");
		double x, y = 0, a = 2, b = -5, c = -8;
		double sqrt;
		c = c + 4; // рассчитываем х при котором у = -4
		sqrt = Math.sqrt(b * b - 4 * a * c);
		x = (-b + sqrt) / (2 * a); // х1 положительный
		System.out.println("x+ =" + x + "");
		for (; y <= 4; x += 0.5) {
			// 2х^2-5х-8
			y = 2 * x * x - 5 * x - 8;
			// System.out.println(y);
			if ((y >= -4) && (y <= 4)) {
				System.out.println("y=" + y);
			}
		}

		x = (-b - sqrt) / (2 * a); // х2 отрицательный
		System.out.println("\nx- =" + x + "\n");
		y = 2 * x * x - 5 * x - 8;
		System.out.println("проверка y=" + y);
		for (; y <= 4; x += 0.5) {
			// 2х^2-5х-8
			y = 2 * x * x - 5 * x - 8;
			if ((y >= -4) && (y <= 4)) {
				System.out.println("y=" + y);
			}

		}
	}

}
