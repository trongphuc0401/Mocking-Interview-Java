package Collection.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Exercise10 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();
        stringList.add("Blue");
        stringList.add("Red");
        stringList.add("Yellow");
        stringList.add("Black");
        stringList.add("Hang");
        stringList.add("Ifnot");
        System.out.println(stringList);
        System.out.println("-------------------");

        List<String> sublist = stringList.subList(0,3);
        System.out.println(sublist);
    }
}
