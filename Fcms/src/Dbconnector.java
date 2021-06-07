import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Dbconnector {
	 ResultSet myRs=null;	
	 Connection myConn = null;
	 Statement myStmt = null;
	 
	public Dbconnector() 
	{
	
		try {
			String dbUrl = "jdbc:mysql://localhost:3306/fcms";
			String user = "root";		
			String pass = "guru";
			
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			myStmt = myConn.createStatement();
		   }
			catch (Exception exc) {
				exc.printStackTrace();
			}
		
	}
		public void getData() {
			try {
			myRs = myStmt.executeQuery("select * from fcms");
		
			while (myRs.next()) {
				System.out.println(myRs.getString("username") + " , " + myRs.getString("title") + " , " + myRs.getString("ratings"));
				
			}
			System.out.println("");
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
			
		}
		public void insert( String username,String userph,String title,String year,String language,String director,int ratings) {
			
			try {	
			int rowsAffected = myStmt.executeUpdate(
				"insert into fcms " +
			"(username,userph,title,year,language,Director,ratings) " + 
			"values " + 
			 "( '"+username+"', '"+userph+"','"+title+"','"+year+"','"+language+"', '"+director+"','"+ratings+"')");
			 
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
			
			
		}
		public void countRec(String title,String year) 
		{
			try {
			 String query=null;
			 query= "SELECT COUNT(*) FROM fcms where title= '"+title+"'  AND year = '"+year+"' ";
			 myRs =myStmt.executeQuery(query);
			 myRs.next();
			 int count = myRs.getInt(1);
			 System.out.println("\nNo.of Feedbacks for this movie :"+count);
			
		}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		}
		public void average(String title,String year) {
			try {
			 myRs =myStmt.executeQuery("select ROUND(avg(ratings),1) from fcms  where title= '"+title+"'  AND year = '"+year+"'");
			 myRs.next();
			 System.out.println("avg :"+ myRs.getDouble(1));
		    }
			catch (Exception exc) {
				exc.printStackTrace();
			}
	}
	 public static void main(String[] args)  {
		
	}  	
}
//MYSQL TABLE
//CREATE TABLE `fcms`.`fcms` (
//		  `username` VARCHAR(20) NOT NULL,
//		  `userph` VARCHAR(13) NOT NULL,
//		  `title` VARCHAR(45)NOT NULL,
//		  `year` VARCHAR(4) NOT NULL,
//		  `language` VARCHAR(45) NOT NULL,
//		  `Director` VARCHAR(45) NOT  NULL,
//		  `ratings` INT NOT NULL,
//		  PRIMARY KEY (`username`));
//
//		
		



