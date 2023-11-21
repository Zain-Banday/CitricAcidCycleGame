package Intro;
import in_out.In;
import in_out.Out;


public class SquaredAndCubed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/* 

* Project: ics3u 

* Package: intro 

* Class:  SineOfAngle 

* Programmer: Zain Banday

* Date Created: 2/21/2023

* Description: Takes a user input of a number and outputs the Square and Cube value of that input

*/
		// Variables
		double input;
		double square;
		double cube;
		
		
		// Taking User Input
		Out.println("Enter a Value: ");
		input = In.getDouble();
		
		// Calculating Square and Cube
		square = Math.pow(input, 2);
		cube = Math.pow(input, 3);
		
		// Output of Square and Cube
		Out.println("input = " + input + "\ninput squared = " + square + "\ninput cubed = " + cube);
				
		
		
	
		
		
	}
	

}
