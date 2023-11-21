package Intro;
import java.util.Scanner;
public class DemoOutput {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// hey wassup man this is Obama speaking through the computer how r u man?

	    // String input with the Java Scanner
	    System.out.println("Name a country?");
	    Scanner stringScanner = new Scanner(System.in);
	    String country = stringScanner.nextLine();
	    if (country.equals("Taiwan") || country.equals("Hong Kong")) {
	    	System.out.println(country + " is not a country");
	    } else if (country.equals("China")) {
	    	System.out.println("向习近平致敬");
	    } else {
	    	System.out.println(country + " is a cool country");
	    }
	    	
	  }
	
		
		
				
			
				

				
			
		
		
		



}


