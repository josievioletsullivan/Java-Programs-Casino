//import some GUI repository
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
public class Screen{
	static int screenHeight;
	static int screenWidth;
	int boxCount = 4;
	JLabel boxJLabels[] = new JLabel[boxCount];
	String[] boxLabels = {"Hit","Stand","Double Down","Surrender"}; 
	ChoiceBox[] Boxes = new ChoiceBox[boxCount];
	JButton[] Buttons = new JButton[boxCount];
	public Screen(){
	    screenHeight = 1080; //default values. Will probably change to a different value later
	    screenWidth = 1920;
		JFrame aFrame = new JFrame("Blackjack");
        aFrame.setSize(Screen.screenWidth,Screen.screenHeight);
        aFrame.setVisible(true);
		aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aFrame.setLayout(new FlowLayout());
		gameStartScreen(aFrame);
		createBoxes(aFrame);
	}
	void createBoxes(JFrame aFrame){
	    for(int i = 0; i < boxCount; i++){
	        Boxes[i] = new ChoiceBox(i,screenWidth, screenHeight,4); //good chance says I'll get rid of choice boxes. I thought I'd have to draw these myself. Thank God.
			Buttons[i] = new JButton(boxLabels[i]);
			boxJLabels[i] = new JLabel(boxLabels[i]);
			aFrame.add(boxJLabels[i]);
			aFrame.add(Buttons[i]);
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
	void redraw(JFrame aFrame){
		aFrame.removeAll();
		aFrame.revalidate();
		aFrame.repaint();
		//clears the screen
		//redraws the screen every time an event happens
	}
	void gameStartScreen(JFrame aFrame){
		JLabel wager = new JLabel("How much do you want to wager?");
		JTextField wagField = new JTextField(12);
		aFrame.add(wager);
		aFrame.add(wagField);
	}
}

