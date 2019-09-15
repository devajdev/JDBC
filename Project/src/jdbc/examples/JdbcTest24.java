// WAP to call function which return cursor

/*create or replace function get_employees return
sys_refcursor is c1 sys_refcursor;
begin
open c1 for select empno,ename,sal from emp;
return c1;
end;
*/

package jdbc.examples;
import java.sql.*;

import oracle.jdbc.OracleTypes;
public class JdbcTest24 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dev", "dev");
			CallableStatement cs=cn.prepareCall("{?=call get_employees()}");
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs=(ResultSet) cs.getObject(1);
			while(rs.next()) {
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
