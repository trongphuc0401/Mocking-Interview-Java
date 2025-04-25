package _28Tech.OJ;

import java.util.Scanner;

public class PrintExpression {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long x =  sc.nextLong(); long y = sc.nextLong(); long z=  sc.nextLong(); long t = sc.nextLong();

        System.out.println(x+","+y+","+z+","+t);
        System.out.println(x+y+z+t);
        System.out.print(x-y+z*t);
    }
}
