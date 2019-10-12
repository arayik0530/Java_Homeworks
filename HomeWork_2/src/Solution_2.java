import java.util.Scanner;

public  class Solution_2{
    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);


            String text = scanner.nextLine().trim();

            String[] arr = text.split(" ");

            try {

                int num1 = Integer.parseInt(arr[0]);
                int num2 = Integer.parseInt(arr[1]);

                check(num1, num2);

            }
            catch (NumberFormatException exc){
                System.out.println("Please enter only valid integers \n" +
                        "and\n" +
                        "do not use spaces between entered two numbers:");
            }

        }
    }

    static void check(int num1, int num2){
        System.out.println((num1 % num2 == 0) || (num2 % num1 == 0) ? "1" : "0");
    }
}