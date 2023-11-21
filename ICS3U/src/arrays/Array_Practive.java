package arrays;
import in_out.In;
import in_out.Out;


public class Array_Practive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Variables

		
		int[] marks = new int[7];
		
		
		
		String[] names = new String[7]; //Initialize List
		
		names[0] = "Terry";
		names[1] = "Claudius";	
		names[2] = "Gertrude";	
		names[3] = "Hamlet";	
		names[4] = "Ophelia";
		names[5] = "Polonius";	
		names[6] = "Larry";
				

		
		
		for (int i = 0; i <= names.length - 1; i++) {
			Out.println("Enter a mark for " + names[i] + ": ");
			marks[i] = In.getInt();
			
		}
		
		Out.println("Name       Mark");
		for (int i = 0; i <= names.length - 1; i++) {
			Out.println(names[i] + "       " + marks[i]);
		}
		
		
	}

}
