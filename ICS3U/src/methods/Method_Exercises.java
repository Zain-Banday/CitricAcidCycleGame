package methods;
import in_out.Out;

public class Method_Exercises {

	public static double average (double a, double b) {
		return (a + b) / 2;
	}
		
	public static double circleArea(double r) {
		double area = (Math.pow(r, 2) * Math.PI);
		return area;
	
	}
	
	public static double sphereVolume(double r) {
		double volume = (Math.pow(r, 3) * Math.PI * 1.333333);
		return volume;
	}
	
	public static double compoundInterest(double P, double r, double t, int n) {
		r = r / n;
		t = t * n;
		double A = (P * Math.pow(1 + r, t));
		return A;
		
		
	}
	
	public static double compoundInterest2(double P, double r, int n) {
		r = (r / 100) + 1;
		r = Math.pow(r, n);
		double I = (P * r) - P;
		
		return I;
	}
	
	public static int numDiv(int n) {
		int divisors = 0;
		if (n < 1) {
			return 0;
		}
		else {
			
		
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				divisors ++;
			}
			}
		}
		return divisors;
	}
	
	public static long fibonacci (long n) {
		long firstNum = 1, secondNum = 1;
		long nextNum = 0;
		if (n < 3) {
			nextNum = 1;
		}
		
		else {
			for (int i = 1; i <= n -2  ; i ++) {
				nextNum = firstNum + secondNum;
				firstNum = secondNum;
				secondNum = nextNum;
		
			}
		}
		return nextNum;
	}
	
	public static boolean isEven (int n) {
		if (n % 2 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isPrime (double n) {
		boolean primeStatus = true;
		
		
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				primeStatus = false;
			}
		}
		if (primeStatus == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static String reverseString (String n) {
		String newString = "";
		for (int i = n.length() - 1; i>=0; i--) {
			newString += n.charAt(i);
		}
	return newString;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double i = compoundInterest(1000, 0.14, 4, 1);
		Out.println(i);
		
		double m = compoundInterest2(1000, 50, 12);
		
		Out.println(m);
	}

}
