package jdbc.examples;
import java.sql.*;
import java.util.*;
public class JdbcTest32 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dev", "dev");
			PreparedStatement ps=cn.prepareStatement("select * from person_table");
			ResultSet rs=ps.executeQuery();
			rs.next();
			String name=rs.getString(1);
			
			Map <String,Class<?>> m=new HashMap<String,Class<?>>();
			m.put("ADDRESS_TYPE", Address.class);
			Address a=(Address) rs.getObject(2,m);
			System.out.print(name+" ");
			System.out.println(a);
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}