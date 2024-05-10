package Collection.ArrayList;

import java.util.ArrayList;

public class Exercise13 {

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

        ArrayList<String> c3  = new ArrayList<>();



        c3.addAll(c1);
        c3.addAll(c2);

        for (String b : c3) {
            System.out.println(b);
        }
        ArrayList<String> newC3 = (ArrayList<String>)c3.clone();
        System.out.println(newC3);
        newC3.removeAll(newC3);
        System.out.println(newC3);


    }
}
