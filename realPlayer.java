// Importing library for ArrayList
import java.util.ArrayList;

// The realPlayer class extends the abstract player class
public class realPlayer extends player {
    // Declare instance variables for player's balance and wager
    int balance;
    int wager;

    // Constructor for the realPlayer class
    public realPlayer() {
        // Initialize the player's balance to 1000 to start
        balance = 1000;
    }

    // Ask the player to make a wager
    void makeWager(int input) {
        // Set the wager to the specified input value
        wager = input;
        // Decrease the player's balance by the wager amount
        balance -= input;
    }

    // This method is for when the player to doubles down
    boolean doubleDown(ArrayList deck) {
        // Draw a card (hit) from the deck
        hit(hand, deck);
        // Double the wager
        wager *= 2;
        // Return the stand status
        return stand;
    }

    // This method is for the player to surrender
    boolean surrender() {
        // Reset the wager to 0
        wager = 0;
        // Return the stand status
        return stand;
    }

    // This method represents the player's turn in the game
    void turn(ArrayList deck) {
        // Declare a variable to control the gameplay loop
        boolean gamePlay = true;

        // Make an initial wager (replace 100 with inputDevice.nextInt();)
        makeWager(100);

        // Gameplay loop
        while (gamePlay == true) {
            switch (1) { // Input will be implemented later
                case 1:
                    hit(hand, deck);
                    break;
                case 2:
                    gamePlay = stand;
                    break;
                case 3:
                    doubleDown(deck);
                    break;
                // We removed split; it would be option # 4
                case 5:
                    gamePlay = surrender();
                    break;
            }
            // Check if the player's hand value exceeds 21
            if (handValue() > 21) {
                gamePlay = false;
            }
        }
    }
}
