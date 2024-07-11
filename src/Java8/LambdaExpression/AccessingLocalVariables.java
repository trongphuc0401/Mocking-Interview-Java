package Java8.LambdaExpression;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * AccessingLocalVariables -
 *
 * @param
 * @return
 * @throws
 */

interface Converter<F,T> {
    T convert(F from);
}
public class AccessingLocalVariables {
    public static void doSomething1() {
        final int num = 1;
        Converter<Integer, String > stringConverter = (from) ->String.valueOf(from+ num);
        stringConverter.convert(2);
    }

}
