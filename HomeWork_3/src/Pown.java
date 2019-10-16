/**
 * Here the pown can move forward and backward
 * because we do not know which color it has
 */

public class Pown extends Piece {

    public String type;

    public int letterLocation;
    public int numberLocation;

    @Override
    public boolean canMove(int destNumberLocation, int destLetterLocation) {

        if((Math.abs(destNumberLocation - this.numberLocation) == 1) && (destLetterLocation - this.letterLocation == 0)){
            return true;
        }

        return false;

    }

    public Pown(String type, int letterLocation, int numberLocation) {
        this.type = type;
        this.letterLocation = letterLocation;
        this.numberLocation = numberLocation;
    }
}
