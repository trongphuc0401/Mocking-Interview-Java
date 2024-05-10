package Collection.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Exercise4 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();
        stringList.add("Blue");
        stringList.add("Red");
        stringList.add("Yellow");
        stringList.add("Black");
        stringList.add("Hang");
        stringList.add("Ifnot");

        stringList.add(0,"Pink");
        System.out.println(stringList.get(0));
        System.out.println(stringList.remove(2));
        System.out.println(stringList);
    }
}
