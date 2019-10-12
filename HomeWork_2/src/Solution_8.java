import java.util.Scanner;

public class Solution_8 {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            String text = scanner.nextLine().trim();

            String [] words = text.split(" ");

            try {

                double a = Double.parseDouble(words[0]);
                double b = Double.parseDouble(words[1]);
                double c = Double.parseDouble(words[2]);

                check(a, b, c);

            }
            catch (NumberFormatException exc){
                System.out.println("Please enter only valid integers:");
            }

        }
    }

    static void check(double a, double b, double c) {

        if(a == 0){
            System.out.println("Enter valid constants");
            return;
        }

         double D = b * b - 4 * a * c;

        if(D < 0){
            System.out.println("Solution does not exists");
        }
        else if(D == 0)
            System.out.println("Solution is " + -b / 2 * a);

        else
            System.out.println("Solutions are " + (((-1 * b) + Math.sqrt(D)) / (2 * a)) + " and " + (((-1 * b) - Math.sqrt(D)) / (2 * a)));
    }
}
