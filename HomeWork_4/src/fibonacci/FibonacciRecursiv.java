package fibonacci;

public class FibonacciRecursiv {

    public static int fibonacciRecursion(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        return fibonacciRecursion(n-2) + fibonacciRecursion(n-1);
    }
    public static void main(String args[]) {
        int n = 8;
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursion(i) + " ");

        }
    }

}