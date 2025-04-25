package LeetCode;


/*
* Bài này cơ bản là nối 2 chuỗi từ t sang s lại với nhau và trả về số character có nhỏ nhất có thể nối
*
* Input: s = coaching và  t= coding
* Output = 4
*
* Giải thích : ta thấy chuỗi t có tù coding và "co" đã có trong chuỗi s và "ding" chưa có nên ta phải nối từ ding vào coaching
* thì ta sẽ được "coachingding" và số lượng phần tử đã nối là 4
*
*Ý tưởng sẽ là check phần tử t xem có cái nào trùng hay ko nếu trùng thì add toàn bộ cái còn lại và return về các phần tử đã có
* :)) ei tự nhiên nó dễ ngang ta
*Brute-fore: tạo biến count để đếm
*           duyệt qua phần tử s và check t trong đó ko có trùng ko
*           nếu ko trùng thì biến count +1
* */
public class _2486 {
    public int appendCharacters(String s, String t) {

       int i  = 0;
       int j = 0;
       while (i < s.length() && j < t.length()) {
           if (s.charAt(i) == t.charAt(j)) {
               j++;
               i++;
           }else {
               i++;
           }

       }
        return t.length()-j;
    }

    public static void main(String[] args) {
        String s = "coaching", t = "coding";

        _2486 obj = new _2486();
        System.out.println(obj.appendCharacters(s, t));
    }
}
