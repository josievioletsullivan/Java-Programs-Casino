// Import GUI libraries
import java.awt.*;
import javax.swing.*;

// The Screen class extends JFrame to create a GUI window
public class Screen extends JFrame {
    // Set variables for screen dimensions
    static int screenHeight;
    static int screenWidth;
    // Declare the of boxes for game options
    int boxCount = 4;
    // Create labels for each game option using an array of Strings
    String[] boxLabels = {"Hit", "Stand", "Double Down", "Surrender"};
    // Create an array of buttons for game options
    JButton[] Buttons = new JButton[boxCount];
    // Create a JPanel object for GUI components
    JPanel pnl = new JPanel();
    // Set the background color for the GUI to dark green using RGB
    Color colorBackground = new Color(39, 119, 20);

    // Constructor for the Screen class
    public Screen() {
        // Set screen dimensions. These may be altered if wished.
	// This constructor follows the same steps as the board constructor in the CardGUI class.
        screenHeight = 500;
        screenWidth = 1000;
        setSize(Screen.screenWidth, Screen.screenHeight);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        Board board = new Board();
        setContentPane(board);
        gameStartScreen();
    }

    // This method to creates buttons for game options
    void createBoxes() {
        for (int i = 0; i < boxCount; i++) {
            Buttons[i] = new JButton(boxLabels[i]);
            Buttons[i].setBounds(0, 0, screenWidth, screenHeight);
            add(Buttons[i], i * 100, i);
        }
    }

    // This method to redraws the screen when an event happens
    void redraw() {
        removeAll();
        revalidate();
        repaint();
    }

    // This method draws the start screen for the game 
    void gameStartScreen() {
	// prompt the user to input a value they want to wager
        JLabel wager = new JLabel("How much do you want to wager?");
        JTextField wagField = new JTextField(12);
        add(wager);
        add(wagField);
    }

    // This method creates for the game play screen
    void gamePlayScreen(realPlayer P, house H) {
        for (int i = 0; i < P.hand.size(); i++) {
            // Creates a card at low position
        }
        for (int i = 0; i < H.hand.size(); i++) {
            // Creates a card at high position
        }
    }

    // Board class represents the game board and extends JPanel. This follows a youtube tutorial by a channel named Jon (episode 2).
    public class Board extends JPanel {
        // This method overrides the paintComponent method for custom drawing
        public void paintComponent(Graphics g) {
            setLayout(null);
            // Setting the background color
            g.setColor(colorBackground);
            g.fillRect(0, 0, screenWidth, screenHeight);
        }
    }
}
