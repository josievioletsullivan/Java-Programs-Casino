import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class main {
    private static realPlayer user = new realPlayer();
    private static house mrHouse = new house();
    static ArrayList<Card> deck = new ArrayList<>();
    private static JTextArea textArea;
    static void createDeck(){
        //creates the deck by adding 52 cards
        for(int x = 0; x<13; x++){
            for(int y = 0; y < 4; y++){
                deck.add(new Card(y,x));
            }
        }
    }
    public static void main(String[] args) {
        createDeck();
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Blackjack Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel buttonPanel = createButtonPanel();
        frame.add(buttonPanel, BorderLayout.SOUTH);

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private static JPanel createButtonPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 4));

        JButton hitButton = new JButton("Hit");
        JButton standButton = new JButton("Stand");
        JButton doubleDownButton = new JButton("Double Down");
        JButton surrenderButton = new JButton("Surrender");

        panel.add(hitButton);
        panel.add(standButton);
        panel.add(doubleDownButton);
        panel.add(surrenderButton);

        // Add action listeners to buttons
        hitButton.addActionListener(e -> hitButton("Hit"));
        standButton.addActionListener(e -> standButton("Stand"));
        doubleDownButton.addActionListener(e -> doubleDownButton("Double Down"));
        surrenderButton.addActionListener(e -> surrenderButton("Surrender"));

        return panel;
    }

    private static void hitButton(String action) {
        user.hit(user.hand,deck);
        textArea.append(action + "! Your card total is now " +user.handValue()+ "\n");
    }
    private static void standButton(String action) {
        //TODO: make user.stand toggle the game ending
        textArea.append(action + "! Your card total is now " +user.handValue()+ "\n");
    }
    private static void doubleDownButton(String action) {
        user.doubleDown(deck);
        textArea.append(action + "! Your card total is now " +user.handValue()+ "\n");
    }
    private static void surrenderButton(String action) {
        user.surrender();
        textArea.append(action + "! Your card total is now " +user.handValue()+ "\n");
    }
    // Rest of your code remains unchanged
    // ...
}
