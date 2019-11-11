import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final static byte MAX_COUNT = 5;
    private static Player[] players;
    private static byte countOfPlayers = 0;
    private static List<Card> calod;

    public static void main(String[] args) throws Exception {
        calod = createCards();
        players = new Player[MAX_COUNT];

        System.out.println("Hi, let's play!");
        Thread.sleep(2000);
        System.out.println("\nLet's add players!");
        Thread.sleep(2000);
        System.out.println("Enter the players names with ',' ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().trim();
        String[] names = line.split(",");
        if (names.length < 2) {
            System.out.println("Players must be at least 2.");
            line = scanner.nextLine().trim();
        }
        names = line.split(",");
        for (byte i = 0; i < names.length; ++i) {
            createPlayer(names[i]);
        }
        System.out.println("Here are players... -> " + Arrays.toString(names));

        divide();

        System.out.println("Here are divided cards.");

        // System.out.println(calod.size());

        for (int i = 0; i < players.length && players[i] != null; ++i) {
            System.out.println(Arrays.toString(players[i].cards));
        }
    }

    public static List<Card> createCards() {
        List<Card> calod = new ArrayList<>(52);
        char[] suits = {'s', 'h', 'd', 'c'};
        String[] types = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        for (byte i = 0; i < suits.length; ++i) {
            for (byte j = 0; j < types.length; j++) {
                calod.add(new Card(types[j], suits[i]));
            }
        }

        return calod;
    }

    public static void createPlayer(String name) {
        try {
            Player player = new Player(name);
            players[countOfPlayers++] = player;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Maximum players count exceeded.");
        }
    }

    private static void divide() {

        for (int i = 0; i < players.length && players[i] != null; i++) {

            for (int j = 0; j < 5; j++) {

                byte temp = (byte) Math.floor(Math.random() * (calod.size() - 1));

                players[i].cards[j] = calod.get(temp);
                calod.remove(temp);
            }
        }
    }
}