import java.util.Scanner;

public class Solution_7 {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            String text = scanner.nextLine().trim();

            String [] words = text.split(" ");

            try {

                int[] arr = new int[3];

                for (int i = 0; i < arr.length && i < words.length; i++) {
                    arr[i] = Integer.parseInt(words[i]);
                }

                int countOfMinus = 0;

                for (int i = 0; i < arr.length; i++) {
                    if(arr[i] == 0){
                        System.out.println("unsigned");
                        return;
                    }

                    if(arr[i] < 0){
                        ++countOfMinus;
                    }
                }

                System.out.println((countOfMinus % 2 == 0) ? "+" : "-");

            }
            catch (NumberFormatException exc){
                System.out.println("Please enter only valid integers:");
            }

        }
    }
}
