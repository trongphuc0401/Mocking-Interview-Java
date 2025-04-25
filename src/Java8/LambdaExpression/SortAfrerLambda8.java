package Java8.LambdaExpression;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * SortAfrerLambda8 -
 *
 * @param
 * @return
 * @throws
 */
public class SortAfrerLambda8 {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");
        Collections.sort(languages, String::compareTo);
        languages.forEach(System.out::println);
    }
}
