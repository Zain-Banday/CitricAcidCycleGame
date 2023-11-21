package guiDemos;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

public class MyFrame extends JFrame {

	MyPanel panel;
	
	MyFrame(){
		
		panel = new MyPanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		this.add(panel);
		this.pack();
		//makes the screen appear in the middle
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	

	

}
