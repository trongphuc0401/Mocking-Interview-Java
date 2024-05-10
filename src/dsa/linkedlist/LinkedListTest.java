package dsa.linkedlist;


/**
 * Java program to find middle element of linked list in one pass.
 * In order to find middle element of a linked list
 * we need to find the length first but since we can only
 * traverse linked list one time, we will have to use two pointers
 * one which we will increment on each iteration while
 * other which will be incremented every second iteration.
 * So when the first pointer will point to the end of a
 * linked list, second will be pointing to the middle
 * element of a linked list
 *
 * @author Javin Paul
 *
 *
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        LinkedList.Node head = linkedList.head();

        linkedList.add(new LinkedList.Node("1"));
        linkedList.add(new LinkedList.Node("2"));
        linkedList.add(new LinkedList.Node("3"));
        linkedList.add(new LinkedList.Node("4"));
        linkedList.add(new LinkedList.Node("5"));


        // finding the middle element of LinkedList in single class

        LinkedList.Node current =head;

        int length = 0;
        LinkedList.Node middle = head;

        while (current.next() != null) {
            length ++;
            if(length%2 ==0) {
                middle = middle.next();
            }
            current = current.next();
        }
        if (length%2 ==1) {
            middle = middle.next();
        }
        System.out.println("length of LinkedList: " + length);
        System.out.println("middle element of LinkedList : "+ middle);
    }



}

class LinkedList {

    private Node head; //Head is first node in linked list
    private Node tail;

    public LinkedList() {
       this.head = new Node("head");
       tail = head;
    }

    public Node head() {
        return head;
    }
    public void add (Node node) {
        tail.next = node;
        tail = node;
    }

    public static class Node{
        private Node next;
        private String data;

        public Node(String data) {
            this.data = data;
        }

        public String data() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node next() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }

        public String toString() {
            return this.data;
        }
    }
}
