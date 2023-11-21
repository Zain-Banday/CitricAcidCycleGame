package arrays;
import in_out.Out;


public class String_Arrays_Review {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int LIST_SIZE = 200; 

		int list [] = new int [LIST_SIZE]; 

		for (int i =0; i<list.length; i++) 

		list[i] = (int)(Math.random()*100 + 1); 

		 

		int mode [] = new int [101];   

		for (int i=0; i<mode.length; i++)  

		mode[i] = 0;

		for (int i=0; i<list.length; i++)   

		mode[list[i]]++; 

		

		int count = 0; 

		for (int i=1; i < mode.length; i++) 

		{ 

		count +=mode[i]; 

		

		if (i%5 == 0) 

		{ 

		Out.print(i-4,2); 

		Out.print("-"); 

		Out.print(i,2); 

		Out.print(" "); 

		for (int j=0; j < count; j++) 

		Out.print("*"); 

		Out.println(); 

		count = 0; 

		} 

		} 
	}

}
