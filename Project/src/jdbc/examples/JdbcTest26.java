//WAP to read image from database

package jdbc.examples;
import java.sql.*;
import java.io.*;
public class JdbcTest26 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dev", "dev");
			PreparedStatement ps=cn.prepareStatement("select * from members_profile");
			ResultSet rs=ps.executeQuery();
			rs.next();
			int a=rs.getInt(1);
			String s=rs.getString(2);
			InputStream is=rs.getBinaryStream(3);
			FileOutputStream fos =new FileOutputStream("D:\\file1.jpg");
			int x;
			while((x=is.read())!=-1) {
				fos.write(x);}
			System.out.println(a+" "+s+" ");	
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
