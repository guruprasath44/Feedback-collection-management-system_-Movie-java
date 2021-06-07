import java.util.*;
import java.util.Scanner;
import java.io.*;
class Login{
    String username, userph, title,year, language, director;
    int ratings;
    Dbconnector data =new Dbconnector();
    Login(String username,String userph,String title,String year,String language,String director,int ratings){
        this.username=username;
        this.userph=userph;
        this.title=title;
        this.year=year;
        this.language=language;
        this.director=director;
        this.ratings=ratings;
    
    }
	Scanner in=new Scanner(System.in);
	public void admin(){
		System.out.println("**********ADMIN**********");  
		System.out.print("\nAdmin name : ");
		String admin_name=in.nextLine();
		
		System.out.print("Password  : ");
		String admin_password=in.nextLine();
		String name="admin";
		String password="admin123";
		if(admin_name.equals(name) && admin_password.equals(password))
		{
		System.out.println("\nWelcome Admin");
		System.out.println("\nFeedback Details");
		data.getData();
		}
		else{
		System.out.println("\nInvalid name or password");
		}
	}
	public void user(){
		System.out.println("Welcome To Feedback Collection Management System");  
		System.out.print("\nEnter your user name : ");
		String username=in.nextLine();
		System.out.print("Enter your phone number  : ");
		String userph=in.nextLine();
		System.out.print("Enter the movie name: ");
		String title=in.nextLine();
		System.out.print("Released year: ");
		String year=in.nextLine();
		System.out.print("Language : ");
		String language=in.nextLine();
		System.out.print("Director name : ");
		String director=in.nextLine();
	if(username !="" && userph != "" && title != "" && year !="" && language !="" && director != "") {
		System.out.println("\n******Star Rating******");
    	 System.out.println(" 5.***** ");
    	 System.out.println(" 4.**** ");
    	 System.out.println(" 3.*** ");
    	 System.out.println(" 2.** ");
    	 System.out.println(" 1.* ");
    	 System.out.println("\nHello "+ username);
    	 System.out.println("\nEnter a number between 1 and 5 to select your ratings for "+ title);
    	 int rating=in.nextInt();
    	 in.nextLine();
    	 calculate(rating,title);
    	 data.insert(username, userph,title,year,language, director,rating);
    	 data.countRec(title,year);
    	 data.average(title, year);
    	 System.out.println("\nThank you For your feedback !!!");
	}else {
		System.out.println("\nPlease try again...\n");
		user();
	}
        
	}
	public void calculate (int rating,String title)
    {
        if(rating==1 )
        {
            System.out.println(title +" is FLOP");
          
        }
         else if(rating ==2)
        {
             System.out.println(title +" is GOOD");
        }  
        else if(rating == 3)
        {     
            System.out.println(title +" is SEMI HIT");
        } 
        else if(rating == 4)
        {  
            System.out.println(title +" is HIT");
         } 
        else if(rating ==5)
        {  
          System.out.println(title +" is BLOCKBUSTERR HIT");
        }
        }
	
        
}
        class Main{
        public static void main(String[] args){
            String username="";
            String userph="";
            String title="";
            String year="";
            String language="";
            String director="";
            int ratings=0;
        Login login=new Login(username,userph,title, year,language,director, ratings);
        Scanner in=new Scanner(System.in);
        int c=0;
        do {
        System.out.println("1.Admin\n2.User\n3.Exit\nEnter your choice: ");
         c=in.nextInt();
        switch(c){
        	case 1:
        		login.admin();
        		break;
        	case 2:
        		login.user();
        		break;
        	case 3:
        		System.out.println("\nExcited");
            	System.exit(0);
            	
            	break;
        	default:
        		System.out.println("\nInvalid Input\n");
        }
        }while(c!=0);
        
       
        

}
}