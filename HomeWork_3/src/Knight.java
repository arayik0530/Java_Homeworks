public class Knight extends Piece {

    public String type;

    public int letterLocation;
    public int numberLocation;

    @Override
    public boolean canMove(int destNumberLocation, int destLetterLocation) {

        if((Math.abs(destLetterLocation - this.letterLocation) == 2 && Math.abs(destNumberLocation -
                this.numberLocation) == 1) || (Math.abs(destLetterLocation - this.letterLocation) == 1
                && Math.abs(destNumberLocation - this.numberLocation) == 2)){
            return true;
        }

        return false;
    }

    public Knight(String type, int numberLocation, int letterLocation) {
        this.type = type;
        this.letterLocation = letterLocation;
        this.numberLocation = numberLocation;
    }
}
