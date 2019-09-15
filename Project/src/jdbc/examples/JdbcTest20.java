//WAP to increase sal emp using Callable Statement
// without parameter
/*create replace procedure update_sal is
 * begin
 * update emp set sal=sal+1000;
 * end;
 */

package jdbc.examples;
import java.sql.*;
public class JdbcTest20 {
	public static void main(String[] agrs) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dev", "dev");
			CallableStatement cs=cn.prepareCall("{call update_sal}");
			cs.executeQuery();
			System.out.println("Procedure Execute");	
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
