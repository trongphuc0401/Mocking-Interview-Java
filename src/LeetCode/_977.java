package LeetCode;

import java.util.Arrays;

/*
* Given an integer array nums sorted in non-decreasing order,
* return an array of the squares of each number sorted in non-decreasing order.
* */
public class _977 {
    public int[] sortedSquares(int[] nums) {
        for(int i = 0; i< nums.length;i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

}
