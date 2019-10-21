package chessboard;

public class Board {

    public final int numberLocation = 8;
    public final int letterLocation = 8;

    int[][] matrix;

    public Board() {
        this.matrix = new int[this.numberLocation][this.letterLocation];
    }
}
