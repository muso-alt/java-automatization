import java.sql.*;

public class ObjectDatabaseApp {
    // Подключение к базе данных SQLite
    static final String JDBC_URL = "jdbc:sqlite:sqlite-jdbc-3.43.2.0.db";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL);
             Statement statement = connection.createStatement()) {
            // Создание таблицы, если она еще не существует
            statement.execute("CREATE TABLE IF NOT EXISTS objects (id INTEGER PRIMARY KEY, name TEXT, description TEXT)");

            // Добавление нового объекта
            addNewObject(connection, "Object1", "Description for Object1");

            // Изменение параметров существующего объекта
            updateObject(connection, 1, "UpdatedObject1", "Updated description");

            // Удаление объекта
            deleteObject(connection, 1);

            // Поиск объектов по заданным критериям
            findObjects(connection, "Object");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Добавление нового объекта
    public static void addNewObject(Connection connection, String name, String description) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO objects (name, description) VALUES (?, ?)");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, description);
        preparedStatement.executeUpdate();
    }

    // Изменение параметров существующего объекта
    public static void updateObject(Connection connection, int id, String name, String description) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE objects SET name=?, description=? WHERE id=?");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, description);
        preparedStatement.setInt(3, id);
        preparedStatement.executeUpdate();
    }

    // Удаление объекта
    public static void deleteObject(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM objects WHERE id=?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    // Поиск объектов по заданным критериям
    public static void findObjects(Connection connection, String searchTerm) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM objects WHERE name LIKE ?");
        preparedStatement.setString(1, "%" + searchTerm + "%");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            System.out.println("ID: " + id + ", Name: " + name + ", Description: " + description);
        }
    }
}