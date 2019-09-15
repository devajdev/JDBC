// program to register user or inserting details into user register table Dynamic

package jdbc.examples;
import java.sql.*;
import java.util.*;
public class JdbcTest05{
	public static void main(String[] args){
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter Name      : ");
		String name="'"+scan.next()+"'";
		System.out.print("Enter User Name : ");
		String uname="'"+scan.next()+"'";
		System.out.print("Enter Password  : ");
		String pwd="'"+scan.next()+"'";
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dev", "dev");
		Statement st= cn.createStatement();
		String sql="insert into user_register values("+name+","+uname+","+pwd+")";
		int count=st.executeUpdate(sql);
		if(count==1)
		System.out.println("User registration details is done");
		}
	catch(ClassNotFoundException e) {
		System.out.println(e.getMessage());
		}
	catch(SQLException s) {
		System.out.println(s.getMessage());
		}
	}
}