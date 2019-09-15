//program for registring driver
package jdbc.examples;
public class JdbcTest02 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Registred With Driver Manager");
		}
		catch(ClassNotFoundException e) {
			System.out.println(e);
			System.out.println("Invalid Driver Class Nmae");
		}

	}

}
