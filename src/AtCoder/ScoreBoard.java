package AtCoder;

import java.util.Scanner;

public class ScoreBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int takahashiScore = 0;
        int aokiScore = 0;

        for(int i = 0; i < N; i++) {
            int Xi = scanner.nextInt();
            int Yi = scanner.nextInt();

            takahashiScore +=Xi;
            aokiScore += Yi;
        }
        if (takahashiScore > aokiScore) {
            System.out.println("Takahashi");
        } else if (takahashiScore < aokiScore) {
            System.out.println("Aoki");
        } else {
            System.out.println("Draw");
        }
    }
}
