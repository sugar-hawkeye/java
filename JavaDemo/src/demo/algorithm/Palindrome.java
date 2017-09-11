package demo.algorithm;

/**
 * Created by wim on 2017/8/15.
 */
public class Palindrome {
    public boolean isPalindrome(int x) {
        int reverse = 0;
        int current = x;
        while(x != 0){
            int tail = x % 10;
            reverse = reverse * 10 + tail;
            x = x/10;
        }
        if (reverse == current){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        palindrome.isPalindrome(32144123);

    }
}
