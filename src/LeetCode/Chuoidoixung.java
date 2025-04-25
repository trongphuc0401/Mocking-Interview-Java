package LeetCode;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Chuoidoixung -
 *
 * cho 1 chuỗi {@code string}  kiểm tra chuỗi đó có đối xứng hay không
 * <p>
 *
 * nếu các phần tử trong chuỗi đối xứng với nhau thì return về true ngược lại false
 * <p>
 * string = "acbca";<p>
 * return true; <p>
 *   Giải <p>
 *   tạo 2 biến left đầu chuỗi, right cuối chuỗi <p>
 *   Kiểm tra vị trí của left và right và so sánh xem 2 biến đó có bằng vs nhau hay ko <p>
 *   Nếu mà char(left) != char(right) return flase <p>
 *   còn nếu == thì left và right dịch vô trong<p>
 *   Thoát vòng lặp <p>
 *   return true
 * @param
 * @return
 * @throws
 */
public class Chuoidoixung {

    public boolean findPalindrome(String string) {
        int left = 0 ;
        int right = string.length() -1;

        while(left < right) {
            if (string.charAt(left)!= string.charAt(right)) {
                return false;
            }
            left ++;
            right--; // cho phần bên trái dịch vào trong nên --;
        }
        return true;

    }


    public static void main(String[] args) {
        String string  = "abba";
        Chuoidoixung chuoidoixung = new Chuoidoixung();

        if (chuoidoixung.findPalindrome(string)) {
            System.out.println("true");
        }else {
            System.out.println("false");
        }


    }
}

