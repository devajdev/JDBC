//WAP to read data from any DATABASE table
package jdbc.examples;
import java.sql.*;
import java.util.*;
public class JdbcTest34 {

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
		//int i=1;
		while(rs.next()) {
		//if(i<=c)
			for(int i=1;i<=c;i++)
			{
				String type=rsmd.getColumnTypeName(i);
				if(type.equals("VARCHAR2"))
					//System.out.printf("%s",rs.getString(i));
					System.out.print(rs.getString(i)+" ");
				if(type.equals("NUMBER"))
					//System.out.printf("%d",rs.getInt(i));
					System.out.print(rs.getInt(i)+" ");
			}
			System.out.println();
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