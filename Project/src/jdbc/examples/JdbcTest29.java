//WAP to insert array value into database
//create type course_type as varray(3) of varchar2(20);
//create table student_table(rollno number(4) primary key,name varchar2(20),course_name course_type);

package jdbc.examples;
import java.sql.*;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
public class JdbcTest29 {

	public static void main(String[] args){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dev", "dev");
			PreparedStatement ps=cn.prepareStatement("insert into student_table values(?,?,?)");
			ps.setInt(1, 103);
			ps.setString(2,"Dev");
			String course[]= {"Java","Oracle","Python"};
			ArrayDescriptor ad= ArrayDescriptor.createDescriptor("COURSE_TYPE",cn);
			ARRAY a=new ARRAY(ad,cn,course);
			ps.setArray(3,a);
			int c=ps.executeUpdate();
			System.out.println(c);
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
