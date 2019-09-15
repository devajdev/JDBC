// program to read emp number, emo name, sal from emp table 
package jdbc.examples;
import java.sql.*;
public class JdbcTest08{
	public static void main(String[] args){
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dev", "dev");
		Statement st= cn.createStatement();
		ResultSet rs=st.executeQuery("select empno, ename, sal from emp");
		while(rs.next()) 
			{
		int eno =rs.getInt(1);
		String en=rs.getString(2);
		int s=rs.getInt(3);
		System.out.println(eno+"  "+en+"  "+s);
			}
		}
	catch(ClassNotFoundException e) {
		System.out.println("Invalid Driver Class Name");
		}
	catch(SQLException s) {
		System.out.println(s.getMessage());
		}
	}
}