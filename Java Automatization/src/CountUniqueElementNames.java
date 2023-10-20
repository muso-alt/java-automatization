import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.HashSet;

public class CountUniqueElementNames {

    public static void main(String[] args) {
        try {
            // Создаем парсер для анализа XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Загрузка XML-файла для анализа (замените на свой путь)
            Document document = builder.parse("src/XML/StudentList.xml");

            HashSet<String> uniqueElementNames = new HashSet<>();

            // Рекурсивно обходим дерево XML
            countUniqueElementNames(document.getDocumentElement(), uniqueElementNames);

            // Вывод количества уникальных имен элементов
            System.out.println("Количество уникальных имен элементов: " + uniqueElementNames.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Рекурсивная функция для обхода дерева XML и подсчета уникальных имен элементов
    private static void countUniqueElementNames(Node node, HashSet<String> uniqueElementNames) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            String localName = node.getLocalName(); // Получаем локальное имя элемента
            if (localName != null && !localName.isEmpty()) {
                uniqueElementNames.add(localName); // Добавляем в множество
            }
        }

        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            countUniqueElementNames(childNodes.item(i), uniqueElementNames);
        }
    }
}
