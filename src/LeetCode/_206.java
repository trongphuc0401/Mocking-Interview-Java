package LeetCode;


import dsa.linkedlist.Settings;

public class _206 {

    static class ListNode {
        int val;
        _206.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, _206.ListNode next) { this.val = val; this.next = next; }


    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }



    public static void main(String[] args) {
        // Tạo danh sách liên kết đơn
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // In danh sách liên kết ban đầu
        System.out.println("Danh sách liên kết ban đầu:");
        printList(head);

        // Đảo ngược danh sách liên kết
        ListNode reversedHead = reverseList(head);

        // In danh sách liên kết sau khi đảo ngược
        System.out.println("Danh sách liên kết sau khi đảo ngược:");
        printList(reversedHead);
    }

    // Hàm in danh sách liên kết
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }


}
