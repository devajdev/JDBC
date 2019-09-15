// to show list of all jdbc drivers

package jdbc.examples;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration; //Retrieve all current jdbc drivers
public class JdbcTest03 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Registred With Drivernager");
			Enumeration <Driver> e=DriverManager.getDrivers();
			while(e.hasMoreElements())
				System.out.println(e.nextElement());
				System.out.println(e.toString());
				System.out.println(e);
				String s="s";
				System.out.println(s.toString());
					}
		catch(ClassNotFoundException e) {
			System.out.println("Invalid Driver Class Nmae");
		}

	}

}
