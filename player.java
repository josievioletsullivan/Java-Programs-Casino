package Casino;
import java.util.ArrayList;
public abstract class player {
    ArrayList<Card> hand = new ArrayList<Card>();
    public player(){
        
    }
    int handValue(){
        int handValue = 0;
        for(int x = 0; x<hand.size(); x++){
                handValue += hand.get(x).face;
            }
        return handValue;
    }
    void hit(Deck cardDeck){
        hand.add(cardDeck.deck.get(cardDeck.deck.size()-1));
        cardDeck.deck.remove(cardDeck.deck.size()-1);
    }
    boolean stand = false;
}
