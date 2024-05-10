package dsa.linkedlist;

public class Settings {

    Node head;

    Node next;
    public static class Node{

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }

        public int data(){return data;}

        public void setData(int data){this.data = data;}

        public Node next(){return next;}

        public void setNext(Node next){this.next = next;}

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }



/*
* How do you find length of a Singly Linked list using Loop and Recursion? Example
* Làm thế nào để tìm độ dại cảu Danh Liên kết Đơn sử dụng vòng lặp và Đệ Quy
* */
    // Đây là cách sử dụng vòng lặp:
    // Bằngc cách tạo ra một biến count để đếm các phần từ bên trong đó bằng cách duyệt qua tất cả
    // danh sách liên kết đơn mỗi lần 1 nút và cho đến khi nó đạt được giá trị rỗng khác thì biến count sẽ tự động +1 và đến khi hết nút trong danh sách liên kết
    /// khi hết thì nó sẽ dừng laij
    public int length() {
        int count = 0;

        Node current  = this.head;

        while (current != null) {
            count++;
            current = current.next;
        }
        return count ;
    }
    

    
    // Đây là cách sử dụng đệ qui (recursive) :
    public int length(Node current) {
        if (current == null) {
            return 0;
        }
        return 1 + length(current.next);

    }

    // return false if linked list is empty
    public boolean isEmpty() {
        return length() == 0;
    }

    // Finding the middle element

    public void findMiddle() {

        Node current = head;

        int count = 0;
        Node middle = head;

        while (current.next() != null) {
            count++;

            if(count %2 == 0) {
                middle = middle.next();
            }
            current = current.next();
        }
        if(count %2 == 1) {
            middle = middle.next();
        }
        System.out.println("length of LinkedList: " + count);
        System.out.println("middle element of LinkedList : "+ middle);
    }

    public Object valueAt(int index) {
        Node current = head;
        for(int i = 0; i < index;i++) {
            if(current == null) {
                return null;
            }
            current = current.next;
        }
        return current.data;
    }




    // push in beginning
    public void pushFront(int data) {
        // Allocate node and put it into the data

        Node node = new Node(data);

        // Make next of new Node as head

        node.next = head;

        // Move the head to point to the new node
        head = node;
    }
    public Object popFront() {

        Node temp  = head;

        head = head.next;
        return temp.data;
    }

    public Object popBack() {
        Node previous  = head;
        Node last = head.next;
        if(last.next != null ) {
            previous = previous.next;
            last = last.next;
        }
        previous.next = null;
        return last.data;
    }

    public Object front() {
        Node temp = head;
        return temp.data;
    }

    public Object back() {
        if (head == null) {
            return null; // Handle empty list
        }
        if (head.next == null) {
            return head.data; // Return data of the only node
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.data;
    }

    public Node reverse(Node node) {
        Node prev = null;
        Node current  = node;
        Node next = null;

        while(current != null) {
            next  =current.next;
            current.next  =prev;
            prev = current;
            current  =next;
        }
        node  =prev;
        return node;
    }

    public void erase(int position) {
        // check if linked list is empty
        if (head == null) {
            return;
        }
        // Store head in to node with temporary variable
        Node temp = head;

        //  if head needs to be remove
        if (position ==0) {
            head  = temp.next;
            return;
        }
        // Find previous node of the node to be deleted

        for(int i = 0; temp != null && i < position -1 ;i++ )
            temp =temp.next;
        // If position is more than number of nodes
        if(temp == null || temp.next ==null) {
            return;
        }

        Node next = temp.next.next;

        temp.next = next;

    }

    public void insertAfter(Node index, int data) {
        // check if the given node is null

        if (index == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }

        // Allocate node and put it into the data

        Node new_node = new Node(data);

        // Make next of new Node as next of prev_node

        new_node.next = index.next;

        // Make next of prev_node as new node

        index.next = new_node;

    }

    public void pushBack(int data) {
        // Allocate node and put it into the data

        Node new_node = new Node(data);

        // if the linked list is empty then make the new node as the head

        if(head ==null) {
            head = new  Node(data);
            return;
        }

        //This new is gonna be the last node so make of the new node is as null

        new_node.next = null;

        Node last = head;
        while(last.next != null) {
            last = last.next;
        }
        last.next = new_node;

    }
    // Delete All linked list

    public void deleteAll() {
        head = null;
    }


    public Object showAll() {
        Node temp  =head;
        return head;
    }

    // Delete from the beginning
    /*
    * Point head to the next node i.e. second node
        temp = head
        head = head->next

    Make sure to free unused memory

    * */

    // Creating LinkedList
    // MergeSort for Linked List

    public Node sortedMerge(Node a,Node b) {
        Node result = null;
        if(a ==null)
            return b;
        if(b == null)
            return a;
        if(a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next,b);
        }else {
            result = b;
            result.next = sortedMerge(b.next,a);
        }
        return result;
    }

    public Node mergeSort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node middle = getMiddle(head);
        Node nextMiddle = middle.next;

        middle.next = null;

        Node left = mergeSort(head);
        Node right  = mergeSort(nextMiddle);

        return sortedMerge(left,right);


    }

    public static Node getMiddle(Node head) {
        if(head ==null) {
            return head;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public void merge2List(Settings q) {
        Node p_current =  head;
        Node q_current  = q.next;
        Node p_next;
        Node q_next;

        while(p_current!= null && q_current != null) {
            p_next = p_current.next;
            q_next = q_current.next;

            q_current.next = p_next;
            p_current.next = q_current;

            p_current = p_next;
            q_current = q_next;
        }
        q.head = q_current;


    }
    public static void main(String[] args) {
        Settings list = new Settings();
        Settings list1 = new Settings();
        list.pushFront(566);
        list.pushFront(55);
        list.pushFront(2);
        list.pushFront(5);
        list.pushFront(6);
        list.pushFront(100);
        list.pushFront(89);
        list.pushFront(99);
        list.pushFront(29);
        list.pushFront(19);
        list.pushFront(989);
        list.pushFront(799);
        list.pushFront(299);

        list1.pushFront(312);
        list1.pushFront(3123);
        list1.pushFront(543);
        list1.pushFront(656);
        list1.pushFront(293);
        list1.pushFront(623);
        list1.pushFront(637);

        list.head = list.mergeSort(list.head);

        System.out.println("Sorted Linked list: "+list.showAll());
        list.merge2List(list1);
        System.out.println("Sorted 2 Linked list: "+list.showAll());
        System.out.println("Linked List: "+list.length());

        System.out.println("The element is: "+list.valueAt(2));



        System.out.println("Show all element in linked list: "+ list.showAll());
        System.out.println("Front element in linked list: "+list.front());
        System.out.println("Back element in linked list: "+list.back());
        System.out.println("The element front removed: "+list.popFront());
        System.out.println("Show all element in linked list: "+ list.showAll());
        System.out.println("The element back removed: "+list.popBack());
        System.out.println("Show all element in linked list: "+ list.showAll());



    }
}
