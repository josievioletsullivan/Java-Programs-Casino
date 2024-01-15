import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class main {
    private static realPlayer user = new realPlayer();
    static ArrayList<Card> deck = new ArrayList<>();
    private static house mrHouse = new house();
    private static JLabel playerBalance; //This block of code was instructed by chatGPT. I originally had these within the JFrame, and couldn't figure
    private static JLabel playerWager; // out how to get them to update
    private static JLabel playerHand;
    private static JLabel HouseHand;
    private static JTextArea textArea;
    static void createDeck(){
        //creates the deck by adding 52 cards
        for(int x = 0; x<12; x++){ //12 Faces
            for(int y = 0; y < 4; y++){ //4 Suits
                deck.add(new Card(y,x));
            }
            Collections.shuffle(deck); //shuffling with collections because I don't want to write a shuffler --Will
        }
    }
    public static void main(String[] args) {
        createDeck();
        mrHouse.hit(mrHouse.hand, deck);
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

        JPanel labelPanel = createLabelPanel();
        frame.add(labelPanel, BorderLayout.EAST);

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    private static JPanel createLabelPanel(){
        JPanel panel = new JPanel(new GridLayout(4, 1));

        playerBalance = new JLabel("Balance: "+user.balance+" chips");
        playerWager = new JLabel("Wager: "+user.wager+" chips");
        playerHand = new JLabel("Hand Value: "+user.handValue());;
        HouseHand = new JLabel("House Card: "+mrHouse.hand.get(0).getCardName());

        panel.add(playerBalance);
        panel.add(playerWager);
        panel.add(playerHand);
        panel.add(HouseHand);
        return panel;
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
    private void updateLabels(){
        SwingUtilities.invokeLater(() -> { //This was also instructed by chatGPT. I had no clue about invokeLater, and this came up in my quest to find out
        playerBalance.setText("Balance: "+user.balance+" chips"); //how to update individual components of the GUI
        playerWager.setText("Wager: "+user.wager+" chips");
        playerHand.setText("Hand Value: "+user.handValue());
        HouseHand.setText("House Card: "+mrHouse.hand.get(0).getCardName());
        });
    }
    private static void hitButton(String action) {
        user.hit(user.hand,deck);
        textArea.append(action + "! You drew "+ user.hand.get(0).getCardName()+ "\n");
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
}
