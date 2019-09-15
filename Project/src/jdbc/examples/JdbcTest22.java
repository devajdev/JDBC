//program to call procedure having OUT parameter
/*create or replace procedure get_taotal(pempno number, totalsal out number)is
 *begin
 *select sal+nvl(comm,0) into totalsal from emp where empno=pempno;
 *end;
 */
package jdbc.examples;
import java.sql.*;
import java.util.*;
public class JdbcTest22 {
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.print("Enter Empno : ");
		int eno=scn.nextInt();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dev", "dev");
			CallableStatement cs=cn.prepareCall("{call get_total(?,?)}");
			cs.registerOutParameter(2, Types.NUMERIC);
			cs.setInt(1,eno);
			cs.execute();
			int t=cs.getInt(2);
			System.out.println("Total Sal : "+t);
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		}
	}