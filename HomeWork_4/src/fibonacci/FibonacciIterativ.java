package fibonacci;

public class FibonacciIterativ {

    public static void main(String[] args) {

        System.out.println(fibonacci(4));
    }

    public static StringBuilder fibonacci(int num){

        StringBuilder sb = new StringBuilder();
        if(num == 0){
            return sb.append(num);
        }

        if(num == 1){
            return sb.append(num);
        }


        int lastOfLast = 0;

        int last = 1;

        sb.append(lastOfLast).append(" ").append(last).append(" ");

        for(int i = 2; i < num; ++i){

            int fib = last + lastOfLast;

            sb.append(fib).append(" ");

            lastOfLast = last;
            last = fib;

        }

        return sb;

    }
}
