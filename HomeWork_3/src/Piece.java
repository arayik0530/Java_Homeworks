public abstract class Piece {

    public String type;

    public int numberLocation;
    public int letterLocation;


    public abstract boolean canMove(int destNumberLocation, int destLetterLocation);

}

