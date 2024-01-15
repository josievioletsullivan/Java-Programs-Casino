public abstract class ChoiceBox{
    int leftBound, rightBound, topBound, bottomBound, function;
    public ChoiceBox(int position, int screenWidth, int screenHeight, int boxCount){//creates a box at a position from the left side. all boxes are equal width and height
        leftBound=(screenWidth/boxCount)*(position-1);
        rightBound=(screenWidth/boxCount)*(position);
	    topBound=(screenHeight/boxCount+1);
	    bottomBound=0;
	    function=position+1;
    }
    boolean checkClick(int x, int y){
        if(x<rightBound && x>leftBound && y<topBound && y>bottomBound){
            return true;
        }
        return false;
    }
}
