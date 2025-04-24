package LeetCode;

import java.util.Arrays;
import java.util.List;

/**
 * _874 -
 *
 * @param
 * @return
 * @throws
 */
public class _874 {


    public static int robotSim(int[] commands, int[][] obstacles) {

        List<int[]> directions = Arrays.asList(
                new int[]{0, 1},   // Bắc
                new int[]{1, 0},   // Đông
                new int[]{0, -1},  // Nam
                new int[]{-1, 0}   // Tây
        );
    int dirIndex = 0;

    for (int command : commands){
        if (command == -2) {
            dirIndex = (dirIndex - 1) % 4;
        }else if (command == -1) {
            dirIndex = (dirIndex + 1) % 4;
        }else {
            int dx = directions.get(dirIndex)[0];
            int dy = directions.get(dirIndex)[1];
            System.out.println(dx+":"+dy);
        }

    }

    return 0;

    }

    public static void main(String[] args) {
        int[] commands = {-2, 1, -1, 1};
        int[][] obstacles ={{0},{1},{-1}};
        robotSim(commands, obstacles);
    }
}
