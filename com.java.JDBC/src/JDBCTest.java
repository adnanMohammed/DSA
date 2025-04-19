import java.sql.*;

public class JDBCTest {

	public static void main(String[] args) {
		Connection conn = null;
		Statement smt = null;
		ResultSet rs = null;
		String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=ORGANIZATION;encrypt=false";
		String user = "sa";
		String pass = "WelcomeSAG@123456*";
		try {
			// Load the JDBC Driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// Establish the connection
			conn = DriverManager.getConnection(dbURL, user, pass);
			// conn=DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=ORGANIZATION;encrypt=false;user=sa;password=WelcomeSAG@123456*;");

			// create a Statement
			smt = conn.createStatement();

			// Execute a Query
			// int res= smt.executeUpdate(QueryList.CREATE_TABLE);
			smt.executeUpdate(QueryList.UPDATE_DATA);
			System.out.println(QueryList.UPDATE_DATA);
			rs = smt.executeQuery(QueryList.selectQuery);
			// rs = smt.executeQuery(QueryList.CREATE_TABLE);
			while (rs != null && rs.next()) {
				int empId = rs.getInt("empID");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				System.out.println("empId=" + empId + " name=" + name + " age=" + age + " gender=" + gender);
			}
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
		}

	}
}
