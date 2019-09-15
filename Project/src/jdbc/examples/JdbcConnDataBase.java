// program to establish to darabase

package jdbc.examples;
import java.sql.*;
public class JdbcConnDataBase{
	public static void main(String[] args){
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dev", "dev");
		System.out.println(cn);
	}
	catch(ClassNotFoundException e) {
		System.out.println("Invalid Driver");
	}
	catch(SQLException s) {
		System.out.println("Error in establishing connection");
	}
	}
}