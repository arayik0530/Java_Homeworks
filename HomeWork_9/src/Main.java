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
        System.out.println("Enter the players names with 'space' \n");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().trim();
        String[] names = line.split(" ");
        if (names.length < 2) {
            System.out.println("Players must be at least 2.");
            line = scanner.nextLine().trim().toUpperCase();
        }
        names = line.split(" ");
        for (byte i = 0; i < names.length; ++i) {
            createPlayer(names[i]);
        }

        System.out.println("\nHere are players... -> " + Arrays.toString(names) + "\n");
        System.out.println("Starting to divide cards...\n");
        Thread.sleep(3000);

        divide();

        show();

        System.out.println("\n\nIf you want to shuffle cards, just press 's' then a 'space' and then\nthe player's name " +
                "whos cards must be shuffled.\n");
        String[] commands = (scanner.nextLine().trim().toUpperCase().split(" "));

        if (commands[0].equals("S")) {
            for (int i = 0; i < players.length && players[i] != null; ++i) {
                if (commands[1].equals(((players[i].toString().toUpperCase())))) {
                    shuffle(players[i]);
                    break;
                }
                else {
                    System.out.println("No such player.");
                    break;
                }
            }
        }
        else {
            System.out.println("Wrong command.");
        }
    }

    private static void shuffle(Player player) {
        System.out.println("How many cards do you want to shuffle from " + player.getName() + "'s cards?");
        Scanner scanner = new Scanner(System.in);
        byte count = 0;
        try {
            count = Byte.parseByte(scanner.nextLine().trim());
            if (count > 5 || count < 1) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException ne) {
            System.out.println("Wrong command.");
        }

        for (byte i = 0; i < count; ++i) {
            calod.add(player.cards[i]);
            player.cards[i] = null;
        }

        for (byte i = 0; i < count; ++i) {

            byte temp = (byte) Math.floor(Math.random() * (calod.size() - 1));

            player.cards[i] = calod.get(temp);
            calod.remove(temp);
        }

        System.out.println("Let's see the result.");
        show();
    }

    private static void show() {

        System.out.println("Here are divided cards.\n");
        for (int i = 0; i < players.length && players[i] != null; ++i) {
            System.out.println(players[i] + "--->" + Arrays.toString(players[i].cards));
        }

        System.out.println("\nHere is the calod.\n");
        for (int i = 0; i < calod.size(); i++) {

            System.out.print(calod.get(i) + " ");

            if ((i + 1) % 13 == 0) {
                System.out.println();
            }
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