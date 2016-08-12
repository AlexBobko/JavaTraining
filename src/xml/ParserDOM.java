package xml;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*Напишите программу, которая будет разбирать xml файл с помощью DOM, SAX и StAX, и выводить его на экран в текстовом виде. 
 * Каждая точка должна выводиться на отдельной строке в виде двух чисел, разделенных запятой, 
 * при этом должна выводиться единица измерения. Например: 
pointList
point 1: 10px, 30px
point 2: 17cm, 75cm*/
public class ParserDOM {

	public static void main(String[] args) {
		// создали фабрику строителей, сложный и грамосткий процесс
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// f.setValidating(false); // не делать проверку валидации
		// создали конкретного строителя документа
		DocumentBuilder builder = null;
		Document doc = null;
		int el = 0;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		File f = new File("src/xml/FileToParse.xml");
		try {
			// стооитель построил документ
			doc = builder.parse(f);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Element root = doc.getDocumentElement();
		System.out.println(root.getTagName());
		NodeList nList = root.getChildNodes();
		for (int i = 0; i < nList.getLength(); i++) {
			if (nList.item(i) instanceof Element) {
				el++;
				System.out.print(nList.item(i).getNodeName());
				NodeList point = nList.item(i).getChildNodes();
				System.out.print(
						" " + el + ": " + point.item(1).getTextContent() + point.item(5).getTextContent() + ", ");
				System.out.println(point.item(3).getTextContent() + point.item(5).getTextContent());
			}
		}
	}
}
/*
 * смотреть пример здесь
 * http://www.quizful.net/post/getting-started-with-xml-in-java
 * 
 */
