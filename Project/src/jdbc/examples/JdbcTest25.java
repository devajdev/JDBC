package jdbc.examples;
import java.sql.*;
import java.io.*;
public class JdbcTest25 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dev", "dev");
			PreparedStatement ps=cn.prepareStatement("insert into members_profile values(?,?,?)");
			ps.setInt(1, 111);
			ps.setString(2, "Abc");
			FileInputStream fis =new FileInputStream("C:\\Users\\Devaj Dev\\Desktop\\mix\\image.jpg");
			ps.setBinaryStream(3, fis);
			int count=ps.executeUpdate();
			System.out.println("Sucessful Uploaded "+count);	
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
