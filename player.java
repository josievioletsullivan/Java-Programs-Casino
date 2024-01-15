
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
    void hit(ArrayList hand, ArrayList deck){
        hand.add(0,deck.get(deck.size()-1));
        deck.remove(deck.size()-1);
        
    }
    void didTheyBust(){
        if (handValue()>21) {
            
        }
    }
    boolean stand = false;
    abstract void turn(ArrayList deck);
}
