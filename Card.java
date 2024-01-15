
public class Card {
    String suits[] = {"Hearts","Diamonds","Clubs","Spades"}; 
    String faces[] = {"2","3","4","5","6","7","8","9","Jack","Queen","King","Ace"}; 
    int values[] = {2,3,4,5,6,7,8,9,10,10,10,10};
    int suit;
    int face;
    boolean hidden;
    public Card(int suitNum, int faceNum){
        suit = suitNum;
        face = faceNum;
        hidden = true;
    }
    public String getCardName(){
    	return faces[face] + " of " + suits[suit];
    }
}
