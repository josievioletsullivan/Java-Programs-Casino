import java.util.ArrayList;
public class house extends player {
    void turn(ArrayList deck){
        while(handValue() < 17){
			hit(hand, deck);
		}
    }
    @Override void hit(ArrayList hand, ArrayList deck){
        hand.add(deck.get(deck.size()-1));
        deck.remove(deck.size()-1);
    }
}
