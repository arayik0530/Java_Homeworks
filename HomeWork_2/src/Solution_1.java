import java.util.Scanner;

public  class Solution_1{
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);


            String text = scanner.nextLine().trim();

            try {

                int num = Integer.parseInt(text);

                checkDivisionByTwo(num);
            }
            catch (NumberFormatException exc){
                System.out.println("Please enter only valid integers:");
            }

        }
    }

    static void checkDivisionByTwo(int num){
        System.out.println((num % 2 == 0) ? "even" : "odd");
    }
}