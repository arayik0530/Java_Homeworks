package project;

import project.commands.AddCurrency;
import project.commands.Command;
import project.commands.DoChange;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static Map<String, Currency> currencies = new HashMap<>();

    public static void main(String[] args) {

        Map<String, Command> commands = new HashMap<>();
        commands.put("add", new AddCurrency());
        commands.put("change", new DoChange());


        System.out.println("Hi, I am currency exchanger, Let's play.");

        while (true) {
            System.out.println("\n \n Enter please only valid commands: " +
                    "\n add -> for adding currencies" +
                    "\n change -> for exchange" +
                    "\n help -> for help \n \n");

            Scanner scanner = new Scanner(System.in);

            String input = getInput(scanner);

            switch (input) {

                case "add":
                    commands.get("add").execute();
                    break;

                case "change":
                    commands.get("change").execute();
                    break;

                case "help":
                    help(commands);
                    break;

                default:
                    System.out.println("Invalid command");
            }
        }

    }

    static String getInput(Scanner scanner) {

        return scanner.nextLine().toLowerCase().trim().split(" ")[0];
    }

    static void help(Map<String, Command> commands) {

        System.out.println("Help");
        for (String key : commands.keySet()) {
            System.out.println(commands.get(key).getDescription());
        }
    }
}
