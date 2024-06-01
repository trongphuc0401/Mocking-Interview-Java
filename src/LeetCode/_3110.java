package LeetCode;

/*
* 104 101 108 108 111
sum	= |104 - 101| + |101 - 108| + |108 - 108| + |108 - 111|
    = 3 + 7 + 0 + 3

-  tạo biến result để lưu tổng nữa
- dùng vòng for duyệt qua tất cả phần tử  "hello"
for(
	- chuyển tất cả kí tự trong string thành value (.....) charAT()
    -công thức là trị tuyệt đối của |phần tử hiện tại + giá trị phần tử tiếp theo| + |phần tử kế tiếp + giá trị phần tử tiếp theo|

* */
public class _3110 {
    public int scoreOfString(String s) {
        int result  = 0 ;

        for(int i = 0 ; i < s.length()-1 ; i++){
            result = Math.abs(s.charAt(i)-s.charAt(i+1))+result;

        }
        return result;

    }

    public static void main(String[] args) {
        String s = "hello";

        _3110 obj = new _3110();
        System.out.println(obj.scoreOfString(s));
    }

}
