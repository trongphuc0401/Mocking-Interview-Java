package LeetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ListNode{
    int val;
    ListNode next;

    public ListNode(int x) {
        this.val = x;

        this.next = null;
    }
}
public class _160 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        ListNode tempA =headA;
        while (tempA != null) {
            lenA ++;
            tempA = tempA.next;

        }
        int lenB = 0;
        ListNode tempB =headB;
        while (tempB != null) {
            lenB ++;
            tempB = tempB.next;

        }

        int diff = Math.abs(lenA - lenB);

        tempA = headA;
        tempB = headB;

        if (lenA > lenB) {
            while (diff-- > 0 ) {
                tempA = tempA.next;
            }
        }else {
            while (diff-- > 0) {
                tempB = tempB.next;
            }
        }

        while (tempA!= tempB) {
            tempA = tempA.next;
            tempB = tempB.next;

            if (tempA != null || tempB != null) {
                return null;
            }
        }
        return tempA;



    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        ListNode result = null;

        while (tempA != tempB) {
            tempA = tempA != null ? tempA.next : headB;
            tempB = tempB != null ? tempB.next : headA;
        }

        return result;
    }

    public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {

        Set<Integer> set  =new HashSet<>();

        ListNode result = new ListNode(0);
        ListNode current = result;

        ListNode tempA = headA;
        ListNode tempB = headB;


        while (tempA != null) {
            set.add(tempA.val);
            tempA = tempA.next;
        }

        while (tempB != null) {
            if (set.contains(tempB.val)) {
                current.next = new ListNode(tempB.val);
                current = current.next;
            }
            tempB = tempB.next;
        }

        return result.next;
    }
}
