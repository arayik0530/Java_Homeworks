import java.util.Scanner;

public class Solution_11 {

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            String line = scanner.nextLine().trim();

            String[] words = line.split(" ");

            String word = words[0];

            String[] characters = word.split("");

            try {

                Integer.parseInt(word);

                String temp = characters[0];
                characters[0] = characters[characters.length-1];
                characters[characters.length-1] = temp;

                StringBuilder sb = new StringBuilder("");

                for (int i = 0; i < characters.length; i++) {
                    sb.append(characters[i]);
                }


                System.out.println(Integer.parseInt(sb.toString()));

            } catch (NumberFormatException exc) {
                System.out.println("Please enter only valid integers:");
            }

        }
    }
}
