package methods;

import in_out.In;
import in_out.Out;

public class binaryConverter {
	
	public static int[] BinaryMaker(int num){ 
		int arrLength, power = 0;
		

		while (Math.pow(2, power) < num) {
			power += 1;
		}
		arrLength = power + 1;
		
		int[] numArray = new int[arrLength];
		
		for (int i = 0; i < arrLength; i++) {
			numArray[i] = num%2;
			num = num / 2;
		}
		
		return numArray;
		
 	}
	
	//this is used for decimal -----> binary
	//reverses an array to make the binary number from above the correct way
	public static int reverseArray(int[] array) {
		int result = 0;
		
		for (int i = array.length - 1; i >= 0; --i) {
			  result = 10*result + array[i];//combines int list into single int
			  //^^the above is taken from: https://stackoverflow.com/questions/33607753/way-to-combine-integer-array-to-a-single-integer-variable
			}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Out.println("Enter a number in decimal");
		int num = In.getInt();
		int[] array = BinaryMaker(num);
		int binary = reverseArray(array);
		
		Out.println(binary);
	}

}
