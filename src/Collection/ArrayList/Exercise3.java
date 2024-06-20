package Collection.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Exercise3 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Blue");
        stringList.add("Red");
        stringList.add("Yellow");
        stringList.add("Black");
        stringList.add("Hang");
        stringList.add("Ifnot");

        stringList.set(0,"Pink");
        for (String element : stringList) {
            System.out.println(element);
        }
    }
}
