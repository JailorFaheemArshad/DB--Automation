package com.bridgelabz.qa.DB_Testing;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DB_Test extends Base{
	@Test
	public void getTableData() throws SQLException {
		con=this.setUp();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select *  from students_info");
		// While Loop to iterate through all data and print results		
		while (rs.next()){
	        		int id = rs.getInt(1);								        
                    String Name = rs.getString(2);
                    String Mobile = rs.getString(3);
                    String email_id = rs.getString(4);
                    String city = rs.getString(5);
                    System. out.println(id+" "+Name+" "+Mobile+" "+email_id+" "+city);
		}
	}	
	@Test
	public void insertData() throws SQLException {
		con=this.setUp();
		PreparedStatement stmt = con.prepareStatement("insert into students_info(id,Name,Mobile,email_id,city) values(?,?,?,?,?)");
		stmt.setInt(1,4);
		stmt.setString(2, "Faheem");
		stmt.setString(3, "7498478548");
		stmt.setString(4, "faheemjailor0055@gmail.com");
		stmt.setString(5, "Solapur");
		stmt.executeUpdate();
		getTableData();
	}
}
