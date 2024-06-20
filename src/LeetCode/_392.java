package LeetCode;



public class _392 {
    public boolean isSubsequence(String s, String t) {

        int j = 0;
        if(s.length()<1)
            return true;
        for(int i = 0; i<t.length();i++) {
            if (s.charAt(j) == t.charAt(i)) {


                j++;
            }

            if(j == s.length() ) {
                return true;
            }

        }
        return false;
    }


    public static void main(String[] args) {
        String s = "axc", t = "ahbgdc";
        _392 obj = new _392();
        System.out.println(obj.isSubsequence(s, t));
    }
}
