/* 11*. В данной квадратной целочисленной матрице разместить столбцы так, чтобы элементы на главной диагонали были расположены по возрастанию. 
 * Если это невозможно - выдать сообщение.
 * * * *
 *  Прога генерит сама матрицу, размера n со значениями элементов в диапазоне +/-rnd.
 * Потом на n размер общитывает все возможные перестановки столбцов и возвращает в виде строки типа ABC CBA и тп
 * где А-0 столбец, B-1 и тп.
 * потом все варианты проверяются на матрице. 
 * выдает все найденные решиния либо пишет об их отсутствии. 
 * 
 * n - задаем размер матрицы, больше чем 10 не работает, GC ошибку выдает (n=11 - 39 916 800 -комбинаций:) больше 16 млн не хочет обсчитывать ),
 * а вот 10х10 общитывает. 
 *  Не всегда с первого раза геренится матрица, для которой есть решения. 
 *  Нужно несколько раз запустить, пока не сгенерится нужная. 
 */

package lesson003;

import java.util.Random;

public class P011SortMatrixColumn {
	private static int rnd = 500; // величина максимального элемента массива
	private static int ii = 0; // счетчик возможных комбинаций перестановок
	private static int n = 8; // размер квадратной матрицы
	private static Random random = new Random();
	private static String str1 = new String();
	private static String str2 = new String();
	//исходная матрица, размер кототой задаем ниже,геренерится
	private static int[][] myArray;
	//массив строк со всеми комбинациями перестановок
	private static String[] allCombCharIndex;
	private static int[] allCombIndex;
	private static boolean b = false; // если ни одного решения не найдено
	public static void main(String[] args) {
		//создаем и выводим матрицу
		myArray = createMatrixRandomElements();
		// находим количество перестановок столбцов factorial= n!
		int factorial = 1;
		for (int k = 1; k <= n; k++)
			factorial = factorial * k;
		System.out.println("вариантов перестанки: " + factorial);
		// создаем пустой массив нужного размера под результаты комбинаций с
		// перестановками
		allCombCharIndex = new String[factorial];
		// кодируем числовые индексы в символы и передаем созданную строку для
		// поиска всех перестановок
		permuteString("", codingIntToString(n)); // готовый allCombCharIndex
		
		// ищем решения на через перебор комбинаций
		int previeItem = 0;
		search: for (String combination : allCombCharIndex) {
			int i = 0;
			// перегоняем в массив Char чтобы получить int - индекс столбца
			char[] chArray = combination.toCharArray();
			int[] currentIngCombine = new int[n];
			for (char ch : chArray) {
				int index = reCodingIntToString(ch);
				// System.out.print (i + "-" + index + "|"+ myArray [i][index] +
				// "||");
				currentIngCombine[i] = index;
				if (i > 0) {
					// сравниваем с предыдущим элементом диагонали
					if (myArray[i][index] > previeItem) {
						if (i == n - 1) {
							// заносим комбинацию в массив готовых решений
							System.out.println("решение: " + combination);
							// выводим матрицу
							outSolution(currentIngCombine);
							b = true;
						}
					} else {
						// System.out.println();
						continue search; // бракуем комбинацию
					}
				}
				previeItem = myArray[i][index]; // элемент диагонали
				i++;
				// System.out.println (combination);
			}
		}
		if (!b) {
			System.out.println("\n ни одного решения не найдено!");
		}
		System.out.println("\n --==THE END==-- "); // окончание работы программы

	}

	// выводит решение
	public static void outSolution(int[] intCombine) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%5d", myArray[i][intCombine[j]]); 
			}
			System.out.println();
		}
	}

	// генератор для создания матрицы (двумерного массива) вернет матрицу
	public static int[][] createMatrixRandomElements() {
		int[][] myArray = new int[n][n];
		System.out.println("генерируем матрицу размером " + n + " на " + n);
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < n; y++) {
				myArray[x][y] = random.nextInt(rnd * 2) - rnd;
				System.out.printf("%5d", myArray[x][y]); 
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
		return myArray;
	}

	// перекодировка строки вида 01234..n в строку вида. ABCD.
	public static String codingIntToString(int l) {
		String alphabet = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		// char[] alphabetArray = alphabet.toCharArray();
		return alphabet.substring(0, l);

	}
	// перекодировка в int, индекс для работы со столбцами
	public static int reCodingIntToString(char ch) {
		String alphabet = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		char[] alphabetArray = alphabet.toCharArray();
		int ichar = 0;
		for (char ch1 : alphabetArray) {
			if (ch1 == ch) {
				return ichar;
			}
			ichar++;
		}
		return ichar;
	}
	
	/*Генератор комбинаций. На вход набор символов в виде строки, по ходу работы создает с комбинациями*/
	// дернул метод перебора отсюда
	// http://www.java2s.com/Tutorial/Java/0100__Class-Definition/RecursivemethodtofindallpermutationsofaString.htm
	// немного подпилил под себя вывод, чтобы создало массив с вариантами
	public static void permuteString(String beginningString, String endingString) {
		if (endingString.length() <= 1) {
			allCombCharIndex[ii] = beginningString.concat(endingString);
			ii++;
			//System.out.print(ii + ":\n");
			// System.out.println(beginningString + endingString);

		} else
			for (int i = 0; i < endingString.length(); i++) {
				try {
					String newString = endingString.substring(0, i) + endingString.substring(i + 1);

					permuteString(beginningString + endingString.charAt(i), newString);
				} catch (StringIndexOutOfBoundsException exception) {
					exception.printStackTrace();
				}
			}
	}

}
