package dsa.hash;

import java.util.HashMap;
import java.util.Map;

/*
* Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
*
*
* Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if nums[i] == nums[j] and i < j.
*
*
*
*
Tạo một biến đếm và khởi tạo giá trị là không.
Chạy một vòng lặp lồng nhau, vòng lặp ngoài cho a[i] từ i=0 đến i=n-1 và vòng lặp trong cho a[j] từ j=i+1 đến j=n-1.
Nếu a[i] bằng a[j], thêm cặp hiện tại vào biến đếm bằng cách tăng giá trị của nó lên 1.
Trả về giá trị của biến đếm.
* */
public class _512 {
    public static int numIdenticalPairs(int[] nums) {
        int count = 0 ;
        for (int i = 0; i < nums.length-1 ; i++) {
            for (int j = i+1 ; j< nums.length;j++) {
                if (nums[i] == nums[j]) {
                    count ++;
                }
            }
        }
        return count;
    }

    public static int numIdenticcalPairs(int[] nums) {
        Map<Integer,Integer> map  = new HashMap<>();
        int frequency = 0;
        for (int num : nums) {
           int count  = map.getOrDefault(num,0);
               frequency += count;
               map.put(num, count+1);

        }
        return frequency;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,1,1,3};
        System.out.println(numIdenticalPairs(nums));
        System.out.println(numIdenticcalPairs(nums));
    }
}
