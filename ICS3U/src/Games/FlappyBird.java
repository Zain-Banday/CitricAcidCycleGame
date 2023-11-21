package Games;

import javax.swing.JFrame;

public class FlappyBird {
	
	public static FlappyBird Games;
	
	//set width and height variables
	public final int WIDTH = 800, HEIGHT = 800;
	
	public FlappyBird() {
		
		//create jframe
		JFrame jframe = new JFrame();
		//set size of JFrame
		jframe.setSize(WIDTH, HEIGHT);
		//make JFrame visible
		jframe.setVisible(true);
	}
	

	public static void main(String[] args) {
		Games = new FlappyBird();
		
	}

}
