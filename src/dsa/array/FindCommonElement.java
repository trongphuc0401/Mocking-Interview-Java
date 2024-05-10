package dsa.array;
/*
*
Input:
ar1[] = {1, 5, 10, 20, 40, 80}
ar2[] = {6, 7, 20, 80, 100}
ar3[] = {3, 4, 15, 20, 30, 70, 80, 120}
Output: 20, 80
*
Input:
ar1[] = {1, 5, 5}
ar2[] = {3, 4, 5, 5, 10}
ar3[] = {5, 5, 10, 20}
Output: 5, 5
*
*
*gợi ý cách giải

Initialize both pointers i and j to 0, and an empty list common.
While both pointers i and j are within the bounds of the two arrays:
If arr1[i] is less than arr2[j], increment i by 1.
If arr2[j] is less than arr1[i], increment j by 1.
If arr1[i] is equal to arr2[j]:
Add arr1[i] to the common list.
Increment both i and j by 1.
Return the common list containing the common elements of the two arrays.
* */
public class FindCommonElement {
    static void findIntersection(int [] arr1 , int [] arr2, int[] temp, int m , int n , int[] k ) {
        int i = 0, j = 0;

        while (i < m && j < n)  {
            if(arr1[i] < arr2[j]) {
                i++;
            }
            else if (arr2[j] < arr1[i]) {
                j++;
            }
            else  {
                temp[k[0]] = arr1[i];
                i++;
                j++;
                k[0] ++;
            }
        }
    }

    /*
    Create and initialize three variables i, j, and k with 0, it will point to the indices of the arrays.
    Repeat the following steps until we reach the end of any one of the arrays:
        + Check whether the integers appointed by i, j, and k are equal or not.
        + If they are equal, print any of the integers and increase i, j, and k by 1.
        + Otherwise, increase the index that points to the smaller integer by 1.

    * */
    static void findCommon(int arr1[], int arr2[], int arr3[]) {
        int i  = 0, j = 0, k = 0;

        while(i<arr1.length &&  j<arr2.length && k<arr3.length) {
            if(arr1[i] == arr2[j] && arr2[j] ==arr3[k])  {
                System.out.println(arr1[i] + " ");
                i++;
                j++;
                k++;
            }else if (arr1[i] < arr2[j]) {
                i++;
            }else if (arr2[j] < arr3[k] ) {
                j++;
            } else {
                k++;
            }
        }
    }

     public static int[] findIntersectionValues(int[] nums1 , int[] nums2) {
        int i = 0 , j = 0;

        while (i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                System.out.println(nums1[i] + " ");
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) {
                i++;
            } else  {
                j++;
            }
        }
        return nums1;
    }

    public static void main(String[] args) {

        FindCommonElement object = new FindCommonElement();
        int[] arr1 = { 4,3,2,3,1 };
        int[] arr2 = { 2,2,5,2,3,6,4 };
        int[] arr3 = { 3, 4, 15, 20, 30, 70, 80, 120 };
        int[] nums1 = { 4,3,2,3,1 };
        int[] nums2 = {2,2,5,2,3,6};
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n3 = arr3.length;

        int[] temp = new int[200000];

        int[] ans = new int[200000];

        int[] k = {0};

        findIntersection(arr1,arr2,temp,n1,n2,k);
        int tempSize = k[0];
        k[0] = 0;

        findIntersection(arr3 , temp, ans,n3,tempSize,k);
        object.findCommon(arr1,arr2,arr3);
        object.findIntersectionValues(nums1,nums2);
        System.out.println("Common elements present in arrays are: ");

        for (int i = 0; i<k[0];i++) {
            System.out.println(ans[i] + " ");
        }

    }

}
