import java.util.Scanner;

public class Solution_6 {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            String text = scanner.nextLine().trim();

            String [] words = text.split(" ");

            try {

                int num_1 = Integer.parseInt(words[0]);
                int num_2 = Integer.parseInt(words[1]);
                int num_3 = Integer.parseInt(words[2]);

                int min = num_1;

                if (num_2 < min)
                    min = num_2;

                if(num_3 < min)
                    min = num_3;

                int max = num_1;

                if (num_2 > max)
                    max = num_2;

                if(num_3 > max)
                    max = num_3;

                int mid = (num_1 + num_2 + num_3) - (max + min);

                System.out.println(min + " " + mid + " " + max);
            }
            catch (NumberFormatException exc){
                System.out.println("Please enter only valid integers:");
            }

        }
    }
}
