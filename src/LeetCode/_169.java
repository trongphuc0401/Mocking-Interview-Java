package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _169
{
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;


        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public int majorityElement2(int[] nums) {

        int n = nums.length;
        int result = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int count  =  map.getOrDefault(nums[i],0)+1;
            map.put(nums[i],count);
            if (max < count) {
                max = count;
                result = nums[i];
            }
        }

        // for (Map.Entry<Integer,Integer> map1: map.entrySet()) {
        //     if (map1.getValue() > n) {
        //        return map1.getKey();
        //     }
        // }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {3,2,3,3,3,2,2,2,2,2,3,};
        _169 object = new _169();
        System.out.println( object.majorityElement2(nums));
    }


}
