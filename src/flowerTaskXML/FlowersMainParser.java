package flowerTaskXML;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.util.Set;
import java.util.TreeSet;

public class FlowersMainParser {
	// Collection<Flover> flovers = new Collection<Flover>();
	static Set<Flower> flowers;
	static String schemaName = "src/flowerTaskXML/flowers.xsd";
	static String fullFilename = "src/flowerTaskXML/flowers.xml";

	public static void main(String[] args) {
		try {
			setUp();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		// создали фабрику строителей
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// factory.setValidating(true); // проверка валидации
		DocumentBuilder builder = null;
		Document doc = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		File f = new File(fullFilename);
		try {
			// стооитель построил документ
			doc = builder.parse(f);
			// create a SchemaFactory capable of understanding WXS schemas
			SchemaFactory shemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			// load a WXS schema, represented by a Schema instance
			Source schemaFile = new StreamSource(new File(schemaName));
			Schema schema = shemaFactory.newSchema(schemaFile);
			// create a Validator instance, which can be used to validate an
			// instance document
			Validator validator = schema.newValidator();
			// validate the DOM tree
			validator.validate(new DOMSource(doc));
			System.out.println(fullFilename + " is valid");

		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// doc.getDocumentElement().normalize(); //посмотреть что это
		// Element root = doc.getDocumentElement();
		// NodeList nList = root.getChildNodes();
		NodeList nList = doc.getElementsByTagName("flower");
		System.out.println("----------------------------");
		for (int i = 0; i < nList.getLength(); i++) {
			if (nList.item(i).getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nList.item(i);

				String name = eElement.getElementsByTagName("name").item(0).getTextContent();
				String soil = eElement.getElementsByTagName("soil").item(0).getTextContent();
				String origin = eElement.getElementsByTagName("origin").item(0).getTextContent();
				String stemColor = eElement.getElementsByTagName("stemColor").item(0).getTextContent();
				String stemSize = eElement.getElementsByTagName("stemSize").item(0).getTextContent();
				short temperature = Short
						.valueOf(eElement.getElementsByTagName("temperature").item(0).getTextContent());
				short watering = Short.valueOf(eElement.getElementsByTagName("watering").item(0).getTextContent());
				String multiplying = eElement.getElementsByTagName("multiplying").item(0).getTextContent();

				try {
					flowers.add(
							new Flower(name, soil, origin, stemColor, stemSize, temperature, watering, multiplying));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		for (Flower flower : flowers) {
			System.out.print(flower.getName() + " ");
			System.out.println(flower.getTemperature());
		}
	}

	public static void setUp() throws Exception {
		// Инициализируем наш список и указываем наш компаратор
		// который будет выполнять фильтрацию элементов и их положение в списке
		flowers = new TreeSet<Flower>(new FlowerComparator());
	}

}

/*
 * System.out.print("название: " +
 * eElement.getElementsByTagName("name").item(0).getTextContent( ));
 * System.out.print(" почва: " +
 * eElement.getElementsByTagName("soil").item(0).getTextContent( ));
 * System.out.print(" страна: " +
 * eElement.getElementsByTagName("origin").item(0). getTextContent());
 * System.out.println(" цвет: " +
 * eElement.getElementsByTagName("stemColor").item(0). getTextContent());
 * System.out.print(" размер: " +
 * eElement.getElementsByTagName("stemSize").item(0). getTextContent());
 * System.out.print( " температура: " +
 * eElement.getElementsByTagName("temperature").item(0). getTextContent());
 * System.out.print(" полив: " +
 * eElement.getElementsByTagName("watering").item(0). getTextContent());
 * System.out.println( " размножение: " +
 * eElement.getElementsByTagName("multiplying").item(0). getTextContent());
 */
