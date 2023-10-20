import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLStatementsExample {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Устанавливаем соединение с базой данных
            connection = DatabaseConnection.connectToDatabase();

            // Создаем объект Statement
            statement = connection.createStatement();

            // Пример SQL-запросов

            // Пример SELECT-запроса
            String selectQuery = "SELECT * FROM objects";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                System.out.println("ID: " + id + ", Name: " + name + ", Description: " + description);
            }

            // Пример INSERT-запроса
            String insertQuery = "INSERT INTO objects (name, description) VALUES ('NewObject', 'New Description')";
            int rowsInserted = statement.executeUpdate(insertQuery);
            System.out.println(rowsInserted + " rows inserted.");

            // Пример UPDATE-запроса
            String updateQuery = "UPDATE objects SET description = 'Updated Description' WHERE name = 'NewObject'";
            int rowsUpdated = statement.executeUpdate(updateQuery);
            System.out.println(rowsUpdated + " rows updated.");

            // Пример DELETE-запроса
            String deleteQuery = "DELETE FROM objects WHERE name = 'NewObject'";
            int rowsDeleted = statement.executeUpdate(deleteQuery);
            System.out.println(rowsDeleted + " rows deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
