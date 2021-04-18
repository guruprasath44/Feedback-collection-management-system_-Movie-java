import java.util.*;
import java.util.Scanner;
import java.io.*;
class Login{
    String username, userph, title,year, lang, dir;
    int ratings;
   Dbconnector t =new  Dbconnector();
    Login(String username,String userph,String title,String year,String lang,String dir,int ratings){
        this.username=username;
        this.userph=userph;
        this.title=title;
        this.year=year;
        this.lang=lang;
        this.dir=dir;
        this.ratings=ratings;
    
    }
	Scanner in=new Scanner(System.in);
	void Admin(){
		System.out.println("**********ADMIN**********");  
		System.out.print("\nAdmin name : ");
		String admin=in.nextLine();
		System.out.print("Password  : ");
		String adpass=in.nextLine();
		String ad="admin";
		String pass="admin";
		if(admin.equals(ad) && adpass.equals(pass))
		{
		System.out.println("\nWelcome Admin");
		System.out.println("\nFeedback Details");
		t.getData();
		}
		else{
		System.out.println("\nInvalid name or password");
		}
	}
	void user(){
		System.out.println("Welcome To Feedback Collection Management System");  
		System.out.print("\nUser name : ");
		String username=in.nextLine();
		System.out.print("Phone number  : ");
		String userph=in.nextLine();
		System.out.print("Enter the Movie name: ");
		String title=in.nextLine();
		System.out.print("Released year: ");
		String year=in.nextLine();
		System.out.print("Language : ");
		String lang=in.nextLine();
		System.out.print("Director name : ");
		String dir=in.nextLine();
		
		System.out.println("\n******Star Rating******");
    	 System.out.println(" 5.***** ");
    	 System.out.println(" 4.**** ");
    	 System.out.println(" 3.*** ");
    	 System.out.println(" 2.** ");
    	 System.out.println(" 1.* ");
    	 System.out.println("\nHello "+ username);
    	 System.out.println("\nEnter the number to select your Ratings for "+ title);
    	 int rating=in.nextInt();
    	 in.nextLine();
    	 calculate(rating,title);
    	 t.insert(username, userph,title,year,lang, dir,rating);
    	 t.countRec(title,year);
    	 t.average(title, year);
    	
        System.out.println("\nThank you For your feedback !!!");
	}
	void calculate (int rating,String title)
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
            String lang="";
            String dir="";
            int ratings=0;
        Login m=new Login(username,userph,title, year,lang,dir, ratings);
        Scanner in=new Scanner(System.in);
        System.out.println("1.Admin\n2.User\nEnter your choice: ");
        int c=in.nextInt();
        switch(c){
        	case 1:
        	m.Admin();
        	break;
        	case 2:
        	m.user();
        	break;
        	default:
        	System.out.println("Invalid Input");
        }
        in.close();
       
        

}
}