// Navigation Method
package jdbc.examples;
import java.sql.*;
public class JdbcTest10 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dev","dev");
			Statement st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = st.executeQuery("select empno, ename, sal from emp");
			rs.next();
			System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getFloat(3));
			rs.last();
			System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getFloat(3));
			rs.previous();
			System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getFloat(3));
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch(SQLException s) {
			System.out.println(s.getMessage());
		}
	}
}
