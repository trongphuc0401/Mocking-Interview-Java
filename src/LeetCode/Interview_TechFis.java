package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Interview_TechFis {

    public static List<List<String>> palindromePartitioning(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private static void backtrack(List<List<String>> result, List<String> current, String s, int start) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                current.add(s.substring(start, end + 1));
                backtrack(result, current, s, end + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String input1 = "aab";
        List<List<String>> output1 = palindromePartitioning(input1);
        System.out.println("Output for input \"" + input1 + "\":");
        for (List<String> partition : output1) {
            System.out.println(partition);
        }

        String input2 = "a";
        List<List<String>> output2 = palindromePartitioning(input2);
        System.out.println("\nOutput for input \"" + input2 + "\":");
        for (List<String> partition : output2) {
            System.out.println(partition);
        }
    }
}
