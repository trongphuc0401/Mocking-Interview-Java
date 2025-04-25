package LeetCode;

import java.util.Arrays;

/**
 * _1894 -
 *
 * @param
 * @return
 * @throws
 */
public class _1894 {
    public static int chalkReplacer(int[] chalk, int k) {
        // Find the sum of all elements.
        long sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
            if (sum > k) {
                break;
            }
        }
        // Find modulo of k with sum.
        k = k % (int) sum;
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k = k - chalk[i];
        }
        return 0;
    }


    public static void main(String[] args) {
        int[]chalk = {5,1,5};
        int k = 22;

        System.out.println(chalkReplacer(chalk, k));
    }

}
