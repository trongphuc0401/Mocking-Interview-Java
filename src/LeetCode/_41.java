package LeetCode;

import java.util.Arrays;

/*
* 41. First Missing Positive
*
 Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.


* */
public class _41 {
    public static int firstMissingPositive1(int[] nums) {
        int len = nums.length;
        int N = 1000010;

        boolean[] present  = new boolean[N];
        int maxElement = Integer.MIN_VALUE;

        for(int i = 0; i < len ; i++) {
            if (nums[i] > 0 && nums[i] < len) {
                present[nums[i]]  = true;
            }
            maxElement = Math.max(maxElement,nums[i]);
        }

        for(int i = 1; i< N; i++) {
            if(!present[i]) {
                return i;
            }
        }
        return maxElement + 1;
    }

    public static  int firstMissingPositive(int[] nums) {
        int len = nums.length;
        int ptr = 0;

        for(int i = 0; i<len ;i++) {
            if(nums[i] ==1) {
                ptr = 1;
                break;
            }
        }
        if(ptr ==0)
            return 1;

        for(int i=0 ; i<len ; i++) {
            if(nums[i] < 1 || nums[i] > len) {
                nums[i]  = 1;
            }
        }
        for (int i = 0; i<len ;i++)
            if(nums[len] <= len)
                return (i+1);
        return (len +1);
    }

    public static int firstMissingPositive2(int[] nums)
    {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == ans)
                ans++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = { 0, 10, 2, -10, -20 };
        int nums1[] = {1};
        System.out.println(firstMissingPositive1(nums));
        System.out.println(firstMissingPositive(nums));
        System.out.println(firstMissingPositive2(nums));

    }
}
