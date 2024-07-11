package Java8.LambdaExpression;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * SortBeforeLambda8 - Ví dụ cách sắp xếp một tập hợp có sẵn trước phiên bản Java 8
 *
 * @param
 * @return
 * @throws
 */
public class SortBeforeLambda8 {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");
        Collections.sort(languages, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (String language: languages) {
            System.out.println(language);
        }

    }
}
