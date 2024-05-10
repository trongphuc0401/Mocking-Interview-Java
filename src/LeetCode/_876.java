package LeetCode;

public class _876 {


     public class ListNode {
      int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode middleNode(ListNode head) {
        if(head == null && head.next ==null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null); {
            fast = fast.next;
            if(fast!= null) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return slow;
    }
}
