//WAP read array data from database
package jdbc.examples;
import java.sql.*;
public class JdbcTest30 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dev","dev");
			PreparedStatement ps=cn.prepareStatement("select * from student_table");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int rno=rs.getInt(1);
				String name=rs.getString(2);
				Array a=rs.getArray(3);
				System.out.printf(" %d %s",rno,name);
				//System.out.print(rno+" "+name);
				ResultSet r=a.getResultSet();
				while(r.next())
				System.out.printf(" %s",r.getString(2));
				System.out.println();
			}
			}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
