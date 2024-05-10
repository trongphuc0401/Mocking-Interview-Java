package LeetCode;

public class _1249 {
    public static String minRemoveToMakeValid(String s) {
        int open  = 0, close  = 0,flag = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) ==' '){
                open ++;
                flag +=1;

            }else if(s.charAt(i) ==')' && flag >0) {
                close ++;
                flag --;
            }
        }
        int k = Math.min(open,close);
        String answer ="";
        open = k;
        close = k;

        for (int i=0;i<s.length();i++) {
            if(s.charAt(i) =='(') {
                if (open >0) {
                    answer+='(';
                    open--;
                }
                continue;
            }
            if (s.charAt(i) ==')') {
                if (close>0 && close>open) {
                    answer +=')';
                    close--;
                }
                continue;
            }
            else answer+=s.charAt(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        minRemoveToMakeValid(s);
        System.out.println(s);
    }
}
