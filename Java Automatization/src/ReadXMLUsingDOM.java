import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ReadXMLUsingDOM {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("output.xml"); // Замените на путь к вашему XML-файлу
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // Теперь у вас есть объект Document для работы с XML-данными
            System.out.println(document.getDocumentElement().getNodeName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
