package xml;

import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/*Напишите программу, которая будет разбирать xml файл с помощью DOM, SAX и StAX, и выводить его на экран в текстовом виде. 
 * Каждая точка должна выводиться на отдельной строке в виде двух чисел, разделенных запятой, 
 * при этом должна выводиться единица измерения. Например: 
pointList
point 1: 10px, 30px
point 2: 17cm, 75cm*/
public class ParserSaX {
	
	public static void main(String[] args) {
		try {
			// создание SAX-анализатора
			XMLReader reader = XMLReaderFactory.createXMLReader();
			SaxHandler handler = new SaxHandler();
			reader.setContentHandler(handler);
			reader.parse("src/xml/FileToParse.xml");
		} catch (SAXException e) {
			System.err.print("ошибка SAX парсера " + e);
		} catch (IOException e) {
			System.err.print("ошибка I/О потока " + e);
		}
	}
}
