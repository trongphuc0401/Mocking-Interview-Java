//package dsa.linkedlist;
//
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// * A Simple linked list implementation in Java to demonstrate unit testing.
// * JUnit tests will be created to test this singly linked list.
//
// * @author Javin Paul
// */
//public class SinglyLinkedList {
//    private Node head; // Head is first node in linked list
//
//    public boolean isEmpty() {
//        return length() == 0;
//    }
//
//    public void append(String data) {
//        if(head == null) {
//            head = new Node(data);
//            return;
//        }
//        tail().next = new Node(data);
//    }
//
//    private Node tail() {
//        Node tail = head;
//
//        if(tail.next != null) {
//            tail = tail.next;
//        }
//        return tail;
//    }
//
//    public int length() {
//        int count = 0;
//
//        Node current = head;
//        while (current != null) {
//            count ++;
//            current = current.next;
//        }
//        return count;
//    }
//    private static class Node {
//        private Node next;
//        private String data;
//
//        public Node(String data) {
//            this.data = data;
//        }
//
//        @Override
//        public String toString() {
//            return "Node{" +
//                    "next=" + next +
//                    ", data='" + data + '\'' +
//                    '}';
//        }
//    }
//    @Test
//    public void testNewLinkedList(){
//        SinglyLinkedList singly = new SinglyLinkedList();
//        assertTrue(singly.isEmpty());       // linked list should be empty
//        assertEquals(0, singly.length());
//        // length of linked list should be zero
//
//        singly.append("ABC");
//        assertFalse(singly.isEmpty());     // linked list should not be empty
//        assertEquals(1, singly.length());
//        // length of linked list should be 1
//
//    }
//}
