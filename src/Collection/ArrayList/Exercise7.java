package Collection.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise7 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();
        stringList.add("Blue");
        stringList.add("Red");
        stringList.add("Yellow");
        stringList.add("Black");
        stringList.add("Hang");
        stringList.add("Ifnot");

        for (String element : stringList) {
            System.out.println(element);
        }
        Collections.sort(stringList);
        System.out.println("------------------------");
        for (String element : stringList) {
            System.out.println(element);
        }
        System.out.println("----------------------------");

    }
}
