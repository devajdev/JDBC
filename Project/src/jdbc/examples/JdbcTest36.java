//WAP to table exist in database
package jdbc.examples;
import java.sql.*;
public class JdbcTest36 {

	public static void main(String[] args) throws Exception {
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dev","dev");
	 DatabaseMetaData dmd=cn.getMetaData();
	 String type[]= {"TABLE","VIEW"};
	 ResultSet rs=dmd.getTables("","DEV","S%",type);
	 while(rs.next())
	 System.out.println(rs.getString(2)+" "+rs.getString(3));
	}

}
