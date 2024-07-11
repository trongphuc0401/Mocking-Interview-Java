package LeetCode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * _1550 -Three Consecutive Odds
 *
 * Given an integer array {@code arr } , return  {@code true } if there are three consecutive odd numbers in the array. <p>Otherwise, return {@code false } .
 * @param
 * @return
 * @throws
 */
public class _1550 {

    // use Cổ Ngữ
    public boolean threeConsecutiveOdds(int[] arr) {
            for (int i = 0 ; i< arr.length -2 ;i++) {
                if(arr[i] % 2 ==1 && arr[i+1] %2 ==1 && arr[i+2] %2 ==1 ) {
                    return true;
                }
            }
            return false;
    }
    // use Stream API and Lambda Expression
    public boolean threeConsecutiveOdds1(int[] arr) {
        return IntStream.range(0 ,arr.length -2).anyMatch(i -> arr[i] %2 ==1 && arr[i+1] %2 ==1 && arr[i+2] %2 ==1);
    }


    public static void main(String[] args) {
        int[] arr = {1,2,34,3,4,5,7,23,12};
        _1550 object = new _1550();
        if (object.threeConsecutiveOdds1(arr)) {
            System.out.println("True");
        }else {
            System.out.println("False");
        }

    }
}
