package guiDemos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyDrawPanel5ex extends JPanel{
	
	private static final long serialVersionUID = 1l;
	
	
	public void paintComponent (Graphics g) {
		int red = (int) (Math.random()*256);
		int green = (int) (Math.random()*256);
		int blue = (int) (Math.random()*256);
		Color myColor = new Color(red,green,blue);
		g.setColor(myColor);
		g.fillOval(70,70,100,100);
		
	}
	
}



public class SimpleGUI5ex implements ActionListener {

	private JFrame frame;
	
	public static void main(String[] args) {
		
		SimpleGUI5ex gui = new SimpleGUI5ex();
		gui.go();
		

	}
	
	
	public void go() {
		frame = new JFrame("Kanye > Taylor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("Change Colour");
		button.addActionListener(this);
		MyDrawPanel5ex drawPanel = new MyDrawPanel5ex();
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.setSize(300,300);
		frame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent event) {
		frame.repaint();
	}

}
