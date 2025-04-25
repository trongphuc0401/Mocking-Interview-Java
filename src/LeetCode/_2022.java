package LeetCode;

import java.util.Arrays;

/**
 * _2022 -
 *
 * @param
 * @return
 * @throws
 */
public class _2022 {
    public int[][] construct2DArray1(int[] original, int m, int n) {

        if (m*n != original.length) return null;

        int[][] array2D = new int[m][n];

        int i = 0 ;

        for(int col = 0 ; col < m ; col++){
            for(int row = 0 ; row < n ; row++) {
                array2D[col][row] = original[i];
                i++;
            }
        }
        return array2D;
    }

    public int[][] construct2DArray2(int[] original, int m, int n) {

        if (m*n != original.length) return null;

        int[][] array2D = new int[m][n];

       for(int i = 0 ; i < m ; i++){
           array2D[i] = Arrays.copyOfRange(original, i*n , i*n+n);
       }
        return array2D;
    }

}
