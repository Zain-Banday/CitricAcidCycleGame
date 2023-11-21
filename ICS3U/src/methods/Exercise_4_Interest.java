package methods;
import in_out.Out;
import in_out.In;

/* 
* Project: src
* Package: methods
* Class:  Exercise_4_Interest
* Programmer: Zain Banday
* Date Created: 4/25/2023
* Description: Calculates compound interest with a P value in $, r percentage, and n value for months
*/ 

public class Exercise_4_Interest {

	//method calculates compound interest
	public static double compoundInterest(double P, double r, int n) {
		r = (r / 100) + 1; //turn percentage into decimal and add 1
		r = Math.pow(r, n);//r to the power n
		double I = (P * r) - P; //find total money gained
		
		return I; //return value
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Out.println("Enter a P value");
		double P = In.getDouble();
		Out.println("Enter an r value in percentage");
		double r = In.getDouble();
		Out.println("Enter an n value");
		int n = In.getInt();
		
		Out.println(compoundInterest(P, r, n));
				
	}

}
