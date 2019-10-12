import java.util.Arrays;
import java.util.Scanner;

public class Solution_4 {
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            String line = scanner.nextLine().trim();

            String [] words = line.split(" ");

            String word = words[0];

            String [] characters = word.split("");

            try {

                Integer.parseInt(word);

                if(Integer.parseInt(characters[characters.length-1]) == 0)
                    System.out.println(word);
                else {

                    StringBuilder sb = new StringBuilder("");

                    sb.append(characters[characters.length-1]);

                    for (int i = 0; i < characters.length-1; i++) {
                        sb.append(characters[i]);
                    }
                    System.out.println(sb);
                }
            }
            catch (NumberFormatException exc){
                System.out.println("Please enter only valid integers:");
            }

        }
    }
}
