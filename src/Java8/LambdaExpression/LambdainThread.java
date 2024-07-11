package Java8.LambdaExpression;

/**
 * LambdainThread -
 *
 * @param
 * @return
 * @throws
 */
public class LambdainThread {
    public static void main(String[] args) {
        Runnable r1 = () -> System.out.println("Runnable 1");
        r1.run();

    }
}
