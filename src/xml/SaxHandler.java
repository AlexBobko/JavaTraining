package xml;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SaxHandler extends DefaultHandler {
	String result = new String();
	String x = new String();
	String y = new String();
	String name = new String();
	String unit = new String();
	int i = 0;

	@Override
	public void startDocument() {
		// System.out.println("Parsing started");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) {
		name = localName;
		// получение и вывод информации об атрибутах элемента
		/*
		 * for (int i = 0; i < attrs.getLength(); i++) { s += " " +
		 * attrs.getLocalName(i) + "=" + attrs.getValue(i); }
		 */
		// System.out.print(s.trim() + "\n");
		if (name.equals("pointList")) {
			result = result.concat(name.trim()).concat("\n");
		}
		if (name.equals("point")) {
			i++;
			result = result.concat(name.trim()).concat(" " + i + ": ");
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		String s = new String(ch, start, length);
		if (name.equals("x")) {
			x = s.trim();
			name = "";
		}
		if (name.equals("y")) {
			y = s.trim();
			name = "";
		}
		if (name.equals("unit")) {
			unit = s.trim();
			result = result.concat(x).concat(unit).concat(", ").concat(y).concat(unit).concat("\n");
			name = "";
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) {
		// System.out.print(localName);
	}

	@Override
	public void endDocument() {
		// System.out.println("\nParsing ended");
		System.out.println(result);
	}
}
