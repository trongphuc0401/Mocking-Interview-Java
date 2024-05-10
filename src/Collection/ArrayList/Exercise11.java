package Collection.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class Exercise11 {
    public static void main(String[] args) {
        ArrayList<String> c1 = new ArrayList<String>();
        c1.add("Red");
        c1.add("Blue");
        c1.add("Yellow");
        c1.add("Green");
        c1.add("Black");
        c1.add("Pink");
        c1.add("Cyan");
        System.out.println(c1);

        ArrayList<String> c2 = new ArrayList<String>();

        c2.add("Red");
        c2.add("Blue");
        c2.add("Yellow");
        c2.add("Green2");
        c2.add("Black");
        c2.add("Pink");
        c2.add("Cyan");
        System.out.println(c2);

        ArrayList<String> c3 = new ArrayList<String>();
        for (String element :c1 ) {
            c3.add(c2.contains(element) ? "Yes":"No");
        }
        System.out.println(c3);



    }
}
