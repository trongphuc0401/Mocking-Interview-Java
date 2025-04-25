package LeetCode;

import java.util.*;

/**
 * _1636 -
 *
 * @param
 * @return
 * @throws
 */
public class _1636 {
    /**
     * Hôm nay sẽ giải bài này với brute forcce
     * input: int[1,1,2,2,2,3] count[]=
     * Output: [3,1,1,2,2,2]
     *
     * yêu cầu bài này sắp xếp dãy số theo thứ tự tăng dần tùy thuộc vào số lượng phần tử sẽ sắp xếp theo từ ít đến cao
     *Output sẽ là 1 mảng số chứa các phần tử đã dc sắp xếp
     * vậy là phải sử dungj hàm để nạp data đã dc ăps xếp vào mảng mới
     * tạo biến count để đếm các phần tử nhiều nhất nếu
     *
     * dùng vòng for duyệt qua từng phần tử và tìm
     *
     *(Khó :(((((((((((((()
     * @param nums
     * @return
     */
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0 ; i < nums.length;i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(a,b) ->{
            if (map.get(a) == map.get(b)) {
                return b-a;
            }
            else {
                return map.get(a) - map.get(b);
            }
        });

        int[] result = new int[nums.length];
        int index = 0;
        for(int num: list) {
            for (int i = 0 ; i < map.get(num); i++) {
                result[index++] = num;
            }
        }
       return result;

    }
}
