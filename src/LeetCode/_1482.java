package LeetCode;

/**
 * _1482 - Minimum Number of Days to Make m Bouquets
 *
 * You are given an integer array bloomDay, an integer m and an integer k.
 * You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
 * The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
 * Return the minimum number of days you need to wait to be able to make m bouquets from the garden.
 * If it is impossible to make m bouquets return -1.
 *
 * i
 *
 *
 */
public class _1482 {
    private int getNumOBouquets(int[] bloomDay, int mid, int k) {
        int numOfBouquets = 0;
        int count  = 0;

        for(int i = 0 ; i < bloomDay.length;i++) {
            if(bloomDay[i] <= mid) {
                count++;
            }else {
                count = 0 ;

            }
            if(count ==k) {
                numOfBouquets++;
                count = 0;
            }
        }
        return numOfBouquets;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int start = 0;
        int end = 0;
        for (int day : bloomDay) {
            end = Math.max(end, day);
        }
        int minDays = -1;
        while( start <= end) {
            int mid = (start + end)/2;

            if(getNumOBouquets(bloomDay,mid,k) >= m) {
                minDays = mid;
                end  =mid -1;

            }else {
                start = mid +1;
            }
        }
        return minDays;
    }
}
