package _28Tech.OJ;

import java.util.Scanner;

public class PrintSQRT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x =  sc.nextInt();

        double resultSqrt  = Math.sqrt(x);
        double resultCbrt = Math.cbrt(x);

        System.out.printf("%.2f%n", resultSqrt);
        System.out.printf("%.2f", resultCbrt);


    }
}
