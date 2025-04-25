package MemoryManagementJava.StackAndHeap;

/**
 * Test -
 *
 * @param
 * @return
 * @throws
 */


class Parent {
    void display() {}
}
class Child extends Parent {
    static void show() {
        System.out.println("Child show");
    }
}
public class Test {
    public static void main(String[] args) {
        Child.show();
    }
}
