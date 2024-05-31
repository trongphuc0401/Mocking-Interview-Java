package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int left = 0;

        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {

                left ++;
                right --;
            }else {
                right--;
            }
            count ++;

        }
        return count;

    }
    public int numRescueBoats2(int[] people, int limit) {
        bucketSort(people,limit);
        int count = 0;

        for(int i = 0, j = people.length -1; i <= j ; j--) {
            if (people[i] + people[j] <= limit) {
                i++;
            }
            count ++;
        }
        return count;
        }

    private void bucketSort(int[] people, int limit) {
        int[] buckets = new int[limit + 1];
        for (int passenger : people) {
            buckets[passenger]++;
        }
        for (int i = 0, j = 0; i <= limit; i++) {
            while (buckets[i] > 0) {
                buckets[i]--;
                people[j++] = i;
            }
        }
    }
    public static void main(String[] args) {
       int[] people = new int[]{3,2,2,1};
       int limit = 3;
       _881 obj = new _881();
        System.out.println(obj.numRescueBoats2(people, limit));





    }
}
