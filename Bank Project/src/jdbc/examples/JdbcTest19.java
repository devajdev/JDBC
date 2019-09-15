// Bank project for Deposit or Withdrawal

package jdbc.examples;

import java.sql.*;
import java.util.*;

public class JdbcTest19 {
	static int r = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dev", "dev");
			PreparedStatement ps1 = cn
					.prepareStatement("insert into transaction_table(accno,tamt,ttype) values(?,?,?)");
			PreparedStatement ps2 = cn.prepareStatement("select accno,balance from account_master where accno=?");
			PreparedStatement ps3 = cn.prepareStatement("update account_master set balance=? where accno=?");

			int s1 = 0;
			String s2 = null;

			System.out.print("Enter Account Number     : ");
			r = scan.nextInt();
			ps2.setInt(1, r);
			ResultSet rs = ps2.executeQuery();
			rs.next();
			int accno = rs.getInt(1);
			int bal = rs.getInt(2);

			if (accno == r) {
				System.out
						.print("Press 1 for Deposit      : \nPress 2 for Withdrawal   : \nPress 3 for view Balance :");
				int ch = scan.nextInt();

				switch (ch) {
				case 1:
					System.out.print("Enter Transaction Amount : ");
					s1 = scan.nextInt();
					System.out.print("Purpose of transaction   : ");
					s2 = scan.next();
					bal = bal + s1;
					ps3.setInt(1, bal);
					ps3.setInt(2, accno);
					ps3.executeUpdate();
					System.out.println("Amount " + s1 + " is deposited in your Account Number = " + accno);
					System.out.println("Available Balance in your Account is = "+ bal);
					System.out.println("Thank You!!! for using our Services.");
					break;

				case 2:
					System.out.print("Transaction Amount : ");
					s1 = scan.nextInt();
					if (s1 < 0) {
						System.out.println("Please Enter Positive Number");
						break;
					}

					else if (bal < s1) {
						System.out.println("Insuffient Balance in your Account Number = " + r);
						System.out.println("Available Balance in your Account = " + bal);
						System.out.println("**** SORRY ****");
						break;
					} else
						System.out.print("Purpose of transaction : ");
					s2 = scan.next();
					bal = bal - s1;
					ps3.setInt(1, bal);
					ps3.setInt(2, accno);
					ps3.executeUpdate();
					System.out.println("Amount " + s1 + " is Withdrawal from your Account Number = " + accno);
					System.out.println("Available Balance in your Account = " + bal);
					System.out.println("Thank You!! for using our Services.");
					break;

				case 3:
					System.out.println("Available Balance in your Account Number " + r + " is " + bal);
					break;

				default:
					System.out.println("Please Enter Proper Input : ");
				}// switch close

				ps1.setInt(1, r);
				ps1.setInt(2, s1);
				ps1.setString(3, s2);
				ps1.executeUpdate();

			} // if close
		} // try close

		catch (SQLException e) {
			System.out.println("Account Number " + r + " not exist in our bank details");
		} catch (ClassNotFoundException s) {
			System.out.println(s.getMessage());
		}
	}// main close
}// class close