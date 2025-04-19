import java.sql.*;

public class executeExample {
    public static void main(String[] args) {
        Connection conn = null;
        Statement psmt = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=ORGANIZATION;encrypt=false";
        String user = "sa";
        String pass = "WelcomeSAG@123456*";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, user, pass);
            psmt = conn.createStatement();
            boolean res = psmt.execute("Update JDBC_TEST_EMPLOYEE set name='Shahid khan' where age=32");
            if (res) {
                rs = psmt.getResultSet();
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getInt(3) + "," + rs.getString(4));
                }
            } else {
                int result = psmt.getUpdateCount();
                System.out.println(result + " rows are affected");
            }

        } catch (ClassNotFoundException cx) {
            cx.printStackTrace();
        } catch (SQLException sq) {
            sq.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (psmt != null)
                psmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (conn != null)
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
