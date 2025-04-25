package LeetCode;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * _26 -
 *
 * @param
 * @return
 * @throws
 */
public class _26 {
    public int removeDuplicates(int[] nums) {

        int count = 0;

        for (int i = count+2; i < nums.length;i++) {
            if (nums[count] != nums[i]) {
                nums[count+2] =nums[i];
                count++;
            }
        }
            return count+2;
    }

}
