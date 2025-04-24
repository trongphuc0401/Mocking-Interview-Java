package LeetCode;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * _1945 -
 *
 * @param
 * @return
 * @throws
 */
public class _1945 {

    public static int getLucky(String s, int k) {

        BigInteger number = stringToPositions(s);
        for(int i = 0 ; i < k ; i++){
            number = sumOfDigits(number);
        }
    return number.intValue();

    }


    private static BigInteger sumOfDigits(BigInteger number) {
        BigInteger sum = BigInteger.ZERO;
        while(number.compareTo(BigInteger.ZERO) > 0){
            sum = sum.add(number.mod(BigInteger.valueOf(10)));
            number = sum.divide(BigInteger.valueOf(10));
        }

        return sum;
    }


    public static BigInteger stringToPositions(String s) {
        s = s.toLowerCase();

        StringBuilder result = new StringBuilder();


        for(char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                int position = c - 'a' +1;
                result.append(position);
            }
        }

        if (!result.isEmpty()) {
           return new BigInteger(result.toString());
        }
        return BigInteger.valueOf(0);
    }



    public static void main(String[] args) {

        String s = "fleyctuuajsr";
        int k =1;

        System.out.println(getLucky(s, k));


    }
}
