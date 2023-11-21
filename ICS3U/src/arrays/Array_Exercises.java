package arrays;
import in_out.Out;
import java.util.Arrays;


public class Array_Exercises {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
/*
		double sum = 0, avg;
		
		int[] numbers = new int[50];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int) (Math.random()*49 + 1);
			sum += numbers[i];
		}
		
		avg = (sum / 50);
		
		Out.println(Arrays.toString(numbers));
		Out.println("the average is " + avg);

*/	
/*
		double max = 0;
		int[] numbers = new int[50];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int) (Math.random()*49+1);
			max = Math.max(max, numbers[i]);
			
			
		}
		
		Out.println(Arrays.toString(numbers));
		Out.println(max);
		
*/
/*
		double max = 0, min = 0, range;
		int[] numbers = new int[50];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int) (Math.random()*49+1);
			max = Math.max(max, numbers[i]);
		}
		
		for (int i = 0; i < numbers.length; i++) {
			if (i == 0) {
				min = numbers[i];
			}
			else {
				min = Math.min(min, numbers[i]);
			}
		}
		
		range = (max - min);
		Out.println(range);
		Out.println(max + " - " + min);

*/

		int[] numbers = new int[50];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int) (Math.random()*49 + 1);
		}
		
		int maxNumber = -1, maxAppearances = -1;
		
		for (int i = 0; i < numbers.length; i++) {
			int count = 0;
			
			for (int j = 0; j < numbers.length; j++) {
				if (numbers[i] == numbers[j]) {
					count ++;
				}
					
			
			if (count > maxAppearances) {
				maxNumber = numbers[i];
				maxAppearances = count;
			}
			}
		
		
		}
		
		
		Out.println("The mode is " + maxNumber + " appearing " + maxAppearances + " times");
		Out.println(Arrays.toString(numbers));
		
		

		
		
		
		
		
		
		
		
		
/*	
		
		String starString = "";
		int num1to5 = 0, num6to10 = 0, num11to15 = 0, num16to20= 0, num21to25 = 0, num26to30 = 0, num31to35 = 0, num36to40 = 0, num41to45 = 0, num46to50 = 0;
		int[] numbers = new int[50];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int) (Math.random()*49+1);
			if (numbers[i] >= 1 && numbers[i] <=5) {
				num1to5 += 1;
			}
			else if (numbers[i] >= 6 && numbers[i] <= 10) {
				num6to10 += 1;
			}
			else if (numbers[i] >= 11 && numbers[i] <= 15) {
				num11to15 += 1;
			}
			else if (numbers[i] >= 16 && numbers[i] <= 20) {
				num16to20 += 1;
			}
			else if (numbers[i] >= 21 && numbers[i] <= 25) {
				num21to25 += 1;
			}
			else if (numbers[i] >= 26 && numbers[i] <= 30) {
				num26to30 += 1;
			}
			else if (numbers[i] >= 31 && numbers[i] <= 35) {
				num31to35 += 1;
			}
			else if (numbers[i] >= 36 && numbers[i] <= 40) {
				num36to40 += 1;
			}
			else if (numbers[i] >= 41 && numbers[i] <= 45) {
				num41to45 += 1;
			}
			else if (numbers[i] >= 46 && numbers[i] <= 50) {
				num46to50 += 1;
			}

		}
	
		
		for (int i = 0; i < num1to5; i++) {
			starString += "*";
		}
		Out.println("1-5:   " + starString);
		
		
		starString = "";
		for (int i = 0; i < num6to10; i++) {	
			starString += "*";
		}
		Out.println("6-10:  " + starString);
		
		starString = "";
		for (int i = 0; i < num11to15; i++) {
			starString += "*";
		}
		
		Out.println("11-15: " + starString);
		
		starString = "";
		for (int i = 0; i < num16to20; i++) {
			starString += "*";
		}
		Out.println("16-20: " + starString);
		
		starString = "";
		for (int i = 0; i < num21to25; i++) {
			starString += "*";
		}
		Out.println("21-25: " + starString);
		
		starString = "";
		for (int i = 0; i < num26to30; i++) {
			starString += "*";
		}
		Out.println("26-30: " + starString);
		
		starString = "";
		for (int i = 0; i < num31to35; i++) {
			starString += "*";
		}
		Out.println("31-35: " + starString);
		
		starString = "";
		for (int i = 0; i < num36to40; i++) {
			starString += "*";
		}
		Out.println("36-40: " + starString);
		
		starString = "";
		for (int i = 0; i < num41to45; i++) {
			starString += "*";
		}
		Out.println("41-45: " + starString);
		
		starString = "";
		for (int i = 0; i < num46to50; i++) {
			starString += "*";
		
		}
		Out.println("46-50: " + starString);
	
		Out.println(Arrays.toString(numbers));

*/	
	}

}
