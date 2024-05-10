package JavaCore;

import java.util.Scanner;

@SuppressWarnings("ALL")
public class SumOfBinary {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("First Binary Number: ");
        long firstBinary  = scanner.nextLong();
        System.out.println("Second Binary Number: ");
        long secondBinary = scanner.nextLong();
        addBinaryNumber(firstBinary, secondBinary);
    }

    public static void addBinaryNumber(long firstBinary, long secondBinary) throws Exception{
        int remainder = 0;
        int[] sum  = new int[20];
        int i = 0;
        while(firstBinary !=0 || secondBinary !=0) {
            sum[i++] = (int)(firstBinary % 10 + secondBinary % 10 + remainder)%2;
            remainder = (int)(firstBinary % 10 + secondBinary % 10 + remainder)/2;
            firstBinary /=10;
            secondBinary /=10;
        }
        if (remainder != 0) {
            sum[i++] = remainder;
        }
        i--;
        System.out.print("Sum of Binary Number: ");
        while (i>=0) {
            System.out.print(sum[i--]);
        }
    }

}


