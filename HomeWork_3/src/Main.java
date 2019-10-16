/**
 * Here are not included the colors of the pieces and
 * wheter the pieces meet another pieces during moving or not
 *
 * No time for more validations.
 */

import java.util.Scanner;

public class Main {

    static int[][] board;

    public static void main(String[] args) {

        board = new int[8][8];

        int countOffAddedPieces = 0;

       Outer: while (countOffAddedPieces <= 64){

            Piece piece;

           Scanner scanner = new Scanner(System.in);

           System.out.println("If You want to check whether a location is busy or not please enter a letter and a number");

           String input = scanner.nextLine().trim().toLowerCase();
           String[] parametres = input.split(" ");

           if(isBusy(Integer.parseInt(parametres[1]) -1, parametres[0].charAt(0)- 'a')){
               System.out.println("Busy");
           }
           else {
               System.out.println("Empty");
           }

            System.out.println("Please enter the type of the piece, " +
                    "the letter destination and the number destination of the piece\n" +
                    "which You want to put: the letter must be between \"a\" and \"f\", case does not matter,\n" +
                    "a space and then the number: from 1 to 8.\n");

            String line = scanner.nextLine().trim().toLowerCase();
            String[] pieceParameters = line.split(" ");


            switch(pieceParameters[0]){

                case "king": piece = new King("King", Integer.parseInt(pieceParameters[2])-1,
                        pieceParameters[1].charAt(0)- 'a');
                    break;
                case "queen": piece = new Queen("Queen", Integer.parseInt(pieceParameters[2])-1,
                        pieceParameters[1].charAt(0)- 'a');
                    break;
                case "rook": piece = new Rook("Rook", Integer.parseInt(pieceParameters[2])-1,
                        pieceParameters[1].charAt(0)- 'a');
                    break;
                case "bishop": piece = new Bishop("Bishop", Integer.parseInt(pieceParameters[2])-1,
                        pieceParameters[1].charAt(0)- 'a');
                    break;
                case "knight": piece = new Knight("Knight", Integer.parseInt(pieceParameters[2])-1,
                        pieceParameters[1].charAt(0)- 'a');
                    break;
                case "pown": piece = new Pown("Pown", Integer.parseInt(pieceParameters[2])-1,
                        pieceParameters[1].charAt(0)- 'a');
                    break;
                default:
                    System.out.println("Please enter valid piece parameters");
                    continue Outer;
            }

            if(isBusy(piece.letterLocation, piece.numberLocation)){

                System.out.println("The destination is busy, please try another");
                continue ;
            }
            else {
                board[piece.letterLocation][piece.numberLocation] = 1;
                ++countOffAddedPieces;
            }

           System.out.println("Now enter please where to move: a letter and a number");

            String dest = scanner.nextLine().trim().toLowerCase();
            String[] moveCoordinates = dest.split(" ");

            if(isValid(piece, Integer.parseInt(moveCoordinates[1])-1,
                    moveCoordinates[0].charAt(0)- 'a')){

                board[moveCoordinates[0].charAt(0) - 'a'][Integer.parseInt(moveCoordinates[1]) -1] = 1;
                board[piece.letterLocation][piece.numberLocation] = 0;
                System.out.println("the piece is moved successfully");
            }
            else {
                System.out.println("The movement is not valid.");
            }
        }
    }

    public static boolean isBusy(int letterLocation, int numberLocation){

        return (board[letterLocation][numberLocation] == 1);
    }

    public static boolean isValid(Piece piece, int destNumberLocation, int destLetterLocation){
        return ((piece.canMove(destNumberLocation, destLetterLocation)) && (!isBusy(destNumberLocation, destLetterLocation)));
    }

}
