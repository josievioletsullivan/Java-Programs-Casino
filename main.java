
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class main{
    static realPlayer user = new realPlayer();
    static Screen Screen = new Screen();
    static house mrHouse = new house();
    static ArrayList<Card> deck = new ArrayList<Card>();
	public static void main(String[] args) {
        //user.turn(cardDeck);
		//mrHouse.turn(cardDeck);
	}
    void debugDeck(){
        for(int x = 0; x < deck.size(); x++){
            System.out.print(deck.get(x).suit);
        }
    }
	void evaluateGame(realPlayer user){
		if(user.handValue()>mrHouse.handValue()){
			user.balance+=user.wager*2;
		}
	}
    void createDeck(){
        //creates the deck by adding 52 cards
        for(int x = 0; x<13; x++){
            for(int y = 0; y < 4; y++){
                deck.add(new Card(y,x));
            }
        }
    }
}
