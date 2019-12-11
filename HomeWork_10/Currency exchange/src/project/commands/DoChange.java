package project.commands;

import project.Currency;

import static project.Main.currencies;

import java.util.Arrays;
import java.util.Scanner;


public class DoChange implements Command {

    private String description;

    private final double MLN = 1_000_000;

    public DoChange() {

        this.description = "'change' command makes a change.";
    }

    @Override
    public void execute() {

        System.out.println("PLease enter the international code for the currency then the count to make change. \n");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();

        try {
            String codeFrom = input.split(" ")[0].toLowerCase();
            double count = Double.parseDouble(input.split(" ")[1]);

            System.out.println("\nNow enter please to which currency to change");

            input = sc.nextLine().trim();

            String codeTo = input.split(" ")[0].toLowerCase();

            if(!currencies.containsKey(codeFrom) || !currencies.containsKey(codeTo)){
                System.out.println("We don't have such currencies");
            }

            else {
                double result = (currencies.get(codeFrom).getExchangeValue() * count) / currencies.get(codeTo).getExchangeValue();

                System.out.println("The result is: " + result + " " + codeTo.toUpperCase());

                if(result >= MLN){
                    System.out.println("You have to write a declaration about sources of your money");
                }
            }

            System.out.println("\n Please press any key then 'enter' to go to main menu or type 'help' for help.");

            input = sc.nextLine().trim();

            if (input.toLowerCase().equals("help".toLowerCase())) {
                System.out.println(this.description + "");
            }

            System.out.println("Going back to main menu");
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid values.");
        }
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
