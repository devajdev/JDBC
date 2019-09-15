//WAP to display emp details
package jdbc.examples;
import java.sql.*;
import java.util.*;
public class JdbcTest13 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("Input Row Number : ");
		int number=scan.nextInt();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dev","dev");
			Statement st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("select empno, ename, sal from emp");
			boolean b=rs.absolute(number);
			if(b==true)
				System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getFloat(3));
			else
				System.out.println("Invalid row Number");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
