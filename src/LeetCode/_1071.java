package LeetCode;
/*
1071. Greatest Common Divisor of Strings


* For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2
* */
public class _1071 {

    public static String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) {
            return "";
        }
        int gcd = gcd(str1.length(),str2.length());
        return str1.substring(0,gcd);
    }
    private static int gcd(int a, int b) {
        return b==0 ? a:gcd(b,a%b);
    }

    public static void main(String[] args) {


       String str1 = "ABCABC";
               String str2 = "ABC";
       gcdOfStrings(str1,str2);
    }
}
