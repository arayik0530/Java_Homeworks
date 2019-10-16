public class Rook extends Piece {

    public String type;

    public int letterLocation;
    public int numberLocation;

    @Override
    public boolean canMove(int destNumberLocation, int destLetterLocation) {

        if(((destLetterLocation - this.letterLocation) == 0 && (destNumberLocation - this.numberLocation) != 0)
                || ((destLetterLocation - this.letterLocation) != 0 && (destNumberLocation - this.numberLocation) == 0)){
            return true;
        }

        return false;
    }

    public Rook(String type, int numberLocation, int letterLocation) {
        this.type = type;
        this.letterLocation = letterLocation;
        this.numberLocation = numberLocation;
    }
}
