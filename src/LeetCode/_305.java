package LeetCode;

import java.util.*;

public class _305 {
//    public int[] intersect(int[] nums1, int[] nums2) {
//        Arrays.sort(nums1);
//        Arrays .sort(nums2);
//
//        int i = 0;
//        int j = 0;
//
//        int[] result = new int[nums1.length];
//        int k = 0 ;
//
//        while(i< nums1.length && j < nums2.length) {
//            if(nums1[i] == nums2[j]) {
//                result[k] = nums1[i];
//                i++;
//                j++;
//                k++;
//            }else if(nums1[i]  > nums2[j]) {
//                j++;
//            }else {
//                i++;
//            }
//
//        }
//        return Arrays.copyOfRange(result, 0, k);
//
//    }
    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i],map.getOrDefault(nums1[i],0) + 1);

        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            int countNumber = map.getOrDefault(nums2[i],0);
            if (countNumber > 0) {
                list.add(nums2[i]);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i]  = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int [] nums1 = {1,2,2,1};
        int [] nums2 = {2,2};

        _305 obj = new _305();
        System.out.println(obj.intersect(nums1, nums2));
    }
}
