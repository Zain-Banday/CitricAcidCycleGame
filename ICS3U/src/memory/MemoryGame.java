package memory;

import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MemoryGame implements ActionListener {

	// Set up an ImageIcon to represent the "back" pattern of the card.
	// We use this picture a lot.

	ImageIcon backOfCard = new ImageIcon(
			"C:\\Users\\bandzai929\\OneDrive - Bluewater District School Board\\Workspace\\Memory Game Assets\\backSide.png");

	final int GAME_SIZE = 16; // constant to represent the number of cards used in game.
								// this needs to be a square number and even!

	String[] pictureNames = { "drake.jpg", "drake.jpg", "kanye west.jpg", "kanye west.jpg", "playboi carti.jpg",
			"playboi carti.jpg", "Travis Scott.jpeg", "Travis Scott.jpeg", "Tyler The Creator.jpg",
			"Tyler The Creator.jpg", "kendrick.jpg", "kendrick.jpg", "future.jfif", "future.jfif", "lil uzi.jfif",
			"lil uzi.jfif" };

	JButton[] cards; // hold the button object in an array.

	int numCardsFlipped; // this is an integer that tells us number of CURRENT

	// cards that have been flipped this turn. (always 0, 1 or 2)

	int lastIndex1, lastIndex2; // keeps track of the two indices of cards being turned over to check

	private JPanel myPanel;

	public static void main(String[] args) {

		MemoryGame gui = new MemoryGame();

		gui.go();

	}

	public void go() {

		numCardsFlipped = 0;

		lastIndex1 = -1; // just set to some default values.

		lastIndex2 = -1;

		cards = new JButton[GAME_SIZE]; // array to store buttons

		JFrame frame = new JFrame("Memory Game");

		frame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {

				System.exit(0);

			}

		});

		frame.setSize(600, 600);

		myPanel = (JPanel) frame.getContentPane();

		myPanel.setLayout(new GridLayout(4, 4));

		shuffleCards();

		createButtons();

		frame.setVisible(true);

	}

	private void createButtons() {

		// this method creates all of the cards/buttons, adds them to the cards[] array

		// it also sets the name of each card (to its location) and gives each card the

		// "back" image (to start).

		// HERE WE CREATE ONE JBUTTON. NEED 16 of these.

		for (int i = 0; i < GAME_SIZE; i++) {

			JButton button = new JButton(); // create first button

			button.addActionListener(this); // add action listener

			button.setIcon(backOfCard); // set its image to back of card

			// for testing only

			// ImageIcon testCard = new ImageIcon(pictureNames[i]);

			// button.setIcon(testCard);

			myPanel.add(button); // add it to myPanel.

			button.setName(Integer.toString(i)); // "name" the button 0

			cards[i] = button; // add it to the array

		}

	}

	private void shuffleCards() {

		int randNum;

		String temp;

		for (int i = 0; i < GAME_SIZE; i++)

		{

			randNum = (int) (Math.random() * GAME_SIZE);

			temp = pictureNames[i];

			pictureNames[i] = pictureNames[randNum];

			pictureNames[randNum] = temp;

		}

	}

	private boolean isMatch(int prev, int current) {

		// this method returns true if the two integers represent cards

		// with the same picture

		boolean result = false;

		if (pictureNames[prev] == pictureNames[current])

			result = true;

		return result;

	}

	public void actionPerformed(ActionEvent e) {

		if (numCardsFlipped == 2) {

			if (!isMatch(lastIndex1, lastIndex2)) {

				cards[lastIndex1].setIcon(backOfCard);

				cards[lastIndex2].setIcon(backOfCard);

			}

			numCardsFlipped = 0;

		}

		// method called when any button (with an ActionListener) is pushed

		JButton pressed = (JButton) e.getSource();

		// determine what button pressed

		String cardName = pressed.getName();

		int index = Integer.parseInt(cardName);

		// index now tells us the index or location of the card clicked.

		ImageIcon card = new ImageIcon(pictureNames[index]);

		pressed.setIcon(card);

		// System.out.println(index); // for TESTING - can remove later

		if (numCardsFlipped == 0)

			lastIndex1 = index;

		else

			lastIndex2 = index;

		numCardsFlipped++;

	}

}
