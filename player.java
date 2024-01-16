
// Importing library for ArrayList
import java.util.ArrayList;

// This is an abstract class to represent a player in the game. It is extended by the RealPlayer class.
public abstract class player {
    // Create an ArrayList to represent the player's hand of cards
    ArrayList<Card> hand = new ArrayList<Card>();

    // This is a default constructor for the player class
    public player() {
        // Constructor body (empty in this case)
    }

    // This Method to calculates the value of the player's hand
    int handValue() {
        int handValue = 0;
        // Loop through the player's hand and calculate the total value
        for (int x = 0; x < hand.size(); x++) {
            handValue += hand.get(x).face + 2;
        }
        return handValue;
    }

    // This method is for when a player to draws a card (hit)
    void hit(ArrayList hand, ArrayList deck) {
        // Add the top card from the deck to the player's hand
        hand.add(0, deck.get(deck.size() - 1));
        // Remove the added card from the deck
        deck.remove(deck.size() - 1);
    }

    // This method to checks if the player has busted (hand value > 21)
    void didTheyBust() {
        if (handValue() > 21) {
            // Code in real class will end the game to take if the player has busted
        }
    }

    // Declare a variable to track whether the player chose to stand
    boolean stand = false;

    // Create an abstract method representing the player's turn in the game
    abstract void turn(ArrayList deck);
}
