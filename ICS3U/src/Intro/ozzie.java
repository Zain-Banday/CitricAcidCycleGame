package Intro;
import java.util.Scanner;

public class ozzie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int num;
	    System.out.print("Enter an Integer number: ");

	    //The input provided by user is stored in num
	    Scanner input = new Scanner(System.in);
	    num = input.nextInt();
	    
	    if ( num % 2 == 0 )
	        System.out.println(num+" is an even number.");
	      else
	        System.out.println(num+" is an odd number.");
	

		

	}

}
