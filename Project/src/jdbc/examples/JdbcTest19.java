//login application using PrepareStatement
package jdbc.examples;
import java.sql.*;
import java.util.*;
public class JdbcTest19 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter User Name : ");
		String u=scan.nextLine();
		System.out.print("Enter Password : ");
		String p=scan.nextLine();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dev","dev");
			PreparedStatement ps=cn.prepareStatement("select count(*) from user_register where uname=? and pwd=?");
			ps.setString(1, u);
			ps.setString(2, p);
			ResultSet rs=ps.executeQuery();
			rs.next();
			int c=rs.getInt(1);
			if(c==1)
				System.out.println("Welcome to my Application");
			else
				System.out.println("Invalid username & password");
			}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		}
	}
