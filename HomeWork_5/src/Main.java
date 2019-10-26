import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(isPalindrome("* Eva, can I see bees in a cave?"));
        // write your code here
    }

    static boolean isPalindrome(String s){
        s = s.toLowerCase();
        char[] c = s.toCharArray();
        List<Character> newChar = new ArrayList<Character>();
        for (int i = 0; i < c.length; ++i){
            if(c[i] >= 'a' && c[i] <= 'z'){
                newChar.add(c[i]);
            }
        }


        for(int i = 0 ; i < newChar.size(); ++i){
            if(newChar.get(i) != newChar.get(newChar.size()-i-1)){
                return false;
            }
        }
        return true;
    }
}
