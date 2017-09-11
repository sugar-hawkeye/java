package demo.algorithm;

/**
 * Created by wim on 2017/8/8.
 */
public class ReverseInteger {

    public int reverse(int x) {
        int result = 0;
        while( x != 0){
            result= result*10 + x % 10;
            x= x/10;
            if( result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
                return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int result = reverseInteger.reverse(-1248);
        System.out.println("result=="+result);
    }
}
