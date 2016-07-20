/**
 * Создать класс Student c тремя полями: id, name, dateOfBirth. 
 * Сериализовать и десериализовать в файл.
 * Создать файл с текстом в котором присутствуют числа программно. Найти все числа, распечатать, посчитать сумму
 */
package quest;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class mainStudent {
	Student vasya = new Student(45, "Вася Пупкин", "24-09-1994");
	FileOutputStream fos = new FileOutputStream("vasya.tmp");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	try{

	}catch(
	Exception e)
	{

	}
}
