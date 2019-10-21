package chessboard; /**
 * Here are not included the colors of the pieces and
 * wheter the pieces meet another pieces during moving or not
 *
 * No time for more validations.
 */

import java.util.Scanner;

public class Main {

    public static Board board;

    public static void main(String[] args) {

        board = new Board();

        Piece piece;

        System.out.println("Hi, I'm a chessboard. Let's play.");

        int countOfPieces = 0;

        Outer: while (countOfPieces <= 64){

            Scanner scanner = new Scanner(System.in);

            System.out.println("If You want to check whether a location is busy or not " +
                    "please enter a letter: from 'a' to 'h' and a number: from '1' to '8'.");
            try {

                String input = scanner.nextLine().trim().toLowerCase();
                String[] parametres = input.split("");
                if(isBusy(parametres[0].charAt(0) - 'a',
                        8 - Integer.parseInt(parametres[1]))){
                    System.out.println("Busy, try another location.");
                    continue;
                }
                else {
                    System.out.println("What piece do you want to put.");
                    String pieceType = scanner.nextLine().trim().toLowerCase();

                    switch(pieceType){

                        case "king": piece = new King(pieceType, 7 - Integer.parseInt(parametres[1]),
                                parametres[0].charAt(0) - 'a');
                            break;
                        case "queen": piece = new Queen(pieceType, 7 - Integer.parseInt(parametres[1]),
                                parametres[0].charAt(0) - 'a');
                            break;
                        case "rook": piece = new Rook(pieceType, 7 - Integer.parseInt(parametres[1]),
                                parametres[0].charAt(0) - 'a');
                            break;
                        case "bishop": piece = new Bishop(pieceType, 7 - Integer.parseInt(parametres[1]),
                                parametres[0].charAt(0) - 'a');
                            break;
                        case "knight": piece = new Knight(pieceType, 7 - Integer.parseInt(parametres[1]),
                                parametres[0].charAt(0) - 'a');
                            break;
                        case "pown": piece = new Pown(pieceType, 7 - Integer.parseInt(parametres[1]),
                                parametres[0].charAt(0) - 'a');
                            break;
                        default:
                            throw new Exception();
                    }

                    board.matrix[7 - Integer.parseInt(parametres[1])][parametres[0].charAt(0) - 'a'] = 1;
                    countOfPieces++;
                }

               while (true){
                   System.out.println("Where to move the " + piece.toString());
                   String location = scanner.nextLine().trim().toLowerCase();
                   String [] locParams = location.split("");

                   if(board.matrix[7 - Integer.parseInt(locParams[1])][locParams[0].charAt(0) - 'a'] == 1){
                       System.out.println("There is already one piece, please try another destination");
                   }
                   else {
                       if(isValidStep(piece, locParams[0].charAt(0) - 'a',
                               7 - Integer.parseInt(locParams[1]))){
                           board.matrix[7 - Integer.parseInt(locParams[1])][locParams[0].charAt(0) - 'a'] = 1;
                           board.matrix[7 - Integer.parseInt(parametres[1])][parametres[0].charAt(0) - 'a'] = 0;
                           System.out.println("Succsessfull.");
                       }
                   }

                   System.out.println("If you want to start from the beginning, please press 'r'.");
                   String restart = scanner.nextLine().trim().toLowerCase();

                   if(restart.equals("r")){
                       continue Outer;
                   }
                   else {
                       continue;
                   }
               }
            }

            catch (Exception exc){
                System.out.println("Wrong input parameters. Please try again.");
            }

        }

        System.out.println("The Board is full.");
    }

    public static boolean isBusy(int letterLocation, int numberLocation){

        return (board.matrix[numberLocation][letterLocation] == 1);
    }

    public static boolean isValidStep(Piece piece, int destLetterLocation, int destNumberLocation){
        return ((piece.canMove(destNumberLocation, destLetterLocation)) && (!isBusy(destLetterLocation, destNumberLocation)));
    }

}
