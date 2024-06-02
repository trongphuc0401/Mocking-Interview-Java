package Collection.TreeSet.ExampleReal;

import java.util.*;

public class TreeSetExample2 {
    public static final int NUM_OF_ELEMENT = 5;
    public static void main(String[] args) {

        // Create list with no comparator
        List<Student> students = new ArrayList<>();
//        Set<Student> students = new TreeSet<>();
        Student student1 = new Student(1, "myname1");
        Student student2 = new Student(2, "myname2");
        Student student3 = new Student(3, "myname3");
        Student student4 = new Student(4, "myname4");
        Student student5 = new Student(5, "myname5");
        students.add(student1);
        students.add(student3);
        students.add(student2);
        students.add(student5);
        students.add(student4);
        students.add(student2);
        students.add(student3);


        // Show set student
        System.out.println("List without sorted: ");
        printData(students);
        System.out.println("--- ");

        System.out.println("List sorted using StudentNameComparator: ");
        List<Student> students2 = new ArrayList<>(students);
        Collections.sort(students2, new NameComparatorStudent());
        printData(students2);
        System.out.println("-------");

        System.out.println("List sorted using StudentIDComparator: ");
        List<Student> students3  =new ArrayList<>(students);
        Collections.sort(students3, new IdComparatorStudent());
        printData(students3);
        System.out.println("------------------");



        System.out.println("List sorted using Comparable: ");
        List<Student> students4 = new ArrayList<>(students);
        Collections.sort(students4, new NameComparatorStudent(){
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }
    public static void printData(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
