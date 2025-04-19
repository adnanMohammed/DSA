public class QueryList {
	private static String name = "'Mohammed Adnan'";
	private static String updatedName = "'Mohammed Faisal'";
	private static String gender = "'Male'";
	private static int age = 27;
	// DDL

	public static String CREATE_TABLE = "create Table JDBC_TEST_EMPLOYEE(empID int primary key identity(1,1),name varchar(15) not null,age int,gender varchar(15))";
	public static String ALTER_TABLE = "ALTER TABLE JDBC_TEST_EMPLOYEE gender not null varchar(20)";
	public static String DROP_TABLE = "DROP TABLE JDBC_TEST_EMPLOYEE if exists";
	// DML
	public static String INSERT_DATA = "insert into JDBC_TEST_EMPLOYEE values(" + name + "," + age + "," + gender + ")";
	public static String UPDATE_DATA = "update JDBC_TEST_EMPLOYEE set name=" + updatedName + " where name=" + name;
	public static String DELETE_DATA = "Delete from JDBC_TEST_EMPLOYEE where name=" + name;
	public static String selectQuery = "Select * from JDBC_TEST_EMPLOYEE";
	public static String psSelectQuery = "Select * from JDBC_TEST_EMPLOYEE where name=?";
	public static String psUpdatetQuery = "Update JDBC_TEST_EMPLOYEE set name=? where name='Mohammed Faisal'";
	public static String psInsertQuery = "insert into JDBC_TEST_EMPLOYEE(name,age,gender) values(?,?,?)";

}
