package LeetCode;

import static LeetCode._160.getIntersectionNode;
import static org.junit.jupiter.api.Assertions.*;

public class _160Test {
    public static void main(String[] args) {
        _160 solution = new _160();

        // Create LinkedList1: 9->6->4->2->3->8
        ListNode headA = new ListNode(9);
        headA.next = new ListNode(6);
        headA.next.next = new ListNode(4);
        headA.next.next.next = new ListNode(2);
        headA.next.next.next.next = new ListNode(3);
        headA.next.next.next.next.next = new ListNode(8);

        // Create LinkedList2: 1->2->8->6
        ListNode headB = new ListNode(1);
        headB.next = new ListNode(2);
        headB.next.next = new ListNode(8);
        headB.next.next.next = new ListNode(6);

        ListNode result = solution.getIntersectionNode3(headA, headB);

        if (result != null) {
            System.out.println("Intersection node value: " + result.val);
        } else {
            System.out.println("No intersection node found.");
        }
    }
}