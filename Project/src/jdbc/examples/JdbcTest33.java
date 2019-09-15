// WAP to display Number Of coloum exist in Database Table
package jdbc.examples;
import java.sql.*;
import java.util.*;
public class JdbcTest33 {

	public static void main(String[] args) //throws Exception 
	{
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dev","dev");
		Scanner scn=new Scanner(System.in);
		System.out.print("Input Any Query : ");
		String query=scn.nextLine();
		PreparedStatement ps=cn.prepareStatement(query);
		ResultSet rs=ps.executeQuery();
		ResultSetMetaData rsmd=rs.getMetaData();
		int c=rsmd.getColumnCount();
		int i=1;
		while(i>0) {
		if(i<=c)
			System.out.println(rsmd.getColumnName(i)+" "+rsmd.getColumnTypeName(i));
			i++;
		}
	}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}	
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}