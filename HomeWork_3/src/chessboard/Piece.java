package chessboard;

public abstract class Piece {

    public String type;

     int numberLocation;
     int letterLocation;


    public abstract boolean canMove(int destNumberLocation, int destLetterLocation);

    @Override
    public String toString() {
        return this.type;
    }
}

