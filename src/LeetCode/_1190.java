package LeetCode;

/**
 * _1190 -
 *
 * @param
 * @return
 * @throws
 */
public class _1190 {
    public static void main(String[] args) {
        String str = "(Phuc)";
        System.out.println(reverseParentheses(str));
    }
    public static String swap(String str) {
        char ch;
        String nstr = "";
        for (int i = 0; i<str.length();i++) {
            ch = str.charAt(i);
            nstr = ch+nstr;
        }
        return nstr;
    }
    public static String reverseParentheses(String s) {
        char ch ;
        String nstr = "";
        for(int i = 0 ; i < s.length();i++) {
            if (s.contains("(") && s.contains(")")) {
                ch = s.charAt(i);
                nstr = ch+ nstr;
            }
        }
        return nstr.replaceAll("[()]", "");
    }
}
