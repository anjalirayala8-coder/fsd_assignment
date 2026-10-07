import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class display {
    private static final String URL = "jdbc:mysql://localhost:3306/stu";
    private static final String USER = "root";
    private static final String PASSWORD = "Anjalibs";

    public static void main(String[] args) {
        String query = "SELECT id, name, marks FROM stu";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu","root","Anjalibs");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("+----+---------+-------+");
            System.out.println("| id | name    | marks |");
            System.out.println("+----+---------+-------+");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int marks = rs.getInt("marks");
                System.out.printf("|  %d | %-7s |    %d |\n", id, name, marks);
            }
            System.out.println("+----+---------+-------+");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
