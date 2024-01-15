//import some GUI repository
import java.awt.*;
import javax.swing.*;
public class Screen extends JFrame{
	static int screenHeight;
	static int screenWidth;
	int boxCount = 4;
	//JLabel boxJLabels[] = new JLabel[boxCount];
	String[] boxLabels = {"Hit","Stand","Double Down","Surrender"}; 
	//ChoiceBox[] Boxes = new ChoiceBox[boxCount];
	JButton[] Buttons = new JButton[boxCount];
	JPanel pnl = new JPanel();
	Color colorBackground = new Color(39,119,20);
	public Screen(){
	    screenHeight = 500; //default values. Will probably change to a different value later
	    screenWidth = 1000;
        setSize(Screen.screenWidth,Screen.screenHeight);
        setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		Board board = new Board();
		setContentPane(board);
		gameStartScreen();
	}
	void createBoxes(){
	    for(int i = 0; i < boxCount; i++){
	        //Boxes[i] = new ChoiceBox(i,screenWidth, screenHeight,4); //good chance says I'll get rid of choice boxes. I thought I'd have to draw these myself. Thank God.
			Buttons[i] = new JButton(boxLabels[i]);
			Buttons[i].setBounds(0,0,screenWidth,screenHeight);
			//boxJLabels[i] = new JLabel(boxLabels[i]);
			//add(boxJLabels[i]);
			add(Buttons[i],i*100,i);
	    }
	}
	void redraw(){
		removeAll();
		revalidate();
		repaint();
		//clears the screen
		//redraws the screen every time an event happens
	}
	void gameStartScreen(){
		JLabel wager = new JLabel("How much do you want to wager?");
		JTextField wagField = new JTextField(12);
		add(wager);
		add(wagField);
	}
	void gamePlayScreen(realPlayer P, house H){
		for(int i = 0; i < P.hand.size(); i++){
			//create card at low position
		}
		for(int i = 0; i < H.hand.size(); i++){
			//create card at high position
		}
	}
	public class Board extends JPanel{ //I'm following Jon's youtube tutorial (episode 2) on how to do this
		public void paintComponent(Graphics g){
			setLayout(null);
			g.setColor(colorBackground);
			g.fillRect(0,0,screenWidth,screenHeight);
		}
	}
}

