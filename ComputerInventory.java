import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ComputerInventory {

    public static void main(String[] args) {
        Map<String, Computer> inventory = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить компьютер");
            System.out.println("2. Поиск компьютера");
            System.out.println("3. Выйти");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addComputer(inventory, scanner);
                    break;
                case 2:
                    searchComputer(inventory, scanner);
                    break;
                case 3:
                    System.out.println("Программа завершена.");
                    return;
                default:
                    System.out.println("Неправильный выбор. Попробуйте снова.");
            }
        }
    }

    public static void addComputer(Map<String, Computer> inventory, Scanner scanner) {
        System.out.println("Введите уникальный идентификатор компьютера:");
        String id = scanner.next();
        System.out.println("Введите модель компьютера:");
        String model = scanner.next();
        System.out.println("Введите серийный номер компьютера:");
        String serialNumber = scanner.next();

        Computer computer = new Computer(id, model, serialNumber);
        inventory.put(id, computer);
        System.out.println("Компьютер добавлен в инвентарь.");
    }

    public static void searchComputer(Map<String, Computer> inventory, Scanner scanner) {
        System.out.println("Введите уникальный идентификатор компьютера для поиска:");
        String id = scanner.next();

        if (inventory.containsKey(id)) {
            Computer computer = inventory.get(id);
            System.out.println("Идентификатор: " + computer.getId());
            System.out.println("Модель: " + computer.getModel());
            System.out.println("Серийный номер: " + computer.getSerialNumber());
        } else {
            System.out.println("Компьютер с указанным идентификатором не найден.");
        }
    }
}

class Computer {
    private String id;
    private String model;
    private String serialNumber;

    public Computer(String id, String model, String serialNumber) {
        this.id = id;
        this.model = model;
        this.serialNumber = serialNumber;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
}
