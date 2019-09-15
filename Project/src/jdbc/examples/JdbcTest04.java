// program to register user or inserting details into user register table Static

package jdbc.examples;
import java.sql.*;
public class JdbcTest04{
	public static void main(String[] args){
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dev", "dev");
		Statement st= cn.createStatement();
		int count=st.executeUpdate("insert into user_register values('Duggudev', 'duggu1', 'duggu1234')");
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