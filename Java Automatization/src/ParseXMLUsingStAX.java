import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileReader;

public class ParseXMLUsingStAX {
    public static void main(String[] args) {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new FileReader("src/XML/Employees.xml"));

            String currentElement = "";
            String id = "", firstName = "", lastName = "", age = "", salary = "";

            while (reader.hasNext()) {
                int event = reader.next();

                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        currentElement = reader.getLocalName();
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        String value = reader.getText().trim();

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
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        if (reader.getLocalName().equals("Employee")) {
                            System.out.println("Employee " + id + ": " + firstName + " " + lastName + ", Age: " + age + ", Salary: " + salary);
                        }
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
