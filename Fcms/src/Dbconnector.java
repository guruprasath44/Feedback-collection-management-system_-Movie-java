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
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
			
		}
		public void insert( String username,String userph,String title,String year,String lang,String dir,int ratings) {
			try {
				//System.out.println("Inserting a new record to database\n");
				String user_name=username;
				String user_ph=userph;
				String tit=title;
				String yr=year;
				String lan=lang;
				String dirt=dir;
				int rating=ratings;
				
				
			int rowsAffected = myStmt.executeUpdate(
				"insert into fcms " +
			"(username,userph,title,year,language,Director,ratings) " + 
			"values " + 
			 "( '"+user_name+"', '"+user_ph+"','"+tit+"','"+yr+"','"+lan+"', '"+dirt+"','"+rating+"')");
			 
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
			
		}
		public void countRec(String title,String year) 
		{
			try {
				String tit=title;
				String yr=year;
			 String query=null;
			 query= "SELECT COUNT(*) FROM fcms where title= '"+tit+"'  AND year = '"+yr+"' ";
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
				String tit=title;
				String yr=year;
            // myRs = myStmt.executeQuery("select * from user");
			 
			 
			 myRs =myStmt.executeQuery("select ROUND(avg(ratings),1) from fcms  where title= '"+tit+"'  AND year = '"+yr+"'");
			 myRs.next();
			 //float co = myRs.getInt(1);
			 System.out.println("avg :"+ myRs.getDouble(1));
		    }
			catch (Exception exc) {
				exc.printStackTrace();
			}
	}
	 public static void main(String[] args)  {

		//Testdb  db =new Testdb();
		
	}  	
}
//MYSQL TABLE
//CREATE TABLE `fcms`.`fcms` (
//		  `username` VARCHAR(20) NOT NULL,
//		  `userph` VARCHAR(13) NULL,
//		  `title` VARCHAR(45) NULL,
//		  `year` VARCHAR(4) NULL,
//		  `language` VARCHAR(45) NULL,
//		  `Director` VARCHAR(45) NULL,
//		  `ratings` INT NULL,
//		  PRIMARY KEY (`username`));
//
//		
		



