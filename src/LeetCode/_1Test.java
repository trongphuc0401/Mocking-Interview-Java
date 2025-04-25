package LeetCode;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class _1Test {

    @DisplayName("test 1")
    @ParameterizedTest
    @CsvSource({
            "'2,7,11,15', 9, '0,1'",
            "'3,2,4', 6, '1,2'",
            "'3,3', 6, '0,1'"
    })
    public void test_1(String numsStr, int target, String expectedStr) {
        _1 twoSum = new _1();

        int[] nums = convertStringToIntArray(numsStr);
        int[] expected = convertStringToIntArray(expectedStr);

        // Thực hiện test
        Assert.assertArrayEquals(expected, twoSum.twoSum(nums, target));
    }

    private int[] convertStringToIntArray(String str) {
        String[] parts = str.split(",");
        int[] result = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            result[i] = Integer.parseInt(parts[i].trim());
        }
        return result;
    }
}
