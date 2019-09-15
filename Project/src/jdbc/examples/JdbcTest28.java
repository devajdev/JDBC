//WAP to read txt file from database

package jdbc.examples;
import java.sql.*;
import java.io.*;
public class JdbcTest28 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dev", "dev");
			PreparedStatement ps=cn.prepareStatement("select * from member_register");
			ResultSet rs=ps.executeQuery();
			rs.next();
			int a=rs.getInt(1);
			String s=rs.getString(2);
			Reader r=rs.getCharacterStream(3);
			FileWriter fw =new FileWriter("D:\\ticket.txt");
			int x;
			while((x=r.read())!=-1) {
				fw.write(x);}
			System.out.println(a+", "+s+", "+"File store in this location >> D:\\\\ticket.txt");	
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
