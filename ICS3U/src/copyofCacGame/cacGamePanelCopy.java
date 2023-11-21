package CitricAcidCycleGame;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import in_out.Out;


public class cacGamePanel extends JPanel implements KeyListener, ActionListener, ImageObserver, MouseListener {

	final int PANEL_WIDTH = 1200;
	final int PANEL_HEIGHT = 700;
	
	//records how many wrong answers you got
	int wrongAnswer = 0;
	
	//are we on a end game question?
	boolean question1 = false;
	boolean question2 = false;
	boolean question3 = false;
	boolean question4 = false;
	boolean question5 = false;
	boolean question6 = false;
	
	boolean gameOver = false;
	
	//is pyruvate oxidation diagram showing?
	boolean pyruvateShowing = true;
	
	//is citric acid cycle diagram showing?
	boolean cacShowing = true;
	
	//final continue button
	boolean menuContinueShown = false;
	
	//has the buttons been clicked
	boolean acetylCoAClicked[] = {false, false, false, false, false, false};
	boolean citrateClicked[] = {false, false, false, false, false, false};
	boolean isocitrateClicked[] = {false, false, false, false, false, false};
	boolean NADplus1Clicked[] = {false, false, false, false};
	boolean NADH1Clicked[] = {false, false, false, false, false};
	boolean co2Clicked[] = {false, false, false, false};
	boolean aketoglutarateClicked[] = {false, false, false, false, false, false};
	boolean succinylcoaClicked[] = {false, false, false, false, false, false};
	boolean gtpClicked[] = {false, false, false, false, false};
	boolean atpClicked[] = {false, false, false, false, false};
	boolean succinateClicked[] = {false, false, false, false, false, false};
	boolean fadClicked[] = {false, false, false, false};
	boolean fadh2Clicked[] = {false, false, false, false, false};
	boolean fumarateClicked[] = {false, false, false, false, false, false};
	boolean NADplus2Clicked[] = {false, false, false, false};
	boolean NADH2Clicked[] = {false, false, false, false, false};
	boolean malateClicked[] = {false, false, false, false, false, false};
	boolean NADplus3Clicked[] = {false, false, false, false};
	boolean NADH3Clicked[] = {false, false, false, false, false};
	boolean oxaloacetateClicked[] = {false, false, false, false, false, false};
	boolean pyruvateClicked[] = {false, false, false, false, false, false};
	boolean pco2Clicked[] = {false, false, false, false};
	boolean coenzymeClicked[] = {false, false, false, false};
	boolean NADplusPClicked[] = {false, false, false, false};
	boolean NADHPClicked[] = {false, false, false, false, false};
	boolean acetylCoAPClicked[] = {false, false, false, false, false, false};
	
	boolean question1Clicked[] = {false, false, false, false, false, false};
	boolean question2Clicked[] = {false, false, false, false, false, false};
	boolean question3Clicked[] = {false, false, false, false, false, false};
	boolean question4Clicked[] = {false, false, false, false, false, false};
	boolean question5Clicked[] = {false, false, false, false, false, false};
	boolean question6Clicked[] = {false, false, false, false, false, false};
	
	boolean menuContinueClicked = true;
	

	
	
	//has the user completed acetylCoA
	boolean acetylCoACompletion = false;
	boolean citrateCompletion = false;
	boolean isocitrateCompletion = false;
	boolean NADplus1Completion = false;
	boolean NADH1Completion = false;
	boolean co2Completion = false;
	boolean aketoglutarateCompletion = false;
	boolean succinylcoaCompletion = false;
	boolean gtpCompletion = false;
	boolean atpCompletion = false;
	boolean succinateCompletion = false;
	boolean fadCompletion = false;
	boolean fadh2Completion = false;
	boolean fumarateCompletion = false;
	boolean NADplus2Completion = false;
	boolean NADH2Completion = false;
	boolean malateCompletion = false;
	boolean NADplus3Completion = false;
	boolean NADH3Completion = false;
	boolean oxaloacetateCompletion = false;
	boolean pyruvateCompletion = false;
	boolean pco2Completion = false;
	boolean coenzymeCompletion = false;
	boolean NADplusPCompletion = false;
	boolean NADHPCompletion = false;
	boolean acetylCoAPCompletion = false;
	boolean question1Completion = false;
	boolean question2Completion = false;
	boolean question3Completion = false;
	boolean question4Completion = false;
	boolean question5Completion = false;
	boolean question6Completion = false;
	
	//colours of buttons in molecules (0 represents grey, 1 represents red (or green for correct option)
	int acetylCoAColour[] = {0,0,0,0,0};
	int citrateColour[] = {0,0,0,0,0};
	int isocitrateColour[] = {0,0,0,0,0};
	int NADplus1Colour[] = {0,0,0};
	int NADH1Colour[] = {0,0,0,0};
	int co2Colour[] = {0,0,0};
	int aketoglutarateColour[] = {0,0,0,0,0};
	int succinylcoaColour[] = {0,0,0,0,0};
	int gtpColour[] = {0,0,0,0};
	int atpColour[] = {0,0,0,0};
	int succinateColour[] = {0,0,0,0,0};
	int fadColour[] = {0,0,0};
	int fadh2Colour[] = {0,0,0,0};
	int fumarateColour[] = {0,0,0,0,0};
	int NADplus2Colour[] = {0,0,0};
	int NADH2Colour[] = {0,0,0,0};
	int malateColour[] = {0,0,0,0,0};
	int NADplus3Colour[] = {0,0,0};
	int NADH3Colour[] = {0,0,0,0};
	int oxaloacetateColour[] = {0,0,0,0,0};
	int pyruvateColour[] = {0,0,0,0,0};
	int pco2Colour[] = {0,0,0};
	int coenzymeColour[] = {0,0,0};
	int NADplusPColour[] = {0,0,0};
	int NADHPColour[] = {0,0,0,0};
	int acetylCoAPColour[] = {0,0,0,0,0};
	int question1Colour[] = {0,0,0,0,0};
	int question2Colour[] = {0,0,0,0,0};
	int question3Colour[] = {0,0,0,0,0};
	int question4Colour[] = {0,0,0,0,0};
	int question5Colour[] = {0,0,0,0,0};
	int question6Colour[] = {0,0,0,0,0};
	
	
	Image citricAcidCyleBlank = new ImageIcon("src\\cacImages\\citricAcidCycleBlank.jpg").getImage();
	Image acetylCoADiagram = new ImageIcon("src\\cacImages\\acetylCoADiagram.jpg").getImage();
	Image redX = new ImageIcon("src\\cacImages\\redX.jpg").getImage();
	Image citrateDiagram = new ImageIcon("src\\cacImages\\citrateDiagram.jpg").getImage();
	Image isocitrateDiagram = new ImageIcon("src\\cacImages\\isocitrateDiagram.jpg").getImage();
	Image nadplus1Diagram = new ImageIcon("src\\cacImages\\nadplus1Diagram.jpg").getImage();
	Image nadh1Diagram = new ImageIcon("src\\cacImages\\nadh1Diagram.jpg").getImage();
	Image aketoglutarateDiagram = new ImageIcon("src\\cacImages\\aketoglutarateDiagram.jpg").getImage();
	Image succinylcoaDiagram = new ImageIcon("src\\cacImages\\succinylcoaDiagram.jpg").getImage();
	Image co2Diagram = new ImageIcon("src\\cacImages\\co2Diagram.jpg").getImage();
	Image gtpDiagram = new ImageIcon("src\\cacImages\\gtpDiagram.jpg").getImage();
	Image atpDiagram = new ImageIcon("src\\cacImages\\atpDiagram.jpg").getImage();
	Image succinateDiagram = new ImageIcon("src\\cacImages\\succinateDiagram.jpg").getImage();
	Image fadDiagram = new ImageIcon("src\\cacImages\\fadDiagram.jpg").getImage();
	Image fadh2Diagram = new ImageIcon("src\\cacImages\\fadh2Diagram.jpg").getImage();
	Image fumarateDiagram = new ImageIcon("src\\cacImages\\fumarateDiagram.jpg").getImage();
	Image nadplus2Diagram = new ImageIcon("src\\cacImages\\nadplus2Diagram.jpg").getImage();
	Image nadh2Diagram = new ImageIcon("src\\cacImages\\nadh2Diagram.jpg").getImage();
	Image malateDiagram = new ImageIcon("src\\cacImages\\malateDiagram.jpg").getImage();
	Image nadplus3Diagram = new ImageIcon("src\\cacImages\\nadplus3Diagram.jpg").getImage();
	Image nadh3Diagram = new ImageIcon("src\\cacImages\\nadh3Diagram.jpg").getImage();
	Image oxaloacetateDiagram = new ImageIcon("src\\cacImages\\oxaloacetateDiagram.jpg").getImage();
	
	
	//pyruvate oxidation images
	Image pyruvateOxidationBlankDiagram = new ImageIcon("src\\cacImages\\pyruvateOxidationBlankDiagram.jpg").getImage();
	Image pyruvateDiagram = new ImageIcon("src\\cacImages\\pyruvateDiagram.jpg").getImage();
	Image pco2Diagram = new ImageIcon("src\\cacImages\\pco2Diagram.jpg").getImage();
	Image coenzymeDiagram = new ImageIcon("src\\cacImages\\coenzymeDiagram.jpg").getImage();
	Image nadplusPDiagram = new ImageIcon("src\\cacImages\\nadplusPDiagram.jpg").getImage();
	Image nadhPDiagram = new ImageIcon("src\\cacImages\\nadhPDiagram.jpg").getImage();
	Image acetylCoAPDiagram = new ImageIcon("src\\cacImages\\acetylCoAPDiagram.jpg").getImage();
	Image x2p = new ImageIcon("src\\cacImages\\x2p.png").getImage();
	Image x2cac = new ImageIcon("src\\cacImages\\x2cac.png").getImage();
	
	//set initial screen to menu
	String screenSetting = "menu";
	
	cacGamePanel() {
		
		Timer timer = new Timer(5, this); //this makes frame update every 5 miliseconds, KEEP THIS SO GRAPHICS CAN CHANGE, this has nothing to do with an ingame timer, its your fps
		timer.start();
		
		
		
		

		this.addKeyListener(this);
		this.addMouseListener(this);
		setFocusable(true);
		// setFocusTraversalKeysEnabled(false);

		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setLayout(null);
		this.setBackground(Color.white);
		
		

	}
	
	public void paint(Graphics g) {
		
		super.paint(g); // paint background

		Graphics2D g2D = (Graphics2D) g;
		
		//title on top
		
		if (screenSetting == "menu") {
			g.setFont(new Font("Helvetica", Font.PLAIN, 40));
			g.setColor(Color.lightGray);
			g2D.fillRect(57, 190, 335, 55);
			g.setColor(Color.black);
			g2D.drawRect(57, 190, 335, 55);
			g.setColor(Color.blue.darker());
			g2D.drawString("Pyruvate Oxidation", 60, 226);
			g.setColor(Color.lightGray);
			g2D.fillRect(673, 16, 307, 52);
			g.setColor(Color.black);
			g2D.drawRect(673, 16, 307, 52);
			g.setColor(Color.yellow);
			g2D.drawString("Citric Acid Cycle", 684, 56);
			//draw seperator line
			g.setColor(Color.black);
			g2D.fillRect(421, 0, 5, PANEL_HEIGHT);
			
			// draw citric acid cycle (blank)
			g2D.drawImage(citricAcidCyleBlank, 500, 100, null);
			
			//draw pyruvate oxidation cycle (blank)
			g2D.drawImage(pyruvateOxidationBlankDiagram, 20, 378, null);
			
			//draw x2 for pyruvate
			g2D.drawImage(x2p, 172, 590, null);
			
			//draw x2 for cac
			g2D.drawImage(x2cac, 728, 280, null);
			
		}
		
		else if (screenSetting == "acetylCoA") {
			
			g.setFont(new Font("Helvetica", Font.PLAIN, 50));
			g.setColor(Color.red.darker());
			g2D.drawString("What Molecule is this?", 40, 75);
			g2D.drawImage(acetylCoADiagram, 500, 100, null);
			
			
			
			g.setFont(new Font("Helvetica", Font.PLAIN, 30));
			
			//draw options for answers
			if (acetylCoAColour[0] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (acetylCoAColour[0] == 1) {
				g.setColor(Color.red.brighter());
			}
			
			g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
			g.setColor(Color.black);
			g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
			
			g2D.drawString("Succinate", 125, 190);
			
			if (acetylCoAColour[1] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (acetylCoAColour[1] == 1) {
				g.setColor(Color.red.brighter());
			}
			
			
			g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
			g.setColor(Color.black);
			g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
			
			g2D.drawString("Fumarase", 125, 290);
			
			if (acetylCoAColour[2] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (acetylCoAColour[2] == 1) {
				g.setColor(Color.green.brighter());
			}
			g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
			g.setColor(Color.black);
			g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
			
			
			g2D.drawString("Acetyl-CoA", 125, 390);//correct answer
			
			
			if (acetylCoAColour[3] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (acetylCoAColour[3] == 1) {
				g.setColor(Color.red.brighter());
			}
			g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fourth rect
			g.setColor(Color.black);
			g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fourth rect
			
			g2D.drawString("NADH", 125, 490);
			
			if (acetylCoAColour[4] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (acetylCoAColour[4] == 1) {
				g.setColor(Color.red.brighter());
			}
			g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 416, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fifth rect
			g.setColor(Color.black);
			g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 416, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fifth rect
			
			g2D.drawString("Glucose", 125, 590);
			
			if (acetylCoACompletion == true) {
				g.setColor(Color.cyan);
				g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
				g.setColor(Color.black);
				g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
				//write "continue"
				g.setFont(new Font("Helvetica", Font.PLAIN, 30));
				g.drawString("Continue",500,650);
			}
			
			
			
			
			
			
			
			//JTextField textField = new JTextField(10);
			//textField.setBounds(100,100,100,100);
			//this.add(textField);
			
			
		
			
		}
		
		else if (screenSetting == "citrate") {
			g.setFont(new Font("Helvetica", Font.PLAIN, 50));
			g.setColor(Color.red.darker());
			g2D.drawString("What Molecule is this?", 40, 75);
			g2D.drawImage(citrateDiagram, 500, 100, null);
			
			g.setFont(new Font("Helvetica", Font.PLAIN, 30));
			
			if (citrateColour[0] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (citrateColour[0] == 1) {
				g.setColor(Color.red.brighter());
			}
			
			g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
			g.setColor(Color.black);
			g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
			
			g2D.drawString("Malate", 125, 190);
			
			if (citrateColour[1] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (citrateColour[1] == 1) {
				g.setColor(Color.red.brighter());
			}
			
			
			g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
			g.setColor(Color.black);
			g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
			
			g2D.drawString("FAD", 125, 290);
			
			if (citrateColour[2] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (citrateColour[2] == 1) {
				g.setColor(Color.red.brighter());
			}
			g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
			g.setColor(Color.black);
			g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
			
			
			g2D.drawString("Oxaloacetate", 125, 390);
			
			
			if (citrateColour[3] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (citrateColour[3] == 1) {
				g.setColor(Color.red.brighter());
			}
			g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fourth rect
			g.setColor(Color.black);
			g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fourth rect
			
			g2D.drawString("Isocitrate", 125, 490);
			
			if (citrateColour[4] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (citrateColour[4] == 1) {
				g.setColor(Color.green.brighter());
			}
			g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 416, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fifth rect
			g.setColor(Color.black);
			g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 416, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fifth rect
			
			g2D.drawString("Citrate", 125, 590);//correct answer
			
			if (citrateCompletion == true) {
				g.setColor(Color.cyan);
				g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
				g.setColor(Color.black);
				g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
				//write "continue"
				g.setFont(new Font("Helvetica", Font.PLAIN, 30));
				g.drawString("Continue",500,650);
			}
			
			
		}
		
		else if (screenSetting == "isocitrate") {
			g.setFont(new Font("Helvetica", Font.PLAIN, 50));
			g.setColor(Color.red.darker());
			g2D.drawString("What Molecule is this?", 40, 75);
			g2D.drawImage(isocitrateDiagram, 500, 100, null);
			
			g.setFont(new Font("Helvetica", Font.PLAIN, 30));
			
			if (isocitrateColour[0] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (isocitrateColour[0] == 1) {
				g.setColor(Color.green.brighter());
			}
			
			g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
			g.setColor(Color.black);
			g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
			
			g2D.drawString("Isocitrate", 125, 190);//correct answer
			
			if (isocitrateColour[1] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (isocitrateColour[1] == 1) {
				g.setColor(Color.red.brighter());
			}
			
			
			g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
			g.setColor(Color.black);
			g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
			
			g2D.drawString("ATP", 125, 290);
			
			if (isocitrateColour[2] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (isocitrateColour[2] == 1) {
				g.setColor(Color.red.brighter());
			}
			g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
			g.setColor(Color.black);
			g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
			
			
			g2D.drawString("Succinyl-CoA", 125, 390);
			
			
			if (isocitrateColour[3] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (isocitrateColour[3] == 1) {
				g.setColor(Color.red.brighter());
			}
			g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fourth rect
			g.setColor(Color.black);
			g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fourth rect
			
			g2D.drawString("Pyruvate", 125, 490);
			
			if (isocitrateColour[4] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (isocitrateColour[4] == 1) {
				g.setColor(Color.red.brighter());
			}
			g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 416, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fifth rect
			g.setColor(Color.black);
			g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 416, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fifth rect
			
			g2D.drawString("a-ketoglutarate", 125, 590);
			
			if (isocitrateCompletion == true) {
				g.setColor(Color.cyan);
				g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
				g.setColor(Color.black);
				g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
				//write "continue"
				g.setFont(new Font("Helvetica", Font.PLAIN, 30));
				g.drawString("Continue",500,650);
			}
			
		}
		
		//first NAD+ screen
		else if (screenSetting == "nadplus1") {
			g.setFont(new Font("Helvetica", Font.PLAIN, 50));
			g.setColor(Color.red.darker());
			g2D.drawString("What Molecule is this?", 40, 75);
			g2D.drawImage(nadplus1Diagram, 500, 100, null);
			
			
g.setFont(new Font("Helvetica", Font.PLAIN, 30));
			
			if (NADplus1Colour[0] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (NADplus1Colour[0] == 1) {
				g.setColor(Color.red.brighter());
			}
			
			g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
			g.setColor(Color.black);
			g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
			
			g2D.drawString("FAD", 125, 190);
			
			if (NADplus1Colour[1] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (NADplus1Colour[1] == 1) {
				g.setColor(Color.green.brighter());
			}
			
			
			g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
			g.setColor(Color.black);
			g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
			
			g2D.drawString("NAD⁺", 125, 290);//correct answer
			
			if (NADplus1Colour[2] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (NADplus1Colour[2] == 1) {
				g.setColor(Color.red.brighter());
			}
			g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
			g.setColor(Color.black);
			g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
			
			
			g2D.drawString("GDP", 125, 390);
			
			if (NADplus1Completion == true) {
				g.setColor(Color.cyan);
				g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
				g.setColor(Color.black);
				g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
				//write "continue"
				g.setFont(new Font("Helvetica", Font.PLAIN, 30));
				g.drawString("Continue",500,650);
			}
			
		}
		
		//first NADH + H+ screen
				else if (screenSetting == "nadh1") {
					g.setFont(new Font("Helvetica", Font.PLAIN, 50));
					g.setColor(Color.red.darker());
					g2D.drawString("What Molecule(s) is this?", 40, 75);
					g2D.drawImage(nadh1Diagram, 500, 100, null);
					
					
		g.setFont(new Font("Helvetica", Font.PLAIN, 30));
					
					if (NADH1Colour[0] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (NADH1Colour[0] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
					
					g2D.drawString("GTP and CO₂", 125, 190);
					
					if (NADH1Colour[1] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (NADH1Colour[1] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
					
					g2D.drawString("FADH₂ and CO₂", 125, 290);
					
					if (NADH1Colour[2] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (NADH1Colour[2] == 1) {
						g.setColor(Color.green.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
					
					
					g2D.drawString("NADH + H⁺ + CO₂", 65, 390);//correct answer
					
					
					if (NADH1Colour[3] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (NADH1Colour[3] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fourth rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fourth rect
					
					g2D.drawString("ATP", 125, 490);
					
					if (NADH1Completion == true) {
						g.setColor(Color.cyan);
						g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
						g.setColor(Color.black);
						g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
						//write "continue"
						g.setFont(new Font("Helvetica", Font.PLAIN, 30));
						g.drawString("Continue",500,650);
					}
					
				}
		
		
		
		//draw for a ketoglutarate
				else if (screenSetting == "aketoglutarate") {
					
					g.setFont(new Font("Helvetica", Font.PLAIN, 50));
					g.setColor(Color.red.darker());
					g2D.drawString("What Molecule is this?", 40, 75);
					g2D.drawImage(aketoglutarateDiagram, 500, 100, null);
					
					
					
					g.setFont(new Font("Helvetica", Font.PLAIN, 30));
					
					//draw options for answers
					if (aketoglutarateColour[0] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (aketoglutarateColour[0] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
					
					g2D.drawString("Oxaloacetate", 125, 190);
					
					if (aketoglutarateColour[1] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (aketoglutarateColour[1] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
					
					g2D.drawString("Succinyl-CoA", 125, 290);
					
					if (aketoglutarateColour[2] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (aketoglutarateColour[2] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
					
					
					g2D.drawString("Isocitrate", 125, 390);
					
					
					if (aketoglutarateColour[3] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (aketoglutarateColour[3] == 1) {
						g.setColor(Color.green.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fourth rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fourth rect
					
					g2D.drawString("α-Ketoglutarate", 125, 490);//correct answer
					
					if (aketoglutarateColour[4] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (aketoglutarateColour[4] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 416, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fifth rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 416, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fifth rect
					
					g2D.drawString("Acetyl-CoA", 125, 590);
					
					if (aketoglutarateCompletion == true) {
						g.setColor(Color.cyan);
						g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
						g.setColor(Color.black);
						g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
						//write "continue"
						g.setFont(new Font("Helvetica", Font.PLAIN, 30));
						g.drawString("Continue",500,650);
					}
					
					
				}
		
		//draw for a Succinyl Co A
				else if (screenSetting == "succinylcoa") {
					
					g.setFont(new Font("Helvetica", Font.PLAIN, 50));
					g.setColor(Color.red.darker());
					g2D.drawString("What Molecule is this?", 40, 75);
					g2D.drawImage(succinylcoaDiagram, 500, 100, null);
					
					
					
					g.setFont(new Font("Helvetica", Font.PLAIN, 30));
					
					//draw options for answers
					if (succinylcoaColour[0] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (succinylcoaColour[0] == 1) {
						g.setColor(Color.green.brighter());
					}
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
					
					g2D.drawString("Succinyl-CoA", 125, 190);//correct answer
					
					if (succinylcoaColour[1] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (succinylcoaColour[1] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
					
					g2D.drawString("Isocitrate", 125, 290);
					
					if (succinylcoaColour[2] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (succinylcoaColour[2] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
					
					
					g2D.drawString("α-Ketoglutarate", 125, 390);
					
					
					if (succinylcoaColour[3] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (succinylcoaColour[3] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fourth rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fourth rect
					
					g2D.drawString("Citrate", 125, 490);
					
					if (succinylcoaColour[4] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (succinylcoaColour[4] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 416, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fifth rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 416, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fifth rect
					
					g2D.drawString("Aconitase", 125, 590);
					
					if (succinylcoaCompletion == true) {
						g.setColor(Color.cyan);
						g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
						g.setColor(Color.black);
						g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
						//write "continue"
						g.setFont(new Font("Helvetica", Font.PLAIN, 30));
						g.drawString("Continue",500,650);
					}
					
					
				}
		
		//GDP - GTP
				else if (screenSetting == "gtp") {
					g.setFont(new Font("Helvetica", Font.PLAIN, 50));
					g.setColor(Color.red.darker());
					g2D.drawString("What 2 molecules are these?", 40, 75);
					g2D.drawImage(gtpDiagram, 500, 100, null);
					
					
		g.setFont(new Font("Helvetica", Font.PLAIN, 30));
					
					if (gtpColour[0] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (gtpColour[0] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
					
					g2D.drawString("FAD ---> FADH2", 125, 190);
					
					if (gtpColour[1] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (gtpColour[1] == 1) {
						g.setColor(Color.green.brighter());
					}
					
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
					
					g2D.drawString("GDP ---> GTP", 125, 290);//correct answer
					
					if (gtpColour[2] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (gtpColour[2] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
					
					
					g2D.drawString("ADP ---> ATP", 125, 390);
					
					
					if (gtpColour[3] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (gtpColour[3] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fourth rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fourth rect
					
					g2D.drawString("NAD⁺ ---> NADH and H⁺", 80, 490);
					
					if (gtpCompletion == true) {
						g.setColor(Color.cyan);
						g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
						g.setColor(Color.black);
						g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
						//write "continue"
						g.setFont(new Font("Helvetica", Font.PLAIN, 30));
						g.drawString("Continue",500,650);
					}
					
				}
		
		//ADP - ATP
				else if (screenSetting == "atp") {
					g.setFont(new Font("Helvetica", Font.PLAIN, 50));
					g.setColor(Color.red.darker());
					g2D.drawString("What 2 molecules are these?", 40, 75);
					g2D.drawImage(atpDiagram, 500, 100, null);
					
					
		g.setFont(new Font("Helvetica", Font.PLAIN, 30));
					
					if (atpColour[0] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (atpColour[0] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
					
					g2D.drawString("FAD ---> FADH₂", 125, 190);
					
					if (atpColour[1] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (atpColour[1] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
					
					g2D.drawString("GDP ---> GTP", 125, 290);
					
					if (atpColour[2] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (atpColour[2] == 1) {
						g.setColor(Color.green.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
					
					
					g2D.drawString("ADP ---> ATP", 125, 390);//correct answer
					
					
					if (atpColour[3] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (atpColour[3] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fourth rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fourth rect
					
					g2D.drawString("NAD⁺ ---> NADH and H⁺", 80, 490);
					
					if (atpCompletion == true) {
						g.setColor(Color.cyan);
						g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
						g.setColor(Color.black);
						g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
						//write "continue"
						g.setFont(new Font("Helvetica", Font.PLAIN, 30));
						g.drawString("Continue",500,650);
					}
					
				}
		
		//draw for a Succinate
				else if (screenSetting == "succinate") {
					
					g.setFont(new Font("Helvetica", Font.PLAIN, 50));
					g.setColor(Color.red.darker());
					g2D.drawString("What Molecule is this?", 40, 75);
					g2D.drawImage(succinateDiagram, 500, 100, null);
					
					
					
					g.setFont(new Font("Helvetica", Font.PLAIN, 30));
					
					//draw options for answers
					if (succinateColour[0] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (succinateColour[0] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
					
					g2D.drawString("Isocitrate", 125, 190);
					
					if (succinateColour[1] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (succinateColour[1] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
					
					g2D.drawString("Succinyl-CoA", 125, 290);
					
					if (succinateColour[2] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (succinateColour[2] == 1) {
						g.setColor(Color.green.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
					
					
					g2D.drawString("Succinate", 125, 390); //correct answer
					
					
					if (succinateColour[3] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (succinateColour[3] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fourth rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fourth rect
					
					g2D.drawString("Fumarate", 125, 490);
					
					if (succinateColour[4] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (succinateColour[4] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 416, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fifth rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 416, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fifth rect
					
					g.setFont(new Font("Helvetica", Font.PLAIN, 25));
					g2D.drawString("α-Ketoglutarate dehydrogenase", 49, 590);
					
					if (succinateCompletion == true) {
						g.setColor(Color.cyan);
						g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
						g.setColor(Color.black);
						g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
						//write "continue"
						g.setFont(new Font("Helvetica", Font.PLAIN, 30));
						g.drawString("Continue",500,650);
					}
					
					
				}
		
		//first FAD
				else if (screenSetting == "fad") {
					g.setFont(new Font("Helvetica", Font.PLAIN, 50));
					g.setColor(Color.red.darker());
					g2D.drawString("What Molecule is this?", 40, 75);
					g2D.drawImage(fadDiagram, 500, 100, null);
					
					
		g.setFont(new Font("Helvetica", Font.PLAIN, 30));
					
					if (fadColour[0] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (fadColour[0] == 1) {
						g.setColor(Color.green.brighter());
					}
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
					
					g2D.drawString("FAD", 125, 190);//correct
					
					if (fadColour[1] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (fadColour[1] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
					
					g2D.drawString("NAD⁺", 125, 290);
					
					if (fadColour[2] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (fadColour[2] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
					
					
					g2D.drawString("GDP", 125, 390);
					
					if (fadCompletion == true) {
						g.setColor(Color.cyan);
						g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
						g.setColor(Color.black);
						g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
						//write "continue"
						g.setFont(new Font("Helvetica", Font.PLAIN, 30));
						g.drawString("Continue",500,650);
					}
					
				}
		
		//draw FADH2
				else if (screenSetting == "fadh2") {
					g.setFont(new Font("Helvetica", Font.PLAIN, 50));
					g.setColor(Color.red.darker());
					g2D.drawString("What Molecule(s) is this?", 40, 75);
					g2D.drawImage(fadh2Diagram, 500, 100, null);
					
					
		g.setFont(new Font("Helvetica", Font.PLAIN, 30));
					
					if (fadh2Colour[0] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (fadh2Colour[0] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
					
					g2D.drawString("GTP", 125, 190);
					
					if (fadh2Colour[1] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (fadh2Colour[1] == 1) {
						g.setColor(Color.green.brighter());
					}
					
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
					
					g2D.drawString("FADH₂", 125, 290);//correct answer
					
					if (fadh2Colour[2] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (fadh2Colour[2] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
					
					
					g2D.drawString("NADH and H⁺", 125, 390);
					
					
					if (fadh2Colour[3] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (fadh2Colour[3] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fourth rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fourth rect
					
					g2D.drawString("ATP", 125, 490);
					
					if (fadh2Completion == true) {
						g.setColor(Color.cyan);
						g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
						g.setColor(Color.black);
						g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
						//write "continue"
						g.setFont(new Font("Helvetica", Font.PLAIN, 30));
						g.drawString("Continue",500,650);
					}
					
				}
		
		//draw for a Fumarate
				else if (screenSetting == "fumarate") {
					
					g.setFont(new Font("Helvetica", Font.PLAIN, 50));
					g.setColor(Color.red.darker());
					g2D.drawString("What Molecule is this?", 40, 75);
					g2D.drawImage(fumarateDiagram, 500, 100, null);
					
					
					
					g.setFont(new Font("Helvetica", Font.PLAIN, 30));
					
					//draw options for answers
					if (fumarateColour[0] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (fumarateColour[0] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
					
					g2D.drawString("Succinyl-CoA", 125, 190);
					
					if (fumarateColour[1] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (fumarateColour[1] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
					
					g2D.drawString("Oxaloacetate", 125, 290);
					
					if (fumarateColour[2] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (fumarateColour[2] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
					
					
					g2D.drawString("Malate", 125, 390); 
					
					
					if (fumarateColour[3] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (fumarateColour[3] == 1) {
						g.setColor(Color.green.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fourth rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fourth rect
					
					g2D.drawString("Fumarate", 125, 490);//correct answer
					
					if (fumarateColour[4] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (fumarateColour[4] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 416, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fifth rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 416, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fifth rect
					
					
					g2D.drawString("Pyruvate", 125, 590);
					
					if (fumarateCompletion == true) {
						g.setColor(Color.cyan);
						g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
						g.setColor(Color.black);
						g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
						//write "continue"
						g.setFont(new Font("Helvetica", Font.PLAIN, 30));
						g.drawString("Continue",500,650);
					}
					
					
				}
		
		//second NAD+ screen
				else if (screenSetting == "nadplus2") {
					g.setFont(new Font("Helvetica", Font.PLAIN, 50));
					g.setColor(Color.red.darker());
					g2D.drawString("What Molecule is this?", 40, 75);
					g2D.drawImage(nadplus2Diagram, 500, 100, null);
					
					
		g.setFont(new Font("Helvetica", Font.PLAIN, 30));
					
					if (NADplus2Colour[0] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (NADplus2Colour[0] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
					
					g2D.drawString("GDP", 125, 190);
					
					if (NADplus2Colour[1] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (NADplus2Colour[1] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
					
					g2D.drawString("FAD", 125, 290);
					
					if (NADplus2Colour[2] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (NADplus2Colour[2] == 1) {
						g.setColor(Color.green.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
					
					
					g2D.drawString("NAD⁺", 125, 390);//correct answer
					
					if (NADplus2Completion == true) {
						g.setColor(Color.cyan);
						g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
						g.setColor(Color.black);
						g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
						//write "continue"
						g.setFont(new Font("Helvetica", Font.PLAIN, 30));
						g.drawString("Continue",500,650);
					}
					
				}
		
		//second NADH + H+ screen
				else if (screenSetting == "nadh2") {
					g.setFont(new Font("Helvetica", Font.PLAIN, 50));
					g.setColor(Color.red.darker());
					g2D.drawString("What Molecule(s) is this?", 40, 75);
					g2D.drawImage(nadh2Diagram, 500, 100, null);
					
					
		g.setFont(new Font("Helvetica", Font.PLAIN, 30));
					
					if (NADH2Colour[0] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (NADH2Colour[0] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
					
					g2D.drawString("FADH₂ and CO₂", 125, 190);
					
					if (NADH2Colour[1] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (NADH2Colour[1] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
					
					g2D.drawString("ATP", 125, 290);
					
					if (NADH2Colour[2] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (NADH2Colour[2] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
					
					
					g2D.drawString("GTP and CO₂", 125, 390);
					
					
					if (NADH2Colour[3] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (NADH2Colour[3] == 1) {
						g.setColor(Color.green.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fourth rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fourth rect
					
					g2D.drawString("NADH + H⁺ + CO₂ ", 65, 490);//correct answer
					
					if (NADH2Completion == true) {
						g.setColor(Color.cyan);
						g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
						g.setColor(Color.black);
						g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
						//write "continue"
						g.setFont(new Font("Helvetica", Font.PLAIN, 30));
						g.drawString("Continue",500,650);
					}
					
				}
		
		//draw for Malate
				else if (screenSetting == "malate") {
					
					g.setFont(new Font("Helvetica", Font.PLAIN, 50));
					g.setColor(Color.red.darker());
					g2D.drawString("What Molecule is this?", 40, 75);
					g2D.drawImage(malateDiagram, 500, 100, null);
					
					
					
					g.setFont(new Font("Helvetica", Font.PLAIN, 30));
					
					//draw options for answers
					if (malateColour[0] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (malateColour[0] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
					
					g2D.drawString("Succinate", 125, 190);
					
					if (malateColour[1] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (malateColour[1] == 1) {
						g.setColor(Color.green.brighter());
					}
					
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
					
					g2D.drawString("Malate", 125, 290);//correct answer
					
					if (malateColour[2] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (malateColour[2] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
					
					
					g2D.drawString("Oxaloacetate", 125, 390); 
					
					
					if (malateColour[3] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (malateColour[3] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fourth rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fourth rect
					
					g2D.drawString("CO₂", 125, 490);
					
					if (malateColour[4] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (malateColour[4] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 416, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fifth rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 416, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fifth rect
					
					
					g2D.drawString("Acetyl-Coa", 125, 590);
					
					if (malateCompletion == true) {
						g.setColor(Color.cyan);
						g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
						g.setColor(Color.black);
						g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
						//write "continue"
						g.setFont(new Font("Helvetica", Font.PLAIN, 30));
						g.drawString("Continue",500,650);
					}
					
					
				}
		
		//third NAD+ screen
				else if (screenSetting == "nadplus3") {
					g.setFont(new Font("Helvetica", Font.PLAIN, 50));
					g.setColor(Color.red.darker());
					g2D.drawString("What Molecule is this?", 40, 75);
					g2D.drawImage(nadplus3Diagram, 500, 100, null);
					
					
		g.setFont(new Font("Helvetica", Font.PLAIN, 30));
					
					if (NADplus3Colour[0] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (NADplus3Colour[0] == 1) {
						g.setColor(Color.green.brighter());
					}
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
					
					g2D.drawString("NAD⁺", 125, 190);//correct answer
					
					if (NADplus3Colour[1] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (NADplus3Colour[1] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
					
					g2D.drawString("GDP", 125, 290);
					
					if (NADplus3Colour[2] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (NADplus3Colour[2] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
					
					
					g2D.drawString("FAD", 125, 390);
					
					if (NADplus3Completion == true) {
						g.setColor(Color.cyan);
						g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
						g.setColor(Color.black);
						g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
						//write "continue"
						g.setFont(new Font("Helvetica", Font.PLAIN, 30));
						g.drawString("Continue",500,650);
					}
					
				}
		
		//third NADH + H+ screen
				else if (screenSetting == "nadh3") {
					g.setFont(new Font("Helvetica", Font.PLAIN, 50));
					g.setColor(Color.red.darker());
					g2D.drawString("What Molecule(s) is this?", 40, 75);
					g2D.drawImage(nadh3Diagram, 500, 100, null);
					
					
		g.setFont(new Font("Helvetica", Font.PLAIN, 30));
					
					if (NADH3Colour[0] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (NADH3Colour[0] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
					
					g2D.drawString("GTP", 125, 190);
					
					if (NADH3Colour[1] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (NADH3Colour[1] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
					
					g2D.drawString("FADH₂", 125, 290);
					
					if (NADH3Colour[2] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (NADH3Colour[2] == 1) {
						g.setColor(Color.green.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
					
					
					g2D.drawString("NADH + H⁺", 125, 390);//correct answer
					
					
					if (NADH3Colour[3] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (NADH3Colour[3] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fourth rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fourth rect
					
					g2D.drawString("ATP", 125, 490);
					
					if (NADH3Completion == true) {
						g.setColor(Color.cyan);
						g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
						g.setColor(Color.black);
						g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
						//write "continue"
						g.setFont(new Font("Helvetica", Font.PLAIN, 30));
						g.drawString("Continue",500,650);
					}
					
				}
		
		//draw for Oxaloacetate
				else if (screenSetting == "oxaloacetate") {
					
					g.setFont(new Font("Helvetica", Font.PLAIN, 50));
					g.setColor(Color.red.darker());
					g2D.drawString("What Molecule is this?", 40, 75);
					g2D.drawImage(oxaloacetateDiagram, 500, 100, null);
					
					
					
					g.setFont(new Font("Helvetica", Font.PLAIN, 30));
					
					//draw options for answers
					if (oxaloacetateColour[0] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (oxaloacetateColour[0] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
					
					g2D.drawString("Succinate", 125, 190);
					
					if (oxaloacetateColour[1] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (oxaloacetateColour[1] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
					
					g2D.drawString("Malate", 125, 290);
					if (oxaloacetateColour[2] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (oxaloacetateColour[2] == 1) {
						g.setColor(Color.green.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
					
					
					g2D.drawString("Oxaloacetate", 125, 390); //correct answer
					
					
					if (oxaloacetateColour[3] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (oxaloacetateColour[3] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fourth rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fourth rect
					
					g2D.drawString("CO₂", 125, 490);
					
					if (oxaloacetateColour[4] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (oxaloacetateColour[4] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 416, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fifth rect
					g.setColor(Color.black);
					g2D.drawRect(PANEL_WIDTH / 67, PANEL_HEIGHT/5 + 416, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fifth rect
					
					
					g2D.drawString("Acetyl-Coa", 125, 590);
					
					if (oxaloacetateCompletion == true) {
						g.setColor(Color.cyan);
						g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
						g.setColor(Color.black);
						g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
						//write "continue"
						g.setFont(new Font("Helvetica", Font.PLAIN, 30));
						g.drawString("Continue",500,650);
					}
					
					
				}
		
		//draw for Pyruvate
				else if (screenSetting == "pyruvate") {
					
					g.setFont(new Font("Helvetica", Font.PLAIN, 50));
					g.setColor(Color.red.darker());
					g2D.drawString("What Molecule is this?", 40, 75);
					g2D.drawImage(pyruvateDiagram, 20, 378, null);
					
					
					
					g.setFont(new Font("Helvetica", Font.PLAIN, 30));
					
					//draw options for answers
					if (pyruvateColour[0] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (pyruvateColour[0] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					g2D.fillRect(660, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
					g.setColor(Color.black);
					g2D.drawRect(660, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
					
					g2D.drawString("CO₂", 782, 190);
					
					if (pyruvateColour[1] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (pyruvateColour[1] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					
					g2D.fillRect(660, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
					g.setColor(Color.black);
					g2D.drawRect(660, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
					
					g2D.drawString("Acetyl-CoA", 782, 290);
					if (pyruvateColour[2] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (pyruvateColour[2] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(660, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
					g.setColor(Color.black);
					g2D.drawRect(660, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
					
					
					g2D.drawString("NAD⁺", 782, 390); 
					
					
					if (pyruvateColour[3] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (pyruvateColour[3] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(660, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fourth rect
					g.setColor(Color.black);
					g2D.drawRect(660, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fourth rect
					
					g2D.drawString("Glucose", 782, 490);
					
					if (pyruvateColour[4] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (pyruvateColour[4] == 1) {
						g.setColor(Color.green.brighter());
					}
					g2D.fillRect(660, PANEL_HEIGHT/5 + 416, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fifth rect
					g.setColor(Color.black);
					g2D.drawRect(660, PANEL_HEIGHT/5 + 416, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fifth rect
					
					
					g2D.drawString("Pyruvate", 782, 590);//correct answer
					
					if (pyruvateCompletion == true) {
						g.setColor(Color.cyan);
						g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
						g.setColor(Color.black);
						g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
						//write "continue"
						g.setFont(new Font("Helvetica", Font.PLAIN, 30));
						g.drawString("Continue",500,650);
					}
					
					
				}
		
		//Co2 screen on pyruvate
		else if (screenSetting == "pco2") {
					g.setFont(new Font("Helvetica", Font.PLAIN, 50));
					g.setColor(Color.red.darker());
					g2D.drawString("What Molecule is this?", 40, 75);
					g2D.drawImage(pco2Diagram, 20, 378, null);
					
					
		g.setFont(new Font("Helvetica", Font.PLAIN, 30));
					
		//draw options for answers
		if (pco2Colour[0] == 0) {
			g.setColor(Color.gray.brighter());
		}
		else if (pco2Colour[0] == 1) {
			g.setColor(Color.green.brighter());
		}
		
		g2D.fillRect(660, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
		g.setColor(Color.black);
		g2D.drawRect(660, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
		
		g2D.drawString("CO₂", 782, 190);//correct answer
		
		if (pco2Colour[1] == 0) {
			g.setColor(Color.gray.brighter());
		}
		else if (pco2Colour[1] == 1) {
			g.setColor(Color.red.brighter());
		}
		
		
		g2D.fillRect(660, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
		g.setColor(Color.black);
		g2D.drawRect(660, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
		
		g2D.drawString("O₂", 782, 290);
		if (pco2Colour[2] == 0) {
			g.setColor(Color.gray.brighter());
		}
		else if (pco2Colour[2] == 1) {
			g.setColor(Color.red.brighter());
		}
		g2D.fillRect(660, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
		g.setColor(Color.black);
		g2D.drawRect(660, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
		
		
		g2D.drawString("H₂O", 782, 390); 
					
					if (pco2Completion == true) {
						g.setColor(Color.cyan);
						g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
						g.setColor(Color.black);
						g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
						//write "continue"
						g.setFont(new Font("Helvetica", Font.PLAIN, 30));
						g.drawString("Continue",500,650);
					}
					
				}
		
		//Coenzyme screen on pyruvate
		else if (screenSetting == "coenzyme") {
					g.setFont(new Font("Helvetica", Font.PLAIN, 50));
					g.setColor(Color.red.darker());
					g2D.drawString("What Enzyme is this?", 40, 75);
					g2D.drawImage(coenzymeDiagram, 20, 378, null);
					
					
		g.setFont(new Font("Helvetica", Font.PLAIN, 30));
					
		//draw options for answers
		if (coenzymeColour[0] == 0) {
			g.setColor(Color.gray.brighter());
		}
		else if (coenzymeColour[0] == 1) {
			g.setColor(Color.red.brighter());
		}
		
		g2D.fillRect(660, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
		g.setColor(Color.black);
		g2D.drawRect(660, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
		
		g2D.drawString("Citrate synthase", 782, 190);
		
		if (coenzymeColour[1] == 0) {
			g.setColor(Color.gray.brighter());
		}
		else if (coenzymeColour[1] == 1) {
			g.setColor(Color.green.brighter());
		}
		
		
		g2D.fillRect(660, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
		g.setColor(Color.black);
		g2D.drawRect(660, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
		
		g2D.drawString("Coenzyme A", 782, 290);//correct answer
		if (coenzymeColour[2] == 0) {
			g.setColor(Color.gray.brighter());
		}
		else if (coenzymeColour[2] == 1) {
			g.setColor(Color.red.brighter());
		}
		g2D.fillRect(660, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
		g.setColor(Color.black);
		g2D.drawRect(660, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
		
		
		g2D.drawString("Fumarase", 782, 390); 
					
					if (coenzymeCompletion == true) {
						g.setColor(Color.cyan);
						g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
						g.setColor(Color.black);
						g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
						//write "continue"
						g.setFont(new Font("Helvetica", Font.PLAIN, 30));
						g.drawString("Continue",500,650);
					}
					
				}
		
		else if (screenSetting == "nadplusP") {
					g.setFont(new Font("Helvetica", Font.PLAIN, 50));
					g.setColor(Color.red.darker());
					g2D.drawString("What Molecule is this?", 40, 75);
					g2D.drawImage(nadplusPDiagram, 20, 378, null);
					
					
		g.setFont(new Font("Helvetica", Font.PLAIN, 30));
					
					if (NADplusPColour[0] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (NADplusPColour[0] == 1) {
						g.setColor(Color.green.brighter());
					}
					
					g2D.fillRect(660, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
					g.setColor(Color.black);
					g2D.drawRect(660, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
					
					g2D.drawString("NAD⁺", 782, 190);//correct answer
					
					if (NADplusPColour[1] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (NADplusPColour[1] == 1) {
						g.setColor(Color.red.brighter());
					}
					
					
					g2D.fillRect(660, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
					g.setColor(Color.black);
					g2D.drawRect(660, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
					
					g2D.drawString("GDP", 782, 290);
					
					if (NADplusPColour[2] == 0) {
						g.setColor(Color.gray.brighter());
					}
					else if (NADplusPColour[2] == 1) {
						g.setColor(Color.red.brighter());
					}
					g2D.fillRect(660, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
					g.setColor(Color.black);
					g2D.drawRect(660, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
					
					
					g2D.drawString("FAD", 782, 390);
					
					if (NADplusPCompletion == true) {
						g.setColor(Color.cyan);
						g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
						g.setColor(Color.black);
						g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
						//write "continue"
						g.setFont(new Font("Helvetica", Font.PLAIN, 30));
						g.drawString("Continue",500,650);
					}
					
				}
		
		
		else if (screenSetting == "nadhP") {
			g.setFont(new Font("Helvetica", Font.PLAIN, 50));
			g.setColor(Color.red.darker());
			g2D.drawString("What Molecule(s) is this?", 40, 75);
			g2D.drawImage(nadhPDiagram, 20, 378, null);
			
			
g.setFont(new Font("Helvetica", Font.PLAIN, 30));
			
			if (NADHPColour[0] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (NADHPColour[0] == 1) {
				g.setColor(Color.red.brighter());
			}
			
			g2D.fillRect(660, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
			g.setColor(Color.black);
			g2D.drawRect(660, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
			
			g2D.drawString("FADH₂", 782, 190);
			
			if (NADHPColour[1] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (NADHPColour[1] == 1) {
				g.setColor(Color.red.brighter());
			}
			
			
			g2D.fillRect(660, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
			g.setColor(Color.black);
			g2D.drawRect(660, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
			
			g2D.drawString("ATP", 782, 290);
			
			if (NADHPColour[2] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (NADHPColour[2] == 1) {
				g.setColor(Color.red.brighter());
			}
			g2D.fillRect(660, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
			g.setColor(Color.black);
			g2D.drawRect(660, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
			
			
			g2D.drawString("GTP", 782, 390);
			
			
			if (NADHPColour[3] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (NADHPColour[3] == 1) {
				g.setColor(Color.green.brighter());
			}
			g2D.fillRect(660, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fourth rect
			g.setColor(Color.black);
			g2D.drawRect(660, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fourth rect
			
			g2D.drawString("NADH + H⁺", 782, 490);//correct answer
			
			if (NADHPCompletion == true) {
				g.setColor(Color.cyan);
				g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
				g.setColor(Color.black);
				g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
				//write "continue"
				g.setFont(new Font("Helvetica", Font.PLAIN, 30));
				g.drawString("Continue",500,650);
			}
			
		}
		
else if (screenSetting == "acetylcoaP") { 
			
			g.setFont(new Font("Helvetica", Font.PLAIN, 50));
			g.setColor(Color.red.darker());
			g2D.drawString("What Molecule is this?", 40, 75);
			g2D.drawImage(acetylCoAPDiagram, 20, 379, null);
			
			
			
			g.setFont(new Font("Helvetica", Font.PLAIN, 30));
			
			//draw options for answers
			if (acetylCoAPColour[0] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (acetylCoAPColour[0] == 1) {
				g.setColor(Color.red.brighter());
			}
			
			g2D.fillRect(660, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill first rect
			g.setColor(Color.black);
			g2D.drawRect(660, PANEL_HEIGHT/5 + 16, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline first rect
			
			g2D.drawString("Succinate", 782, 190);
			
			if (acetylCoAPColour[1] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (acetylCoAPColour[1] == 1) {
				g.setColor(Color.red.brighter());
			}
			
			
			g2D.fillRect(660, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill second rect
			g.setColor(Color.black);
			g2D.drawRect(660, PANEL_HEIGHT/5 + 116, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline second rect
			
			g2D.drawString("Fumarase", 782, 290);
			
			if (acetylCoAPColour[2] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (acetylCoAPColour[2] == 1) {
				g.setColor(Color.green.brighter());
			}
			g2D.fillRect(660, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill third rect
			g.setColor(Color.black);
			g2D.drawRect(660, PANEL_HEIGHT/5 + 216, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline third rect
			
			
			g2D.drawString("Acetyl-CoA", 782, 390);//correct answer
			
			
			if (acetylCoAPColour[3] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (acetylCoAPColour[3] == 1) {
				g.setColor(Color.red.brighter());
			}
			g2D.fillRect(660, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fourth rect
			g.setColor(Color.black);
			g2D.drawRect(660, PANEL_HEIGHT/5 + 316, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fourth rect
			
			g2D.drawString("NADH", 782, 490);
			
			if (acetylCoAPColour[4] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (acetylCoAPColour[4] == 1) {
				g.setColor(Color.red.brighter());
			}
			g2D.fillRect(660, PANEL_HEIGHT/5 + 416, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //fill fifth rect
			g.setColor(Color.black);
			g2D.drawRect(660, PANEL_HEIGHT/5 + 416, PANEL_WIDTH / 3, PANEL_HEIGHT / 14); //outline fifth rect
			
			g2D.drawString("Glucose", 782, 590);
			
			if (acetylCoAPCompletion == true) {
				g.setColor(Color.cyan);
				g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
				g.setColor(Color.black);
				g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
				//write "continue"
				g.setFont(new Font("Helvetica", Font.PLAIN, 30));
				g.drawString("Continue",500,650);
			}
			
			
		
			
		}
		
		if (question1) {
			g.setFont(new Font("Helvetica", Font.PLAIN, 30));
			g.setColor(Color.blue);
			g2D.drawString("How many times does Pyruvate Oxidation occur with one molecule of Glucose?", 66, 75);
			
			
			
			g.setFont(new Font("Helvetica", Font.PLAIN, 50));
			
			
			
			if (question1Colour[0] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question1Colour[0] == 1) {
				g.setColor(Color.red);
			}
			
			g2D.fillRect(529,137,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,137,70,70);
			g.drawString("1",549,193);
			
			
			
			if (question1Colour[1] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question1Colour[1] == 1) {
				g.setColor(Color.green);
			}
			
			g2D.fillRect(529,237,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,237,70,70);
			g.drawString("2",549,293);//correct answer
			
			
			if (question1Colour[2] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question1Colour[2] == 1) {
				g.setColor(Color.red);
			}
			
			g2D.fillRect(529,337,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,337,70,70);
			g.drawString("3",549,393);
			
			
			if (question1Colour[3] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question1Colour[3] == 1) {
				g.setColor(Color.red);
			}
		
			g2D.fillRect(529,437,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,437,70,70);
			g.drawString("4",549,493);
			
			if (question1Colour[4] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question1Colour[4] == 1) {
				g.setColor(Color.red);
			}

			
			g2D.fillRect(529,537,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,537,70,70);
			g.drawString("5",549,593);
			
			
			if (question1Completion == true) {
				g.setColor(Color.cyan);
				g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
				g.setColor(Color.black);
				g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
				//write "continue"
				g.setFont(new Font("Helvetica", Font.PLAIN, 30));
				g.drawString("Continue",500,650);
			}
			
		}
		
		if (question2) {
			g.setFont(new Font("Helvetica", Font.PLAIN, 30));
			g.setColor(Color.orange);
			g2D.drawString("How many times does the Citric Acid Cycle occur with one molecule of Glucose?", 66, 75);
			
			
			
			g.setFont(new Font("Helvetica", Font.PLAIN, 50));
			
			
			
			if (question2Colour[0] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question2Colour[0] == 1) {
				g.setColor(Color.red);
			}
			
			g2D.fillRect(529,137,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,137,70,70);
			g.drawString("1",549,193);
			
			
			
			if (question2Colour[1] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question2Colour[1] == 1) {
				g.setColor(Color.green);
			}
			
			g2D.fillRect(529,237,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,237,70,70);
			g.drawString("2",549,293);//correct answer
			
			
			if (question2Colour[2] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question2Colour[2] == 1) {
				g.setColor(Color.red);
			}
			
			g2D.fillRect(529,337,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,337,70,70);
			g.drawString("3",549,393);
			
			
			if (question2Colour[3] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question2Colour[3] == 1) {
				g.setColor(Color.red);
			}
		
			g2D.fillRect(529,437,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,437,70,70);
			g.drawString("4",549,493);
			
			if (question2Colour[4] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question2Colour[4] == 1) {
				g.setColor(Color.red);
			}

			
			g2D.fillRect(529,537,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,537,70,70);
			g.drawString("5",549,593);
			
			
			if (question2Completion == true) {
				g.setColor(Color.cyan);
				g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
				g.setColor(Color.black);
				g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
				//write "continue"
				g.setFont(new Font("Helvetica", Font.PLAIN, 30));
				g.drawString("Continue",500,650);
			}
			
		}
		
		if (question3) {
			g.setFont(new Font("Helvetica", Font.PLAIN, 30));
			g.setColor(Color.blue);
			g2D.drawString("How many total molecules of NADH are made during Pyruvate Oxidation?", 66, 75);
			
			
			
			g.setFont(new Font("Helvetica", Font.PLAIN, 50));
			
			
			
			if (question3Colour[0] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question3Colour[0] == 1) {
				g.setColor(Color.red);
			}
			
			g2D.fillRect(529,137,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,137,70,70);
			g.drawString("1",549,193);
			
			
			
			if (question3Colour[1] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question3Colour[1] == 1) {
				g.setColor(Color.green);
			}
			
			g2D.fillRect(529,237,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,237,70,70);
			g.drawString("2",549,293);//correct answer
			
			
			if (question3Colour[2] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question3Colour[2] == 1) {
				g.setColor(Color.red);
			}
			
			g2D.fillRect(529,337,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,337,70,70);
			g.drawString("3",549,393);
			
			
			if (question3Colour[3] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question3Colour[3] == 1) {
				g.setColor(Color.red);
			}
		
			g2D.fillRect(529,437,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,437,70,70);
			g.drawString("4",549,493);
			
			if (question3Colour[4] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question3Colour[4] == 1) {
				g.setColor(Color.red);
			}

			
			g2D.fillRect(529,537,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,537,70,70);
			g.drawString("5",549,593);
			
			
			if (question3Completion == true) {
				g.setColor(Color.cyan);
				g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
				g.setColor(Color.black);
				g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
				//write "continue"
				g.setFont(new Font("Helvetica", Font.PLAIN, 30));
				g.drawString("Continue",500,650);
			}
			
		}
		
		if (question4) {
			g.setFont(new Font("Helvetica", Font.PLAIN, 30));
			g.setColor(Color.orange);
			g2D.drawString("How many total molecules of NADH are made during the Citric Acid Cycle?", 66, 75);
			
			
			
			g.setFont(new Font("Helvetica", Font.PLAIN, 50));
			
			
			
			if (question4Colour[0] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question4Colour[0] == 1) {
				g.setColor(Color.red);
			}
			
			g2D.fillRect(529,137,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,137,70,70);
			g.drawString("2",549,193);
			
			
			
			if (question4Colour[1] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question4Colour[1] == 1) {
				g.setColor(Color.red);
			}
			
			g2D.fillRect(529,237,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,237,70,70);
			g.drawString("4",549,293);
			
			
			if (question4Colour[2] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question4Colour[2] == 1) {
				g.setColor(Color.green);
			}
			
			g2D.fillRect(529,337,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,337,70,70);
			g.drawString("6",549,393);//correct
			
			
			if (question4Colour[3] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question4Colour[3] == 1) {
				g.setColor(Color.red);
			}
		
			g2D.fillRect(529,437,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,437,70,70);
			g.drawString("8",549,493);
			
			if (question4Colour[4] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question4Colour[4] == 1) {
				g.setColor(Color.red);
			}

			
			g2D.fillRect(529,537,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,537,70,70);
			g.drawString("10",539,593);
			
			
			if (question4Completion == true) {
				g.setColor(Color.cyan);
				g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
				g.setColor(Color.black);
				g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
				//write "continue"
				g.setFont(new Font("Helvetica", Font.PLAIN, 30));
				g.drawString("Continue",500,650);
			}
			
		}
		
		if (question5) {
			g.setFont(new Font("Helvetica", Font.PLAIN, 30));
			g.setColor(Color.orange);
			g2D.drawString("How many total molecules of FADH₂ are made during the Citric Acid Cycle?", 66, 75);
			
			
			
			g.setFont(new Font("Helvetica", Font.PLAIN, 50));
			
			
			
			if (question5Colour[0] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question5Colour[0] == 1) {
				g.setColor(Color.green);
			}
			
			g2D.fillRect(529,137,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,137,70,70);
			g.drawString("2",549,193);
			
			
			
			if (question5Colour[1] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question5Colour[1] == 1) {
				g.setColor(Color.red);
			}
			
			g2D.fillRect(529,237,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,237,70,70);
			g.drawString("4",549,293);
			
			
			if (question5Colour[2] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question5Colour[2] == 1) {
				g.setColor(Color.red);
			}
			
			g2D.fillRect(529,337,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,337,70,70);
			g.drawString("6",549,393);//correct
			
			
			if (question5Colour[3] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question5Colour[3] == 1) {
				g.setColor(Color.red);
			}
		
			g2D.fillRect(529,437,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,437,70,70);
			g.drawString("8",549,493);
			
			if (question5Colour[4] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question5Colour[4] == 1) {
				g.setColor(Color.red);
			}

			
			g2D.fillRect(529,537,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,537,70,70);
			g.drawString("10",539,593);
			
			
			if (question5Completion == true) {
				g.setColor(Color.cyan);
				g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
				g.setColor(Color.black);
				g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
				//write "continue"
				g.setFont(new Font("Helvetica", Font.PLAIN, 30));
				g.drawString("Continue",500,650);
			}
			
		}
		
		if (question6) {
			g.setFont(new Font("Helvetica", Font.PLAIN, 30));
			g.setColor(Color.orange);
			g2D.drawString("How many total ATP are made during the Citric Acid Cycle?", 192, 75);
			
			
			
			g.setFont(new Font("Helvetica", Font.PLAIN, 50));
			
			
			
			if (question6Colour[0] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question6Colour[0] == 1) {
				g.setColor(Color.green);
			}
			
			g2D.fillRect(529,137,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,137,70,70);
			g.drawString("2",549,193);
			
			
			
			if (question6Colour[1] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question6Colour[1] == 1) {
				g.setColor(Color.red);
			}
			
			g2D.fillRect(529,237,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,237,70,70);
			g.drawString("4",549,293);
			
			
			if (question6Colour[2] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question6Colour[2] == 1) {
				g.setColor(Color.red);
			}
			
			g2D.fillRect(529,337,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,337,70,70);
			g.drawString("6",549,393);//correct
			
			
			if (question6Colour[3] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question6Colour[3] == 1) {
				g.setColor(Color.red);
			}
		
			g2D.fillRect(529,437,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,437,70,70);
			g.drawString("8",549,493);
			
			if (question6Colour[4] == 0) {
				g.setColor(Color.gray.brighter());
			}
			else if (question6Colour[4] == 1) {
				g.setColor(Color.red);
			}

			
			g2D.fillRect(529,537,70,70); 
			g.setColor(Color.black);
			g2D.drawRect(529,537,70,70);
			g.drawString("10",539,593);
			
			
			if (question6Completion == true) {
				g.setColor(Color.cyan);
				g2D.fillRect(473, 617, 200, PANEL_HEIGHT / 14); //fill completion button
				g.setColor(Color.black);
				g2D.drawRect(473, 617, 200, PANEL_HEIGHT / 14); //outline completion button
				//write "continue"
				g.setFont(new Font("Helvetica", Font.PLAIN, 30));
				g.drawString("Continue",500,650);
			}
			
		}
		
		if (gameOver) {
			g.setFont(new Font("Helvetica", Font.PLAIN, 100));
			g.drawString("Thank You for Playing",69,100);
			
			g.setFont(new Font("Helvetica", Font.PLAIN, 50));
			g.drawString("Wrong Answers: " + wrongAnswer ,350,250);
			
			double finalScore =132 - (wrongAnswer/2);
			finalScore /= 132.0;
			
			finalScore *= 100.0;
			
			g.setFont(new Font("Helvetica", Font.PLAIN, 50));
			g.drawString("Your final score is : " + Math.round(finalScore) + "%" ,350,350);
		}
		
		
		
			

		
		
		if (cacShowing == true) {
			//draw first NAD+ box
			
			g.setColor(Color.CYAN.brighter());
			g2D.fillRect(969, 258, 60, 20);
			g.setColor(Color.black);
			g2D.setStroke(new BasicStroke(3));
			g2D.drawRect(969, 258, 60, 20);
			
			
			//draw first NADH + H+ box
			g.setColor(Color.ORANGE.brighter());
			g2D.fillRect(974, 288, 150, 20);
			g.setColor(Color.black);
			g2D.setStroke(new BasicStroke(3));
			g2D.drawRect(974, 288, 150, 20);
			

			
			//draw GDP box
			g.setColor(Color.PINK.darker());
			g2D.fillRect(875, 493, 22, 19);
			g.setColor(Color.black);
			g2D.setStroke(new BasicStroke(3));
			g2D.drawRect(875, 493, 22, 19);
			
			//draw ADP box
			g.setColor(Color.MAGENTA);
			g2D.fillRect(864, 548, 30, 25);
			g.setColor(Color.black);
			g2D.setStroke(new BasicStroke(3));
			g2D.drawRect(864, 548, 30, 25);
			
			//draw FAD box
			g.setColor(Color.red);
			g2D.fillRect(650, 465, 41, 32);
			g.setColor(Color.black);
			g2D.setStroke(new BasicStroke(3));
			g2D.drawRect(650, 465, 41, 32);
			
			//draw FADH2 box
			g.setColor(Color.gray);
			g2D.fillRect(592, 435, 47, 25);
			g.setColor(Color.black);
			g2D.setStroke(new BasicStroke(3));
			g2D.drawRect(592, 435, 47, 25);
			
			//cover arrow
			g.setColor(Color.white);
			g2D.fillRect(936, 307, 25, 29);
			
			//draw Second NAD+ box
			g.setColor(Color.CYAN.brighter());
			g2D.fillRect(957, 392, 60, 20);
			g.setColor(Color.black);
			g2D.setStroke(new BasicStroke(3));
			g2D.drawRect(957, 392, 60, 20);
			
			//draw Second NADH + H+
			g.setColor(Color.ORANGE.brighter());
			g2D.fillRect(955, 417, 150, 20);
			g.setColor(Color.black);
			g2D.setStroke(new BasicStroke(3));
			g2D.drawRect(955, 417, 150, 20);
			
			//draw third NAD+ box
			g.setColor(Color.CYAN.brighter());
			g2D.fillRect(555, 281, 60, 20);
			g.setColor(Color.black);
			g2D.setStroke(new BasicStroke(3));
			g2D.drawRect(555, 281, 60, 20);
			
			//draw Third NADH + H+
			g.setColor(Color.ORANGE.brighter());
			g2D.fillRect(453, 252, 150, 20);
			g.setColor(Color.black);
			g2D.setStroke(new BasicStroke(3));
			g2D.drawRect(453, 252, 150, 20);
		}
		
		
		
		if (pyruvateShowing == true) {
			//draw box for pyruvate
			g.setColor(Color.orange);
			g2D.fillRect(25, 534, 60, 16);
			g.setColor(Color.black);
			g2D.setStroke(new BasicStroke(3));
			g2D.drawRect(25, 534, 60, 16);

			
			//draw box for co2
			g.setColor(Color.pink);
			g2D.fillRect(171, 407, 42, 32);
			g.setColor(Color.black);
			g2D.setStroke(new BasicStroke(3));
			g2D.drawRect(171, 407, 42, 32);
			
			//draw box for CoA
			g.setColor(Color.green.brighter());
			g2D.fillRect(221, 407, 86, 32);
			g.setColor(Color.black);
			g2D.setStroke(new BasicStroke(3));
			g2D.drawRect(221, 407, 86, 32);
			
			//draw box for NAD+
			g.setColor(Color.magenta);
			g2D.fillRect(179, 521, 41, 18);
			g.setColor(Color.black);
			g2D.setStroke(new BasicStroke(3));
			g2D.drawRect(179, 521, 41, 18);
			
			//draw box for NADH2
			g.setColor(Color.blue.brighter());
			g2D.fillRect(226, 519, 88, 22);
			g.setColor(Color.black);
			g2D.setStroke(new BasicStroke(3));
			g2D.drawRect(226, 519, 88, 22);
			
			//draw box for Acetyl-CoA
			g.setColor(Color.yellow);
			g2D.fillRect(332, 525, 76, 25);
			g.setColor(Color.black);
			g2D.setStroke(new BasicStroke(3));
			g2D.drawRect(332, 525, 76, 25);
		}
		
		if (menuContinueClicked == false) {
			g.setColor(Color.green.brighter());
			g2D.fillRect(959, 584, 210, 70);
			g.setColor(Color.black);
			g2D.setStroke(new BasicStroke(3));
			g2D.drawRect(959, 584, 210, 70);
		}
		
		



		if (cacShowing == true) {
			if (acetylCoACompletion == true && acetylCoAClicked[5] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 15));
				g2D.drawString("Acetyl-CoA", 640, 165);
			}
			
			if (citrateCompletion == true && citrateClicked[5] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 15));
				g2D.drawString("Citrate", 755, 195);
			}
			
			if (isocitrateCompletion == true && isocitrateClicked[5] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 15));
				g2D.drawString("Isocitrate", 865, 245);
			}
			
			if (NADplus1Completion == true && NADplus1Clicked[3] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 15));
				g2D.drawString("NAD⁺", 980, 275);
			}
			
			if (NADH1Completion == true && NADH1Clicked[4] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 15));
				g2D.drawString("NADH + H⁺ + CO₂", 985, 304);
			}
			
			if (aketoglutarateCompletion == true && aketoglutarateClicked[5] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 15));
				g2D.drawString("α-Ketoglutarate", 880, 380);
			}
			
			if (succinylcoaCompletion == true && succinylcoaClicked[5] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 15));
				g2D.drawString("Succinyl-CoA", 842, 438);
			}
			
			if (gtpCompletion == true && gtpClicked[4] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 10));
				g2D.drawString("GTP", 836, 530);
				g.setFont(new Font("Helvetica", Font.PLAIN, 8));
				g2D.drawString("GDP", 878, 508);
			}
			
			if (atpCompletion == true && atpClicked[4] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 13));
				g2D.drawString("ADP", 866, 568);
				g.setFont(new Font("Helvetica", Font.PLAIN, 10));
				g2D.drawString("ATP", 925, 542);
				
			}
			
			if (succinateCompletion == true && succinateClicked[5] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 15));
				g2D.drawString("Succinate", 743, 478);

				
			}
			
			if (fadCompletion == true && fadClicked[3] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 15));
				g2D.drawString("FAD", 657, 488);

				
			}
			
			if (fadh2Completion == true && fadh2Clicked[4] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 13));
				g2D.drawString("FADH₂", 594, 456);

				
			}
			if (fumarateCompletion == true && fumarateClicked[5] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 13));
				g2D.drawString("Fumarate", 630, 395);

				
			}
			
			if (NADplus2Completion == true && NADplus2Clicked[3] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 15));
				g2D.drawString("NAD⁺", 968, 408);

				
			}
			
			if (NADH2Completion == true && NADH2Clicked[4] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 15));
				g2D.drawString("NADH + H⁺ + CO₂", 967, 433);
			}
			
			if (malateCompletion == true && malateClicked[5] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 13));
				g2D.drawString("Malate", 628, 336);

				
			}
			if (NADplus3Completion == true && NADplus3Clicked[3] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 15));
				g2D.drawString("NAD⁺", 568, 298);

				
			}
			
			if (NADH3Completion == true && NADH3Clicked[4] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 16));
				g2D.drawString("NADH + H⁺", 489, 267);
			}
			if (oxaloacetateCompletion == true && oxaloacetateClicked[5] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 16));
				g2D.drawString("Oxaloacetate", 642, 238);
			}
		}
		
		if (pyruvateShowing == true) {
			if (pyruvateCompletion == true && pyruvateClicked[5] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 12));
				g2D.drawString("Pyruvate",32, 547);
			}
			
			if (pco2Completion == true && pco2Clicked[3] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 15));
				g2D.drawString("CO₂",178, 428);
			}
			
			if (coenzymeCompletion == true && coenzymeClicked[3] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 14));
				g2D.drawString("Coenzyme A",226, 428);
			}
			
			if (NADplusPCompletion == true && NADplusPClicked[3] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 14));
				g2D.drawString("NAD⁺",183, 536);
			}
			
			if (NADHPCompletion == true && NADHPClicked[4] == true) {
				g.setColor(Color.white);
				g.setFont(new Font("Helvetica", Font.PLAIN, 14));
				g2D.drawString("NADH + H⁺",234, 536);
			}
			
			if (acetylCoAPCompletion == true && acetylCoAPClicked[5] == true) {
				g.setColor(Color.black);
				g.setFont(new Font("Helvetica", Font.PLAIN, 14));
				g2D.drawString("Acetyl CoA",335, 542);
			}
			
		}
		
		if (menuContinueClicked == false) {
			g.setColor(Color.black);
			g.setFont(new Font("Helvetica", Font.PLAIN, 50));
			g2D.drawString("Continue",964, 639);
		}
		
		
		


		
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		//audio
				File wrongFile = new File("src\\cacImages\\plopSound.wav");
				
				AudioInputStream audioStream = null;
				try {
					audioStream = AudioSystem.getAudioInputStream(wrongFile);
				} catch (UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Clip wrongClip = null;
				try {
					wrongClip = AudioSystem.getClip();
				} catch (LineUnavailableException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					wrongClip.open(audioStream);
				} catch (LineUnavailableException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
						// create instance for plop
						
						File plopFile = new File("src\\cacImages\\plopSound.wav");
						
					
						try {
							audioStream = AudioSystem.getAudioInputStream(plopFile);
						} catch (UnsupportedAudioFileException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						Clip plopClip = null;
						try {
							plopClip = AudioSystem.getClip();
						} catch (LineUnavailableException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							plopClip.open(audioStream);
						} catch (LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
				
				switch (e.getButton()) {
				case 1:
					int x = e.getX();
					int y = e.getY();
					Out.print("\n" + x + " " + y);
					
					//start of game, when you choose whatever option you want
					if (screenSetting == "menu") { 
						if (637 < x && x < 719 && 153 < y && y < 172 && acetylCoACompletion == false) {//acetly coa option
							screenSetting = "acetylCoA";
							plopClip.start();
							pyruvateShowing = false;
						}
						else if (741 < x && x < 812 && 180 < y && y < 204 && citrateCompletion == false) {
							screenSetting = "citrate";
							plopClip.start();
							pyruvateShowing = false;
						}
						
						else if (861 < x && x < 929 && 230 < y && y < 253 && isocitrateCompletion == false) {
							screenSetting = "isocitrate";
							plopClip.start();
							pyruvateShowing = false;
						}
						
						else if (969 < x && x < 1028 && 259 < y && y < 278 && NADplus1Completion == false) {
							screenSetting = "nadplus1";
							plopClip.start();
							pyruvateShowing = false;
						}
						
						else if (974 < x && x < 1122 && 287 < y && y < 308 && NADH1Completion == false) {
							screenSetting = "nadh1";
							plopClip.start();
							pyruvateShowing = false;
						}
						
						
						else if (874 < x && x < 985 && 363 < y && y < 384 && aketoglutarateCompletion == false) {
							screenSetting = "aketoglutarate";
							plopClip.start();
							pyruvateShowing = false;
						}
						else if (840 < x && x < 932 && 425 < y && y < 444 && succinylcoaCompletion == false) {
							screenSetting = "succinylcoa";
							plopClip.start();
							pyruvateShowing = false;
						}
						
						else if (836 < x && x < 858 && 515 < y && y < 534 && gtpCompletion == false && screenSetting != "gtp") {
							screenSetting = "gtp";
							plopClip.start();
							pyruvateShowing = false;
						}
						
						else if (876 < x && x < 895 && 492 < y && y < 510 && gtpCompletion == false && screenSetting != "gtp") {
							screenSetting = "gtp";
							plopClip.start();
							pyruvateShowing = false;
						}
						
						else if (864 < x && x < 893 && 551 < y && y < 572 && atpCompletion == false && screenSetting != "atp") {
							screenSetting = "atp";
							plopClip.start();
							pyruvateShowing = false;
						}
						else if (924 < x && x < 944 && 528 < y && y < 544 && atpCompletion == false && screenSetting != "atp") {
							screenSetting = "atp";
							plopClip.start();
							pyruvateShowing = false;
						}
						
						else if (739 < x && x < 807 && 461 < y && y < 479 && succinateCompletion == false) {
							screenSetting = "succinate";
							plopClip.start();
							pyruvateShowing = false;
						}
						
						else if (651 < x && x < 690 && 468 < y && y < 498 && fadCompletion == false) {
							screenSetting = "fad";
							plopClip.start();
							pyruvateShowing = false;
						}
						else if (594 < x && x < 637 && 438 < y && y < 459 && fadh2Completion == false) {
							screenSetting = "fadh2";
							plopClip.start();
							pyruvateShowing = false;
						}
						
						else if (627 < x && x < 696 && 380 < y && y < 401 && fumarateCompletion == false) {
							screenSetting = "fumarate";
							plopClip.start();
							pyruvateShowing = false;
						}
						else if (960 < x && x < 1016 && 394 < y && y < 412 && NADplus2Completion == false) {
							screenSetting = "nadplus2";
							plopClip.start();
							pyruvateShowing = false;
						}
						else if (957 < x && x < 1104 && 418 < y && y < 436 && NADH2Completion == false) {
							screenSetting = "nadh2";
							plopClip.start();
							pyruvateShowing = false;
						}
						else if (624 < x && x < 673 && 319 < y && y < 341 && malateCompletion == false) {
							screenSetting = "malate";
							plopClip.start();
							pyruvateShowing = false;
						}
						else if (554 < x && x < 613 && 283 < y && y < 300 && NADplus3Completion == false) {
							screenSetting = "nadplus3";
							plopClip.start();
							pyruvateShowing = false;
						}
						
						else if (455 < x && x < 601 && 254 < y && y < 271 && NADH3Completion == false) {
							screenSetting = "nadh3";
							plopClip.start();
							pyruvateShowing = false;
						}
						else if (634 < x && x < 755 && 221 < y && y < 244 && oxaloacetateCompletion == false) {
							screenSetting = "oxaloacetate";
							plopClip.start();
							pyruvateShowing = false;
							
						}
						
						else if (25 < x && x < 84 && 537 < y && y < 548 && pyruvateCompletion == false) {
							screenSetting = "pyruvate";
							plopClip.start();
							cacShowing = false;
							
						}
						
						else if (178 < x && x < 212 && 409 < y && y < 439 && pco2Completion == false) {
							screenSetting = "pco2";
							plopClip.start();
							cacShowing = false;
							
						}
	
						
						else if (224 < x && x < 304 && 409 < y && y < 439 && coenzymeCompletion == false) {
							screenSetting = "coenzyme";
							plopClip.start();
							cacShowing = false;
							
						}
						
						else if (181 < x && x < 218 && 523 < y && y < 539 && NADplusPCompletion == false) {
							screenSetting = "nadplusP";
							plopClip.start();
							cacShowing = false;
							
						}
						
						else if (226 < x && x < 314 && 521 < y && y < 541 && NADHPCompletion == false) {
							screenSetting = "nadhP";
							plopClip.start();
							cacShowing = false;
							
						}
						
						else if (333 < x && x < 403 && 529 < y && y < 550 && acetylCoAPCompletion == false) {
							screenSetting = "acetylcoaP";
							plopClip.start();
							cacShowing = false;
							
						}
						
						
						
						
						
						
						
					}
					
					
					//when youre in acetly coa
					if (screenSetting == "acetylCoA") {
						//button 1 (wrong)
						if (acetylCoACompletion == false && acetylCoAClicked[0] == false && 18 < x && x < 416 && 157 < y && y < 206 ) {
							acetylCoAClicked[0] = true;
							acetylCoAColour[0] = 1;
							wrongAnswer ++;		
						}
						//button 2 (wrong)
						else if (acetylCoACompletion == false && acetylCoAClicked[1] == false && 18 < x && x < 416 && 257 < y && y < 306 ) {
							acetylCoAClicked[1] = true;
							acetylCoAColour[1] = 1;
							wrongAnswer ++;		
						}
						//button 3 (correct)
						else if (acetylCoACompletion == false && acetylCoAClicked[2] == false &&  18 < x && x < 416 && 357 < y && y < 406 ) {
							acetylCoAClicked[2] = true;
							acetylCoAColour[2] = 1;
							acetylCoACompletion = true;
							
						}
						
						//button 4 (wrong)
						else if (acetylCoACompletion == false && acetylCoAClicked[3] == false &&  18 < x && x < 416 && 457 < y && y < 506 ) {
							acetylCoAClicked[3] = true;
							acetylCoAColour[3] = 1;
							wrongAnswer ++;		
						}
						//button 5 (wrong)
						else if (acetylCoACompletion == false && acetylCoAClicked[4] == false &&  18 < x && x < 416 && 557 < y && y < 606 ) {
							acetylCoAClicked[4] = true;
							acetylCoAColour[4] = 1;
							wrongAnswer ++;		
						}
						
						else if (acetylCoACompletion == true && acetylCoAClicked[5] == false &&  474 < x && x < 673 && 619 < y && y < 667 ) {
							acetylCoAClicked[5] = true;
							screenSetting = "menu";
							pyruvateShowing = true;
								
							
							
						}
					}
					//if in citrate screen
					else if (screenSetting == "citrate") {
						//button 1 (wrong)
						if (citrateCompletion == false && citrateClicked[0] == false && 18 < x && x < 416 && 157 < y && y < 206 ) {
							citrateClicked[0] = true;
							citrateColour[0] = 1;
							wrongAnswer ++;		
						}
						//button 2 (wrong)
						else if (citrateCompletion == false && citrateClicked[1] == false && 18 < x && x < 416 && 257 < y && y < 306 ) {
							citrateClicked[1] = true;
							citrateColour[1] = 1;
							wrongAnswer ++;		
						}
						//button 3 (wrong)
						else if (citrateCompletion == false && citrateClicked[2] == false && 18 < x && x < 416 && 357 < y && y < 406 ) {
							citrateClicked[2] = true;
							citrateColour[2] = 1;
							wrongAnswer ++;
							
						}
						
						//button 4 (wrong)
						else if (citrateCompletion == false && citrateClicked[3] == false  && 18 < x && x < 416 && 457 < y && y < 506 ) {
							citrateClicked[3] = true;
							citrateColour[3] = 1;
							wrongAnswer ++;		
						}
						//button 5 (correct)
						else if (citrateCompletion == false && citrateClicked[4] == false  && 18 < x && x < 416 && 557 < y && y < 606 ) {
							citrateClicked[4] = true;
							citrateColour[4] = 1;
							citrateCompletion = true;	
						}
						
						else if (citrateCompletion == true && citrateClicked[5] == false && 474 < x && x < 673 && 619 < y && y < 667 ) {
							citrateClicked[5] = true;
							screenSetting = "menu";
							pyruvateShowing = true;
								
							
							
						}
					}
					
					//if in isocitrate screen
					else if (screenSetting == "isocitrate") {
						//button 1 (correct)
						if (isocitrateCompletion == false && isocitrateClicked[0] == false && 18 < x && x < 416 && 157 < y && y < 206 ) {
							isocitrateClicked[0] = true;
							isocitrateColour[0] = 1;
							isocitrateCompletion = true;
						}
						//button 2 (wrong)
						else if (isocitrateCompletion == false && isocitrateClicked[1] == false && 18 < x && x < 416 && 257 < y && y < 306 ) {
							isocitrateClicked[1] = true;
							isocitrateColour[1] = 1;
							wrongAnswer ++;		
						}
						//button 3 (wrong)
						else if (isocitrateCompletion == false && isocitrateClicked[2] == false && 18 < x && x < 416 && 357 < y && y < 406 ) {
							isocitrateClicked[2] = true;
							isocitrateColour[2] = 1;
							wrongAnswer ++;
							
						}
						
						//button 4 (wrong)
						else if (isocitrateCompletion == false && isocitrateClicked[3] == false  && 18 < x && x < 416 && 457 < y && y < 506 ) {
							isocitrateClicked[3] = true;
							isocitrateColour[3] = 1;
							wrongAnswer ++;		
						}
						//button 5 (correct)
						else if (isocitrateCompletion == false && isocitrateClicked[4] == false  && 18 < x && x < 416 && 557 < y && y < 606 ) {
							isocitrateClicked[4] = true;
							isocitrateColour[4] = 1;
							wrongAnswer++;
						}
						
						else if (isocitrateCompletion == true && isocitrateClicked[5] == false && 474 < x && x < 673 && 619 < y && y < 667 ) {
							isocitrateClicked[5] = true;
							screenSetting = "menu";
							pyruvateShowing = true;
								
							
							
						}
					}
					
					else if (screenSetting == "nadplus1") {
						//button 1 (wrong)
						if (NADplus1Completion == false && NADplus1Clicked[0] == false && 18 < x && x < 416 && 157 < y && y < 206 ) {
							NADplus1Clicked[0] = true;
							NADplus1Colour[0] = 1;
							wrongAnswer ++;		
						}
						//button 2 (correct)
						else if (NADplus1Completion == false && NADplus1Clicked[1] == false && 18 < x && x < 416 && 257 < y && y < 306 ) {
							NADplus1Clicked[1] = true;
							NADplus1Colour[1] = 1;
							NADplus1Completion = true;	
						}
						//button 3 (wrong)
						else if (NADplus1Completion == false && NADplus1Clicked[2] == false && 18 < x && x < 416 && 357 < y && y < 406 ) {
							NADplus1Clicked[2] = true;
							NADplus1Colour[2] = 1;
							wrongAnswer ++;
							
						}
						
					
						
						else if (NADplus1Completion == true && NADplus1Clicked[3] == false && 474 < x && x < 673 && 619 < y && y < 667 ) {
							NADplus1Clicked[3] = true;
							screenSetting = "menu";
							pyruvateShowing = true;	
							
							
						}
					}
					
					//when in first NADH = H+ screen
					if (screenSetting == "nadh1") {
						//button 1 (wrong)
						if (NADH1Completion == false && NADH1Clicked[0] == false && 18 < x && x < 416 && 157 < y && y < 206 ) {
							NADH1Clicked[0] = true;
							NADH1Colour[0] = 1;
							wrongAnswer ++;		
						}
						//button 2 (wrong)
						else if (NADH1Completion == false && NADH1Clicked[1] == false && 18 < x && x < 416 && 257 < y && y < 306 ) {
							NADH1Clicked[1] = true;
							NADH1Colour[1] = 1;
							wrongAnswer ++;		
						}
						//button 3 (correct)
						else if (NADH1Completion == false && NADH1Clicked[2] == false &&  18 < x && x < 416 && 357 < y && y < 406 ) {
							NADH1Clicked[2] = true;
							NADH1Colour[2] = 1;
							NADH1Completion = true;
							
						}
						
						//button 4 (wrong)
						else if (NADH1Completion == false && NADH1Clicked[3] == false &&  18 < x && x < 416 && 457 < y && y < 506 ) {
							NADH1Clicked[3] = true;
							NADH1Colour[3] = 1;
							wrongAnswer ++;		
						}

						
						else if (NADH1Completion == true && NADH1Clicked[4] == false &&  474 < x && x < 673 && 619 < y && y < 667 ) {
							NADH1Clicked[4] = true;
							screenSetting = "menu";
							pyruvateShowing = true;	
							
							
						}
					}
					

					
					
					//a ketoglutarate screen
					if (screenSetting == "aketoglutarate") {
						//button 1 (wrong)
						if (aketoglutarateCompletion == false && aketoglutarateClicked[0] == false && 18 < x && x < 416 && 157 < y && y < 206 ) {
							aketoglutarateClicked[0] = true;
							aketoglutarateColour[0] = 1;
							wrongAnswer ++;		
						}
						//button 2 (wrong)
						else if (aketoglutarateCompletion == false && aketoglutarateClicked[1] == false && 18 < x && x < 416 && 257 < y && y < 306 ) {
							aketoglutarateClicked[1] = true;
							aketoglutarateColour[1] = 1;
							wrongAnswer ++;		
						}
						//button 3 (wrong)
						else if (aketoglutarateCompletion == false && aketoglutarateClicked[2] == false &&  18 < x && x < 416 && 357 < y && y < 406 ) {
							aketoglutarateClicked[2] = true;
							aketoglutarateColour[2] = 1;
							wrongAnswer ++;	
							
							
						}
						
						//button 4 (correct)
						else if (aketoglutarateCompletion == false && aketoglutarateClicked[3] == false &&  18 < x && x < 416 && 457 < y && y < 506 ) {
							aketoglutarateClicked[3] = true;
							aketoglutarateColour[3] = 1;	
							aketoglutarateCompletion = true;
						}
						//button 5 (wrong)
						else if (aketoglutarateCompletion == false && aketoglutarateClicked[4] == false &&  18 < x && x < 416 && 557 < y && y < 606 ) {
							aketoglutarateClicked[4] = true;
							aketoglutarateColour[4] = 1;
							wrongAnswer ++;		
						}
						
						else if (aketoglutarateCompletion == true && aketoglutarateClicked[5] == false &&  474 < x && x < 673 && 619 < y && y < 667 ) {
							aketoglutarateClicked[5] = true;
							screenSetting = "menu";
							pyruvateShowing = true;
							
							
						}
					}
					
					else if (screenSetting == "succinylcoa") {
						//button 1 (correct)
						if (succinylcoaCompletion == false && succinylcoaClicked[0] == false && 18 < x && x < 416 && 157 < y && y < 206 ) {
							succinylcoaClicked[0] = true;
							succinylcoaColour[0] = 1;
							succinylcoaCompletion = true;
						}
						//button 2 (wrong)
						else if (succinylcoaCompletion == false && succinylcoaClicked[1] == false && 18 < x && x < 416 && 257 < y && y < 306 ) {
							succinylcoaClicked[1] = true;
							succinylcoaColour[1] = 1;
							wrongAnswer ++;		
						}
						//button 3 (wrong)
						else if (succinylcoaCompletion == false && succinylcoaClicked[2] == false && 18 < x && x < 416 && 357 < y && y < 406 ) {
							succinylcoaClicked[2] = true;
							succinylcoaColour[2] = 1;
							wrongAnswer ++;
							
						}
						
						//button 4 (wrong)
						else if (succinylcoaCompletion == false && succinylcoaClicked[3] == false  && 18 < x && x < 416 && 457 < y && y < 506 ) {
							succinylcoaClicked[3] = true;
							succinylcoaColour[3] = 1;
							wrongAnswer ++;		
						}
						//button 5 (correct)
						else if (succinylcoaCompletion == false && succinylcoaClicked[4] == false  && 18 < x && x < 416 && 557 < y && y < 606 ) {
							succinylcoaClicked[4] = true;
							succinylcoaColour[4] = 1;
							wrongAnswer++;
						}
						
						else if (succinylcoaCompletion == true && succinylcoaClicked[5] == false && 474 < x && x < 673 && 619 < y && y < 667 ) {
							succinylcoaClicked[5] = true;
							screenSetting = "menu";
							pyruvateShowing = true;	
							
							
						}
					}
					
					//when in GTP scren
					if (screenSetting == "gtp") {
						//button 1 (wrong)
						if (gtpCompletion == false && gtpClicked[0] == false && 18 < x && x < 416 && 157 < y && y < 206 ) {
							gtpClicked[0] = true;
							gtpColour[0] = 1;
							wrongAnswer ++;		
						}
						//button 2 (correct)
						else if (gtpCompletion == false && gtpClicked[1] == false && 18 < x && x < 416 && 257 < y && y < 306 ) {
							gtpClicked[1] = true;
							gtpColour[1] = 1;
							gtpCompletion = true;	
						}
						//button 3 (wrong)
						else if (gtpCompletion == false && gtpClicked[2] == false &&  18 < x && x < 416 && 357 < y && y < 406 ) {
							gtpClicked[2] = true;
							gtpColour[2] = 1;
							wrongAnswer++;
							
						}
						
						//button 4 (wrong)
						else if (gtpCompletion == false && gtpClicked[3] == false &&  18 < x && x < 416 && 457 < y && y < 506 ) {
							gtpClicked[3] = true;
							gtpColour[3] = 1;
							wrongAnswer ++;		
						}

						
						else if (gtpCompletion == true && gtpClicked[4] == false &&  474 < x && x < 673 && 619 < y && y < 667 ) {
							gtpClicked[4] = true;
							screenSetting = "menu";
							pyruvateShowing = true;
							
							
						}
					}
					
					//when in ATP screen
					if (screenSetting == "atp") {
						//button 1 (wrong)
						if (atpCompletion == false && atpClicked[0] == false && 18 < x && x < 416 && 157 < y && y < 206 ) {
							atpClicked[0] = true;
							atpColour[0] = 1;
							wrongAnswer ++;		
						}
						//button 2 (wrong)
						else if (atpCompletion == false && atpClicked[1] == false && 18 < x && x < 416 && 257 < y && y < 306 ) {
							atpClicked[1] = true;
							atpColour[1] = 1;
							wrongAnswer++;
						}
						//button 3 (correct)
						else if (atpCompletion == false && atpClicked[2] == false &&  18 < x && x < 416 && 357 < y && y < 406 ) {
							atpClicked[2] = true;
							atpColour[2] = 1;
							atpCompletion = true;
							
						}
						
						//button 4 (wrong)
						else if (atpCompletion == false && atpClicked[3] == false &&  18 < x && x < 416 && 457 < y && y < 506 ) {
							atpClicked[3] = true;
							atpColour[3] = 1;
							wrongAnswer ++;		
						}

						
						else if (atpCompletion == true && atpClicked[4] == false &&  474 < x && x < 673 && 619 < y && y < 667 ) {
							atpClicked[4] = true;
							screenSetting = "menu";
							pyruvateShowing = true;
							
							
						}
					}
					
					else if (screenSetting == "succinate") {
						//button 1 (wrong)
						if (succinateCompletion == false && succinateClicked[0] == false && 18 < x && x < 416 && 157 < y && y < 206 ) {
							succinateClicked[0] = true;
							succinateColour[0] = 1;
							wrongAnswer++;
						}
						//button 2 (wrong)
						else if (succinateCompletion == false && succinateClicked[1] == false && 18 < x && x < 416 && 257 < y && y < 306 ) {
							succinateClicked[1] = true;
							succinateColour[1] = 1;
							wrongAnswer ++;		
						}
						//button 3 (correct)
						else if (succinateCompletion == false && succinateClicked[2] == false && 18 < x && x < 416 && 357 < y && y < 406 ) {
							succinateClicked[2] = true;
							succinateColour[2] = 1;
							succinateCompletion = true;
							
						}
						
						//button 4 (wrong)
						else if (succinateCompletion == false && succinateClicked[3] == false  && 18 < x && x < 416 && 457 < y && y < 506 ) {
							succinateClicked[3] = true;
							succinateColour[3] = 1;
							wrongAnswer ++;		
						}
						//button 5 (correct)
						else if (succinateCompletion == false && succinateClicked[4] == false  && 18 < x && x < 416 && 557 < y && y < 606 ) {
							succinateClicked[4] = true;
							succinateColour[4] = 1;
							wrongAnswer++;
						}
						
						else if (succinateCompletion == true && succinateClicked[5] == false && 474 < x && x < 673 && 619 < y && y < 667 ) {
							succinateClicked[5] = true;
							screenSetting = "menu";
							pyruvateShowing = true;
							
							
						}
					}
					
					else if (screenSetting == "fad") {
						//button 1 (correct)
						if (fadCompletion == false &&fadClicked[0] == false && 18 < x && x < 416 && 157 < y && y < 206 ) {
							fadClicked[0] = true;
							fadColour[0] = 1;
							fadCompletion = true;	
						}
						//button 2 (wrong)
						else if (fadCompletion == false && fadClicked[1] == false && 18 < x && x < 416 && 257 < y && y < 306 ) {
							fadClicked[1] = true;
							fadColour[1] = 1;
							wrongAnswer++;
						}
						//button 3 (wrong)
						else if (fadCompletion == false && fadClicked[2] == false && 18 < x && x < 416 && 357 < y && y < 406 ) {
							fadClicked[2] = true;
							fadColour[2] = 1;
							wrongAnswer ++;
							
						}
						
					
						
						else if (fadCompletion == true && fadClicked[3] == false && 474 < x && x < 673 && 619 < y && y < 667 ) {
							fadClicked[3] = true;
							screenSetting = "menu";
							pyruvateShowing = true;
							
							
						}
					}
					
					//when in fadh2
					if (screenSetting == "fadh2") {
						//button 1 (wrong)
						if (fadh2Completion == false && fadh2Clicked[0] == false && 18 < x && x < 416 && 157 < y && y < 206 ) {
							fadh2Clicked[0] = true;
							fadh2Colour[0] = 1;
							wrongAnswer ++;		
						}
						//button 2 (correct)
						else if (fadh2Completion == false && fadh2Clicked[1] == false && 18 < x && x < 416 && 257 < y && y < 306 ) {
							fadh2Clicked[1] = true;
							fadh2Colour[1] = 1;
							fadh2Completion = true;	
						}
						//button 3 (wrong)
						else if (fadh2Completion == false && fadh2Clicked[2] == false &&  18 < x && x < 416 && 357 < y && y < 406 ) {
							fadh2Clicked[2] = true;
							fadh2Colour[2] = 1;
							wrongAnswer++;
							
						}
						
						//button 4 (wrong)
						else if (fadh2Completion == false && fadh2Clicked[3] == false &&  18 < x && x < 416 && 457 < y && y < 506 ) {
							fadh2Clicked[3] = true;
							fadh2Colour[3] = 1;
							wrongAnswer ++;		
						}

						
						else if (fadh2Completion == true && fadh2Clicked[4] == false &&  474 < x && x < 673 && 619 < y && y < 667 ) {
							fadh2Clicked[4] = true;
							screenSetting = "menu";
							pyruvateShowing = true;	
							
							
						}
					}
					
					else if (screenSetting == "fumarate") {
						//button 1 (wrong)
						if (fumarateCompletion == false && fumarateClicked[0] == false && 18 < x && x < 416 && 157 < y && y < 206 ) {
							fumarateClicked[0] = true;
							fumarateColour[0] = 1;
							wrongAnswer++;
						}
						//button 2 (wrong)
						else if (fumarateCompletion == false && fumarateClicked[1] == false && 18 < x && x < 416 && 257 < y && y < 306 ) {
							fumarateClicked[1] = true;
							fumarateColour[1] = 1;
							wrongAnswer ++;		
						}
						//button 3 (wrong)
						else if (fumarateCompletion == false && fumarateClicked[2] == false && 18 < x && x < 416 && 357 < y && y < 406 ) {
							fumarateClicked[2] = true;
							fumarateColour[2] = 1;
							wrongAnswer ++;	
							
						}
						
						//button 4 (correct)
						else if (fumarateCompletion == false && fumarateClicked[3] == false  && 18 < x && x < 416 && 457 < y && y < 506 ) {
							fumarateClicked[3] = true;
							fumarateColour[3] = 1;
							fumarateCompletion = true;
						}
						//button 5 (wrong)
						else if (fumarateCompletion == false && fumarateClicked[4] == false  && 18 < x && x < 416 && 557 < y && y < 606 ) {
							fumarateClicked[4] = true;
							fumarateColour[4] = 1;
							wrongAnswer++;
						}
						
						else if (fumarateCompletion == true && fumarateClicked[5] == false && 474 < x && x < 673 && 619 < y && y < 667 ) {
							fumarateClicked[5] = true;
							screenSetting = "menu";
							pyruvateShowing = true;
							
							
						}
					}
					
					else if (screenSetting == "nadplus2") {
						//button 1 (wrong)
						if (NADplus2Completion == false && NADplus2Clicked[0] == false && 18 < x && x < 416 && 157 < y && y < 206 ) {
							NADplus2Clicked[0] = true;
							NADplus2Colour[0] = 1;
							wrongAnswer ++;		
						}
						//button 2 (wrong)
						else if (NADplus2Completion == false && NADplus2Clicked[1] == false && 18 < x && x < 416 && 257 < y && y < 306 ) {
							NADplus2Clicked[1] = true;
							NADplus2Colour[1] = 1;
							wrongAnswer ++;
						}
						//button 3 (correct)
						else if (NADplus2Completion == false && NADplus2Clicked[2] == false && 18 < x && x < 416 && 357 < y && y < 406 ) {
							NADplus2Clicked[2] = true;
							NADplus2Colour[2] = 1;
							
							NADplus2Completion = true;
							
						}
						
					
						
						else if (NADplus2Completion == true && NADplus2Clicked[3] == false && 474 < x && x < 673 && 619 < y && y < 667 ) {
							NADplus2Clicked[3] = true;
							screenSetting = "menu";
							pyruvateShowing = true;	
							
							
						}
					}
					
					//when in first NADH = H+ screen
					if (screenSetting == "nadh2") {
						//button 1 (wrong)
						if (NADH2Completion == false && NADH2Clicked[0] == false && 18 < x && x < 416 && 157 < y && y < 206 ) {
							NADH2Clicked[0] = true;
							NADH2Colour[0] = 1;
							wrongAnswer ++;		
						}
						//button 2 (wrong)
						else if (NADH2Completion == false && NADH2Clicked[1] == false && 18 < x && x < 416 && 257 < y && y < 306 ) {
							NADH2Clicked[1] = true;
							NADH2Colour[1] = 1;
							wrongAnswer ++;		
						}
						//button 3 (wrong)
						else if (NADH2Completion == false && NADH2Clicked[2] == false &&  18 < x && x < 416 && 357 < y && y < 406 ) {
							NADH2Clicked[2] = true;
							NADH2Colour[2] = 1;
							
							wrongAnswer ++;	
							
						}
						
						//button 4 (correct)
						else if (NADH2Completion == false && NADH2Clicked[3] == false &&  18 < x && x < 416 && 457 < y && y < 506 ) {
							NADH2Clicked[3] = true;
							NADH2Colour[3] = 1;
							NADH2Completion = true;
						}

						
						else if (NADH2Completion == true && NADH2Clicked[4] == false &&  474 < x && x < 673 && 619 < y && y < 667 ) {
							NADH2Clicked[4] = true;
							screenSetting = "menu";
							pyruvateShowing = true;
							
							
						}
					}
					
					else if (screenSetting == "malate") {
						//button 1 (wrong)
						if (malateCompletion == false && malateClicked[0] == false && 18 < x && x < 416 && 157 < y && y < 206 ) {
							malateClicked[0] = true;
							malateColour[0] = 1;
							wrongAnswer++;
						}
						//button 2 (correct)
						else if (malateCompletion == false && malateClicked[1] == false && 18 < x && x < 416 && 257 < y && y < 306 ) {
							malateClicked[1] = true;
							malateColour[1] = 1;
							malateCompletion = true;
						}
						//button 3 (wrong)
						else if (malateCompletion == false && malateClicked[2] == false && 18 < x && x < 416 && 357 < y && y < 406 ) {
							malateClicked[2] = true;
							malateColour[2] = 1;
							wrongAnswer ++;	
							
						}
						
						//button 4 (wrong)
						else if (malateCompletion == false && malateClicked[3] == false  && 18 < x && x < 416 && 457 < y && y < 506 ) {
							malateClicked[3] = true;
							malateColour[3] = 1;
							wrongAnswer ++;	
						}
						//button 5 (wrong)
						else if (malateCompletion == false && malateClicked[4] == false  && 18 < x && x < 416 && 557 < y && y < 606 ) {
							malateClicked[4] = true;
							malateColour[4] = 1;
							wrongAnswer++;
						}
						
						else if (malateCompletion == true && malateClicked[5] == false && 474 < x && x < 673 && 619 < y && y < 667 ) {
							malateClicked[5] = true;
							screenSetting = "menu";
							pyruvateShowing = true;
							
							
						}
					}
					
					else if (screenSetting == "nadplus3") {
						//button 1 (correct)
						if (NADplus3Completion == false && NADplus3Clicked[0] == false && 18 < x && x < 416 && 157 < y && y < 206 ) {
							NADplus3Clicked[0] = true;
							NADplus3Colour[0] = 1;
							NADplus3Completion = true;
						}
						//button 2 (wrong)
						else if (NADplus3Completion == false && NADplus3Clicked[1] == false && 18 < x && x < 416 && 257 < y && y < 306 ) {
							NADplus3Clicked[1] = true;
							NADplus3Colour[1] = 1;
							wrongAnswer ++;
							
						}
						//button 3 (correct)
						else if (NADplus3Completion == false && NADplus3Clicked[2] == false && 18 < x && x < 416 && 357 < y && y < 406 ) {
							NADplus3Clicked[2] = true;
							NADplus3Colour[2] = 1;
							wrongAnswer ++;	
							
							
						}
						
					
						
						else if (NADplus3Completion == true && NADplus3Clicked[3] == false && 474 < x && x < 673 && 619 < y && y < 667 ) {
							NADplus3Clicked[3] = true;
							screenSetting = "menu";
							pyruvateShowing = true;
							
						}
					}
					
					//when in third NADH + H+ screen
					if (screenSetting == "nadh3") {
						//button 1 (wrong)
						if (NADH3Completion == false && NADH3Clicked[0] == false && 18 < x && x < 416 && 157 < y && y < 206 ) {
							NADH3Clicked[0] = true;
							NADH3Colour[0] = 1;
							wrongAnswer ++;		
						}
						//button 2 (wrong)
						else if (NADH3Completion == false && NADH3Clicked[1] == false && 18 < x && x < 416 && 257 < y && y < 306 ) {
							NADH3Clicked[1] = true;
							NADH3Colour[1] = 1;
							wrongAnswer ++;		
						}
						//button 3 (correct)
						else if (NADH3Completion == false && NADH3Clicked[2] == false &&  18 < x && x < 416 && 357 < y && y < 406 ) {
							NADH3Clicked[2] = true;
							NADH3Colour[2] = 1;
							NADH3Completion = true;
							
						}
						
						//button 4 (wrong)
						else if (NADH3Completion == false && NADH3Clicked[3] == false &&  18 < x && x < 416 && 457 < y && y < 506 ) {
							NADH3Clicked[3] = true;
							NADH3Colour[3] = 1;
							wrongAnswer ++;		
						}

						
						else if (NADH3Completion == true && NADH3Clicked[4] == false &&  474 < x && x < 673 && 619 < y && y < 667 ) {
							NADH3Clicked[4] = true;
							screenSetting = "menu";
							pyruvateShowing = true;
							
							
						}
					}
					
					else if (screenSetting == "oxaloacetate") {
						//button 1 (wrong)
						if (oxaloacetateCompletion == false && oxaloacetateClicked[0] == false && 18 < x && x < 416 && 157 < y && y < 206 ) {
							oxaloacetateClicked[0] = true;
							oxaloacetateColour[0] = 1;
							wrongAnswer++;
						}
						//button 2 (wrong)
						else if (oxaloacetateCompletion == false && oxaloacetateClicked[1] == false && 18 < x && x < 416 && 257 < y && y < 306 ) {
							oxaloacetateClicked[1] = true;
							oxaloacetateColour[1] = 1;
							wrongAnswer ++;	
						}
						//button 3 (correct)
						else if (oxaloacetateCompletion == false && oxaloacetateClicked[2] == false && 18 < x && x < 416 && 357 < y && y < 406 ) {
							oxaloacetateClicked[2] = true;
							oxaloacetateColour[2] = 1;
							
							oxaloacetateCompletion = true;
							
						}
						
						//button 4 (wrong)
						else if (oxaloacetateCompletion == false && oxaloacetateClicked[3] == false  && 18 < x && x < 416 && 457 < y && y < 506 ) {
							oxaloacetateClicked[3] = true;
							oxaloacetateColour[3] = 1;
							wrongAnswer ++;	
						}
						//button 5 (wrong)
						else if (oxaloacetateCompletion == false && oxaloacetateClicked[4] == false  && 18 < x && x < 416 && 557 < y && y < 606 ) {
							oxaloacetateClicked[4] = true;
							oxaloacetateColour[4] = 1;
							wrongAnswer++;
						}
						
						else if (oxaloacetateCompletion == true && oxaloacetateClicked[5] == false && 474 < x && x < 673 && 619 < y && y < 667 ) {
							oxaloacetateClicked[5] = true;
							screenSetting = "menu";
							pyruvateShowing = true;
							
							
						}
					}
					
					else if (screenSetting == "pyruvate") {
						//button 1 (wrong)
						if (pyruvateCompletion == false && pyruvateClicked[0] == false && 660 < x && x < 1060 && 157 < y && y < 206 ) {
							pyruvateClicked[0] = true;
							pyruvateColour[0] = 1;
							wrongAnswer++;
						}
						//button 2 (wrong)
						else if (pyruvateCompletion == false && pyruvateClicked[1] == false && 660 < x && x < 1060 && 257 < y && y < 306 ) {
							pyruvateClicked[1] = true;
							pyruvateColour[1] = 1;
							wrongAnswer ++;	
						}
						//button 3 (wrong)
						else if (pyruvateCompletion == false && pyruvateClicked[2] == false && 660 < x && x < 1060 && 357 < y && y < 406 ) {
							pyruvateClicked[2] = true;
							pyruvateColour[2] = 1;
							wrongAnswer++;
							
							
							
						}
						
						//button 4 (wrong)
						else if (pyruvateCompletion == false && pyruvateClicked[3] == false  && 660 < x && x < 1060 && 457 < y && y < 506 ) {
							pyruvateClicked[3] = true;
							pyruvateColour[3] = 1;
							wrongAnswer ++;	
						}
						//button 5 (correct)
						else if (pyruvateCompletion == false &&pyruvateClicked[4] == false  && 660 < x && x < 1060 && 557 < y && y < 606 ) {
							pyruvateClicked[4] = true;
							pyruvateColour[4] = 1;
							pyruvateCompletion = true;
						}
						
						else if (pyruvateCompletion == true && pyruvateClicked[5] == false && 474 < x && x < 673 && 619 < y && y < 667 ) {
							pyruvateClicked[5] = true;
							screenSetting = "menu";
							cacShowing = true;
							
							
						}
					}
					
					else if (screenSetting == "pco2") {
						//button 1 (correct)
						if (pco2Completion == false && pco2Clicked[0] == false && 660 < x && x < 1060 && 157 < y && y < 206 ) {
							pco2Clicked[0] = true;
							pco2Colour[0] = 1;
							pco2Completion = true;
						}
						//button 2 (wrong)
						else if (pco2Completion == false && pco2Clicked[1] == false && 660 < x && x < 1060 && 257 < y && y < 306 ) {
							pco2Clicked[1] = true;
							pco2Colour[1] = 1;
							wrongAnswer ++;	
						}
						//button 3 (wrong)
						else if (pco2Completion == false && pco2Clicked[2] == false && 660 < x && x < 1060 && 357 < y && y < 406 ) {
							pco2Clicked[2] = true;
							pco2Colour[2] = 1;
							wrongAnswer++;
							
							
							
						}
						
						
						else if (pco2Completion == true && pco2Clicked[3] == false && 474 < x && x < 673 && 619 < y && y < 667 ) {
							pco2Clicked[3] = true;
							screenSetting = "menu";
							cacShowing = true;
							
							
						}
					}
					
					else if (screenSetting == "coenzyme") {
						//button 1 (wrong)
						if (coenzymeCompletion == false && coenzymeClicked[0] == false && 660 < x && x < 1060 && 157 < y && y < 206 ) {
							coenzymeClicked[0] = true;
							coenzymeColour[0] = 1;
							
							wrongAnswer ++;	
						}
						//button 2 (correct)
						else if (coenzymeCompletion == false && coenzymeClicked[1] == false && 660 < x && x < 1060 && 257 < y && y < 306 ) {
							coenzymeClicked[1] = true;
							coenzymeColour[1] = 1;
							coenzymeCompletion = true;
						}
						//button 3 (wrong)
						else if (coenzymeCompletion == false && coenzymeClicked[2] == false && 660 < x && x < 1060 && 357 < y && y < 406 ) {
							coenzymeClicked[2] = true;
							coenzymeColour[2] = 1;
							wrongAnswer++;
							
							
							
						}
						
						
						else if (coenzymeCompletion == true && coenzymeClicked[3] == false && 474 < x && x < 673 && 619 < y && y < 667 ) {
							coenzymeClicked[3] = true;
							screenSetting = "menu";
							cacShowing = true;
							
							
						}
					}
					
					else if (screenSetting == "nadplusP") {
						//button 1 (correct)
						if (NADplusPCompletion == false && NADplusPClicked[0] == false && 660 < x && x < 1060 && 157 < y && y < 206 ) {
							NADplusPClicked[0] = true;
							NADplusPColour[0] = 1;
							NADplusPCompletion = true;
							
						}
						//button 2 (wrong)
						else if (NADplusPCompletion == false && NADplusPClicked[1] == false && 660 < x && x < 1060 && 257 < y && y < 306 ) {
							NADplusPClicked[1] = true;
							NADplusPColour[1] = 1;
							
							wrongAnswer ++;	
						}
						//button 3 (wrong)
						else if (NADplusPCompletion == false && NADplusPClicked[2] == false && 660 < x && x < 1060 && 357 < y && y < 406 ) {
							NADplusPClicked[2] = true;
							NADplusPColour[2] = 1;
							wrongAnswer++;
							
							
							
						}
						
						
						else if (NADplusPCompletion == true && NADplusPClicked[3] == false && 474 < x && x < 673 && 619 < y && y < 667 ) {
							NADplusPClicked[3] = true;
							screenSetting = "menu";
							cacShowing = true;
							
							
						}
					}
					
					//when in pyruvate NADH screen
					if (screenSetting == "nadhP") {
						//button 1 (wrong)
						if (NADHPCompletion == false && NADHPClicked[0] == false && 660 < x && x < 1060 && 157 < y && y < 206 ) {
							NADHPClicked[0] = true;
							NADHPColour[0] = 1;
							wrongAnswer ++;		
						}
						//button 2 (wrong)
						else if (NADHPCompletion == false && NADHPClicked[1] == false && 660 < x && x < 1060 && 257 < y && y < 306 ) {
							NADHPClicked[1] = true;
							NADHPColour[1] = 1;
							wrongAnswer ++;		
						}
						//button 3 (wrong)
						else if (NADHPCompletion == false && NADHPClicked[2] == false &&  660 < x && x < 1060 && 357 < y && y < 406 ) {
							NADHPClicked[2] = true;
							NADHPColour[2] = 1;
							
							wrongAnswer ++;	
							
						}
						
						//button 4 (correct)
						else if (NADHPCompletion == false && NADHPClicked[3] == false &&  660 < x && x < 1060 && 457 < y && y < 506 ) {
							NADHPClicked[3] = true;
							NADHPColour[3] = 1;
							NADHPCompletion = true;
						}

						
						else if (NADHPCompletion == true && NADHPClicked[4] == false &&  474 < x && x < 673 && 619 < y && y < 667 ) {
							NADHPClicked[4] = true;
							screenSetting = "menu";
							cacShowing = true;
							
							
						}
					}
					
					//when youre in acetly coa
					if (screenSetting == "acetylcoaP") {
						//button 1 (wrong)
						if (acetylCoAPCompletion == false && acetylCoAPClicked[0] == false && 660 < x && x < 1060 && 157 < y && y < 206 ) {
							acetylCoAPClicked[0] = true;
							acetylCoAPColour[0] = 1;
							wrongAnswer ++;		
						}
						//button 2 (wrong)
						else if (acetylCoAPCompletion == false && acetylCoAPClicked[1] == false && 660 < x && x < 1060 && 257 < y && y < 306 ) {
							acetylCoAPClicked[1] = true;
							acetylCoAPColour[1] = 1;
							wrongAnswer ++;		
						}
						//button 3 (correct)
						else if (acetylCoAPCompletion == false && acetylCoAPClicked[2] == false &&  660 < x && x < 1060 && 357 < y && y < 406 ) {
							acetylCoAPClicked[2] = true;
							acetylCoAPColour[2] = 1;
							acetylCoAPCompletion = true;
							
						}
						
						//button 4 (wrong)
						else if (acetylCoAPCompletion == false && acetylCoAPClicked[3] == false &&  660 < x && x < 1060 && 457 < y && y < 506 ) {
							acetylCoAPClicked[3] = true;
							acetylCoAPColour[3] = 1;
							wrongAnswer ++;		
						}
						//button 5 (wrong)
						else if (acetylCoAPCompletion == false && acetylCoAPClicked[4] == false &&  660 < x && x < 1060 && 557 < y && y < 606 ) {
							acetylCoAPClicked[4] = true;
							acetylCoAPColour[4] = 1;
							wrongAnswer ++;		
						}
						
						else if (acetylCoAPCompletion == true && acetylCoAPClicked[5] == false &&  474 < x && x < 673 && 619 < y && y < 667 ) {
							acetylCoAPClicked[5] = true;
							screenSetting = "menu";
							cacShowing = true;
								
							
							
						}
					}
					
					if(menuContinueShown == false && acetylCoAClicked[5] && citrateClicked[5] && isocitrateClicked[5] && NADplus1Clicked[3] && NADH1Clicked[4]
							&& aketoglutarateClicked[5] && NADplus2Clicked[3] && NADH2Clicked[4] && succinylcoaClicked[5] 
							&& gtpClicked[4] && atpClicked[4] && succinateClicked[5] && fadClicked[3] && fadh2Clicked[4]
							&& fumarateClicked[5] && malateClicked[5] && NADplus3Clicked[3] && NADH3Clicked[4] && oxaloacetateClicked[5]
							&& pyruvateClicked[5] && pco2Clicked[3] && coenzymeClicked[3] && NADplusPClicked[3] && NADHPClicked[4]
							&& acetylCoAPClicked[5]) {
						menuContinueShown = true;
						menuContinueClicked = false;
					}
					
					if (menuContinueClicked == false && menuContinueShown &&  961 < x && x < 1170 && 587 < y && y < 653) {
						menuContinueClicked = true;
						
						question1 = true;
						
						cacShowing = false;
						pyruvateShowing = false;
					}
					
					if (question1) {
						
						screenSetting = "question1";
						
						if (question1Completion == false && question1Clicked[0] == false && 530 < x && x < 598 && 138 < y && y < 208) {//button 1 (wrong)
							question1Clicked[0] = true;
							question1Colour[0] = 1;
							wrongAnswer++;
						}
						
						else if (question1Completion == false && question1Clicked[1] == false && 530 < x && x < 598 && 238 < y && y < 308) {//button 2 (correct)
							question1Clicked[1] = true;
							question1Colour[1] = 1;
							question1Completion = true;
						}
						
						else if (question1Completion == false && question1Clicked[2] == false && 530 < x && x < 598 && 338 < y && y < 408) {//button 3 (wrong)
							question1Clicked[2] = true;
							question1Colour[2] = 1;
							wrongAnswer++;
						}
						
						else if (question1Completion == false && question1Clicked[3] == false && 530 < x && x < 598 && 438 < y && y < 508) {//button 4 (wrong)
							question1Clicked[3] = true;
							question1Colour[3] = 1;
							wrongAnswer++;
						}
						
						else if (question1Completion == false && question1Clicked[4] == false && 530 < x && x < 598 && 538 < y && y < 608) {//button 5 (wrong)
							question1Clicked[4] = true;
							question1Colour[4] = 1;
							wrongAnswer++;
						}
						
						else if (question1Completion == true && question1Clicked[5] == false &&  474 < x && x < 673 && 619 < y && y < 667 ) {
							acetylCoAPClicked[5] = true;
							question1 = false;
							question2 = true;
						
						}
					}
					
					else if (question2) {
						screenSetting = "question2";
						
						if (question2Completion == false && question2Clicked[0] == false && 530 < x && x < 598 && 138 < y && y < 208) {//button 1 (wrong)
							question2Clicked[0] = true;
							question2Colour[0] = 1;
							wrongAnswer++;
						}
						
						else if (question2Completion == false && question2Clicked[1] == false && 530 < x && x < 598 && 238 < y && y < 308) {//button 2 (correct)
							question2Clicked[1] = true;
							question2Colour[1] = 1;
							question2Completion = true;
						}
						
						else if (question2Completion == false && question2Clicked[2] == false && 530 < x && x < 598 && 338 < y && y < 408) {//button 3 (wrong)
							question2Clicked[2] = true;
							question2Colour[2] = 1;
							wrongAnswer++;
						}
						
						else if (question2Completion == false && question2Clicked[3] == false && 530 < x && x < 598 && 438 < y && y < 508) {//button 4 (wrong)
							question2Clicked[3] = true;
							question2Colour[3] = 1;
							wrongAnswer++;
						}
						
						else if (question2Completion == false && question2Clicked[4] == false && 530 < x && x < 598 && 538 < y && y < 608) {//button 5 (wrong)
							question2Clicked[4] = true;
							question2Colour[4] = 1;
							wrongAnswer++;
						}
						
						else if (question2Completion == true && question2Clicked[5] == false &&  474 < x && x < 673 && 619 < y && y < 667 ) {
							acetylCoAPClicked[5] = true;
							question2 = false;
							question3 = true;
						
						}
					}
					
					else if (question3) {
						screenSetting = "question3";
						
						if (question3Completion == false && question3Clicked[0] == false && 530 < x && x < 598 && 138 < y && y < 208) {//button 1 (wrong)
							question3Clicked[0] = true;
							question3Colour[0] = 1;
							wrongAnswer++;
						}
						
						else if (question3Completion == false && question3Clicked[1] == false && 530 < x && x < 598 && 238 < y && y < 308) {//button 2 (correct)
							question3Clicked[1] = true;
							question3Colour[1] = 1;
							question3Completion = true;
						}
						
						else if (question3Completion == false && question3Clicked[2] == false && 530 < x && x < 598 && 338 < y && y < 408) {//button 3 (wrong)
							question3Clicked[2] = true;
							question3Colour[2] = 1;
							wrongAnswer++;
						}
						
						else if (question3Completion == false && question3Clicked[3] == false && 530 < x && x < 598 && 438 < y && y < 508) {//button 4 (wrong)
							question3Clicked[3] = true;
							question3Colour[3] = 1;
							wrongAnswer++;
						}
						
						else if (question3Completion == false && question3Clicked[4] == false && 530 < x && x < 598 && 538 < y && y < 608) {//button 5 (wrong)
							question3Clicked[4] = true;
							question3Colour[4] = 1;
							wrongAnswer++;
						}
						
						else if (question3Completion == true && question3Clicked[5] == false &&  474 < x && x < 673 && 619 < y && y < 667 ) {
							acetylCoAPClicked[5] = true;
							question3 = false;
							question4 = true;
						
						}
					}
					
					else if (question4) {
						screenSetting = "question4";
						
						if (question4Completion == false && question4Clicked[0] == false && 530 < x && x < 598 && 138 < y && y < 208) {//button 1 (wrong)
							question4Clicked[0] = true;
							question4Colour[0] = 1;
							wrongAnswer++;
						}
						
						else if (question4Completion == false && question4Clicked[1] == false && 530 < x && x < 598 && 238 < y && y < 308) {//button 2 wrong)
							question4Clicked[1] = true;
							question4Colour[1] = 1;
							wrongAnswer++;
						}
						
						else if (question4Completion == false && question4Clicked[2] == false && 530 < x && x < 598 && 338 < y && y < 408) {//button 3 (correct)
							question4Clicked[2] = true;
							question4Colour[2] = 1;
							
							question4Completion = true;
						}
						
						else if (question4Completion == false && question4Clicked[3] == false && 530 < x && x < 598 && 438 < y && y < 508) {//button 4 (wrong)
							question4Clicked[3] = true;
							question4Colour[3] = 1;
							wrongAnswer++;
						}
						
						else if (question4Completion == false && question4Clicked[4] == false && 530 < x && x < 598 && 538 < y && y < 608) {//button 5 (wrong)
							question4Clicked[4] = true;
							question4Colour[4] = 1;
							wrongAnswer++;
						}
						
						else if (question4Completion == true && question4Clicked[5] == false &&  474 < x && x < 673 && 619 < y && y < 667 ) {
							acetylCoAPClicked[5] = true;
							question4 = false;
							question5 = true;
						
						}
					}
					
					else if (question5) {
						screenSetting = "question5";
						
						if (question5Completion == false && question5Clicked[0] == false && 530 < x && x < 598 && 138 < y && y < 208) {//button 1 (correct)
							question5Clicked[0] = true;
							question5Colour[0] = 1;
							
							question5Completion = true;
						}
						
						else if (question5Completion == false && question5Clicked[1] == false && 530 < x && x < 598 && 238 < y && y < 308) {//button 2 wrong)
							question5Clicked[1] = true;
							question5Colour[1] = 1;
							wrongAnswer++;
						}
						
						else if (question5Completion == false && question5Clicked[2] == false && 530 < x && x < 598 && 338 < y && y < 408) {//button 3 (wrong)
							question5Clicked[2] = true;
							question5Colour[2] = 1;
							wrongAnswer++;
							
						}
						
						else if (question5Completion == false && question5Clicked[3] == false && 530 < x && x < 598 && 438 < y && y < 508) {//button 4 (wrong)
							question5Clicked[3] = true;
							question5Colour[3] = 1;
							wrongAnswer++;
						}
						
						else if (question5Completion == false && question5Clicked[4] == false && 530 < x && x < 598 && 538 < y && y < 608) {//button 5 (wrong)
							question5Clicked[4] = true;
							question5Colour[4] = 1;
							wrongAnswer++;
						}
						
						else if (question5Completion == true && question5Clicked[5] == false &&  474 < x && x < 673 && 619 < y && y < 667 ) {
							acetylCoAPClicked[5] = true;
							question5 = false;
							question6 = true;
						
						}
					}
					
					else if (question6) {
						screenSetting = "question6";
						
						if (question6Completion == false && question6Clicked[0] == false && 530 < x && x < 598 && 138 < y && y < 208) {//button 1 (correct)
							question6Clicked[0] = true;
							question6Colour[0] = 1;
							
							question6Completion = true;
						}
						
						else if (question6Completion == false && question6Clicked[1] == false && 530 < x && x < 598 && 238 < y && y < 308) {//button 2 wrong)
							question6Clicked[1] = true;
							question6Colour[1] = 1;
							wrongAnswer++;
						}
						
						else if (question6Completion == false && question6Clicked[2] == false && 530 < x && x < 598 && 338 < y && y < 408) {//button 3 (wrong)
							question6Clicked[2] = true;
							question6Colour[2] = 1;
							wrongAnswer++;
							
						}
						
						else if (question6Completion == false && question6Clicked[3] == false && 530 < x && x < 598 && 438 < y && y < 508) {//button 4 (wrong)
							question6Clicked[3] = true;
							question6Colour[3] = 1;
							wrongAnswer++;
						}
						
						else if (question6Completion == false && question6Clicked[4] == false && 530 < x && x < 598 && 538 < y && y < 608) {//button 5 (wrong)
							question6Clicked[4] = true;
							question6Colour[4] = 1;
							wrongAnswer++;
						}
						
						else if (question6Completion == true && question6Clicked[5] == false &&  474 < x && x < 673 && 619 < y && y < 667 ) {
							acetylCoAPClicked[5] = true;
							question6 = false;
							gameOver = true;
							
						
						}
					}
					
					

					
				}
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// repaint window every FRAME
		repaint();
		
		
		
	
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
