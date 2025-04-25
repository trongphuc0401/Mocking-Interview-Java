package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * _189 -
 *
 * @param
 * @return
 * @throws
 */
public class _189   {


    // theo cách brutefort trước
    public static void rotate(int[] nums, int k) {


     int n = nums.length;
     k = k%n;
     int j = 0;
     int[] temp =  new int[n];

     for(int i = k+1 ; i < n ; i++){
        temp[j] = nums[i];
        j++;
     }
     for (int i = 0 ; i < k ; i++) {
        temp[j] = nums[i];
        j++;
     }
     for (int i = 0; i < n ; i++) {
         nums[i] = temp[i];
     }
        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {

     int[] nums = {1,2,3,4,5,6,7};
     int k = 3;

      rotate(nums,k);
    }
}
