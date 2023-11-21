package Intro;
import in_out.In;
import in_out.Out;


public class SineOfAngle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/* 
* Project: ics3u 
* Package: intro 
* Class:  SineOfAngle 
* Programmer: Zain Banday
* Date Created: 2/21/2023
* Description: Takes a user input in degrees, and outputs the Sine of that angle
*/ 
		// Variables
		double degreesAngle;
		double radiansAngle;
		double sine;
		
		// Get input from user
		Out.println("Enter an angle in degrees:" );
		degreesAngle = In.getDouble();
		
		// Convert degrees to radians
		radiansAngle = (degreesAngle * Math.PI) / 180;
		
		// Find Sine value of the radians value
		sine = Math.sin(radiansAngle);
		
		//Output final answer
		Out.println("The sine of your angle is " + sine);

	}

}
