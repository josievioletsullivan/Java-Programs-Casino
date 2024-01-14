
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class main{
    static Deck cardDeck = new Deck();
    int size = cardDeck.deck.size();
    static realPlayer user = new realPlayer();
    static Screen Screen = new Screen();
    static house mrHouse = new house();
	public static void main(String[] args) {
        //user.turn(cardDeck);
		//mrHouse.turn(cardDeck);
	}
    void debugDeck(){
        for(int x = 0; x < size; x++){
            System.out.print(cardDeck.deck.get(x).suit);
        }
    }
	void evaluateGame(realPlayer user){
		if(user.handValue()>mrHouse.handValue()){
			user.balance+=user.wager*2;
		}
	}
}
