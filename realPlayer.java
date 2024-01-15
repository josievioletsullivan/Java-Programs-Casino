import java.util.ArrayList;

public class realPlayer extends player{
    int balance;
    int wager;
    public realPlayer(){
        balance = 1000;
    }
	void makeWager(int input){

		wager = input;
		balance -= input;
	}
    boolean doubleDown(ArrayList deck){
        hit(hand, deck);
        wager*=2;
        return stand;
    }
    boolean surrender(){
        wager=0;
        return stand;
    }
    void turn(ArrayList deck){
        boolean gamePlay = true;
		makeWager(100); //replace 100 with inputDevice.nextInt();
        while(gamePlay = true){
            switch(1){ //input will be implemented later
                case 1: hit(hand, deck);
                case 2: gamePlay = stand;
                case 3: doubleDown(deck);
                // We removed split it would be option # 4
                case 5: gamePlay = surrender();
            }
            if(handValue()>21){
                gamePlay = false;
            }
        }
    }
}
