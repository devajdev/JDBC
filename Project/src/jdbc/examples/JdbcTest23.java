//

/*
create or replace function withdraw1(taccno number, tamt number)
return number
is 
tbal number(10,2);
begin
select balance into tbal from accounts_master where accno=taccno;
if tamt>tbal then
return tbal;
else
update accounts_master set balance=balance-tamt where accno=taccno;
insert into trans_table values(taccno,tamt,'withdraw');
select balance into tbal from accounts_master where accno=taccno;
return tbal;
end if;
end;
*/
package jdbc.examples;
import java.util.*;
import java.sql.*;
public class JdbcTest23 {
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.print("Enter Account Number : ");
		int accno=scn.nextInt();
		System.out.print("Enter Transaction Amount : ");
		int tamt=scn.nextInt();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dev", "dev");
			CallableStatement cs=cn.prepareCall("{?=call withdraw1(?,?)}");
			cs.registerOutParameter(1, Types.NUMERIC);
			cs.setInt(2, accno);
			cs.setInt(3, tamt);
			cs.execute();
			float bal=cs.getFloat(1);
			System.out.println("Balance = "+bal);
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		}

	}
