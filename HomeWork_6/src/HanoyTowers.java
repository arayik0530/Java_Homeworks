import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HanoyTowers {
    static int count = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                count = 0;
                int n = Integer.parseInt(scanner.nextLine().trim());
                Long startTime = System.nanoTime();
                moveDiscs(n, '1', '2', '3');
                Long endTime = System.nanoTime();
                System.out.println((endTime - startTime) + " nanosecond/s/.");
                System.out.println("Count of movements: " + count);
            } catch (NumberFormatException exc) {
                System.out.println("Invalid input, please try again.");
            }
        }

    }

    static void moveDiscs(int n, char from, char temp, char to) {

        if (n == 0){
            return;
        }

        moveDiscs(n-1, from, to, temp);
        System.out.println("Moving the top disc from " + from + " to " + to );
        ++count;
        moveDiscs(n-1, temp, from, to);
    }


}

