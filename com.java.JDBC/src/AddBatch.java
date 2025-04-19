import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class AddBatch {

	public static void main(String[] args) {
		String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=ORGANIZATION;encrypt=false";
		String user = "sa";
		String pass = "WelcomeSAG@123456*";
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(dbURL, user, pass);

			conn.setAutoCommit(false);
			ps = conn.prepareStatement("insert into JDBC_TEST_EMPLOYEE values(?,?,?)");
			ps.setString(1, "Fahad");
			ps.setInt(2, 32);
			ps.setString(3, "Male");
			ps.addBatch();

			ps.setString(1, "Fahad");
			ps.setInt(2, 32);
			ps.setString(3, "Male");
			ps.addBatch();

			ps.setString(1, "Fahad");
			ps.setInt(2, 32);
			ps.setString(3, "Male");
			ps.addBatch();

			ps.setString(1, "Fahad");
			ps.setInt(2, 32);
			ps.setString(3, "Male");
			ps.addBatch();

			ps.setString(1, "Fahad");
			ps.setInt(2, 32);
			ps.setString(3, "Male");
			ps.addBatch();

			ps.setString(1, "Fahad");
			ps.setInt(2, 32);
			ps.setString(3, "Male");
			ps.addBatch();
			ps.executeBatch();
			conn.commit();

			conn.setAutoCommit(true);

		} catch (ClassNotFoundException cx) {
			cx.printStackTrace();
		} catch (SQLException sx) {
			sx.printStackTrace();
		}
	}
}
