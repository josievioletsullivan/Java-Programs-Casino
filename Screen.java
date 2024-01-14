//import some GUI repository
import javax.swing.*;
public class Screen{
	static int screenHeight;
	static int screenWidth;
	int boxCount = 4;
	JLabel boxJLabels[];
	String[] boxLabels = {"Hit","Stand","Double Down","Surrender"}; 
	ChoiceBox[] Boxes = new ChoiceBox[boxCount];
	public Screen(){
	    screenHeight = 500; //default values. Will probably change to a different value later
	    screenWidth = 500;
	    Mouse Mouse = new Mouse(screenHeight);
		JFrame aFrame = new JFrame("Blackjack");
        aFrame.setSize(Screen.screenWidth,Screen.screenHeight);
        aFrame.setVisible(true);
		aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void createBoxes(){
	    for(int i = 0; i < boxCount; i++){
	        Boxes[i] = new ChoiceBox(i,screenWidth, screenHeight,4);
			boxJLabels[i] = new JLabel(boxLabels[i], Boxes[i].leftBound);
	    }
	}
	int checkClick(int x, int y){
	    for(ChoiceBox i : Boxes){
	        if(i.checkClick(x,y)==true){
	            return i.function;
	        }
	    }
	    return 0; //triggers the default case
	}
}

