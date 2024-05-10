package Collection.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Exercise5 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();
        stringList.add("Blue");
        stringList.add("Red");
        stringList.add("Yellow");
        stringList.add("Black");
        stringList.add("Hang");
        stringList.add("Ifnot");


        stringList.add(0,"Pink");
        stringList.set(3,"Yellow2");
        System.out.println('1'+'1');
        for (String element : stringList) {
            System.out.println(element);
        }
    }
}
