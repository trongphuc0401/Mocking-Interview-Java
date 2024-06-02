package LeetCode;

public class _344 {

    public void reverseString(char[] s) {

        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

    }

    public static void main(String[] args) {
        char[]  s = ["h","e","l","l","o"];
        _344 test = new _344();
        System.out.println(test.reverseString(s));
    }
}
