//WAP to insert data into student_marks table by using prepared statement
package jdbc.examples;
import java.sql.*;
import java.util.*;
public class JdbcTest16 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dev", "dev");
			PreparedStatement ps=cn.prepareStatement("insert into student_marks(rollno,sub1,sub2,sub3)"
					+ "values(?,?,?,?)");
			String ans="yes";
			while(ans.equals("yes"))
			{
				System.out.print("Input roll number : ");
				int r=scan.nextInt();
				System.out.println("input 3 subject marks");
				int s1=scan.nextInt();
				int s2=scan.nextInt();
				int s3=scan.nextInt();
				ps.setInt(1, r);
				ps.setInt(2, s1);
				ps.setInt(3, s2);
				ps.setInt(4, s3);
				int c=ps.executeUpdate();
				if(c==1)
					System.out.println("Student is Inserted");
					System.out.println("Add another Student");
					ans=scan.next();
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException s) {
			System.out.println(s.getMessage());
		}
	}
}