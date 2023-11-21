package guiDemos;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*; //action listener and action action event
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public class SimpleGUI2 implements ActionListener {
	private JButton button;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleGUI2 gui = new SimpleGUI2();
		gui.go();
	

	
	
	}


		
	public void go() {
		JFrame frame = new JFrame();
		button = new JButton("click me");
		
		
		button.addActionListener(this); //tells the button "add me to your list of listeners"
		
		frame.getContentPane().add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
		
	}
	
	public void actionPerformed (ActionEvent event) {
		button.setText("ive been clicked");
		
	}
	
	

}
