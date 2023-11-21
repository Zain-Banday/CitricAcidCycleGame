package methods;
import in_out.Out;
import in_out.In;

/* 
* Project: src
* Package: methods
* Class:  Methods_Assignment_2
* Programmer: Zain Banday
* Date Created: 4/26/2023
* Description: Calculates total value of coins
*/ 

public class Add_Coins {
	
	/** 
	 * Takes an amount of quarters, dimes, nickels, and pennies, and adds their values up for a final dollar value
	 * @param (q) number of quarters
	 * @param (d) number of dimes
	 * @param (n) number of nickels
	 * @param (p) number of pennies
	 * @return (value) Amount of dollars
	 */ 
	public static double getDollarAmount (double q, double d, double n, double p) {
		double value = 0;
		value += (q * 0.25) + (d * 0.1) + (n * 0.05) +  (p * 0.01);
		return value;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//variables 
		double quarters = 0, dimes = 0, nickels = 0, pennies = 0, total = 0;
	
		//get number of quarters
		Out.println("Enter your total coins:\n\nQuarters: ");
		quarters = In.getDouble(); 
		
		//get number of dimes
		Out.println("Dimes: ");
		dimes = In.getDouble();
		
		//get number of nickels
		Out.println("Nickels: ");
		nickels = In.getDouble();
		
		//get number of pennies
		Out.println("Pennies: ");
		pennies = In.getDouble();
		
		//call method and calculate total sum
		total = getDollarAmount(quarters, dimes, nickels, pennies);
		
		//Output total sum
		Out.println("\nTotal is: $" + total);
	}

}
