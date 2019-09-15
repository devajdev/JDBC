//WAP to display how many rows after data display by using TYPE_SCROLL_SENSITIVE
package jdbc.examples;
import java.sql.*;
import java.util.*;
public class JdbcTest14 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dev","dev");
			Statement st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=st.executeQuery("select empno,ename,sal,comm,sal+nvl(comm,0) from emp");
			rs.first();
			System.out.print("How Many Rows : ");
			int rows=scan.nextInt();
			boolean b=rs.relative(rows);
			if(b==true)
				System.out.println(rs.getInt(1)+", "+rs.getString(2)+", "+rs.getFloat(3)+", "+rs.getFloat(4)+", "+rs.getFloat(5));
			else 
				System.out.println("Invalid Number of rows");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		}
	}
