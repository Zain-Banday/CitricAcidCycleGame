package Games; 

 

import in_out.In; 

import in_out.Out; 

 

public class RPS { 

 

public static void main(String[] args) { 

char playAgain = 'y'; 

boolean valid; 

String[] choices = { "rock", "paper", "scissors" }; 

int compScore = 0, playerScore = 0; 

 

while (playAgain == 'y') { 

Out.print("Enter your choice (rock, paper, or scissors): "); 

String playerChoice = In.getString(); 

valid = isValidChoice(playerChoice); 

 

while (valid == false) { 

Out.print("Invalid choice. Please try again."); 

playerChoice = In.getString(); 

valid = isValidChoice(playerChoice);  

} 

 

String computerChoice = choices[computerChoiceIndex()]; 

 

Out.println("Computer chooses " + computerChoice); 

 

if (playerChoice.equals(computerChoice)) { 

Out.println("It's a tie!"); 

} else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) 

|| (playerChoice.equals("paper") && computerChoice.equals("rock")) 

|| (playerChoice.equals("scissors") && computerChoice.equals("paper"))) { 

 

Out.println("You win!"); 

playerScore += 1; 

} else { 

Out.println("Computer wins!"); 

compScore += 1; 

} 

 

Out.print("Play again? (y/n): "); 

playAgain = In.getChar(); 

} 

 

printScore(compScore, playerScore); 

} 

 

public static int computerChoiceIndex() { 

int choice = (int) (Math.random() * 3); 

return choice; 

} 

 

public static boolean isValidChoice(String choice) { 

if ((choice.equals("rock")) || (choice.equals("paper")) || (choice.equals("scissors"))) 

return true; 

else 

return false; 

 

} 

 

public static void printScore(int cScore, int pScore) { 

Out.print("Player Score: " + pScore + "  Computer Score: " + cScore); 

} 

 

} 

 