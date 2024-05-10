package Contest.Weekly_387;

import java.util.ArrayList;
import java.util.List;

public class Distribute_Elements_into_Two_Array {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        int ans[] = new int[n];

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for(int i=2;i<n;i++) {
            if (arr1.get(arr1.size()-1)>arr2.get(arr2.size()-1))
                arr1.add(nums[i]);
            else
                arr2.add(nums[i]);
        }
        for(int i=0;i<arr1.size();i++) {
            ans[i] =arr1.get(i);
        }
        int j =arr1.size();
            for (int i = 0;i<arr2.size();i++) {
                ans[i]  =arr2.get(i);
                j++;
            }
            return ans;
    }
}
