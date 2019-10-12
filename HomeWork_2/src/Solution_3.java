import java.util.Scanner;

public class Solution_3 {

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);


            String text = scanner.nextLine().trim();

            String n_n = text + text;
            String n_n_n = text + text + text;

            try {

                int num_n = Integer.parseInt(text);
                int num_n_n = Integer.parseInt(n_n);
                int num_n_n_n = Integer.parseInt(n_n_n);

                System.out.println(num_n + num_n_n + num_n_n_n);

            }
            catch (NumberFormatException exc){
                System.out.println("Please enter only valid integers:");
            }

        }
    }
}
