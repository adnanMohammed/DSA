import java.sql.*;

public class Test3 {
	public static void main(String[] args) {
		String sqlQuery = "select * from Student where rollNo=? and marks=? and StudentName=?";
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=ORGANIZATION;encrypt=false";
		String user = "sa";
		String pass = "WelcomeSAG@123456*";
		try {
			// Loading the Driver Class
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// establish the connection
			conn = DriverManager.getConnection(dbURL, user, pass);

			// creating PreparedStatement
			psmt = conn.prepareStatement(sqlQuery);
			psmt.setInt(1, 1);
			psmt.setInt(2, 50);
			psmt.setString(3, "Mohammed Adnan");
			rs = psmt.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			System.out.println("column count=" + md.getColumnCount() + ", coulmn name=" + md.getColumnName(1)
					+ ", coulmn type name=" + md.getColumnTypeName(1));

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " marks=" + rs.getInt(2) + " Student Name=" + rs.getString(3));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException sq) {
			sq.printStackTrace();
		}
	}
}
