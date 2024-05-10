package dsa.array;

public class CheckForMajorityElementInSortArray {
    public static boolean isMajority(int[] nums , int n, int pos) {
        int lastIndex = 0;

        lastIndex = (n%2 ==0) ? n/2 : n/2+1;

        for(int i = 0; i < lastIndex ; i++) {
            if (nums[i] == pos && nums[i + n/2] == pos) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMajorityBinarySearch(int[] nums , int n , int pos)  {
        int i = binarySearch(nums,0,n-1,pos);
        if(i==-1)
            return false;
        if(((i + n/2) <= (n -1)) && nums[i + n/2] == pos)
            return true;
        else  {
            return false;
        }
    }

    static int binarySearch(int nums[] , int low , int high , int pos) {
        if(high > low) {
            int mid  = (high + low/ 2);

            if((mid ==0)||pos > nums[mid -1] && (nums[mid] ==1)) {
                return mid;
            }
            else if(pos > nums[mid]) {
                return binarySearch(nums,(mid +1),high,pos);
            }
            else {
                return binarySearch(nums,low,(mid-1),pos);
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        int nums[] = {2,3,54,5,2,2,2,1,1};
        int n = nums.length;
        int pos = 2;

        if (isMajority(nums,n,pos)==true) {
            System.out.println(pos+"appears more than" +n/2+"time");
        }
        else {
            System.out.println("Not found");
        }
    }
}
