// WAP to display emp details by using AWT
package jdbc.examples;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
class EmpWindow extends Frame implements ActionListener {
	Label l1,l2,l3;
	Button b1,b2,b3,b4;
	TextField t1,t2,t3;
	Connection cn=null;
	Statement st=null;
	ResultSet rs=null;
	EmpWindow(){
	l1=new Label("Emp Number");	
	l2=new Label("Emp Name");	
	l3=new Label("Salary");
	t1=new TextField(10);
	t2=new TextField(10);
	t3=new TextField(10);
	b1=new Button("First");
	b2=new Button("Next");
	b3=new Button("Previous");
	b4=new Button("Last");
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);
	setLayout(new GridLayout(5,2));
	add(l1);
	add(t1);
	add(l2);
	add(t2);
	add(l3);
	add(t3);
	add(b1);
	add(b2);
	add(b3);
	add(b4);
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","dev","dev");
		st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs=st.executeQuery("select empno,ename,sal from emp");
	}
	catch(ClassNotFoundException e) {
		System.out.println(e.getMessage());
	}
	catch(SQLException e) {
		System.out.println(e.getMessage());
	}
	}// Constructor close
	public void actionPerformed(ActionEvent e) {
		String s=e.getActionCommand();
		try {
			if(s.equals("First"))
				rs.first();
			if(s.equals("Next"))
				rs.next();
			if(s.equals("Previous"))
				rs.previous();
			if(s.equals("Last"))
				rs.last();
			t1.setText(String.valueOf(rs.getInt(1)));
			t2.setText(rs.getString(2));
			t3.setText(String.valueOf(rs.getFloat(3)));
		}
		catch(SQLException x) {
			System.out.println(x.getMessage());
		}
	}//method close
}//class close
public class JdbcTest12 {
	public static void main(String[] args) {
		EmpWindow windows1=new EmpWindow();
		windows1.setTitle("Emp Details");
		windows1.setSize(600,600);
		windows1.setVisible(true);
	}
}