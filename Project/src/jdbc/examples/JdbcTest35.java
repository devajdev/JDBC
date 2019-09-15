//wap display Database Information
package jdbc.examples;
import java.sql.*;
public class JdbcTest35 {

	public static void main(String[] args) throws Exception {
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dev","dev");
	 DatabaseMetaData dmd=cn.getMetaData();
	 System.out.println("Database Product Name : "+dmd.getDatabaseProductName());
	 System.out.println("Database Product Version : "+dmd.getDatabaseProductVersion());
	 System.out.println("Database Driver Name : "+dmd.getDriverName());
	 System.out.println("Database Driver Version : "+dmd.getDriverVersion());
	}

}