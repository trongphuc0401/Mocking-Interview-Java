package LeetCode;
//Daily Coding
//First Unique Character in a String
/*
* input = s : "leetcode"
* output = 0
* find firts character with unduplicatd with else character
*
* ------------
* for i in length() of s
* if indexOf(chart(i)) == lastIndexOf(chart(i))
* return i
* else
* return -1
* */
public class _387 {
    public int firstUniqChar(String s) {

        for(int i = 0;i<s.length();i++) {
           if(s.indexOf(s.charAt(i)) ==s.lastIndexOf(s.charAt(i))){
               return i;
           }
        }
        return -1;
    }
}
