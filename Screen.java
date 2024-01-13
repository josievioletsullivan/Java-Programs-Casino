//import some GUI repository
import javax.swing.*;
public class Screen{
	int screenHeight;
	int screnWidth;
	int boxCount = 4;
	String[] boxLabels = {"Hit","Stand","Double Down","Surrender"}; 
	public Screen(){
	    screenHeight = 500; //default values. Will probably change to a different value later
	    screenWidth = 500;
	    Mouse Mouse = new Mouse();
		JFrame aFrame = new JFrame("Blackjack");
        aFrame.setSize(Screen.screenWidth,Screen.screenHeight);
        aFrame.setVisible(true);
		aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void createBoxes(){
	    ChoiceBox Boxes[] = new ChoiceBox[boxCount];
	    for(int i = 0; i < boxCount; i++){
	        Boxes[i] = new ChoiceBox(i);
			JLabel boxLabels[i] = new JLabel(Boxes[i], Boxes[i].leftBound);
	    }
	}
	int checkClick(int x, int y){
	    for(int i :: Boxes[]){
	        if(Boxes[i].checkClick(x,y)==true){
	            return Boxes[i].function;
	        }
	    }
	    return 0; //triggers the default case
	}
}

