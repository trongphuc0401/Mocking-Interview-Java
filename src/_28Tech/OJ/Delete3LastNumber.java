package _28Tech.OJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Delete3LastNumber {
                public static void main(String[] args) {
                    try {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                        // Đọc một dòng và chuyển đổi thành số nguyên
                        long n = Long.parseLong(reader.readLine());

                        long lastThreeDigits1= n * 2;
                        long lastThreeDigits2 = n * 10;
                        long lastThreeDigits3 = n / 2;
                        double lastThreeDigits4 = (double) n / 2;



                        System.out.println(lastThreeDigits1);
                        System.out.println(lastThreeDigits2);
                        System.out.println(lastThreeDigits3);
                        System.out.format("%.3f",lastThreeDigits4);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
}
