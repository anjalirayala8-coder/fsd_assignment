import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class UpdateStudent {
    private static final String URL = "jdbc:mysql://localhost:3306/stu";
    private static final String USER = "root";
    private static final String PASSWORD = "Anjalibs";

    public static void main(String[] args) {
        String query = "UPDATE stu SET marks = ? WHERE id = ?";

        int targetId = 2; // Targets "sita"
        int newMarks = 100;

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/stu","root","Anjalibs");
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, newMarks);
            pstmt.setInt(2, targetId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Record updated successfully!");
            } else {
                System.out.println("No student found with ID: " + targetId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
