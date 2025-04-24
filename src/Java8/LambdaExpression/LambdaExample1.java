package Java8.LambdaExpression;

import java.util.Date;

/**
 * LambdaExample1 -
 *
 * @param
 * @return
 * @throws
 */


@FunctionalInterface
interface SayHelloWorld {

    int add(int a , int b);

}
public class LambdaExample1 {
    public static void main(String[] args) {

        // SayHelloWorld sayHelloWorld1 = (a,b) -> {
        //     int sum = (a+b);
        //     return sum;
        // };
        // System.out.println(sayHelloWorld1.add(10,20));

        // Cách lambda ko return

        // SayHelloWorld sayHelloWorld1 = (a,b) -> a+b;
        // System.out.println(sayHelloWorld1.add(10,20));

        //Cách lambda sử dụng method reference
        SayHelloWorld sayHelloWorld1  = Integer::sum;
        System.out.println(sayHelloWorld1.add(10,20));

    }
}
