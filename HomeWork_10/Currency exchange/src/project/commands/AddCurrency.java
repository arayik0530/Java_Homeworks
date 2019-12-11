package project.commands;

import project.Currency;

import static project.Main.currencies;

import java.util.Arrays;
import java.util.Scanner;


public class AddCurrency implements Command {

    private String description;

    public AddCurrency() {
        this.description = "'add' command adds a currency.";
    }

    @Override
    public void execute() {
        System.out.println("PLease enter the international code for the currency then a 'space' and the value of the currency. \n");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();

        try {
            String code = input.split(" ")[0].toLowerCase();
            double value = Double.parseDouble(input.split(" ")[1]);
            if (!currencies.containsKey(code)) {
                currencies.put(code, new Currency(code, value));
                System.out.println("Added successfully.\n");
            }

            else{
                System.out.println("Dublicated currency\n \n");
                if(!(currencies.get(code).getExchangeValue() == value)){
                    currencies.get(code).setExchangeValue(value);
                    System.out.println("But the value of " + code.toUpperCase() + " is changed. \n \n");
                }
            }

            System.out.println("Now in the list are: \n");
            for (String key : currencies.keySet()) {
                System.out.print(currencies.get(key));
            }

            System.out.println("\n \n Please press any key to go to main menu or type 'help' for help.");

            input = sc.nextLine().trim();

            if (input.toLowerCase().equals("help".toLowerCase())) {
                System.out.println(this.description);
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
