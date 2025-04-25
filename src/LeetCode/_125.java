package LeetCode;

import java.util.Locale;

public class _125 {
    public boolean isPalindrome(String s) {

        String string = s.toLowerCase(Locale.ROOT);
        int left  = 0, right = string.length() -1;
        while(left < right) {
            if(string.charAt(left++) != string.charAt(right--)) return false;
        }
        return true;
    }
}
