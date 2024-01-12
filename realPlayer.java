package Casino;

public class realPlayer extends player{
    int balance;
    int wager;
    public realPlayer(){
        balance = 1000;
    }
    boolean doubleDown(Deck cardDeck){
        hit(cardDeck);
        wager*=2;
        return stand;
    }
    boolean surrender(Deck cardDeck){
        wager=0;
        return stand;
    }
}
