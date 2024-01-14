public class house extends player {
    void turn(Deck cardDeck){
        while(handValue() < 17){
			hit(cardDeck);
		}
    }
}
