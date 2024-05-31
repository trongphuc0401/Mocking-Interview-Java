package _28Tech.OJ;

import java.io.BufferedReader;
                import java.io.InputStreamReader;
                import java.io.IOException;

                public class HoanVi2So {
                    public static void main(String[] args) {
                        try {
                            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                            String[] input = reader.readLine().split(" ");
                            long a = Long.parseLong(input[0]);
                            long b = Long.parseLong(input[1]);

                            long tmp = a;
                            a = b;
                            b = tmp;

                            long result = 128L * a + 97L * b + 1000L;
                            System.out.println(result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
