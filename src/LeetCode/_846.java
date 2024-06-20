package LeetCode;


import java.util.Map;
import java.util.TreeMap;

/*
* Cái bài này là phải làm sao để cho 1 mảng có nhiều chữ số và int groupSize nhiệm vụ phải chia cái mảng này thành các mảng bằng với số groupSiz theo
* thứ tự tăng dần
* Input
* hand = {1,2,3,6,2,3,4,7,8} và groupSize = 3:
* Output
* Bởi vì chúng ta có thể chia các mảng đó thành 3 nhóm bằng nhau như
* {1,2,3} {2,3,4}, {6,7,8}
* chà có vẻ như sài HashMap :))) vì các phần tử trong đó ko giống nhau
*
*
* */
public class _846 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int handSize = hand.length;
        if(handSize %groupSize != 0) return false;

        Map<Integer,Integer> cardCount = new TreeMap<>();
        for(int i = 0 ; i < handSize ; i++){
            cardCount.put(hand[i],cardCount.getOrDefault(hand[i],0) + 1);
        }
        while (cardCount.size() >0) {
            int current_card = cardCount.entrySet().iterator().next().getKey();
            for (int i = 0; i < groupSize; i++) {
                if (!cardCount.containsKey(current_card + i)) return false;
                cardCount.put(
                        current_card + i,
                        cardCount.get(current_card + i) - 1
                );
                if (cardCount.get(current_card + i) == 0) cardCount.remove(
                        current_card + i
                );
            }
        }
        return true;
    }
}
