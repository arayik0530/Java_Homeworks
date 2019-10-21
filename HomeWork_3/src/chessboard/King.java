package chessboard;

public class King extends Piece {

    public String type;

    public int numberLocation;
    public int letterLocation;

    @Override
    public boolean canMove(int destNumberLocation, int destLetterLocation) {

        if(Math.abs((destLetterLocation - this.letterLocation) *
                (destNumberLocation - this.numberLocation)) <= 1) {
            return true;
        }

        return false;
    }

    public King(String type, int numberLocation, int letterLocation) {
        this.type = type;
        this.letterLocation = letterLocation;
        this.numberLocation = numberLocation;
    }

    @Override
    public String toString() {
        return this.type;
    }

}
