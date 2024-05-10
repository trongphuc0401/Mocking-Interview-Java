package AtCoder;

    import java.util.*;

    public class LuckyWords {
        static int[][] grid;
        static int[][] dp;
        static int[][] path;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int N = scanner.nextInt();
            int M = scanner.nextInt();

            grid = new int[N][N];
            dp = new int[N][N];
            path = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }

            int si = scanner.nextInt();
            int sj = scanner.nextInt();

            List<String> words = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                words.add(scanner.next());
            }

            List<int[]> result = findOptimalPath(N, M, si, sj, words);

            for (int[] point : result) {
                System.out.println((point[0] + 1) + " " + (point[1] + 1));
            }
        }

        private static List<int[]> findOptimalPath(int N, int M, int si, int sj, List<String> words) {
            List<int[]> result = new ArrayList<>();

            for (String word : words) {
                int[][] currentDp = new int[N][N];
                int[][] currentPath = new int[N][N];

                int max = 0;
                int endI = 0;
                int endJ = 0;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        currentDp[i][j] = dp[i][j];
                        currentPath[i][j] = path[i][j];

                        int k = 0;
                        while (k < word.length() && i + k < N && grid[i + k][j] == word.charAt(k)) {
                            k++;
                        }

                        if (k == word.length()) {
                            for (int l = 0; l < k; l++) {
                                currentDp[i + l][j] += Math.abs(i + l - si) + Math.abs(j - sj) + 1;
                                currentPath[i + l][j] = i;
                            }

                            if (currentDp[i + k - 1][j] > max) {
                                max = currentDp[i + k - 1][j];
                                endI = i + k - 1;
                                endJ = j;
                            }
                        }
                    }
                }

                for (int i = N - 1; i >= 0; i--) {
                    for (int j = 0; j < N; j++) {
                        dp[i][j] = currentDp[i][j];
                        path[i][j] = currentPath[i][j];
                    }
                }

                int[] point = {endI, endJ};
                result.add(point);
            }

            return result;
        }
    }


