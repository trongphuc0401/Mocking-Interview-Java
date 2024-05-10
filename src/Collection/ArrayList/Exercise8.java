package Collection.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise8 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();
        stringList.add("Blue");
        stringList.add("Red");
        stringList.add("Yellow");
        stringList.add("Black");
        stringList.add("Hang");
        stringList.add("Ifnot");

        System.out.println("--------------------");
        System.out.println(stringList);
        Collections.reverse(stringList);
        System.out.println("--------------------");
        System.out.println(stringList);
        Collections.shuffle(stringList);
        System.out.println(stringList);


    }
}
