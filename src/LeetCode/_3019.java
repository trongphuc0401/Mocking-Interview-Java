package LeetCode;

public class _3019 {

    public int countKeyChanges(String s) {

        int count  = 0 ;

        for (int i = 0; i < s.length()-1; i++) {
           String s2= s.toLowerCase();
           if (!(s2.charAt(i) == s2.charAt(i + 1))) {
               count ++;
           }
        }
        return count;
    }

    public static void main(String[] args) {

        String s = "AaAaAaaA";
        _3019 obj = new _3019();
        System.out.println(obj.countKeyChanges(s));

    }
}
