import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ParseXMLUsingDOM {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("src/XML/Employees.xml");

            NodeList employeeNodes = document.getElementsByTagName("Employee");
            for (int i = 0; i < employeeNodes.getLength(); i++) {
                Element employeeElement = (Element) employeeNodes.item(i);
                String id = employeeElement.getElementsByTagName("Id").item(0).getTextContent();
                String firstName = employeeElement.getElementsByTagName("FirstName").item(0).getTextContent();
                String lastName = employeeElement.getElementsByTagName("LastName").item(0).getTextContent();
                String age = employeeElement.getElementsByTagName("Age").item(0).getTextContent();
                String salary = employeeElement.getElementsByTagName("Salary").item(0).getTextContent();

                System.out.println("Employee " + id + ": " + firstName + " " + lastName + ", Age: " + age + ", Salary: " + salary);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
