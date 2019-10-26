import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HanoyTowers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                int n = Integer.parseInt(scanner.nextLine().trim());
                Date date = new Date();
                moveDiscs(n, '1', '2', '3');
                Date date2 = new Date();
                System.out.println((date2.getTime() - date.getTime()) + " milisecond/s/.");
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
        moveDiscs(n-1, temp, from, to);
    }


}

