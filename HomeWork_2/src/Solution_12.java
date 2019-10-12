import java.util.Scanner;

public class Solution_12 {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            String line = scanner.nextLine().trim();

            String [] text = line.split(" ");

            String message = text[0];

            try {

                double height = Double.parseDouble(text[1]);
                double base = Double.parseDouble(text[2]);

                System.out.println(check(message, height, base));

            }
            catch (NumberFormatException exc){
                System.out.println("Please enter only valid integers:");
            }

        }
    }

    static String check(String message, double a, double b) {
        String shape = "rectangle";
        double  S = a * b;

        if(message.equals("rectangle")  || message.equals("triangle")){
            if(a <= 0 || b <= 0){
                return "Please enter positive numbers";
            }
            if(message.equals("triangle")){
                S /= 2;
                shape = "triangle";
            }
        }

        else{
            return "Wrong shape type";
        }

        return "The area of " + shape + " is " + S;
    }
}
