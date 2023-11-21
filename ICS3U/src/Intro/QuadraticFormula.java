package Intro;

import in_out.In;
import in_out.Out;


public class QuadraticFormula {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/* 

* Project: ics3u 

* Package: intro 

* Class:  Quadratic Formula

* Programmer: Zain Banday

* Date Created: 2/21/2023

* Description: Takes a user input for a, b, and c for the standard form of the Quadratic Equation, 
* and caluclates the roots (x value)

*/ 

		//variables
		double a;
		double b;
		double c;
		double discriminant;
		double root1;
		double root2;
		
		//get input a from user
		Out.println("Input the value of 'a' for the standard form of a Quadratic Equation: ");
		a = In.getDouble();
		//get input b from user
		Out.println("Input the value of 'b' for the standard form of a Quadratic Equation: ");
		b = In.getDouble();
		//get input c from user
		Out.println("Input the value of 'c' for the standard form of a Quadratic Equation: ");
		c = In.getDouble();
		
		//calculate determinant
		discriminant = (b*b) - (4 * a * c);
		
		//if discriminant is less than 0, there are no roots
		if (discriminant < 0) {
			//output answer
			Out.println("There are no roots for your equation");
		
		
		} 
		
		//if discriminant is equal to 0, there is 1 root
		else if (discriminant == 0) {
			//calculate root
			root1 = ((-b + Math.sqrt(discriminant)) / (2*a));
			//output answer
			Out.println("The one root for your equation is " + root1);
		
		
		} 
		
		//if discriminant is greater than 0, there are 2 roots
		else if (discriminant > 0) {
			//calculate both roots
			root1 = ((-b + Math.sqrt(discriminant)) / (2*a));
			root2 = ((-b - Math.sqrt(discriminant)) / (2*a));
			//output answer
			Out.println("The 2 roots for your equation are " + root1 + " and " + root2);
			
		}
		
		
		
		
		
	}

}
