package methods;

public class Method_Demo {

	
	public static int calculateSum(int n,int m) {
		int sum = n + m;
		return sum;
	}
	
	public static void printMessage(String message) {
		System.out.println(message);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sum = calculateSum(1,2);
		
		
		System.out.println(sum);
	
		printMessage("Hallo");
	}

}
