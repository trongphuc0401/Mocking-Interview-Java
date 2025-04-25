package _28Tech.OJ;


import java.util.Scanner;

/*
*
* Dòng 1 là số nguyên X

Dòng 2 là số nguyên Y

Dòng 3 là kí tự C

Dòng 4 là số thực float F

Dòng 5 là số thực double D.

Nhiệm vụ của bạn là in ra 5 dòng. Dòng 1 in X, dòng 2 in Y, dòng 3 in C, dòng 4 in F với 2 số đằng sau dấu phẩy, dòng 5 in D với 9 số sau dấu phẩy.
*
* */
public class PrintNumber {
        public static void main(String[] args) {

            Scanner sc= new Scanner(System.in);

            int x = sc.nextInt();
            Long y = sc.nextLong();
            String c  = sc.next();
            float f  = sc.nextFloat();
            double d = sc.nextDouble();

            System.out.println(x);
            System.out.println(y);
            System.out.println(c);
            System.out.printf("%.2f%n", f);
            System.out.printf("%.9f", d);


        }
}
