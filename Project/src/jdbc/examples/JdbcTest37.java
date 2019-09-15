//WAP to table exist in database
package jdbc.examples;
import java.sql.*;
public class JdbcTest37 {

	public static void main(String[] args) throws Exception {
	 Class.forName("oracle.jdbc.driver.OracleDriver");
	 Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dev","dev");
	 Statement st=cn.createStatement();
	 st.addBatch("update emp set sal=sal+1000 where deptno=10");
	 st.addBatch("update emp set sal=sal+1000 where deptno=20");
	 st.addBatch("update emp set sal=sal+1000 where deptno=30");
	 int x[]=st.executeBatch();
	 for(int n:x)
		 System.out.println("Total Number Of Rows Updated : "+n); 
	}
}