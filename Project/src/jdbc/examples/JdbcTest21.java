//
//procedure with parameter
/*create table accounts_master(accno number(5) primary key,
 * cname varchar2(20), balance number(10,2));
 * end;
 * insert some data
 * 
 * create table trans_table( accno number(5) references accounts_master(accno), tamt number(10,2), ttype varchar2(20))
 *
 *create or replace procedure deposit(paccno number,pamt number)is
 *begin
 *insert into trans_table values(paccno,pamt,'deposit');
 *update accounts_master set balance=balance+pamt where accno=paccno;
 *end;
 */
package jdbc.examples;
import java.sql.*;
import java.util.*;
public class JdbcTest21 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dev", "dev");
			CallableStatement cs=cn.prepareCall("{call deposit(?,?)}");
			Scanner scn=new Scanner(System.in);
			System.out.print("Enter Account Number : ");
			int accno=scn.nextInt();
			System.out.print("Enter Trnsaction Amount : ");
			int tamt=scn.nextInt();
			cs.setInt(1,accno);
			cs.setInt(2, tamt);
			cs.executeQuery();
			System.out.println("Transaction Completed ");
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
