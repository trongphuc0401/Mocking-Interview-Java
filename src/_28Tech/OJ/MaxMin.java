                        package _28Tech.OJ;
                        import java.io.BufferedReader;
                        import java.io.InputStreamReader;
                        import java.io.IOException;

                        public class MaxMin {
                            public static void main(String[] args) {
                                try {
                                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                                    int x = Integer.parseInt(reader.readLine());
                                    int y = Integer.parseInt(reader.readLine());
                                    int z = Integer.parseInt(reader.readLine());
                                    int t = Integer.parseInt(reader.readLine());

                                    int maxXY = Math.max(x, y);
                                    System.out.println(maxXY);

                                    int minZT = Math.min(z, t);
                                    System.out.println(minZT);

                                    int maxXYZ = Math.max(Math.max(x, y), z);
                                    System.out.println(maxXYZ);

                                    int minXYZT = Math.min(Math.min(x, y), Math.min(z, t));
                                    System.out.println(minXYZT);

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
