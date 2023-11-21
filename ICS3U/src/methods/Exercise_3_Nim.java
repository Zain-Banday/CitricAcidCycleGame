package methods;
import in_out.Out;
import in_out.In;

/* 
* Project: src
* Package: methods
* Class:  Exercise_3_Nim
* Programmer: Zain Banday
* Date Created: 4/26/2023
* Description: allows user to play game called "Nim" against computer
*/ 

public class Exercise_3_Nim {
	
	//methods 
	
	/** 
	 * Checks if user input is valid
	 * @param (amountTaken) The amount of stones the user chooses to take
	 * @param (numLeft) The amount of stones that is left
	 * @return (false or true) Return false is input is invalid, otherwise return true
	 */ 
	public static boolean isValidSelection(int amountTaken, int numLeft) {
		if (amountTaken > numLeft || amountTaken > 3 || amountTaken < 1) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/** 
	 * Generates random computer response based on number of stones left
	 * <p> If number of stones is more than 4, computer can take 1,2, or 3 stones
	 * <p> If number of stones is 4, computer takes 3
	 * <p> If number of stones is 3, computer takes 2
	 * <p> If number of stones is either 2 or 1, the computer will choose 1 stone
	 * @param (numLeft) The amount of stones that is left
	 * @return (computerChoice) The number of stones the computer selects
	 */ 
	public static int getComputerChoice(int numLeft) {
		int computerChoice = 0;
		if (numLeft > 4) {
			computerChoice = (int)(Math.random()*3+1); //if #stones > 4, pick a random number between 1,2,3
		}
		else if (numLeft == 4) {
			computerChoice = 3;
		}
		else if (numLeft == 3) { 
			computerChoice = 2; //if #stones = 3, pick 2
		}
		else if ((numLeft == 2) || (numLeft == 1)) {
			computerChoice = 1; //if #stones is 1 or 2, pick 1;
		}
		return computerChoice;
	}
	
	/** 
	 * Checks who went last to see who the winner and loser is. Then prints gameover message
	 * @param (whoWentLast) This variable changes every time the user or computer goes.
	 * <p> The variable changes to 'u' as in user when the user takes their turn
	 * <p> The variable changes to 'c' as in computer when the computer takes its turn
	 * @param (numLeft) The amount of stones that is left
	 * @return (print statement) Prints statement on who lost or do won
	 */ 
	public static void checkForWinner (char whoWentLast) {
		if (whoWentLast == 'u') {
			Out.println("YOU LOST! The computer wins.");
		}
		else if (whoWentLast == 'c') {
			Out.println("THE COMPUTER LOST! YOU WIN!");
		}
	}

	public static void main(String[] args) {
		//game variables
		int stone = (int)(Math.random()*16 + 15); //number of stones is a random integer between 15-30
		char whoWentLast = 0; // 'u' will represent the user and 'c' will represent the computer
		int userInput, computerInput;
		
		//game is over when #stone hits 0
		while (stone > 0) {
		
			
			
			Out.println("There are " + stone + " stones. How many will you take (3 max)? ");
			userInput = In.getInt();//get user input
			if (isValidSelection(userInput, stone) == false) { //check if input is valid
				Out.println("Invalid Number of stones. Please Try Again");
				continue; //for some reason, this just puts me to the start of the loop which is exactly what i want
			}
			else { // if it is valid, take user input away from stones
				stone -= userInput;
				whoWentLast = 'u'; // change whoWentLast to user
				if (stone == 0) {
					break; //breaks the loop when user lose, because if I don't, program will think computer went last
					
				}
			}
			
			
			
			computerInput = getComputerChoice(stone); //gets computer input
			Out.println("There are " + stone + " stones. The computer takes " + computerInput);
			stone -= computerInput; //takes away computer input from #stones
			whoWentLast = 'c'; //changes whoWentLast to computer
		
		}
		
		checkForWinner(whoWentLast); //outputs proper endgame message
		


	}

}
