//Program for Address
package jdbc.examples;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

public class Address implements SQLData {
	private String hno;
	private String street;
	private String city;
	private String type;
	
	public Address() {}
	
	public Address(String hno, String street, String city, String type) {
		this.hno=hno;
		this.street=street;
		this.city=city;
		this.type=type;
	}
	
	@Override
	public void writeSQL(SQLOutput stream) throws SQLException {
		stream.writeString(hno);
		stream.writeString(street);
		stream.writeString(city);
	}
	
	@Override
	public void readSQL(SQLInput stream, String typeName) throws SQLException {
		hno=stream.readString();
		street=stream.readString();
		city=stream.readString();
		type=typeName;
	}
	
	@Override
	public String getSQLTypeName() throws SQLException {
		// TODO Auto-generated method stub
		return type;
	}
	
	public String toString() {
		return hno+","+street+","+city;
	}
	
}