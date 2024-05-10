package LeetCode;

public class _1137 {
    public int tribonacci(int n) {
        int t[] = {0,1,1};

        if(n < 3) {
            return t[n];

        }
        for(int i = 3 ; i <= n; i++) {
            int sum = t[0] + t[1] + t[2];

            t[0]=t[1];
            t[1] = t[2];
            t[2] = sum;
        }
        return t[2];
    }
    public static void main(String[] args) {

    }

}
