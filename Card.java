

public class Card {
    String suits[] = {"Hearts","Diamonds","Clubs","Spades"}; //these are clubs, hearts, spades, and diamonds in their purest forms
    String faces[] = {"1","2","3","4","5","6","7","8","9","Jack","Queen","King","Ace"}; //these are the card faces in their purest forms
    int values[] = {1,2,3,4,5,6,7,8,9,10,10,10,10};
    int suit;
    int face;
    boolean hidden;
    public Card(int suitNum, int faceNum){
        suit = suitNum;
        face = faceNum;
        hidden = true;
    }
}
