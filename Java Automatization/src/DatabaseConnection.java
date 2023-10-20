import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/object_database";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection connectToDatabase() {
        Connection connection = null;
        try {
            // Register the JDBC driver (if you're using MySQL)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            if (connection != null) {
                System.out.println("Connected to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        // Устанавливаем соединение с базой данных
        Connection connection = connectToDatabase();
        
        // Здесь можно выполнять операции с базой данных, используя объект connection
        
        try {
            if (connection != null) {
                connection.close(); // Закрываем соединение после использования
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
