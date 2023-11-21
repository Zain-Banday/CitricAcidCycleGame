package arrays;
import java.util.Arrays;

public class Mode_Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int listLength = 100;
		int maxNumber = -1, maxAppearances = -1;
		
		
		int[] numbers = new int[listLength];
		
		for (int i = 0; i < listLength; i++) {
			numbers[i] = (int) (Math.random() * 49 + 1);
		}
		
		for (int i = 0; i < numbers.length; i++) {
			int count = 0; //resetting the count for every number in the list
			
			for (int j = 0; j < numbers.length; j++) {
				if (numbers[i] == numbers[j]) {
					count ++;
				}
				
			if (count > maxAppearances) {
				maxAppearances = count;
				maxNumber = numbers[i];
			}
			}
		
			
		}
		
		System.out.println("The mode of this sequence is " + maxNumber + ", appearing " + maxAppearances + " times!");
		System.out.println(Arrays.toString(numbers));
	
	}

}
