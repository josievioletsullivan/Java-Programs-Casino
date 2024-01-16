// Import GUI tools to use the mouse and create graphics
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

// The CardGUI class extends JFrame to create a GUI 
public class CardGUI extends JFrame {
    // These variables set the screen dimensions. They are arbitrary and may be changed to your liking.
    static int screenHeight = 500;
    static int screenWidth = 1000;
    
    // Create a JPanel for the GUI components
    JPanel pnl = new JPanel();
    // This sets the background color for the GUI using RGB (this is a dark green)
    Color colorBackground = new Color(39, 119, 20);

    // Create a constructor for the CardGUI class
    public CardGUI() {
	// sets the size of the GUI
        setSize(CardGUI.screenWidth, CardGUI.screenHeight);
	// sets visibility to true
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
	// Create an object of the board class
        Board board = new Board();
        setContentPane(board);
    }

    // This method redraws the screen. 
        removeAll();
        revalidate();
        repaint();
        // This method is called when an event happens, it clears and redraws the screen.
    }

    // This Board class represents the game board and extends JPanel
    public class Board extends JPanel {
        // Create a constructor for the Board class
        public Board() {
            // Create card objects and add their displays to Board 
            Card clubTwo = new Card(2, 0);
            CardDisplay cardDisplay = new CardDisplay(clubTwo);
            this.add(cardDisplay);
            Card clubFour = new Card(2, 3);
            CardDisplay cardDisplay2 = new CardDisplay(clubFour);
            this.add(cardDisplay2);
        }

        // This method overrides the paintComponent method to use custom drawing
        public void paintComponent(Graphics g) {
            setLayout(new FlowLayout());
            // Setting the background color and fills the panel
            g.setColor(colorBackground);
            g.fillRect(0, 0, screenWidth, screenHeight);
        }
    }

    // The CardDisplay class represents the display of a card and extends JPanel
    public class CardDisplay extends JPanel {
        // Static variables for card dimensions. The card is an arbitrary size and can be changed.
        static int cardHeight = 400;
        static int cardWidth = 200;
	// This is an instance variable of a card
        private Card card;

        // This is the constructor for the CardDisplay class
        public CardDisplay(Card card) {
	// set the card variable equal to the instance variable
            this.card = card;
	// set the dimensions of the card
            setPreferredSize(new Dimension(cardWidth, cardHeight));
	// introduce the MouseListener function to the class
            this.addMouseListener(new MouseHandler());
        }

        // This method overrides the paintComponent method for custom drawing
        public void paintComponent(Graphics g) {
            setLayout(null);
            // This draws the card background. It makes the card white and the display of the card value black.
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, cardWidth, cardHeight);
            g.setColor(Color.BLACK);

            // Draw the card name on the display using an array of character variables
            char[] chars = card.getCardName().toCharArray();
            g.drawChars(chars, 0, chars.length, 20, 50);
        }

        // This class for handles mouse events so the user can interact with the cards through a click
        private class MouseHandler extends MouseAdapter {
            public void mouseClicked(MouseEvent me) {
                // This displays a message when the card is clicked
                JOptionPane.showMessageDialog(null, "Clicked the " + card.getCardName() + "!");
            }
        }
    }

    // This is the main method for running the application
    public static void main(String args[]) {
        // Setting the look and feel for the GUI
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Creating and displaying the CardGUI form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CardGUI().setVisible(true);
            }
        });
    }
}
