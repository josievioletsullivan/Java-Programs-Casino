import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlackjackGUI extends JFrame {

    private JLabel playerLabel, dealerLabel, resultLabel;
    private JButton hitButton, standButton;
    private int playerScore, dealerScore;

    public BlackjackGUI() {
        setTitle("Blackjack GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        playerLabel = new JLabel("Player Score: 0");
        dealerLabel = new JLabel("Dealer Score: 0");
        resultLabel = new JLabel("Result: ");

        hitButton = new JButton("Hit");
        standButton = new JButton("Stand");

        hitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerScore += drawCard();
                updateScores();
                checkGameOver();
            }
        });

        standButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dealerPlay();
                checkWinner();
            }
        });

        add(playerLabel);
        add(dealerLabel);
        add(resultLabel);
        add(hitButton);
        add(standButton);
    }

    private int drawCard() {
        // Simulate drawing a card
        return (int) (Math.random() * 11) + 1;
    }

    private void updateScores() {
        playerLabel.setText("Player Score: " + playerScore);
        dealerLabel.setText("Dealer Score: " + dealerScore);
    }

    private void dealerPlay() {
        // Simulate dealer's play
        while (dealerScore < 17) {
            dealerScore += drawCard();
            updateScores();
        }
    }

    private void checkGameOver() {
        if (playerScore > 21) {
            resultLabel.setText("Result: Player Bust! Dealer Wins.");
            disableButtons();
        }
    }

    private void checkWinner() {
        if (dealerScore > 21 || playerScore > dealerScore) {
            resultLabel.setText("Result: Player Wins!");
        } else if (dealerScore > playerScore) {
            resultLabel.setText("Result: Dealer Wins.");
        } else {
            resultLabel.setText("Result: It's a Tie!");
        }

        disableButtons();
    }

    private void disableButtons() {
        hitButton.setEnabled(false);
        standButton.setEnabled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BlackjackGUI().setVisible(true);
            }
        });
    }
}
