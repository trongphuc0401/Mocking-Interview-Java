package dsa.stack;

import java.util.HashMap;
import java.util.Stack;

public class _20 {
    public static boolean isValid(String s) {
        if(s == null || (s.length()%2!=0)) {
            return false;

        }
            Stack<Character> stack = new Stack<>();
            HashMap<Character,Character> map = new HashMap<>();

            map.put(')','(');
            map.put('}','{');
            map.put(']','[');



            char[] ch = s.toCharArray();
            for (char c: ch) {
                if (map.containsKey(c)) {
                    if (stack.isEmpty() || stack.pop() !=map.get(c)) {
                        return false;
                    }
                }else {
                    stack.push(c);
                }
            }
            return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(}";
        if (isValid(s)) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
    }
}
