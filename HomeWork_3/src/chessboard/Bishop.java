package chessboard;

public class Bishop extends Piece {

    public String type;

    public int letterLocation;
    public int numberLocation;

    @Override
    public boolean canMove(int destNumberLocation, int destLetterLocation) {

        if(Math.abs(destLetterLocation - this.letterLocation) == Math.abs(destNumberLocation - this.numberLocation)){

            return true;
        }

        return false;
    }

    public Bishop(String type, int numberLocation, int letterLocation) {
        this.type = type;
        this.letterLocation = letterLocation;
        this.numberLocation = numberLocation;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
