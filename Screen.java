//import some GUI repository
public class Screen{
	int screenHeight;
	int screnWidth;
	int boxCount = 4;
	public Screen(){
	    screenHeight = 500; //default values. Will probably change to a different value later
	    screenWidth = 500;
	    Mouse Mouse = new Mouse();
	}
	void createBoxes(){
	    ChoiceBox Boxes[] = new ChoiceBox[boxCount];
	    for(int i = 0; i < boxCount; i++){
	        Boxes[i] = new ChoiceBox(i);
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

