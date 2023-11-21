package Intro;
import in_out.In;
import in_out.Out;
import java.text.DecimalFormat;

public class MathMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*		
		Out.println("Enter a small side of a triangle: ");
		double sideA = In.getDouble();
		
		Out.println("Enter another small side of a triangle: ");
		double sideB = In.getDouble();
		
		double sideC = Math.sqrt( ( Math.pow(sideA, 2) + Math.pow(sideB, 2) ));
		Out.println("The hypotenuse of your triangle is " + sideC);
*/

/*	
		Out.println("Enter a side of a triangle: ");
		double sideA = In.getDouble();
		
		Out.println("Enter another side of a triangle: ");
		double sideB = In.getDouble();
		
		Out.println("Enter another side of a triangle: ");
		double sideC = In.getDouble();
		
		double s = (sideA + sideB + sideC) / 2;
		double area = Math.sqrt( s * (s-sideA) * (s-sideB) * (s-sideC));
		
		Out.println("The area to your triangle is " + area);
*/
		
/*		
		Out.println("Enter a value in degrees: ");
		double degree = In.getDouble();
		
		double radian = (degree * Math.PI) / 180;
		Out.println(radian);
		
*/
/*	
		Out.println("Enter a side of a triangle");
		double sideA = In.getDouble();
		
		Out.println("Enter a second side of the triangle");
		double sideB = In.getDouble();
		
		Out.println("Enter an angle (in degrees) that corresponds to the unknown side");
		double radianC = In.getDouble();
		double angleC = (radianC * 180) / Math.PI;
		
		
		
		double area = (sideA * sideB * Math.sin(angleC)) / 2;
		Out.println("The area of your triangle is " + area);
		
*/		
		
/*
		Out.println("Enter a side of a triangle");
		double sideA = In.getDouble();
		
		Out.println("Enter a second side of the triangle");
		double sideB = In.getDouble();
		
		Out.println("Enter an angle (in degrees) that corresponds to the unknown side");
		double angleC = In.getDouble();
		double radianC = (angleC * Math.PI) / 180 ;
		
		double sideC = Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2) - (2 * sideA * sideB * Math.cos(radianC)));
		Out.println("Side C's length is " + sideC);
		
*/
/*
		Out.println("Enter a number: ");
		double a = In.getDouble();
		Out.println("Enter a second number: ");
		double b = In.getDouble();
		double c = Math.pow(a, b);
		Out.println(a + " to the power of " + b + " is " + c);
*/		
		
		Out.println("Input a Number: ");
		double input = In.getDouble();
//		System.out.println(new DecimalFormat("0.000").format(input));
		DecimalFormat df = new DecimalFormat("0.000");
		//double roundedValue = Double.valueOf(df.format(input));
		//Out.println(roundedValue);
		
		
		
		
		
		
		
		
	}

}
