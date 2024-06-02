package Collection.TreeSet;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static final int NUM_OF_ELEMENT = 5;
    public static void main(String[] args) {
        // Create set
        Set<String> set = new TreeSet<>();
        set.add("Item01");
        set.add("Item02");
        set.add("Item03");
        set.add("Item04");
        set.add("Item05");
        set.add("Item02");
        set.add("Item03");

        // Show set through for-each
        for (String item : set) {
            System.out.print(item + " ");
        }
    }
}
