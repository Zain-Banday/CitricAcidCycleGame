/* 
 * Project: ICS3U
 * Package: jetFighter 
 * Class: JetFighter
 * Programmer: Zain Banday
 * Date Created: May 16th, 2023
 * Description: Jet Fighter is a 2-player game where the users control 2 ships. 
 * These ships can move in any 45° direction. Each ship can shoot out bullets, and each ship has a maximum of 4 bullets shot at a time. 
 * Eventually, each bullet will disappear and the ship can shoot more bullets. When either ship leaves the window, 
 * the ship is teleported to the opposite side of the screen. The same feature applies to all bullets.  
 * The objective of the game is to shoot the other player as many times as possible before time Game Timer runs out. 
 * A score is kept for both players, and whoever has the higher score by the time the Game Timer ends, wins the game.  
 */ 

package jetFighter;




public class JetFighter{
	
	
	
	
	public static void main(String[] args) {
		
	
		new JetFrame();
	}

}
