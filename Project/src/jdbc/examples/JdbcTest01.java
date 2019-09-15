// program to register driver with drivermanager service

package jdbc.examples;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.driver.OracleDriver;
public class JdbcTest01 {
public static void main(String[] args) {
	try {
		OracleDriver d = new OracleDriver();
		DriverManager.registerDriver(d);
        System.out.println("Driver is registred with driver manager");
	}
	catch(SQLException e) {
		System.out.println("error in driver register driver");
	}
}
}