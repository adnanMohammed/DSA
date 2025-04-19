import java.sql.*;

public class preparedStatementEx {

    public static void main(String[] args) {
        Connection conn = null;

        String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=ORGANIZATION;encrypt=false";
        String user = "sa";
        String pass = "WelcomeSAG@123456*";
        PreparedStatement ps = null;
        ResultSet rs=null;
        try {
            //load Diver class
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //establish connection
            conn = DriverManager.getConnection(dbURL, user, pass);
          /*  ps = conn.prepareStatement(QueryList.psInsertQuery);

            //setting placeholder values
            ps.setString(1,"Syed Usman");
            ps.setInt(2,27);
            ps.setString(3,"Male");
            System.out.println(ps);*/
         /*   ps = conn.prepareStatement(QueryList.psSelectQuery);
            ps.setString(1, "Syed Usman");
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.print(rs.getInt("empID")+",");
                System.out.print(rs.getString("name")+",");
                System.out.print(rs.getString("age")+",");
                System.out.print(rs.getString("gender"));
            }*/
            // int res=  ps.executeUpdate();
            //  System.out.println(res);
         ps=   conn.prepareStatement(QueryList.psUpdatetQuery);
         ps.setString(1,"Nasir Pasha");
        int res= ps.executeUpdate();


        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
