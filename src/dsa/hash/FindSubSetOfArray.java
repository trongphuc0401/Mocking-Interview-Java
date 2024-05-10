package dsa.hash;


/*
*
* Given two arrays: arr1[0..m-1] and arr2[0..n-1]. Find whether arr2[] is a subset of arr1[] or not.
* Both arrays are not in sorted order.
* It may be assumed that elements in both arrays are distinct.
*
*
*
* Input: arr1[] = {11, 1, 13, 21, 3, 7}, arr2[] = {11, 3, 7, 1}
Output: arr2[] is a subset of arr1[]

Input: arr1[] = {1, 2, 3, 4, 5, 6}, arr2[] = {1, 2, 4}
Output: arr2[] is a subset of arr1[]
* */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindSubSetOfArray {



    public static boolean isSubnetWithTwoLoop(int[] arr1 , int[] arr2) {


        for (int i = 0 ;  i <arr1.length ; i ++) {
            for (int j = 0 ; j < arr2.length; j ++) {
                if (arr1[i] == arr2[j]) {
                    break;

                }
                if (arr1.length == arr2.length)
                    return false;
            }
        }

        return true;

    }

    public static boolean isSubnetWithSortAndBinarySearch(int[] arr1 , int[] arr2) {

        sort(arr1 , 0 , arr1.length - 1);

        for (int i = 0 ; i < arr2.length ; i++) {
            if (binarySearch(arr1, 0 , arr1.length  -1 , arr2[i]) == -1) {
                return  false;
            }
        }

        return true;
    }

    public static boolean isSubnetWithSortAndBinarySearchInSystems(int[] arr1 , int[] arr2) {

        Arrays.sort(arr1,0,arr1.length-1);
        for (int i = 0 ; i < arr2.length ; i++) {
            if (Arrays.binarySearch(arr1,0 , arr1.length - 1 , arr2[i]) ==-1) {
                return  false;
            }
        }

        return true;
    }
    public static boolean isSubnetWithHashing(int[] arr1 , int[] arr2) {


        HashSet<Integer> hash =  new HashSet<>();

       for (int i = 0 ; i < arr1.length ; i++) {
            if (!hash.contains(arr1[i])) {
                hash.add(arr1[i]);
            }

       }

       for (int i = 0 ; i < arr2.length ; i ++) {
           if (!hash.contains(arr2[i])) {
               hash.add(arr2[i]);
               return false;
           }

       }

        return true;
    }

   static int binarySearch(int[] arr , int left , int right , int x) {

        if (right >= left) {
            int mid = (left + right)/2;

            if (arr[mid] == x || mid ==0 || x > arr[mid - 1]) {
                return  mid;
            } else if (x > arr[mid]) {
                return binarySearch(arr,(mid + 1) , right , x );
            }else {
                return binarySearch(arr, left , (mid + 1) , x);
            }
        }
        return -1;

   }

    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void sort(int arr[], int low, int high)
    {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr1 =  {1, 2, 3, 4, 5, 6};
        int[] arr2 =  {1, 2, 4};

        if (isSubnetWithHashing(arr1,arr2)) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }


        Set<Integer> set = new HashSet<>();

        for(int i = 0 ; i<arr1.length ; i++) {
            if (!set.contains(arr1[i])) {
                set.add(arr1[i]);
            }
        }

        int p = set.size();
        for(int i = 0 ; i<arr2.length ; i++) {
            if (!set.contains(arr2[i])) {
                set.add(arr2[i]);
            }
        }

        if (set.size() == p) {
            System.out.println("arr2[] is subset of arr1[] "
                    + "\n");
        }
        else {
            System.out.println(
                    "arr2[] is not subset of arr1[] "
                            + "\n");
        }


    }

}
