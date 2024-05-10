package Array;
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        head = null;
        tail = null;
    }

    void insert(int val) {
        if(head ==null) {
            head = new Node(val);
            tail = head;
        }else{
            tail.next = new Node(val);
            tail = tail.next;
        }
    }
}
public class GFG {

    class Solution {



    }
    public static void main(String[] args)
    {
        String str
                = "The quick brown fox jumps over the lazy dog";


    }
}
