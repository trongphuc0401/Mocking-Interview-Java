package Java8.LambdaExpression;

import java.util.function.Function;

/**
 * Test -
 *
 * @param
 * @return
 * @throws
 */
public class Test {
    public static void main(String[] args) {
        Function<String,Integer> func = name -> Integer.parseInt(name);
        func.apply("Phuc");
    }
}
