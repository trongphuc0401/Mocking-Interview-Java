package _28Tech.OJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ModuloWith2Number {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Đọc một dòng và chuyển đổi thành số nguyên
            long n = Long.parseLong(reader.readLine());

            long lastDigit = n % 10;
            long lastTwoDigits = n % 100;

            System.out.println(lastDigit);
            System.out.print(lastTwoDigits);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
