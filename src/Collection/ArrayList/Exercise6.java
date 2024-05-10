package Collection.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Exercise6 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();
        stringList.add("Blue");
        stringList.add("Red");
        stringList.add("Yellow");
        stringList.add("Black");
        stringList.add("Hang");
        stringList.add("Ifnot");
        System.out.println(stringList.contains("Red"));
    }
}
