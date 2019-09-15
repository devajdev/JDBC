// Deallocating to resource & Navigation method
package jdbc.examples;
import java.sql.*;
public class JdbcTest11 {
	public static void main(String[] args) {
		Connection cn=null;
		Statement st=null;
		ResultSet rs=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dev","dev");
			st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery("select empno, ename, sal, hiredate from emp");
			rs.next();
			System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getFloat(3)+","+rs.getString(4));
			rs.last();
			System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getFloat(3)+","+rs.getString(4));
			rs.previous();
			System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getFloat(3)+","+rs.getString(4));	}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());	}
		catch(SQLException s) {
			System.out.println(s.getMessage());	}
		finally {
			try {
				if(cn!=null)
					cn.close();
				if(st!=null)
					st.close();
				if(rs!=null)
					rs.close();  }
		catch(SQLException k) {
			System.out.println(k.getMessage());
		}}}}
