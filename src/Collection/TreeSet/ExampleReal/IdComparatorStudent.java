package Collection.TreeSet.ExampleReal;

import java.util.Comparator;

public class IdComparatorStudent implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
