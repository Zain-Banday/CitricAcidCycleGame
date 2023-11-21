package arrays;
import in_out.Out;
import in_out.In;
import java.util.Arrays;


public class Arrays_Continued {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		int arrayLength = 0;
		Out.println("How many numbers do you want to type? ");
		arrayLength = In.getInt();
		
		int [] numbers = new int[arrayLength];
		
		for (int i = 0; i < numbers.length; i++) {
			Out.println("Enter a number: ");
			numbers[i] = In.getInt();
			
		}
		
		for (int i = 0; i < numbers.length; i++) {
			Out.print(numbers[i] + " ");
		}
		
		Out.println("\n");
		
		for (int i = numbers.length - 1; i >= 0; i--) {
			Out.print(numbers[i] + " ");
		}
*/		
		
		int commonAppearances = 0, commonNumber = 0, leastAppearances = 1001, leastNumber = 0;
		double sum = 0;
		int[] repeated = new int[10];
		int[] numbers = new int[1000];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int) (Math.random()*10 + 1);
			sum += numbers[i];
			if (numbers[i] == 1) {
				repeated[0] += 1;
			}
			
			else if (numbers[i] == 2) {
				repeated[1] += 1;
			}
			
			else if (numbers[i] == 3) {
				repeated[2] += 1;
			}
			
			else if (numbers[i] == 4) {
				repeated[3] += 1;
			}
			
			else if (numbers[i] == 5) {
				repeated[4] += 1;
			}
			
			else if (numbers[i] == 6) {
				repeated[5] += 1;
			}
			
			else if (numbers[i] == 7) {
				repeated[6] += 1;
			}
			
			else if (numbers[i] == 8) {
				repeated[7] += 1;
			}
			
			else if (numbers[i] == 9) {
				repeated[8] += 1;
			}

			else if (numbers[i] == 10) {
				repeated[9] += 1;
			}
		
		
		}
		
		for (int i = 0; i < 10; i++) {
			Out.println((i + 1) + " is repeated " + repeated[i]  + " times");
			if (repeated[i] > commonAppearances) {
				commonAppearances = repeated[i];
				commonNumber = i + 1;
			}
			
			if (repeated[i]  < leastAppearances) {
				leastAppearances = repeated[i];
				leastNumber = i + 1;
			}
		
		}
		
		Out.println("\nThe most common number is " + commonNumber);
		
		sum = sum / numbers.length;
		
		Out.println("The average of all the numbers is " + sum);
		
		Out.println("The least common number is " + leastNumber);


	}

}
