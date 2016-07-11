//не доделаное еще
package lesson003;

import java.util.Random;
import java.util.Scanner;

public class P011 {
	public static void main(String[] args) {
		Random random = new Random();
		int n = 1, x, y;
		String str1 = new String();
		String str2 = new String();
		int[][] myArray;
		while (true) {
			Scanner scEnterNum = new Scanner(System.in);
			System.out.print("Введите размер матрицы n (не меньше 4х): ");
			if (scEnterNum.hasNextInt()) {
				n = scEnterNum.nextInt();
				if (n < 4) {
					System.out.println("Заданное число меньше 4");
					continue;
				}
				break;
			} else
				System.out.println("Не корректный размер. Попробуйте еще раз.");
		}

		myArray = new int[n][n];
		System.out.println("генерируем матрицу размером " + n + " на " + n);
		for (x = 0; x < n; x++) {
			for (y = 0; y < n; y++) {
				myArray[x][y] = random.nextInt(50) - 25;
				//System.out.printf("%4d", myArray[x][y]); раскоментить, чтобы матрицу увидеть
				if (x == y) {
					str1 = str1.concat(Integer.toString(myArray[x][y]));
					str1 = str1.concat(", ");
				}

				if (y + x == n - 1) {
					str2 = str2.concat(Integer.toString(myArray[x][y]));
					str2 = str2.concat(", ");
				}
			}
			System.out.println();
		}
		// System.out.println("Главная диагональ: " + str1);
		// System.out.println("Побочная диагональ: " + str2);
	
		int k=0,m=0,fkt=1,tmp,i;

		for(k=1;k<=n;k++)fkt=fkt*k;
		
		int[]rndAray = new int [fkt];
		int[]indexAray = new int [n];
		int[]tmpArray = new int [n];
		
		
		k=0;
		while (k<n){
			indexAray [k]=k++;
		}
		System.out.println("Факториал: "+fkt);
		m=0;
		while (m++<n)System.out.printf("%2d",indexAray[m-1]);
		System.out.println("\nСтартовый\n");
		for (k=0;k<=n;k++){
			for (i=0;i<n;i++)
			tmpArray[i]=indexAray[i];
			
			for (i=1;i<n;i++){
				tmp = indexAray [n-i];
				indexAray [n-i]=indexAray [n-i-1]; //уменьшаем i !!
				indexAray [n-i-1]=tmp;
				
				m=0;
				while (m++<n)System.out.printf("%2d",indexAray[m-1]);
				System.out.println();
			}
			System.out.println("круг");
			
			for (i=0;i<n;i++)
				indexAray[i]=tmpArray[i];

			i=0;
			tmp = indexAray [i];
			while (i<n-1) { 
				indexAray [i]=indexAray [++i];
			}
			indexAray [i]=tmp;
			m=0;
			while (m++<n)System.out.printf("%2d",indexAray[m-1]);
			System.out.println("\nитерация");
		}
		//System.out.println(""+fkt);
		//k=0; while (k<n)System.out.printf("%2d",myArray[k]);
	
	
	}

	

}
