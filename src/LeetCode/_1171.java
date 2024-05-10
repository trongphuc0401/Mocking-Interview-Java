package LeetCode;
/*
* Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.

After doing so, return the head of the final linked list.  You may return any such answer.
(Note that in the examples below, all sequences are serializations of ListNode objects.)
*
* Ví dụ như là
* Có Input: 1 2 -3 3 1
* thì nếu mà  các số đầu tiên nếu cộng lại ra = 0 thì nó sẽ dừng lại mà in ra các chư số còn lại
* thì Output có thể là 3 1
*  Và 1 2 3 -3 4
*   thì nó sẽ cộng hết để xem có bằng 0 hay ko ví dụ như là 1+2 = 3 + 3= 6 3+ -3 = 0  nên suy ra loại 3 -3
*
* Giải cách 1
* Đầu tiên xét 1 2 -3 nếu cộng lại ra 0 hai số liền kề thì return head.next
* Lúc này phải lập qua các phần tử trong linked list
*
* while(head != 0)
*      if(head + head.next != 0 {
*           return head.next
*       head.data = head.data.next;
* }
*  return head.data.next;
*
*
* Cácch 2: Tìm các giá trị âm và tổng các số truóc nó có phải = âm hay ko
*
* while(head =! 0 ) {
* loop duyệt qua các linked list trong mảng
* cộng các số dương lại và + thêm số âm
*  câu hỏi ko biết linked list có hỗ trợ tìm đúng data có giá trị âm ko
* nếu có thì chỉ cânv cộng các số dương liền kề và cộng thêm số âm nếu = 0  thì in ra các số còn lại
* còn nếu không thì in next sang tiếp để tìm phần tử kế tiếp nhưng ko tìm các số âm số dương cộng số dương
* và sau đó xuống dòng để biến cộng lại số âm.`
* */
public class _1171 {
}
