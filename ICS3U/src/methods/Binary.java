package methods;
import in_out.In;
import in_out.Out;

public class Binary {
	/*
	*There are 2 purposes for this program
	 *The first one is to convert a decimal to its binary version. Example: 47 ---> 101111 
	 * The second one is to convert a binary to its decimal version. Example 111011 ----> 59
	*/
	

	//this is used for decimal -----> binary
	//Convert Integer to binary in an array (the binary is reversed however)
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
	
	
	//this is used for binary -----> decimal
	//Converts binary to a list but makes it reverse
	public static int[] BinaryListMaker(int Binary) {
		int length = (int)(Math.log10(Binary)+1);
		//^^this is taken from^^:https://stackoverflow.com/questions/1306727/way-to-get-number-of-digits-in-an-int
		int[] binArray = new int[length];
		
		for (int i = 0; i < length; i ++) {//seperates the numbers in the Binary int for further analysis
			binArray[i] = Binary % 10;
			Binary = Binary / 10;
		//^^the above is taken from this source^^
		//https://www.edureka.co/community/2687/how-can-i-separate-the-digits-of-an-int-number-in-java
		}
		return binArray;
	}
	
	
	//this is used for binary -----> decimal
	//converts the reversed binary list into a decimal
	public static int Decimal(int[] BinaryList) {
		int valueOfDigit = 1;//The reason we are working up instead of down in because the list is reversed
		int decimal = 0;
		
		for (int i = 0; i < BinaryList.length; i++) {
			if (BinaryList[i] == 1) {//if it is one, add a certain value (either 1,2,4,8,16...)
				decimal += valueOfDigit;
			}
			valueOfDigit = valueOfDigit * 2; //multuply the value by 2 before moving on to next digit
		}
		return decimal;
	}
	
	
	
	
	
	public static void main(String[] args) {
	int userInput;
	
	Out.println("Enter a Binary Number: ");
	userInput = In.getInt();
	
	int[] array = BinaryListMaker(userInput);
	int value = Decimal(array);
	
	Out.println(value);
	
	
	
	
	}
}

