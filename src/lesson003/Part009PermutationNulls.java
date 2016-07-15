/*9. В массиве из 10 чисел переставить все нули в конец массива, не меняя порядок не нулевых элементов. 
*/
package lesson003;

public class Part009PermutationNulls {
	public static void main(String[] args) {
		int[] myArray = { 45, 42, 0, 5, 54, 0, 5, 0, 41, 7 };
		int[] myNewArray = new int[10];
		int i = 0, n = 0;
		for (; i < 10; i++) {
			if (myArray[i] != 0) {
				myNewArray[n] = myArray[i];
				n++;
			}
			System.out.printf("%4d",myArray[i]);
		}
		
		System.out.println();
		
		myArray = myNewArray;
		myNewArray = null;
		
		for (int value : myArray)System.out.printf("%4d",value);
	}
}
