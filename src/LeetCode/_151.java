package LeetCode;

public class _151 {

    public static String swap(String s, int i , int j) {
        char ch[] = s.toCharArray();
        char temp = ch[i];
        ch[i]  = ch[j];
        ch[j] = temp;
        return new String(ch);
    }
    public static String reverseWords(String s) {

        int left = 0, i = 0, len = s.length();
        while (s.charAt(i) ==' ')
            i++;
        left = i;

        while (i<len) {
            if(i+1 ==len || s.charAt(i) == ' '){
                int j = i-1;
                if(i+1 ==len)
                    j++;
                while (left < j)
                    s = swap(s,left++,j--);
                left = i+1;

            }
            if (i>left && s.charAt(left)==' ')
                left = i;
            i++;
        }
        s = new StringBuilder(s).reverse().toString();
        return s;
    }

    public static void main(String[] args) {
        String s = "i love you";
         s = reverseWords(s);
        System.out.println(s);

    }
}
