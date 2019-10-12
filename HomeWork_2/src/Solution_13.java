import java.util.Scanner;

public class Solution_13 {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            String text = scanner.nextLine().trim();

            String [] digits = text.split("");

            try {

              int [] numDigits = new int[digits.length];

              int min = Integer.parseInt(digits[0]);
              int max = Integer.parseInt(digits[0]);

                for (int i = 0; i < digits.length; i++) {
                    numDigits[i] = Integer.parseInt(digits[i]);

                    if(min > numDigits[i])
                        min = numDigits[i];

                    if(max < numDigits[i])
                        max = numDigits[i];
                }

                System.out.println(max - min);

            }
            catch (NumberFormatException exc){
                System.out.println("Please enter only valid integers:");
            }

        }
    }
}
