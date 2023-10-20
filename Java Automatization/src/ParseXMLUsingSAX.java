import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ParseXMLUsingSAX {
    public static void main(String[] args) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                private String currentElement;
                private String id, firstName, lastName, age, salary;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    currentElement = qName;
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    String value = new String(ch, start, length).trim();

                    if (currentElement.equals("Id")) {
                        id = value;
                    } else if (currentElement.equals("FirstName")) {
                        firstName = value;
                    } else if (currentElement.equals("LastName")) {
                        lastName = value;
                    } else if (currentElement.equals("Age")) {
                        age = value;
                    } else if (currentElement.equals("Salary")) {
                        salary = value;
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if (qName.equals("Employee")) {
                        System.out.println("Employee " + id + ": " + firstName + " " + lastName + ", Age: " + age + ", Salary: " + salary);
                    }
                }
            };

            saxParser.parse("src/XML/Employees.xml", handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
