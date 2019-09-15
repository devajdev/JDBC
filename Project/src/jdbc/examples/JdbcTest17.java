//WAP to update total and avg marks from student_marks table
package jdbc.examples;
import java.sql.*;
public class JdbcTest17 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dev", "dev");
			PreparedStatement ps1=cn.prepareStatement("update student_marks set total=sub1+sub2+sub3");
			PreparedStatement ps2=cn.prepareStatement("update student_marks set avg=total/3");
			ps1.executeQuery();
			ps2.executeQuery();
			System.out.println("taotal and Avg are update");
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException s) {
			System.out.println(s.getMessage());
		}
	}
}