package _28Tech.OJ;

import java.util.Scanner;

public class PrintCellFloorRound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x =  sc.nextDouble();

        int resultCeil  = (int) Math.ceil(x);
        int resultFloor = (int)Math.floor(x);
        int resultRound = (int)Math.round(x);

        System.out.println(resultFloor);
        System.out.println(resultCeil);
        System.out.print(resultRound);

    }
}
