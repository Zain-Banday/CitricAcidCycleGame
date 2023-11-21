package guiDemos;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class MyDrawGuy extends JPanel {

	private static final long serialVersionUID = 1L;

	private int xPos = 120;

	private int yPos = 120;

	public void paintComponent(Graphics g) {

// Draw Character 

		g.fillOval(xPos, yPos, 100, 100);

	}

	public void moveLeft()

	{

		xPos -= 5;

	}

	public void moveUp() {
		yPos -= 5;
	}

	public void moveDown() {
		yPos += 5;
	}

	public void moveRight() {
		xPos += 5;
	}

}

public class MoveCircle {

	private JFrame frame;

	private MyDrawGuy drawPanel;

	public static void main(String[] args) {

		MoveCircle gui = new MoveCircle();

		gui.go();

	}

	public void go() {

		frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// Create movement buttons 

		JButton leftButton = new JButton("Move Left");
		leftButton.addActionListener(new LeftListener());

//create up button
		JButton upButton = new JButton("move up");
		upButton.addActionListener(new UpListener());

		JButton downButton = new JButton("move down");
		downButton.addActionListener(new DownListener());

		JButton rightButton = new JButton("move right");
		rightButton.addActionListener(new RightListener());

// Create pane on which to draw character 

		drawPanel = new MyDrawGuy();

// Add GUI components 

		frame.getContentPane().add(BorderLayout.WEST, leftButton);

		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

		frame.getContentPane().add(BorderLayout.NORTH, upButton);
		frame.getContentPane().add(BorderLayout.SOUTH, downButton);
		frame.getContentPane().add(BorderLayout.EAST, rightButton);

		frame.setSize(500, 400);

		frame.setVisible(true);

	}

// Listeners for buttons 

	class LeftListener implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			drawPanel.moveLeft();

			frame.repaint();

		}

	}

	class UpListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			drawPanel.moveUp();

			frame.repaint();
		}
	}

	class DownListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			drawPanel.moveDown();
			frame.repaint();

		}
	}

	class RightListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			drawPanel.moveRight();
			frame.repaint();

		}
	}

}