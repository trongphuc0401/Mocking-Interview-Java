package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
*  Valid Parenthesis String
* cụ thể là bài toán này nó sẽ giải quyetes bài toàn khi check các dấu ngoặc đơn () và các kí tự khác xem có nos co cân bằng
* không
* cho 3 loại kí tư '(', ')' và '*' trả về true nếu nó valid
*điều kiện để nó valid là
* -  khi mà có'(' thì phải có ')' tương và ngược lại
* - Bắt buộc dấu '(' phải đứng trước ')'
* '*' được xem là dấu '(' hoặc ')'
*
Brute force
- đầu tiên khởi tạo đối tượng stack từ interface ArrayDeque để bỏ các kí tự vào stack
- Duyệt qua chuỗi
    + trong chuỗi thì tạo biến x trỏ nó theo từng phần tử của i tức là x nó sẽ là các kí tự tương ứng index[i];
    +  if x bằng các kí tự '(' và '*'   nó sẽ push các phần tử vào stack
    + nếu stack nó rỗng return false
    + bắt đầu tạo switch case  để check ( , * có match với cái dấu x hay chưa nếu chưa thì sẽ bỏ nó ra ngoài
    + else return false

 */

public class _678 {

    static  boolean checkValidString(String s) {
        Stack<Integer> bracketStack = new Stack<>();
        Stack<Integer> asteriskStack = new Stack<>();

        char[] stringArray = s.toCharArray();
        for (int i = 0; i <stringArray.length; i++) {
            char x = stringArray[i];
            if (x =='(') {
                bracketStack.push(i);

            } else if (x =='*') {
                asteriskStack.push(i);
            }
            else if (!bracketStack.isEmpty()) {
                        bracketStack.pop();
            }else if (!asteriskStack.isEmpty()) {
                        asteriskStack.pop();
            }else {
                return false;
            }

            while(!bracketStack.isEmpty() && !asteriskStack.isEmpty() && bracketStack.peek() <asteriskStack.peek()) {
                bracketStack.pop();
                asteriskStack.pop();
            }

        }
        return (bracketStack.isEmpty());
    }

    public static void main(String[] args) {
        String s = "(*)";
        if (checkValidString(s)) {
            System.out.println("true");
        }else {
            System.out.println("false");
        }

    }
}
