package LeetCode;

import java.util.Arrays;

public class _85 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length ==0) return 0;
        int m = matrix.length, n  = matrix[0].length;

        int[] left = new int[n],right  =new int[n],height = new int[n];
        Arrays.fill(right,n);
        int maxArea = 0;

        for(int i = 0; i< m;i++) {
            int curleft = 0 ,curRight = n;
            for(int j = 0; j<n ; j++ ) {
                if(matrix[i][j] =='1') {
                    height[j]++;
                    left[j] = Math.max(left[j],curleft);
                }else {
                    height[j] =0;
                    left[j] = 0;
                    curleft = j+1;
                }
            }
            for (int j = n-1;j>= 0 ; j--) {
                if (matrix[i][j] =='1') {
                    right[j] = Math.min(right[j],curRight);
                }else {
                    right[j] = n;
                    curRight = j;
                }
            }
            for (int j = 0;j<n;j++) {
                maxArea = Math.max(maxArea,(right[j] - left[j]) * height[j]);

            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
    }
}
