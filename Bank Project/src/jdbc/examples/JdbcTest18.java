// Bank Project for creating new Account

package jdbc.examples;
import java.sql.*;
import java.util.*;
public class JdbcTest18 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dev", "dev");
			PreparedStatement ps=cn.prepareStatement("insert into account_master(accno,name,balance)"
					+ "values(?,?,?)");
			String ans="yes";
			while(ans.equals("yes"))
			{
				System.out.print("Input Account Number : ");
				int r=scan.nextInt();
				System.out.print("input Account Holder Name : ");
				String s1=scan.next();
				System.out.print("Input balance : ");
				int s2=scan.nextInt();
				ps.setInt(1, r);
				ps.setString(2, s1);
				ps.setInt(3, s2);
				int c=ps.executeUpdate();
				if(c==1)
					System.out.println("Account is created, Holder Name = "+s1);
					System.out.println("Add Another Account");
					System.out.println("Plz Enter yes OR no : ");
					ans=scan.next();
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException s) {
			System.out.println(s.getMessage());
		}
	}
}