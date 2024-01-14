import java.util.ArrayList;
public class house extends player {
    void turn(ArrayList deck){
        while(handValue() < 17){
			hit(hand, deck);
		}
    }
}
