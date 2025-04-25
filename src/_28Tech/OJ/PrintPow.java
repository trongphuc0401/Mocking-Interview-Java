package _28Tech.OJ;

import java.util.Scanner;

public class PrintPow {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         double x =  sc.nextInt(); double y = sc.nextInt();

         long result = (long) Math.pow(x,y);

        System.out.println(result);

    }
}
