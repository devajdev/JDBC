// Sql Enjection
package jdbc.examples;
import java.util.*;
import java.sql.*;
public class JdbcTest15{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("input user name: ");
		String u=scan.next();
		System.out.print("input Password: ");
		String p="'"+scan.next()+"'";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dev", "dev");
			Statement st= cn.createStatement();
			ResultSet rs=st.executeQuery("select count(*) from user_register where uname="+u+"and pwd="+p);
			rs.next();
			int c=rs.getInt(1);
			if(c==1)
			System.out.println("Welcome TO My Application ");
			else
			System.out.println("Invalid user name & password ");
			}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			}
		catch(SQLException s) {
			System.out.println(s.getMessage());
			}
	}
}