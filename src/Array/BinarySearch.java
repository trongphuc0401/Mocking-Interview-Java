package Array;

public class BinarySearch {
    public int searchInsert(int[] nums, int target) {

        int i = 0;
        int j = nums.length -1;

        while (i <= j) {
            int mid  = i + (j-i) /2;
            int midValue = nums[mid];

            if(midValue < target) {
                i = mid + 1;
            }else if(midValue > target) {
                j = mid - 1;
            }else{
                return mid;
            }

        }
        return -1;
    }
}
