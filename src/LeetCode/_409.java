package LeetCode;

import java.util.HashMap;
import java.util.Map;

/*
* Hôm nay sẽ làm Longest Palindrome
* Palidrome nghĩa là một chuỗi có thể đọc được từ phía trước và phia sau
* ví dụ: dccaccd :> đọc trước và sau nghĩa cũng y chang
*
* Bài này thì cho mình 1 chuỗi và phải duyệt qua đó xem có bao nhiêu kí tự là Palidrome và sau đó in ra các kí tự đó
*
* bằng kiểu int
*Bài kiểu easy nhưng ko hề easy
*
* */
public class _409 {

    public int longestPalindrome(String s) {


        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);

        }
        int count =0;
        for (Map.Entry<Character,Integer> e: map.entrySet()) {
            if (e.getValue() % 2 == 0) {
                count++;
            }
        }
        if (count > 0) {
            return s.length()-count+1;
        }else {
            return s.length();
        }

    }

    public static void main(String[] args) {
        String s = "adam";
        _409 obj = new _409();
        System.out.println(obj.longestPalindrome(s));
    }
}
