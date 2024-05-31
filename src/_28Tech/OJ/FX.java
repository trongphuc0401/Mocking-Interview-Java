                package _28Tech.OJ;

                import java.io.*;

                public class FX {
                    public static void main(String[] args) {
                        try {
                            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                            String[] input = reader.readLine().split(" ");
                            long x = Long.parseLong(input[0]);
                            long y = Long.parseLong(input[1]);

                            long result = 5 * x + 2 * y + x * y;

                            System.out.println(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
