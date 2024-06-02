                    package _28Tech;

                    import java.io.BufferedReader;
                    import java.io.IOException;
                    import java.io.InputStreamReader;

                    public class Test {

                        public static void main(String[] args) {
                            try {
                                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                                String[] input = reader.readLine().split("     ");
                                int a = Integer.parseInt(input[0]);
                                int b = Integer.parseInt(input[1]);

                                int integerDivision = a % b;
                                System.out.println(integerDivision);


                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
