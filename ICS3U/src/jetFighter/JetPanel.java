package jetFighter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;

import javax.swing.JPanel;

import javax.swing.Timer;

public class JetPanel extends JPanel implements KeyListener, ActionListener, ImageObserver, MouseListener {

	// panel width and height
	final static int PANEL_WIDTH = 800;
	final static int PANEL_HEIGHT = 800;

	// max amount of bullets at a time
	final static int MAX_BULLETS = 4;

	// import images
	Image blueShip = new ImageIcon("src\\images\\ship_blue.png").getImage();
	Image orangeShip = new ImageIcon("src\\images\\ship_orange.png").getImage();
	Image greenPipe = new ImageIcon("src\\images\\green_pipe.png").getImage();
	Image greenPipe180 = new ImageIcon("src\\images\\green_pipe_180.png").getImage();
	Image bluePipe = new ImageIcon("src\\images\\blue_pipe.png").getImage();
	Image bluePipe180 = new ImageIcon("src\\images\\blue_pipe_180.png").getImage();
	Image greyPipe = new ImageIcon("src\\images\\grey_pipe.png").getImage();
	Image greyPipe180 = new ImageIcon("src\\images\\grey_pipe_180.png").getImage();
	Image orangePipe = new ImageIcon("src\\images\\orange_pipe.png").getImage();
	Image orangePipe180 = new ImageIcon("src\\images\\orange_pipe_180.png").getImage();
	Image purplePipe = new ImageIcon("src\\images\\purple_pipe.png").getImage();
	Image purplePipe180 = new ImageIcon("src\\images\\purple_pipe_180.png").getImage();
	Image yellowPipe = new ImageIcon("src\\images\\yellow_pipe.png").getImage();
	Image yellowPipe180 = new ImageIcon("src\\images\\yellow_pipe_180.png").getImage();
	Image playButton = new ImageIcon("src\\images\\play_button.png").getImage();

	// use timer for constant movement
	Timer timer;

	// array of timer for blue bullets and orange bullets

	int blueBulletTimers[] = { 400, 400, 400, 400 };
	int orangeBulletTimers[] = { 400, 400, 400, 400 };

	// timer for game
	public int gameTimer = 4000;

	// status on what screen the player is on. There is 2, the menu, and the actual
	// game
	boolean gameOver = true;

	boolean blueWon = false;
	boolean orangeWon = false;

	// velocity variables
	double bluexVelocity = 0;
	double blueyVelocity = 0;

	double orangexVelocity = 0;
	double orangeyVelocity = 0;

	// generate random x and y for ship
	int blueX = (int) (Math.random() * 470 + 20);
	int blueY = (int) (Math.random() * 470 + 20);

	int orangeX = (int) (Math.random() * 470 + 20);
	int orangeY = (int) (Math.random() * 470 + 20);

	// dimensions for bullet
	int bulletDimension = 5;

	// arrays for bullet coordinates and speed
	double[] blueXBullet = { blueX + 13, blueX + 13, blueX + 13, blueX + 13 };
	double[] blueYBullet = { blueY + 10, blueY + 10, blueY + 10, blueY + 10 };
	double[] orangeXBullet = { orangeX + 13, orangeX + 13, orangeX + 13, orangeX + 13 };
	double[] orangeYBullet = { orangeY + 10, orangeY + 10, orangeY + 10, orangeY + 10 };

	double[] blueXBulletVelocity = { 0, 0, 0, 0 };
	double[] blueYBulletVelocity = { 0, 0, 0, 0 };
	double[] orangeXBulletVelocity = { 0, 0, 0, 0 };
	double[] orangeYBulletVelocity = { 0, 0, 0, 0 };

	boolean[] isBlueBulletShot = { false, false, false, false };
	boolean[] isOrangeBulletShot = { false, false, false, false };

	// collision variables for when collision between bullets and ship occur
	boolean isBlueShipCollision = false;
	boolean isOrangeShipCollision = false;
	// score variables
	int bluePlayerScore = 0, orangePlayerScore = 0;

	JetPanel() {
		timer = new Timer(5, this);
		timer.start();
		this.addKeyListener(this);
		this.addMouseListener(this);
		setFocusable(true);
		// setFocusTraversalKeysEnabled(false);

		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setLayout(null);
		this.setBackground(Color.gray.brighter());

	}

	public void paint(Graphics g) {

		super.paint(g); // paint background

		Graphics2D g2D = (Graphics2D) g;

		if (gameOver == true) {
			// Main title "Jet Fighter" for starting menu
			g.setFont(new Font("Serif", Font.PLAIN, 150));
			g.setColor(Color.green);
			g2D.drawString("Jet Fighter", 70, 150);
			// draw play button
			g2D.drawImage(playButton, 70, 400, null);
			// orange won text
			if (orangeWon == true && blueWon == false) {
				g.setFont(new Font("Serif", Font.PLAIN, 70));
				g2D.setColor(Color.orange);
				g2D.drawString("Orange Won", 200, 300);
				// blue won text
			} else if (blueWon == true && orangeWon == false) {
				g.setFont(new Font("Serif", Font.PLAIN, 70));
				g2D.setColor(Color.blue);
				g2D.drawString("Blue Won", 200, 300);
				// Tie Game text
			} else if (blueWon == true && orangeWon == true) {
				g.setFont(new Font("Serif", Font.PLAIN, 70));
				g2D.setColor(Color.pink.darker());
				g2D.drawString("Tie Game", 200, 300);
			}
			

		}

		// run actual game when game over is false (the game is running)
		else if (gameOver == false) {
			for (int i = 0; i < MAX_BULLETS; i++) {

				// draw blue and orange bullets using a for loop
				if (isBlueBulletShot[i] == true) {
					g2D.setColor(Color.blue);
					g2D.fillRect((int) blueXBullet[i], (int) blueYBullet[i], bulletDimension, bulletDimension);
				}

				if (isOrangeBulletShot[i] == true) {
					g2D.setColor(Color.orange);
					g2D.fillRect((int) orangeXBullet[i], (int) orangeYBullet[i], bulletDimension, bulletDimension);
				}

			}

			// draw rectangle timer
			g.setColor(Color.yellow);
			g2D.fillRect(20, 20, gameTimer / 5, 20);

			// draw score
			g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
			g2D.setColor(Color.blue);
			g2D.drawString(String.valueOf(bluePlayerScore), 75, 150);
			g2D.setColor(Color.orange);
			g2D.drawString(String.valueOf(orangePlayerScore), PANEL_WIDTH - 100, 150);

			// draw blue ship
			g2D.drawImage(blueShip, blueX, blueY, null);
			// draw orange ship
			g2D.drawImage(orangeShip, orangeX, orangeY, null);

			// draw green pipes
			g2D.drawImage(greenPipe, 150, PANEL_HEIGHT - 20, null);
			g2D.drawImage(greenPipe180, 150, -greenPipe180.getHeight(null) + 20, null);

			// draw blue pipes
			g2D.drawImage(bluePipe, PANEL_WIDTH - 20, 150, null);
			g2D.drawImage(bluePipe180, -bluePipe180.getWidth(null) + 20, 150, null);

			// draw orange pipe
			g2D.drawImage(orangePipe, 0, PANEL_HEIGHT - 20, null);
			g2D.drawImage(orangePipe180, 650, -orangePipe180.getHeight(null) + 20, null);

			// draw grey pipe
			g2D.drawImage(greyPipe, 650, PANEL_HEIGHT - 20, null);
			g2D.drawImage(greyPipe180, 0, -greyPipe180.getHeight(null) + 20, null);

			// draw purple pipe
			g2D.drawImage(purplePipe, PANEL_WIDTH - 20, 650, null);
			g2D.drawImage(purplePipe180, -purplePipe180.getWidth(null) + 20, 0, null);

			// draw yellow pipes
			g2D.drawImage(yellowPipe, PANEL_WIDTH - 20, 0, null);
			g2D.drawImage(yellowPipe180, -yellowPipe180.getWidth(null) + 20, 650, null);
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// movement for orange ship
		switch (e.getKeyChar()) {
		case 'w':
			// start ship
			if (orangexVelocity == 0 && orangeyVelocity == 0) {
				orangeUp();
				orangeShip = new ImageIcon("src\\images\\ship_orange.png").getImage();
			}
			// if ship is going down and 'w' key is pressed, make ship go up
			else if (orangeyVelocity == 2) {
				orangeUp();
				orangeShip = new ImageIcon("src\\images\\ship_orange.png").getImage();
			}
			// if ship is going left and 'w' key is pressed, make ship go 315
			else if (orangexVelocity == -2) {
				orangeThreeFifteen();
				orangeShip = new ImageIcon("src\\images\\ship_orange_315.png").getImage();
			}
			// if ship is going 315 and 'w' key is pressed, make ship go up
			else if (orangeyVelocity == -1.5 && orangexVelocity == -1.5) {
				orangeUp();
				orangeShip = new ImageIcon("src\\images\\ship_orange.png").getImage();
			}
			// if ship is going right and 'w' key is pressed, make ship go 45
			else if (orangexVelocity == 2) {
				orangeFortyFive();
				orangeShip = new ImageIcon("src\\images\\ship_orange_45.png").getImage();
			}
			// if ship is going 45 and 'w' key is pressed, amke ship go up
			else if (orangeyVelocity == -1.5 && orangexVelocity == 1.5) {
				orangeUp();
				orangeShip = new ImageIcon("src\\images\\ship_orange.png").getImage();
			}
			break;
		case 's':
			// start ship
			if (orangexVelocity == 0 && orangeyVelocity == 0) {
				orangeDown();
				orangeShip = new ImageIcon("src\\images\\ship_orange_180.png").getImage();

			}
			// if ship is going up and 's' key is pressed, make ship go down
			else if (orangeyVelocity == -2) {
				orangeDown();
				orangeShip = new ImageIcon("src\\images\\ship_orange_180.png").getImage();
			}
			// if ship is going left and 's' key is pressed, make ship go 225
			else if (orangexVelocity == -2) {
				orangeTwoTwentyFive();
				orangeShip = new ImageIcon("src\\images\\ship_orange_225.png").getImage();
			}
			// if ship is going 225 and 's' key is pressed, make ship go down
			else if (orangeyVelocity == 1.5 && orangexVelocity == -1.5) {
				orangeDown();
				orangeShip = new ImageIcon("src\\images\\ship_orange_180.png").getImage();

			}
			// if ship is going right and 's' key is pressed, make ship go 135
			else if (orangexVelocity == 2) {
				orangeOneThirtyFive();
				orangeShip = new ImageIcon("src\\images\\ship_orange_135.png").getImage();
			}
			// if ship is going 135 and 's' key is pressed, make ship go down
			else if (orangeyVelocity == 1.5 && orangexVelocity == 1.5) {
				orangeDown();
				orangeShip = new ImageIcon("src\\images\\ship_orange_180.png").getImage();
			}
			break;
		case 'a':
			// start ship
			if (orangexVelocity == 0 && orangeyVelocity == 0) {
				orangeLeft();
				orangeShip = new ImageIcon("src\\images\\ship_orange_270.png").getImage();
			}
			// if ship is going up and 'a' key is pressed, make ship go 315 degrees
			else if (orangeyVelocity == -2) {
				orangeThreeFifteen();
				orangeShip = new ImageIcon("src\\images\\ship_orange_315.png").getImage();
			}
			// if ship is going 315 and 'a' key is pressed, make ship go left
			else if (orangeyVelocity == -1.5 && orangexVelocity == -1.5) {
				orangeLeft();
				orangeShip = new ImageIcon("src\\images\\ship_orange_270.png").getImage();
			}
			// if ship is going down and 'a' key is pressed, make ship go 225
			else if (orangeyVelocity == 2) {
				orangeTwoTwentyFive();
				orangeShip = new ImageIcon("src\\images\\ship_orange_225.png").getImage();
			}
			// if ship is going 225 and 'a' key is pressed, make ship go left
			else if (orangeyVelocity == 1.5 && orangexVelocity == -1.5) {
				orangeLeft();
				orangeShip = new ImageIcon("src\\images\\ship_orange_270.png").getImage();
			}
			break;
		case 'd':
			// start ship
			if (orangexVelocity == 0 && orangeyVelocity == 0) {
				orangeRight();
				orangeShip = new ImageIcon("src\\images\\ship_orange_90.png").getImage();
			}
			// if ship is going up and 'd' key is pressed, make ship go 45 degrees
			else if (orangeyVelocity == -2) {
				orangeFortyFive();
				orangeShip = new ImageIcon("src\\images\\ship_orange_45.png").getImage();
			}
			// if ship is going 45 degrees and 'd' key is pressed, maek ship go right
			else if (orangeyVelocity == -1.5 && orangexVelocity == 1.5) {
				orangeRight();
				orangeShip = new ImageIcon("src\\images\\ship_orange_90.png").getImage();
			}
			// if ship is going down and 'd' key is pressed, make ship go 135
			else if (orangeyVelocity == 2) {
				orangeOneThirtyFive();
				orangeShip = new ImageIcon("src\\images\\ship_orange_135.png").getImage();
			}
			// if ship is going 135 degrees and 'd' key is pressed, make ship go right
			else if (orangeyVelocity == 1.5 && orangexVelocity == 1.5) {
				orangeRight();
				orangeShip = new ImageIcon("src\\images\\ship_orange_90.png").getImage();
			}
			break;

		case 'q':
			// shoot bullets for orange ship

			if (isOrangeBulletShot[0] == false) {
				isOrangeBulletShot[0] = true;
				if (orangeyVelocity == -2) {
					orangeYBulletVelocity[0] = -3;
					orangeXBulletVelocity[0] = 0;
				} else if (orangeyVelocity == -1.5 && orangexVelocity == 1.5) {
					orangeYBulletVelocity[0] = -2.12;
					orangeXBulletVelocity[0] = 2.12;
				} else if (orangexVelocity == 2) {
					orangeYBulletVelocity[0] = 0;
					orangeXBulletVelocity[0] = 3;
				} else if (orangeyVelocity == 1.5 && orangexVelocity == 1.5) {
					orangeYBulletVelocity[0] = 2.12;
					orangeXBulletVelocity[0] = 2.12;
				} else if (orangeyVelocity == 2) {
					orangeYBulletVelocity[0] = 3;
					orangeXBulletVelocity[0] = 0;
				} else if (orangeyVelocity == 1.5 && orangexVelocity == -1.5) {
					orangeYBulletVelocity[0] = 2.12;
					orangeXBulletVelocity[0] = -2.12;
				} else if (orangexVelocity == -2) {
					orangeYBulletVelocity[0] = 0;
					orangeXBulletVelocity[0] = -3;
				} else if (orangeyVelocity == -1.5 && orangexVelocity == -1.5) {
					orangeYBulletVelocity[0] = -2.21;
					orangeXBulletVelocity[0] = -2.21;
				}

			} else {
				int i = 1;
				boolean j = false;
				while (j == false & i < MAX_BULLETS) {

					if (isOrangeBulletShot[i - 1] == true && isOrangeBulletShot[i] == false) {

						isOrangeBulletShot[i] = true;
						if (orangeyVelocity == -2) {
							orangeYBulletVelocity[i] = -3;
							orangeXBulletVelocity[i] = 0;
						} else if (orangeyVelocity == -1.5 && orangexVelocity == 1.5) {
							orangeYBulletVelocity[i] = -2.12;
							orangeXBulletVelocity[i] = 2.12;
						} else if (orangexVelocity == 2) {
							orangeYBulletVelocity[i] = 0;
							orangeXBulletVelocity[i] = 3;
						} else if (orangeyVelocity == 1.5 && orangexVelocity == 1.5) {
							orangeYBulletVelocity[i] = 2.12;
							orangeXBulletVelocity[i] = 2.12;
						} else if (orangeyVelocity == 2) {
							orangeYBulletVelocity[i] = 3;
							orangeXBulletVelocity[i] = 0;
						} else if (orangeyVelocity == 1.5 && orangexVelocity == -1.5) {
							orangeYBulletVelocity[i] = 2.12;
							orangeXBulletVelocity[i] = -2.12;
						} else if (orangexVelocity == -2) {
							orangeYBulletVelocity[i] = 0;
							orangeXBulletVelocity[i] = -3;
						} else if (orangeyVelocity == -1.5 && orangexVelocity == -1.5) {
							orangeYBulletVelocity[i] = -2.21;
							orangeXBulletVelocity[i] = -2.21;
						}
						j = true;
					}
					i++;

				}

			}

			break;

		}

		// movement for blueShip
		switch (e.getKeyCode()) {
		case 38: // up key
			// start ship
			if (bluexVelocity == 0 && blueyVelocity == 0) {
				blueUp();
				blueShip = new ImageIcon(" src\\images\\ship_blue.png").getImage();

			}
			// if ship is going right and up key is pressed, make ship go 45
			else if (bluexVelocity == 2) {
				blueFortyFive();
				blueShip = new ImageIcon("src\\images\\ship_blue_45.png").getImage();
			}

			// if ship is going 45 and up key is pressed, make ship go up
			else if (blueyVelocity == -1.5 && bluexVelocity == 1.5) {
				blueUp();
				blueShip = new ImageIcon("src\\images\\ship_blue.png").getImage();
			}
			// if ship is going down and key is pressed, make ship go up
			else if (blueyVelocity == 2) {
				blueUp();
				blueShip = new ImageIcon("src\\images\\ship_blue.png").getImage();
			}
			// if ship is going left and up key is pressed, make ship go 315
			else if (bluexVelocity == -2) {
				blueThreeFifteen();
				blueShip = new ImageIcon("src\\images\\ship_blue_315.png").getImage();
			}
			// if ship is going 315 degrees and up key is pressed, make ship go up
			else if (blueyVelocity == -1.5 && bluexVelocity == -1.5) {
				blueUp();
				blueShip = new ImageIcon("src\\images\\ship_blue.png").getImage();
			}

			break;
		case 40: // down key
			// starting ship
			if (blueyVelocity == 0 && bluexVelocity == 0) {
				blueDown();
				blueShip = new ImageIcon("src\\images\\ship_blue_180.png").getImage();
			}
			// if ship is going up and down key is pressed
			else if (blueyVelocity == -2) {
				blueDown();
				blueShip = new ImageIcon("src\\images\\ship_blue_180.png").getImage();
			}
			// if ship is going right and down key is pressed, make ship go 135 degrees
			else if (bluexVelocity == 2) {
				blueOneThirtyFive();
				blueShip = new ImageIcon("src\\images\\ship_blue_135.png").getImage();
			}
			// if ship is going 135 and down key is pressed, make ship go down
			else if (blueyVelocity == 1.5 && bluexVelocity == 1.5) {
				blueDown();
				blueShip = new ImageIcon("src\\images\\ship_blue_180.png").getImage();
			}
			// if ship is going left and down key is pressed, make ship go 225 degrees
			else if (bluexVelocity == -2) {
				blueTwoTwentyFive();
				blueShip = new ImageIcon("src\\images\\ship_blue_225.png").getImage();
			}
			// if ship is going 225 degrees and down key is pressed, make ship go down
			else if (blueyVelocity == 1.5 && bluexVelocity == -1.5) {
				blueDown();
				blueShip = new ImageIcon("src\\images\\ship_blue_180.png").getImage();
			}

			break;
		case 39:// right key
			// start ship
			if (blueyVelocity == 0 && bluexVelocity == 0) {
				blueRight();
				blueShip = new ImageIcon("src\\images\\ship_blue_90.png").getImage();
			}

			else if (blueyVelocity == -2) {// if ship is going up and "right key" is pressed, make ship
				// go 45 degrees (REFERENCE POINT IS THE UP DIRECTION)
				blueFortyFive();
				blueShip = new ImageIcon("src\\images\\ship_blue_45.png").getImage();

			}
			// if ship is going 45 degrees and "right key" is pressed,
			// make ship go right (90 degrees)
			else if (blueyVelocity == -1.5 && bluexVelocity == 1.5) {
				blueRight();
				blueShip = new ImageIcon("src\\images\\ship_blue_90.png").getImage();
			}
			// if ship is going down and right key is pressed, make ship go 135
			else if (blueyVelocity == 2) {
				blueOneThirtyFive();
				blueShip = new ImageIcon("src\\images\\ship_blue_135.png").getImage();
			}
			// if ship is going 135 degrees and right key is pressed, make ship go right
			else if (blueyVelocity == 1.5 && bluexVelocity == 1.5) {
				blueRight();
				blueShip = new ImageIcon("src\\images\\ship_blue_90.png").getImage();
			}
			break;

		case 37:// left key
			// start ship
			if (blueyVelocity == 0 && bluexVelocity == 0) {
				blueLeft();
				blueShip = new ImageIcon("src\\images\\ship_blue_270.png").getImage();
			}

			// if ship is going up and left key is pressed, make ship go 315 degrees
			// NOTE: Up direction is reference point, meaning this position is 315 degrees
			// Clockwise from up
			else if (blueyVelocity == -2) {
				blueThreeFifteen();
				blueShip = new ImageIcon("src\\images\\ship_blue_315.png").getImage();
			}
			// if ship is going 315 degrees and left key is pressed, make ship go left
			else if (blueyVelocity == -1.5 && bluexVelocity == -1.5) {
				blueLeft();
				blueShip = new ImageIcon("src\\images\\ship_blue_270.png").getImage();
			}
			// if ship is going down and left key is pressed make ship go 225
			else if (blueyVelocity == 2) {
				blueTwoTwentyFive();
				blueShip = new ImageIcon("src\\images\\ship_blue_225.png").getImage();
			}
			// if ship is going 225 and left key is pressed, make ship go left
			else if (blueyVelocity == 1.5 && bluexVelocity == -1.5) {
				blueLeft();
				blueShip = new ImageIcon("src\\images\\ship_blue_270.png").getImage();
			}
			break;

		case 17: // ctrl key

			// if fist bullet is not shot yet, then shoot the first bullet
			if (isBlueBulletShot[0] == false) {
				isBlueBulletShot[0] = true;
				if (blueyVelocity == -2) {
					blueYBulletVelocity[0] = -3;
					blueXBulletVelocity[0] = 0;
				} else if (blueyVelocity == -1.5 && bluexVelocity == 1.5) {
					blueYBulletVelocity[0] = -2.12;
					blueXBulletVelocity[0] = 2.12;
				} else if (bluexVelocity == 2) {
					blueYBulletVelocity[0] = 0;
					blueXBulletVelocity[0] = 3;
				} else if (blueyVelocity == 1.5 && bluexVelocity == 1.5) {
					blueYBulletVelocity[0] = 2.12;
					blueXBulletVelocity[0] = 2.12;
				} else if (blueyVelocity == 2) {
					blueYBulletVelocity[0] = 3;
					blueXBulletVelocity[0] = 0;
				} else if (blueyVelocity == 1.5 && bluexVelocity == -1.5) {
					blueYBulletVelocity[0] = 2.12;
					blueXBulletVelocity[0] = -2.12;
				} else if (bluexVelocity == -2) {
					blueYBulletVelocity[0] = 0;
					blueXBulletVelocity[0] = -3;
				} else if (blueyVelocity == -1.5 && bluexVelocity == -1.5) {
					blueYBulletVelocity[0] = -2.21;
					blueXBulletVelocity[0] = -2.21;
				}

				// else if the first bullet was shot, run a couple if statements that say:
				// in a counter, if i - 1 is already shot, then shoot i, otherwise increase i
				// counter
			} else {
				int i = 1;
				boolean j = false;
				while (j == false & i < MAX_BULLETS) {

					if (isBlueBulletShot[i - 1] == true && isBlueBulletShot[i] == false) {

						isBlueBulletShot[i] = true;
						if (blueyVelocity == -2) {
							blueYBulletVelocity[i] = -3;
							blueXBulletVelocity[i] = 0;
						} else if (blueyVelocity == -1.5 && bluexVelocity == 1.5) {
							blueYBulletVelocity[i] = -2.12;
							blueXBulletVelocity[i] = 2.12;
						} else if (bluexVelocity == 2) {
							blueYBulletVelocity[i] = 0;
							blueXBulletVelocity[i] = 3;
						} else if (blueyVelocity == 1.5 && bluexVelocity == 1.5) {
							blueYBulletVelocity[i] = 2.12;
							blueXBulletVelocity[i] = 2.12;
						} else if (blueyVelocity == 2) {
							blueYBulletVelocity[i] = 3;
							blueXBulletVelocity[i] = 0;
						} else if (blueyVelocity == 1.5 && bluexVelocity == -1.5) {
							blueYBulletVelocity[i] = 2.12;
							blueXBulletVelocity[i] = -2.12;
						} else if (bluexVelocity == -2) {
							blueYBulletVelocity[i] = 0;
							blueXBulletVelocity[i] = -3;
						} else if (blueyVelocity == -1.5 && bluexVelocity == -1.5) {
							blueYBulletVelocity[i] = -2.21;
							blueXBulletVelocity[i] = -2.21;
						}
						j = true;
					}
					i++;

				}

			}

			break;

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// repaint window every FRAME
		repaint();

		// create instance for audio
		File file = new File("src\\images\\thud_sound.wav");

		AudioInputStream audioStream = null;
		try {
			audioStream = AudioSystem.getAudioInputStream(file);
		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Clip clip = null;
		try {
			clip = AudioSystem.getClip();
		} catch (LineUnavailableException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			clip.open(audioStream);
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// constantly add velocity to blue ship and orange ship
		blueX += bluexVelocity;
		blueY += blueyVelocity;

		orangeX += orangexVelocity;
		orangeY += orangeyVelocity;

		// if blue bullet is shot, make it follow its own velocity, if not, make it
		// follow the ship
		// (you will notice this makes the bullet x and y always under the ship)
		for (int i = 0; i < MAX_BULLETS; i++) {
			if (isBlueBulletShot[i] == true) {
				blueXBullet[i] += blueXBulletVelocity[i];
				blueYBullet[i] += blueYBulletVelocity[i];
			} else if (isBlueBulletShot[i] == false) {
				blueXBullet[i] = blueX + 13;
				blueYBullet[i] = blueY + 10;
			}
		}

		// if orange bullet is shot, make it follow its own velocity, if not, make it
		// follow the ship
		for (int i = 0; i < MAX_BULLETS; i++) {
			if (isOrangeBulletShot[i] == true) {
				orangeXBullet[i] += orangeXBulletVelocity[i];
				orangeYBullet[i] += orangeYBulletVelocity[i];
			} else if (isOrangeBulletShot[i] == false) {
				orangeXBullet[i] = orangeX + 13;
				orangeYBullet[i] = orangeY + 10;
			}
		}

		// counts down timer for all bullets simeoutaneously
		for (int i = 0; i < MAX_BULLETS; i++) {
			if (isBlueBulletShot[i] == true) {
				blueBulletTimers[i]--;
				if (blueBulletTimers[i] <= 0) {
					isBlueBulletShot[i] = false;
					blueBulletTimers[i] = 400;
				}
			}

			if (isOrangeBulletShot[i] == true) {
				orangeBulletTimers[i]--;
				if (orangeBulletTimers[i] == 0) {
					isOrangeBulletShot[i] = false;
					orangeBulletTimers[i] = 400;
				}
			}

		}

		// check if orange bullet is colliding with Blue Ship
		for (int i = 0; i < MAX_BULLETS; i++) {
			isBlueShipCollision = isCollision(blueX, (int) orangeXBullet[i], blueY, (int) orangeYBullet[i]);
			if (isBlueShipCollision == true && isOrangeBulletShot[i] == true) {
				blueX = (int) (Math.random() * 470 + 20);
				blueY = (int) (Math.random() * 470 + 20);
				isOrangeBulletShot[i] = false;
				// increase score if collision happens
				orangePlayerScore++;
				clip.start();// play audio clip
			}
		}

		// check if blue bullet is colliding with Orange Ship
		for (int i = 0; i < MAX_BULLETS; i++) {
			isOrangeShipCollision = isCollision(orangeX, (int) blueXBullet[i], orangeY, (int) blueYBullet[i]);
			if (isOrangeShipCollision == true && isBlueBulletShot[i] == true) {
				orangeX = (int) (Math.random() * 470 + 20);
				orangeY = (int) (Math.random() * 470 + 20);
				isBlueBulletShot[i] = false;
				// increase score if collision happens
				bluePlayerScore++;
				// play dramatic thud sound if collision occurs
				clip.start();// play audio clip
			}
		}

		// game timer
		if (!gameOver) {
			gameTimer--;
		}

		// When game ends, swicth screens to orignal menu
		if (gameTimer <= 0) {
			gameOver = true;
			// display blue player won
			if (bluePlayerScore > orangePlayerScore) {
				blueWon = true;
				// display orange player won
			} else if (orangePlayerScore > bluePlayerScore) {
				orangeWon = true;
				// display a tie
			} else if (orangePlayerScore == bluePlayerScore) {
				orangeWon = true;
				blueWon = true;
			}
		}

		String blueWindowPosition = isOnWindow(blueX, blueY);
		String orangeWindowPosition = isOnWindow(orangeX, orangeY);
		String blueBulletPosition, orangeBulletPosition;

		// check if blue ship is on window or if a teleportation needs to occur
		if (blueWindowPosition == "goneUpSide") {
			blueY = PANEL_HEIGHT;
			if (blueX < 150) {
				blueX = 700;
			} else if (blueX > 650) {
				blueX = 100;
			}
		} else if (blueWindowPosition == "goneDownSide") {
			blueY = 0;
			if (blueX < 150) {
				blueX = 700;
			} else if (blueX > 650) {
				blueX = 100;
			}
		} else if (blueWindowPosition == "goneLeftSide") {
			blueX = PANEL_WIDTH;
			if (blueY < 150) {
				blueY = 700;
			} else if (blueY > 650) {
				blueY = 100;
			}
		} else if (blueWindowPosition == "goneRightSide") {
			blueX = 0;
			if (blueY < 150) {
				blueY = 700;
			} else if (blueY > 650) {
				blueY = 100;
			}
		}

		// check if orange ship is on window or if a teleportation needs to occur
		if (orangeWindowPosition == "goneUpSide") {
			orangeY = PANEL_HEIGHT;
			if (orangeX < 150) {
				orangeX = 700;
			} else if (orangeX > 650) {
				orangeX = 100;
			}
		} else if (orangeWindowPosition == "goneDownSide") {
			orangeY = 0;
			if (orangeX < 150) {
				orangeX = 700;
			} else if (orangeX > 650) {
				orangeX = 100;
			}
		} else if (orangeWindowPosition == "goneLeftSide") {
			orangeX = PANEL_WIDTH;
			if (orangeY < 150) {
				orangeY = 700;
			} else if (orangeY > 650) {
				orangeY = 100;
			}
		} else if (orangeWindowPosition == "goneRightSide") {
			orangeX = 0;
			if (orangeY < 150) {
				orangeY = 700;
			} else if (orangeY > 650) {
				orangeY = 100;
			}
		}

		// check if blue bullet is on window or if a teleportation needs to occur
		for (int i = 0; i < MAX_BULLETS; i++) {
			blueBulletPosition = isOnWindow((int) blueXBullet[i], (int) blueYBullet[i]);

			if (blueBulletPosition == "goneUpSide") {
				blueYBullet[i] = PANEL_HEIGHT;
				if (blueXBullet[i] < 150) {
					blueXBullet[i] = 700;
				} else if (blueXBullet[i] > 650) {
					blueXBullet[i] = 100;
				}
			} else if (blueBulletPosition == "goneDownSide") {
				blueYBullet[i] = 0;
				if (blueXBullet[i] < 150) {
					blueXBullet[i] = 700;
				} else if (blueXBullet[i] > 650) {
					blueXBullet[i] = 100;
				}
			} else if (blueBulletPosition == "goneLeftSide") {
				blueXBullet[i] = PANEL_WIDTH;
				if (blueYBullet[i] < 150) {
					blueYBullet[i] = 700;
				} else if (blueYBullet[i] > 650) {
					blueYBullet[i] = 100;
				}
			} else if (blueBulletPosition == "goneRightSide") {
				blueXBullet[i] = 0;
				if (blueYBullet[i] < 150) {
					blueYBullet[i] = 700;
				} else if (blueYBullet[i] > 650) {
					blueYBullet[i] = 100;
				}
			}
		}

		// check if orange bullets are on window or if a teleportation needs to occur
		for (int i = 0; i < MAX_BULLETS; i++) {

			orangeBulletPosition = isOnWindow((int) orangeXBullet[i], (int) orangeYBullet[i]);
			if (orangeBulletPosition == "goneUpSide") {
				orangeYBullet[i] = PANEL_HEIGHT;
				if (orangeXBullet[i] < 150) {
					orangeXBullet[i] = 700;
				} else if (orangeXBullet[i] > 650) {
					orangeXBullet[i] = 100;
				}
			} else if (orangeBulletPosition == "goneDownSide") {
				orangeYBullet[i] = 0;
				if (orangeXBullet[i] < 150) {
					orangeXBullet[i] = 700;
				} else if (orangeXBullet[i] > 650) {
					orangeXBullet[i] = 100;
				}
			} else if (orangeBulletPosition == "goneLeftSide") {
				orangeXBullet[i] = PANEL_WIDTH;
				if (orangeYBullet[i] < 150) {
					orangeYBullet[i] = 700;
				} else if (orangeYBullet[i] > 650) {
					orangeYBullet[i] = 100;
				}
			} else if (orangeBulletPosition == "goneRightSide") {
				orangeXBullet[i] = 0;
				if (blueYBullet[i] < 150) {
					blueYBullet[i] = 700;
				} else if (blueYBullet[i] > 650) {
					blueYBullet[i] = 100;
				}
			}
		}

	}

	// a bunch of movement methods
	public void blueUp() {
		blueyVelocity = -2;
		bluexVelocity = 0;

	}

	public void blueFortyFive() {
		blueyVelocity = -1.5;
		bluexVelocity = 1.5;
	}

	public void blueRight() {
		blueyVelocity = 0;
		bluexVelocity = 2;
	}

	public void blueOneThirtyFive() {
		blueyVelocity = 1.5;
		bluexVelocity = 1.5;
	}

	public void blueDown() {
		blueyVelocity = 2;
		bluexVelocity = 0;
	}

	public void blueTwoTwentyFive() {
		blueyVelocity = 1.5;
		bluexVelocity = -1.5;
	}

	public void blueLeft() {
		blueyVelocity = 0;
		bluexVelocity = -2;
	}

	public void blueThreeFifteen() {
		blueyVelocity = -1.5;
		bluexVelocity = -1.5;
	}

//movement methods for orange ship
	public void orangeUp() {
		orangeyVelocity = -2;
		orangexVelocity = 0;
	}

	public void orangeFortyFive() {
		orangeyVelocity = -1.5;
		orangexVelocity = 1.5;
	}

	public void orangeRight() {
		orangeyVelocity = 0;
		orangexVelocity = 2;
	}

	public void orangeOneThirtyFive() {
		orangeyVelocity = 1.5;
		orangexVelocity = 1.5;
	}

	public void orangeDown() {
		orangeyVelocity = 2;
		orangexVelocity = 0;
	}

	public void orangeTwoTwentyFive() {
		orangeyVelocity = 1.5;
		orangexVelocity = -1.5;
	}

	public void orangeLeft() {
		orangeyVelocity = 0;
		orangexVelocity = -2;
	}

	public void orangeThreeFifteen() {
		orangeyVelocity = -1.5;
		orangexVelocity = -1.5;
	}

	// method that sends a string back depending on if the ship is on or off the
	// window
	public static String isOnWindow(int x, int y) {

		if (0 < x && x < PANEL_WIDTH & y < 0) {
			return "goneUpSide";
		} else if (0 < x && x < PANEL_WIDTH & y > PANEL_HEIGHT) {
			return "goneDownSide";
		} else if (0 < y && y < PANEL_HEIGHT && x < 0) {
			return "goneLeftSide";
		} else if (0 < y && y < PANEL_HEIGHT && x > PANEL_WIDTH) {
			return "goneRightSide";
		} else
			return "isOnWindow";
	}

	// collision method that uses distance formula to calculate if the bullet and
	// ship is colliding
	public static boolean isCollision(int x1, int x2, int y1, int y2) {
		double d, p;
		p = (Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
		d = Math.sqrt(p);

		if (y2 < y1 || x2 < x1) {
			if (d <= 5) {
				return true;
			} else {
				return false;
			}

		} else if (y2 >= y1 || x2 >= x1) {
			if (d <= 32) {
				return true;
			} else {
				return false;
			}

		}

		else {
			return false;
		}

	}

	// mouse events (implemented methods for Mouse)
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		switch (e.getButton()) {
		case 1:
			int x = e.getX();
			int y = e.getY();

			// if you click play button, start game
			if (gameOver == true && 70 < x && x < 670 && 400 < y && y < 600) {
				gameOver = false;

				// reset variables
				blueX = (int) (Math.random() * 470 + 20);
				blueY = (int) (Math.random() * 470 + 20);

				orangeX = (int) (Math.random() * 470 + 20);
				orangeY = (int) (Math.random() * 470 + 20);

				gameTimer = 4000;
				bluePlayerScore = 0;
				orangePlayerScore = 0;
				bluexVelocity = 0;
				blueyVelocity = 0;

				orangexVelocity = 0;
				orangeyVelocity = 0;
				orangeWon = false;
				blueWon = false;

				for (int i = 0; i < MAX_BULLETS; i++) {
					blueBulletTimers[i] = 400;
					orangeBulletTimers[i] = 400;

					blueXBullet[i] = blueX + 13;
					blueYBullet[i] = blueY + 10;
					orangeXBullet[i] = orangeX + 13;
					orangeYBullet[i] = orangeY + 10;

					blueXBulletVelocity[i] = 0;
					blueYBulletVelocity[i] = 0;
					orangeXBulletVelocity[i] = 0;
					orangeYBulletVelocity[i] = 0;

					isBlueBulletShot[i] = false;
					isOrangeBulletShot[i] = false;
				}

			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
