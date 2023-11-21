package guiDemos;
import javax.swing.*;


public class SimpleGUI1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame();//declare window
		JButton button = new JButton("click me");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//window closes when X is pressed
		
		frame.getContentPane().add(button); //add button to window
		
		frame.setSize(300,300); //set size of window
		
		frame.setVisible(true); //make window visible
		
		
		
		
		
	}

}
