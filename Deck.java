package Casino;
import java.util.ArrayList;
public class Deck {
    ArrayList<Card> deck = new ArrayList<Card>();
    public Deck(){
        //creates the deck by adding 52 cards
        for(int x = 0; x<13; x++){
            for(int y = 0; y < 4; y++){
                deck.add(new Card(y,x));
            }
        }
    }
}
