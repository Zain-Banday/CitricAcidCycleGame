package Intro;

import in_out.In;
import in_out.Out;


public class IntegerArithmetic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double a, b;
		double sum, difference, product, remainder;
		double quotient;
		
		Out.print("Enter a number: ");
		a = In.getInt();
		
		Out.print("Enter a second number: ");
		b = In.getInt();

		sum = a + b;
		difference = a - b;
		product = a*b;
		quotient = a / b;
		remainder = a % b;
		
		System.out.println("The sum of your numbers is " +sum+ ". The difference of your numbers is "
				+ difference + ". The product of your numbers is " + product + ". The quotient of your"
						+ " numbers is " + quotient + ". The remainder of your number is " +  remainder +
						".");
		

	}

}
