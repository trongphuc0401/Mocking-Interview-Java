package LeetCode;

import java.util.Arrays;

/**
 * Max Number of K-Sum pairs
 *<p>
 * We have array {@code nums} and integer {@code k}
 * <p>
 * In running you can pick two number from the array whose sum equals {@code k} and remove them the array.
 * <p>
 * return maximum number of running perform in array.
 * <p>
 * Input: {@code nums = [1,2,3,4], k = 5 }
 * <p>
 * Output: {@code 2}
 * <p>
 *     Example 1:
 * </p>
 * <blockquote><pre>
 * {@code Explanation:} Starting with nums = [1,2,3,4]:
 * - Remove numbers 1 and 4, then nums = [2,3]
 * - Remove numbers 2 and 3, then nums = []
 * There are no more pairs that sum up to 5, hence a total of 2 operations.
 * </pre></blockquote><p>
 Input: {@code nums = [3,1,3,4,3], k = 6 }
 * <p>
 * Output: {@code 1}
 * <blockquote><pre>
 * {@code Explanation:} Starting with nums = 3,1,3,4,3]:
 *- Remove the first two 3's, then nums = [1,4,3]
 * There are no more pairs that sum up to 6, hence a total of 1 operation.
 * </pre></blockquote><p>
 */
public class _1679 {
    public int maxOperations(int[] nums, int k) {

        Arrays.sort(nums);
        for (int i = 0; i< nums.length ;i++) {
            for (int j = i ; j < nums.length;j++) {
               if (nums[i] +nums[j+1] >k) {
                    /// mốt làm tiếp:))
               }
            }
        }
        return 0;
    }
}
