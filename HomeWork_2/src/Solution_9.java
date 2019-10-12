import java.util.Scanner;

public class Solution_9 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().trim();

        String [] words = text.split(" ");

        try {

            double n = Double.parseDouble(words[0]);
            double i = Double.parseDouble(words[1]);
            double j = Double.parseDouble(words[2]);

            if((n % 2 == 0) && (Math.floor(n / 10) != 0)){
                i += 1;
            }

            if((n % 3 == 0) && (n % 10 == 1)){
                j += 1;
            }
        }

        catch (NumberFormatException exc){
            System.out.println("Please enter only valid numbers:");
        }

    }
}
