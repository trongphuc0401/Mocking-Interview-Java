package LeetCode;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * _2011 -
 *
 * @param
 * @return
 * @throws
 *
 * String[] string = {"X++","X--",X++}
 * output: 1
 */
public class _2011 {

    public int finalValueAfterOperations(String[] operations) {

        // int result = 0;
        // for(String s: operations) {
        //     if(s.contains("++")) result++;
        //     else result --;
        // }
        // return result;

        // return (int) IntStream.range(0,operations.length).filter(i-> Integer.toString(i).contains("++")).

        final int[] count = {0};
         Arrays.stream(operations).forEach(e->{

             if (e.contains("++")) {
                 count[0]++;
             }else {
                 count[0]--;
             }
         });
         return count[0];
    }

    public static void main(String[] args) {

    }
}
