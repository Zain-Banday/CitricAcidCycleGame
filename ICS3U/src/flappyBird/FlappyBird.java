package flappyBird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

import javax.swing.JFrame;

public class FlappyBird implements ActionListener {
	public static FlappyBird flappyBird;

	// set width and height variables
	public final int WIDTH = 800, HEIGHT = 800;
	
	public Random rand;
	
	public int ticks, yMotion;
	
	public Renderer renderer;
	
	public ArrayList<Rectangle> columns;
	
	
	
	public Rectangle bird;
	

	public FlappyBird() {

		
		// create jframe
		JFrame jframe = new JFrame();
		
		//add timer
		Timer timer = new Timer(20, this);
		
		rand = new Random();
		
		
		//add renderer
		renderer = new Renderer();
		
		jframe.add(renderer);
		
		
		// set size of JFrame
		jframe.setSize(WIDTH, HEIGHT);
		// make JFrame visible
		jframe.setVisible(true);
		//set jframe close operation
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set jframe title
		jframe.setTitle("Flappy Bird");
		//make window non resiizable
		jframe.setResizable(true);
		
		bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
		
		columns = new ArrayList<Rectangle>();
		
		addColumn(true);
		addColumn(true);
		addColumn(true);
		addColumn(true);
		
	
	//start timer
		timer.start();
	}
	
	
	public void addColumn(boolean start) {
		int space = 300;
		int width = 100;
		int height = 50 + rand.nextInt(300);
		
		if (start) {
			//bottom column
			columns.add(new Rectangle(WIDTH + width + columns.size() * 300, HEIGHT - height - 120, width, height));
			//top column
			columns.add(new Rectangle(WIDTH + width + (columns.size() - 1) * 300, 0, width, HEIGHT - height - space));
		}
		else {
			columns.add(new Rectangle(columns.get(columns.size()-1).x + 600, HEIGHT - height - 120, width, height));
			columns.add(new Rectangle(columns.get(columns.size()-1).x, 0, width, HEIGHT - height - space));
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		int speed = 7;
		
		ticks ++;
		
		for (int i = 0; i < columns.size(); i++) {
			Rectangle column = columns.get(i);
			column.x -= speed;
			
			if (column.x + column.width < 0) {
				columns.remove(column);
				
				if (column.y == 0) {
					addColumn(false);
				}
				
			}
		}
		
		if (ticks % 2 == 0 && yMotion < 15) {
			yMotion += 2;
		}
		
		bird.y += yMotion;
		renderer.repaint();
	}
	
	
	public void paintColumn(Graphics g, Rectangle column) {
		g.setColor(Color.green.darker());
		g.fillRect(column.x, column.y, column.width, column.height);
	}

	public void repaint(Graphics g) {
		//draw background
		g.setColor(Color.cyan);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		//draw ground
		g.setColor(Color.orange);
		g.fillRect(0, HEIGHT - 120, WIDTH, 120);
		
		//draw grass
		g.setColor(Color.green);
		g.fillRect(0, HEIGHT - 120, WIDTH, 20);
		
		//draw bird
		g.setColor(Color.red);
		g.fillRect(bird.x, bird.y, bird.width, bird.height);
		
		for (Rectangle column : columns) {
			paintColumn(g, column);
		}
	}
	
	public static void main(String[] args) {
		
		flappyBird = new FlappyBird();

	}

}
