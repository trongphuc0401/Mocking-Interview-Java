package LeetCode;

/**
 * _1518 - Water Bottles
 *
 * @param
 * @return
 * @throws
 *
 *
 * Input: numBottles = 9, numExchange = 3
 * Output: 13
 * Explanation: You can exchange 3 empty bottles to get 1 full water bottle.
 * Number of water bottles you can drink: 9 + 3 + 1 = 13
 */
public class _1518 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int exchange = 0 ;
        int max = 0 ;
        int reminder = 0 ;

            if (numBottles >= numExchange) {
                if (numBottles% numExchange ==0) {
                    exchange = numBottles/numExchange;
                }else {
                    reminder = numBottles % numExchange +1;
                }
                max = exchange/numExchange;
                return numBottles + exchange + reminder +max;
            }
            return numBottles;



    }
    public static void main(String[] args) {

        int numBottles = 9;
        int numExchange = 3;
        _1518 object = new _1518();

        System.out.println(object.numWaterBottles(numBottles,numExchange));

    }
}
