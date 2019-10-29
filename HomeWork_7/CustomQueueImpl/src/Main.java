import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Please enter the size of the Queue.");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().trim();
        int size = 0;
        try {
            size = Integer.parseInt(line);
        } catch (NumberFormatException nexc) {
            System.out.println("Please enter an integer.");
        }

        Queue queue = new Queue(size);
        System.out.println("Creating a Queue with size " + size);

        Thread.sleep(3000);

        System.out.println("Please enter a command: 'exit' for exit, 'e' for enqueue, " +
                "'d' for dequeue and 'p' for peek.");

        while (true) {

            String line2 = scanner.nextLine().trim().toLowerCase();

            switch (line2) {

                case "exit":
                    return;

                case "e":
                    System.out.println("Please enter an item.");
                    String line3 = scanner.nextLine().trim().toLowerCase();
                    queue.enqueue(line3);
                    break;

                case "d":
                    queue.dequeue();
                    break;

                case "p":
                    queue.peek();
                    break;

                default:
                    System.out.println("Invalid command.");
            }
        }

    }
}
