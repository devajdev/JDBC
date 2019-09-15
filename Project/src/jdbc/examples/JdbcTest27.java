//WAP to insert text file resume into database
//create table member_register(mid number(4) primary key, name varchar2(20), mresume clob)

package jdbc.examples;
import java.sql.*;
import java.io.*;
public class JdbcTest27 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dev", "dev");
			PreparedStatement ps=cn.prepareStatement("insert into member_register values(?,?,?)");
			ps.setInt(1, 105);
			ps.setString(2, "Abc");
			FileReader fr=new FileReader("C:\\Users\\Devaj Dev\\Desktop\\mix\\ticket.txt");
			ps.setCharacterStream(3, fr);
			int count=ps.executeUpdate();
			System.out.println("Sucessful Uploaded"+count);	
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
