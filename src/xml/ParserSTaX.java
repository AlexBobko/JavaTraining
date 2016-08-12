package xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/*Напишите программу, которая будет разбирать xml файл с помощью DOM, SAX и StAX, и выводить его на экран в текстовом виде. 
 * Каждая точка должна выводиться на отдельной строке в виде двух чисел, разделенных запятой, 
 * при этом должна выводиться единица измерения. Например: 
pointList
point 1: 10px, 30px
point 2: 17cm, 75cm*/
public class ParserSTaX {

	public static void main(String[] args) {
		XMLInputFactory inpFact = XMLInputFactory.newInstance();
		boolean isPointList = false;
		boolean isPoint = false;
		boolean isX = false;
		boolean isY = false;
		boolean isUnit = false;
		String x = "";
		String y = "";
		int el = 0;
		try {
			XMLStreamReader reader = inpFact.createXMLStreamReader(new FileInputStream("src/xml/FileToParse.xml"));
			while (reader.hasNext()) {
				int res = reader.next();
				// System.out.println("#type " + reader.getEventType());
				if (res == XMLStreamConstants.START_ELEMENT) {
					if (reader.getLocalName().equals("pointList")) {
						System.out.println(reader.getLocalName());
						isPointList = true;
					} else if (reader.getLocalName().equals("point")) {
						el++;
						System.out.print(reader.getLocalName() + " " + el + ": ");
						isPoint = true;
					} else if (reader.getLocalName().equals("x"))
						isX = true;
					else if (reader.getLocalName().equals("y"))
						isY = true;
					else if (reader.getLocalName().equals("unit"))
						isUnit = true;
				} else if (res == XMLStreamConstants.CHARACTERS) {
					if (isPointList) {
						isPointList = false;
					} else if (isPoint) {
						isPoint = false;
					} else if (isX) {
						x = reader.getText().trim();
						isX = false;
					} else if (isY) {
						y = reader.getText().trim();
						isY = false;
					} else if (isUnit) {
						System.out.println(x + reader.getText() + ", " + y + reader.getText());
						isUnit = false;
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
}
