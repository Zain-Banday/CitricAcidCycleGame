package Games;
import in_out.In;
import in_out.Out;


public class Hangman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	boolean gameOver = false;
	int maxTries = 6;
	
		
	String[] words = new String[] {"Kangaroo", "Rhinoceros", "Hippopotamus", "Parrot", "Penguin"};
	String gameWord = words[(int) (Math.random() * 3)], dash = "";
	
	
	while (gameOver == false) {
		
		for (int i = 0; i < gameWord.length(); i ++) {
			dash += "_ ";
			
		}
		Out.println(dash + "Enter a letter");
		char letter = In.getChar();
		for (int i = 0; i < gameWord.length(); i ++) {
			if (letter == gameWord.charAt(i)) {
				String stringLetter = String.valueOf(letter);
				dash.replace("_ ", stringLetter);
			}
		}
	}
	
	
	}

}
