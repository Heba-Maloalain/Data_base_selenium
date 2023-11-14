package dataBaseProj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mysql.cj.xdevapi.Statement;

public class dataBaseCon {
	Connection con = null;
	 java.sql.Statement stm =null;
	 ResultSet rs;
	
	
	
	@BeforeTest 
	public void database1() throws SQLException {
		
		con =DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "heba123456789");
	}
	
	
	
	@Test(priority = 1)
	public void AddNewData() throws SQLException {
		
		stm=con.createStatement();
	    String InsertQuery="insert into customers (customerNumber,customerName,contactLastName,contactFirstName,phone,addressLine1,city,country)"+
		"values (2001,'heba','DOE','jafer','123-456-789','Amman','Amman','jordan')";
		
	    int insertedRow= stm.executeUpdate(InsertQuery);
	    if(insertedRow>0) {
	    	System.out.println("data has been added");
	    	
	    }
	    else {
	    	System.out.println("sorry, data was not inserted");
	    }
	    
	}
	
	
	
	@Test(priority = 2)
	
	public void UpdateCutomerNumber() throws SQLException
	{
		stm=con.createStatement();
		String UpdateQuery="update customers SET city='Irbid' where customerNumber=2001 ";
		
		int updatedRow=stm.executeUpdate(UpdateQuery);
		if(updatedRow>0) {
			
			System.out.println("User Updated");
		}
		else {
			
			System.out.println("there is something wrong");
		}
		
		
	}
	@Test(priority = 3)
	public void SelectData() throws SQLException {
	
		stm = con.createStatement();
		rs=stm.executeQuery("select * from customers where customerNumber =2001");
		
		while(rs.next()) {
			int custNumber =rs.getInt("customerNumber");
			String  custName=rs.getString("customerName");
			
		String customerCity=rs.getString("city");
			System.out.println("the customer number is : "+custNumber);
			System.out.println("the customer name is : "+custName);
			System.out.println("the customer city is : "+customerCity);
			
//			if(customerCity.equals("Irbid")) {
//				
//				System.out.println("updated correctly");
//			}else {System.out.println("no updated");}
//			
//			
		}
		
		
		
		
		
	}
	@Test(priority = 4)
	public void DeleteUser() throws SQLException
	{
		stm=con.createStatement();
		String DeleteCommand="delete from customers where customerNumber=2001";
		int deletedRow=stm.executeUpdate(DeleteCommand);
		if(deletedRow>0) {
			System.out.println("user deleted");
		}
		else 
		{
			System.out.println("can not delete");
		}
		
		
		
	}
	@AfterTest 
	public void test3() {}
	
	

}
