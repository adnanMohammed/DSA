import java.sql.*;

public class JDBCExample {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        Statement smt = null;
        ResultSet rs = null;
        String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=ORGANIZATION;encrypt=false";
        String user = "sa";
        String pass = "WelcomeSAG@123456*";
        try {
            //load the driver class
            Class c=Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //establish connection
            conn = DriverManager.getConnection(dbURL, user, pass);
            //create Statement
            smt=conn.createStatement();
            //execte a query
            rs=smt.executeQuery("select * from JDBC_TEST_EMPLOYEE where name='Nasir Pasha'");
            while (rs.next()){
                System.out.println( rs.getInt(1)+","+ rs.getString(2)+","+ rs.getInt(3)+","+ rs.getString(4));
            }
           int res= smt.executeUpdate("insert into JDBC_TEST_EMPLOYEE values('Fazil',45,'Male')");
        /*    ps = conn.prepareStatement("insert into JDBC_TEST_EMPLOYEE values(?,?,?) ");
            ps.setString(1, "Kamil Pasha");
            ps.setInt(2, 23);
            ps.setString(3, "Male");
            ps.addBatch();

            ps.setString(1, "Kamil Pasha");
            ps.setInt(2, 23);
            ps.setString(3, "Male");
            ps.addBatch();

            ps.setString(1, "Kamil Pasha");
            ps.setInt(2, 23);
            ps.setString(3, "Male");
            ps.addBatch();

            ps.setString(1, "Kamil Pasha");
            ps.setInt(2, 23);
            ps.setString(3, "Male");
            ps.addBatch();

            ps.setString(1, "Kamil Pasha");
            ps.setInt(2, 23);
            ps.setString(3, "Male");
            ps.addBatch();

            ps.setString(1, "Kamil Pasha");
            ps.setInt(2, 23);
            ps.setString(3, "Male");
            ps.addBatch();

           int[] resArray =ps.executeBatch();
            for (int res1:resArray) {
                System.out.print(res1+",");
            }

           //int res = ps.executeUpdate();*/
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                smt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
