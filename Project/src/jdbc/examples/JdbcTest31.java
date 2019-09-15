package jdbc.examples;
import java.sql.*;
public class JdbcTest31 {

	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dev","dev");
		PreparedStatement ps=cn.prepareStatement("insert into person_table values(?,?)");
		ps.setString(1, "Devaj");
		Address a=new Address("101","Amreetpet","Hyd","ADDRESS_TYPE");
		ps.setObject(2, a); // set the value of the designated parameter using the given object
		int c=ps.executeUpdate();
		System.out.println("Row Updated :"+c);
	}

}
