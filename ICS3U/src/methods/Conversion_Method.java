package methods;
import in_out.Out;
import in_out.In;

/* 
* Project: src
* Package: methods
* Class:  Conversion Method
* Programmer: Zain Banday
* Date Created: 4/25/2023
* Description: Part 1 converts imperial units of measurement to metric units of measurement
*/ 






public class Conversion_Method {
	
	
	

	
	/** 
	 * Converts an input of measurement in inches and converts it into centimeters
	 * @param (value) Value of inches 
	 * @return (value) Value of centimeters
	 */ 
	public static double incenConversion(double value) {
		value = value * 2.54; //inches to centimeters
		return value;

		}
	
	/** 
	 * Converts an input of measurement in feet and converts it into centimeters
	 * @param (value) Value of feet 
	 * @return (value) Value of centimeters
	 */ 
	public static double feetcenConversion(double value) {
		value = value * 30; //feet to centimeters
		return value;
	}
	
	/** 
	 * Converts an input of measurement in yards and converts it into meters
	 * @param (value) Value of yards 
	 * @return (value) Value of meters
	 */ 
	public static double yardmetConversion(double value) {
		value = value * 0.91; // yards to meters
		return value;
	}
	
	/** 
	 * Converts an input of measurement in miles and converts it into kilometers
	 * @param (value) Value of miles 
	 * @return (value) Value of kilometers
	 */ 
	public static double milkilConversion (double value) {
		value = value * 1.6; // miles to kilometers
		return value;
	}
	
	/** 
	 * Displays menu for program
	 */ 
	public static void menu() {
		Out.println("\nConvert:\n1. Inches to Centimeters\n2. Feet to Centimeters\n3. Yards to Meters\n4. Miles to Kilometers"
				+ "\n\nEnter your choice: ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//variables
		double num = 0;
		int choice = 0;
		double conversionValue = 0;
		
		Out.println("Enter a number:    ");
		num = In.getDouble(); //Get number
		
		menu();
		choice = In.getInt(); //Get type of conversion
		
		
		//Output conversion with correct units
		if (choice == 1) {
			conversionValue = incenConversion(num);
			Out.println("\n" + num + " inches equals " + conversionValue + " centimeters");
		}
		else if (choice == 2) {
			conversionValue = feetcenConversion(num);
			Out.println("\n" + num + " feet equals " + conversionValue + " centimeters");
		}
		else if (choice == 3) {
			conversionValue = yardmetConversion(num);
			Out.println("\n" + num + " yards equals " + conversionValue + " meters");
		}
		else if (choice == 4) {
			conversionValue = milkilConversion(num);
			Out.println("\n" + num + " miles equals " + conversionValue + " kilometers");
		}
	}

}
