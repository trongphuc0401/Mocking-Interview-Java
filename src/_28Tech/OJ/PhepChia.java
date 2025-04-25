package _28Tech.OJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class PhepChia {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String[] input = reader.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            int integerDivision = b / a;
            System.out.println(integerDivision);

            double decimalDivision = (double) b / a;
            System.out.printf("%.2f%n", decimalDivision);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
