package LeetCode;
///205. Isomorphic Strings

import java.util.Arrays;

/*
* What is Isomorphic ?
*
* Có thể nói Phép Đẳng cấu (Isomorphic) là phép mà hai đối có "nguồn" và "đích" trùng nhau
*
* Trong bài toán Isomorphic String này ta ta có thể xét hai chuỗi có phải đẳng cấu hay không
*
* Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters.
*  No two characters may map to the same character, but a character may map to itself.
*
* Input: s = "egg", t = "add"
Output: true
*
Bên Geekforgeek nó có chỉ cách để viết mã giả
*
 if str1 và string not same => return false
 bỏ vô vòng for
 *
* */
public class _205 {
    static int size = 256;
    public static boolean isIsomorphic(String s, String t) {

        int m = s.length();
        int n = t.length();

        if(m!=n) {
            return false;
        }

        Boolean[] marked = new Boolean[size];
        Arrays.fill(marked,Boolean.FALSE);

        int[] map = new int[size];
        Arrays.fill(map,-1);

        for (int i = 0; i<n;i++) {
            if(map[s.charAt(i)] ==1) {
                if(marked[t.charAt(i)] == true) {
                    return false;
                }
                marked[t.charAt(i)] = true;

                map[s.charAt(i)] = t.charAt(i);
            }else if(map[s.charAt(i)]!= t.charAt(i)) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String s = "egg", t = "add";
        _205 object = new _205();
        object.isIsomorphic(s,t);
    }
}
