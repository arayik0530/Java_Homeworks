import java.util.Scanner;

public class Solution_10 {
    public static void main(String[] args) {
        Label: while (true) {
            Scanner scanner = new Scanner(System.in);

            String text = scanner.nextLine().trim();

            String [] words = text.split(" ");

            try {

                int digit = Integer.parseInt(words[0]);
                int number = Integer.parseInt(words[1]);

                if(words[0].length() > 1){
                    System.out.println("The first number must be just a digit");
                    continue;
                }

                String[] digits = words[1].split("");

                for (int i = 0; i < digits.length; i++) {
                    if(words[0].equals(digits[i])){
                        System.out.println("Yes.");
                        continue Label;
                    }
                }

                System.out.println("No.");
            }
            catch (NumberFormatException exc){
                System.out.println("Please enter only valid integers:");
            }

        }
    }
}
