package arrays;
import in_out.Out;
import in_out.In;

public class Array_Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] names = new String[15]; 

		 

		 

		 

		int[] marks; 

		Out.print("How many students are in the class?  "); 

		int max = In.getInt(); 

		marks = new int[max]; 

		 

		names[0] = "Aaron"; 

		Out.println(names[0]); 

		names[1] = "Hanna"; 

		names[2] = "Hayden"; 
		names[3] = "Bob";
		names[4] = "Kaitlyn";
		names[5] = "Kennedy";
		names[6] = "Lance";

		 

		for (int i=0; i <marks.length; i++) 

		{ 

		// Generate a random mark from 50 to 100 

		marks[i] = (int)(Math.random()*51 + 50); 

		Out.println("Student:  "+ names[i] + "   Mark: " + marks[i]); 

		} 
	
	
	}

}
