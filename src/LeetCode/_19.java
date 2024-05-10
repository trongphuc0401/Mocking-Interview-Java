package LeetCode;

import java.util.List;

public class _19 {
    public class ListNode {
     int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int Length = length(head);
            int nodeFromBeginning  = Length - n +1;
            ListNode prev = null;
            ListNode temp = head;
            for(int i = 0;i< nodeFromBeginning;i++) {
                prev = temp;
                temp = temp.next;
            }
            if(prev == null ) {
                head = head.next;
                return head;
            }else{
                prev.next= prev.next.next;
                return head;
            }
        }
    }
    static int length(ListNode head)
    {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
