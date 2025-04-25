package LeetCode;

/**
 * _1052 -Grumpy Bookstore Owner
 *
 * @param
 * @return
 * @throws
 * Giải thích ngắn gọn là bài này sử tìm minnues mà khách hàng hài lòng
 */
public class _1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int unrealizedCustomers = 0;

        for(int i = 0 ;i< minutes ; i ++) {
            unrealizedCustomers+=customers[i]*grumpy[i];
        }
        int maxUnrealizedCustomers = unrealizedCustomers;

        for (int i = 0 ;i< minutes ; i ++) {
            unrealizedCustomers+=customers[i]*grumpy[i];
            unrealizedCustomers -= customers[i-minutes]*grumpy[i-minutes];

            maxUnrealizedCustomers = Math.max(maxUnrealizedCustomers, unrealizedCustomers);
        }
        int totalCustomers = maxUnrealizedCustomers;
        for (int i = 0; i < customers.length; i++) {
            totalCustomers += customers[i] * (1 - grumpy[i]);
        }
        return totalCustomers;
    }
}
