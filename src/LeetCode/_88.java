package LeetCode;

import java.util.Arrays;

/**
 * _88 -Merge Sorted Array
 *
 * @param
 * @return
 * @throws
 */
public class _88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0 ;
        int k = 0;

        while (i < m && j < n ) {
            if (nums1[i] < nums2[j]) {
                nums1[k] = nums1[i];
                i++;
            }else {
                nums2[k] = nums2[j];
                j++;
            }
            k++;
        }

    }

    public static void main(String[] args) {
       int[] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
       int m = 3,n = 3;
       merge(nums1,m,nums2,n);


    }
}
