/**
 * Создать класс Student c тремя полями: id, name, dateOfBirth. 
 * Сериализовать и десериализовать в файл.
 * см. ниже
 * Создать файл с текстом в котором присутствуют числа программно. Найти все числа, распечатать, посчитать сумму
 */
package quest;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.io.ObjectOutputStream;
//import java.io.FileOutputStream;

public class mainStudent {

	public mainStudent() {
	}

	public static void main(String[] args) throws IOException {
		Student vasya = new Student(45, "Вася Пупкин", "24-09-1994");
		File newFile = new File("src/quest/vasya.tmp");
		if (newFile.createNewFile()) {
			System.out.println("Новый файл создан");
		} else {
			System.out.println("Файл уже существует");
		}

		// сериализация
		try (FileOutputStream fos = new FileOutputStream("src/quest/vasya.tmp");) {
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(vasya);
			oos.close();

		} catch (Exception e) {
			System.out.println("Файл не открыт");
		}
		// десериализация
		try (FileInputStream fis = new FileInputStream("src/quest/vasya.tmp");) {
			ObjectInputStream ois = new ObjectInputStream(fis);
			Student vasek = (Student) ois.readObject();
			System.out.println(vasek.id);
			System.out.println(vasek.name);
			System.out.println(vasek.dateOfBirth);
			ois.close();
		} catch (Exception e) {
			System.out.println("Файл не найден");
		}

		// задача с цифрами
		String text = ("Создать 45 файл с текстом 43 в 1 котором 32 присутствуют 87 числа 77 программно. Найти все числа, 12 распечатать, посчитать 67 сумму");
		String fileName = "src/quest/text.txt";
		File newTextFile = new File(fileName);
		if (newFile.createNewFile()) {
			System.out.println("Новый файл создан:" + fileName  );
		} else {
			System.out.println("Файл " + fileName +" уже существует");
		}

		try (FileWriter writer = new FileWriter(fileName, false)) {
			writer.write(text);
			writer.flush();
			System.out.println("Записано");
		} catch (IOException ex) {
			System.out.println("Запись не прошла");
		}

		int sumNumber=0;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(new File(fileName));
		while (sc.hasNext()) {
			try
			{
				int num = sc.nextInt();
				System.out.printf("%3d",num);
				sumNumber= num+sumNumber; 
			}catch(Exception e) {
				sc.next();
			}
		}
		System.out.println(" Sum = " + sumNumber);
	}
}
