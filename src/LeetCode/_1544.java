package LeetCode;

import java.util.Stack;

public class _1544 {
    public static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(!stack.isEmpty() && Math.abs(c-stack.peek()) ==32) {
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0,stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "abBAcC";

        _1544 object = new _1544();
        String result = object.makeGood(s);
        System.out.println(result);
    }
}
