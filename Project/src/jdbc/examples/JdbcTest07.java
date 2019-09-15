// program to delete user 
package jdbc.examples;
import java.sql.*;
import java.util.*;
import java.io.*;
public class JdbcTest07{
	public static void main(String[] args){
		Scanner scan =new Scanner(System.in);
		System.out.print("Enter user Name    : ");
		String uname="'"+scan.next()+"'";
	try {
		FileInputStream fis = new FileInputStream("db.properties");
		Properties p=new Properties();
		p.load(fis);
		Class.forName(p.getProperty("driver"));
		Connection cn=DriverManager.getConnection(p.getProperty("url"),p.getProperty("user"),p.getProperty("pwd"));
		String sql="delete from user_register where uname ="+uname;
		Statement st= cn.createStatement();
		int count=st.executeUpdate(sql);
		if(count>0)
		System.out.println("User deleted");
		}
	catch(ClassNotFoundException e) {
		System.out.println(e.getMessage());
		}
	catch(SQLException s) {
		System.out.println(s.getMessage());
		}
	catch(IOException i) {
		System.out.println(i.getMessage());
		}
	}
}