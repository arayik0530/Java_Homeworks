import java.util.Scanner;

public class Solution_5 {
    public static void main(String[] args) {
        while (true) {

            Scanner scanner = new Scanner(System.in);

            String text = scanner.nextLine();

            String[] words = text.split(" ");

            try {

                double num_1 = Double.parseDouble(words[0]);
                double num_2 = Double.parseDouble(words[1]);
                double num_3 = Double.parseDouble(words[2]);
                double num_4 = Double.parseDouble(words[3]);
                double num_5 = Double.parseDouble(words[4]);

                System.out.println((num_1 + num_2 + num_3 + num_4 + num_5)/5);

            }
            catch (NumberFormatException exc){
                System.out.println("Please enter only valid integers:");
            }

        }
    }
}
