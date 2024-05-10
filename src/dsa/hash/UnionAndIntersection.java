package dsa.hash;

import dsa.linkedlist.Settings;

import java.util.HashMap;
import java.util.Map;

public class UnionAndIntersection {


   static class Node {
        int data;
        Node next;

        Node (int d) {
            this.data =d;
        }
    }

   static class LinkedList {

        Node head;

        void push(int new_data) {

            Node new_node = new Node(new_data);

            new_node.next = head;

            head = new_node;
        }

    }

    public static void printNode(Node node) {
        while (node != null) {
            System.out.print(node.data+ " ");

            node = node.next;
        }
    }


    static void storeEle(Node head1 , Node head2 , Map<Integer,Integer> eleOccurrence) {
        Node ptr1 = head1;
        Node ptr2 = head2;

        while (ptr1 != null || ptr2 != null) {
            if (ptr1 != null) {
                if (eleOccurrence.get(ptr1.data) == null) {
                    eleOccurrence.put(ptr1.data,1);
                }else {
                    eleOccurrence.put(ptr1.data,eleOccurrence.get(ptr1.data)+1);
                }
                ptr1 = ptr1.next;
            }

            if (ptr2 != null) {
                if (eleOccurrence.get(ptr2.data) ==null) {
                    eleOccurrence.put(ptr2.data,1);
                }else {
                    eleOccurrence.put(ptr2.data,eleOccurrence.get(ptr2.data)+1);
                }
                ptr2 = ptr2.next;
            }
        }
    }

    Node getUnion(Map<Integer, Integer> eleOccurrence){
        Node result = null;

        for (int key: eleOccurrence.keySet()) {
            Node node = new Node(key);

            node.next = result;
            result = node;
        }
        return result;
    }

    static void printUnionIntersection(Node head1, Node head2) {
        Map<Integer, Integer> eleOccurrence = new HashMap<>();

        storeEle(head1,head2,eleOccurrence);

        Node intersection_list =  getIntersection(eleOccurrence);
    }

  static Node getIntersection(Map<Integer,Integer> eleOccurrence)  {
        Node result = null;

        for (int key: eleOccurrence.keySet()) {
            if (eleOccurrence.get(key) ==2) {
                Node node = new Node(key);
                node.next = result;
                result = node;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();

        l1.push(1);
        l1.push(2);
        l1.push(3);
        l1.push(4);
        l1.push(5);

        l2.push(1);
        l2.push(3);
        l2.push(5);
        l2.push(6);

        System.out.print("First List: \n");
        printNode(l1.head);
        System.out.println("\nSecond List: ");
        printNode(l2.head);

        printUnionIntersection(l1.head,l2.head);
    }
}
