package dsa.linkedlist;

//{ Driver Code Starts
// driver code

import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
}

class GFG
{
    public static Node newNode(int data){
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }

    public static void makeLoop(Node head, int x){
        if (x == 0)
            return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x)
        {
            curr = curr.next;
            currentPosition++;
        }

        while (last.next != null)
            last = last.next;
        last.next = curr;
    }

    public static boolean detectLoop(Node head){
        Node hare = head.next;
        Node tortoise = head;
        while( hare != tortoise )
        {
            if(hare==null || hare.next==null) return false;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }

    public static int length(Node head){
        int ret=0;
        while(head!=null)
        {
            ret += 1;
            head = head.next;
        }
        return ret;
    }

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t--> 0)
        {
            int n = sc.nextInt();

            int num = sc.nextInt();
            Node head = newNode(num);
            Node tail = head;

            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = newNode(num);
                tail = tail.next;
            }

            int pos = sc.nextInt();
            makeLoop(head, pos);

            Solution x = new Solution();
            x.removeLoop(head);

            if( detectLoop(head) || length(head)!=n )
                System.out.println("0");
            else
                System.out.println("1");
        }
    }
}

// } Driver Code Ends


/*
class Node
{
    int data;
    Node next;
}
*/

class Solution
{
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        if(head == null && head.next == null) {
            return;
        }
        Node    slow = head,
                fast = head;

        slow = slow.next;
        fast = fast.next.next;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        if(slow == fast) {
            slow = head;
            if(slow==fast) {
                while(slow != fast.next) {
                    fast  =fast.next;
                }
                fast.next  = null;
            }else {
                while(fast.next != slow.next) {
                    fast = fast.next;
                    slow = slow.next;
                }
                fast.next  =null;
            }
        }
    }
    Node removeDuplicates(Node head)
    {
        // Your code here
        Node current = head;
        while(current != null && current.next!=null) {
            if(current.data == current.next.data) {
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }

        return current;
    }
    Node removeDuplicates_FromUnSorted(Node head)
    {
        // Your code here
        HashSet<Integer> hs = new HashSet<>();

        Node current = head;
        Node prev = null;
        while(current != null) {
            int currentData = current.data;
            if(hs.contains(currentData)) {
                prev.next = current.next;
            }else {
                hs.add(currentData);
                prev = current;
            }
            current = current.next;
        }
        return head;
    }

    Node reverseList(Node head)
    {
        Node prev  =null;
        Node current = head;
        Node next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head  = prev;
        return head;
    }
    Node reverseList_Recursive(Node head)
    {
        if(head== null || head.next ==null)
            return head;
        Node rest  =reverseList_Recursive(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public static boolean detectLoop(Node head){
        Node    slow = head,
                fast = head;
        boolean flag =  false;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;

            if(fast == slow) {
                flag  = true;
                break;
            }
        }
        return flag;
    }
}