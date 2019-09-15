// program to change user password
package jdbc.examples;
import java.sql.*;
import java.util.*;
import java.io.*;
public class JdbcTest06{
	public static void main(String[] args){
		//@SuppressWarnings("resource")
		Scanner scan =new Scanner(System.in);
		System.out.print("Enter user Name    : ");
		String uname="'"+scan.next()+"'";
		System.out.print("Enter old password : ");
		String pwd1="'"+scan.next()+"'";
		System.out.print("Enter new Password : ");
		String pwd2="'"+scan.next()+"'";
	try {
		FileInputStream fis = new FileInputStream("db.properties");
		Properties p=new Properties();
		p.load(fis);
		Class.forName(p.getProperty("driver"));
		Connection cn=DriverManager.getConnection(p.getProperty("url"),p.getProperty("user"),p.getProperty("pwd"));
		String sql="update user_register set pwd = "+pwd2+"where uname="+uname+"and pwd="+pwd1;
		Statement st= cn.createStatement();
		int count=st.executeUpdate(sql);
		if(count>0)
		System.out.println("Password is updated");
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
	scan.close();
	}
}