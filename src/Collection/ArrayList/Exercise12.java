package Collection.ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise12 {
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

        Collections.swap(c1,2,3);

        for (String b : c1) {
            System.out.println(b);
        }
    }

}
