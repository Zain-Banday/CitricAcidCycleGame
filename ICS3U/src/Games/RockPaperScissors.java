package Games;
import in_out.In;
import in_out.Out;

public class RockPaperScissors {

	
	public static boolean isValidChoice(char c) { //c represents choice
		if (c != 'r' && c != 'p' && c != 's') {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	
	public static char getComputerChoice() { //get computer choice between Rock(1), Paper (2), and Scissors(3)
		char computerChoice = 0;
		int n = (int)(Math.random()*3+1);
		switch (n){
			case 1:
				computerChoice = 'r';
				break;
			case 2:
				computerChoice = 'p';
				break;
			case 3:
				computerChoice = 's';
				break;		
		}
		return computerChoice;
	}
	
	
	public static void main(String[] args) {
	//Game Variables
	boolean gameOver = false;
	char playerChoice, computerChoice, retry;
	int playerScore = 0, computerScore = 0;
	
	while (gameOver == false) {
		
		Out.println("Enter your choice (r/p/s)");
		playerChoice = In.getChar();
		
		if (isValidChoice(playerChoice) == false) {
			Out.println("Invalid Choice");
			continue;
		}
		else {
			computerChoice = getComputerChoice();
			Out.println("The computer chose " + computerChoice);
		}
		
		if (playerChoice == 'r' && computerChoice == 's') {
			Out.println("You won!");
			playerScore += 1;
		}
		else if (playerChoice == 'r' && computerChoice == 'p') {
			Out.println("You lost!");
			computerScore += 1;
		}
		else if (playerChoice == 'r' && computerChoice == 'r') {
			Out.println("A Tie");
		}
		
		
		if (playerChoice == 'p' && computerChoice == 'r') {
			Out.println("You won!");
			playerScore += 1;
		}
		else if (playerChoice == 'p' && computerChoice == 's') {
			Out.println("You lost!");
			computerScore += 1;
		}
		else if (playerChoice == 'p' && computerChoice == 'p') {
			Out.println("A Tie");
		}
		
		if (playerChoice == 's' && computerChoice == 'p') {
			Out.println("You won!");
			playerScore += 1;
		}
		else if (playerChoice == 's' && computerChoice == 'r') {
			Out.println("You lost!");
			computerScore += 1;
		}
		else if (playerChoice == 's' && computerChoice == 's') {
			Out.println("A Tie");
		}
		
		Out.println("The Score is Player: " + playerScore + " || Computer: " + computerScore + 
				"\nWould you like to play again? (y/n)");
		retry = In.getChar();
		if (retry == 'y') {
			continue;
		}
		else {
			gameOver = true;
		}
		
	}
		
		

	}

}
