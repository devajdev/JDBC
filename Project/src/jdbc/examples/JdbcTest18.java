//WAP to read data from student_marks table

package jdbc.examples;
import java.util.*;
import java.sql.*;
public class JdbcTest18 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dev","dev");
			PreparedStatement ps=cn.prepareStatement("select * from student_marks");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				int rno=rs.getInt(1);
				int s1=rs.getInt(2);
				int s2=rs.getInt(3);
				int s3=rs.getInt(4);
				int total=rs.getInt(5);
				float avg=rs.getFloat(6);
				System.out.println(rno+" "+s1+", "+s2+", "+s3+", "+total+", "+avg);
			}
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

}
