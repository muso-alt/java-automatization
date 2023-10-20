import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class ReadXMLUsingSAX {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("src/XML/StudentList.xml"); // Замените на путь к вашему XML-файлу
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    // Обработка начальных элементов
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    // Обработка текстовых данных
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    // Обработка завершающих элементов
                }
            };

            saxParser.parse(xmlFile, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
