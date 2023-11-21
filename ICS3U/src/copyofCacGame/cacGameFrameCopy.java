package CitricAcidCycleGame;

import java.awt.Component;

import javax.swing.JFrame;


public class cacGameFrame extends JFrame{
	
	cacGamePanel panel;

	cacGameFrame(){
		panel = new cacGamePanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setLayout(null);
		
		this.setResizable(false);
		
		this.setVisible(true);
		this.setTitle("Citric Acid Cycle Game");
		
		this.add(panel);
		this.pack();
		
	}

}
