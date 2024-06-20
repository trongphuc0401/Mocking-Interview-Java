package LeetCode;

import java.util.Hashtable;

/*
* Chà chà hôm nay giải bài thực tế cũng zui :))
* Khó :))
*
* Bài này cơ bản thì mình có một mảng tương tự những cái cột để chứa nướng có nhiều cột tương ứng vs cải mảng
* Nếu mưa rơi xuống thì nó sẽ lấp đầy cái cột đó thì 2 cái cột ở ngoài sẽ thành cái tường để chứa nước mưa
* nhiệm vụ h phaiwr tính xem cái bể đó chứa dc bao nhiêu nướng
*
* thì phương pháp t vừa xem sử dụng two pointer
*
* đầu tiên xác định 2 bên phía tưởng bằng biến
* left = 0 ;
* right = heght.lengh -1;
* sau khi tạo được tường
*
* cho vòng lặp đi trong cái left và right kết thúc khi left >= right
* bắt đầu tính khu vực chứa nướnc bằng hàm min(height[left],heght[right] + (right - left))
* sau đó có kết quả thfi tính khối lượng nước bằng hàm max(max_are,are)
*
* Nếu mà h[left] < right
* thì left++;
* ko thì right--;
* return lại cái hàm nước
*
* */
public class _11 {
    public int maxArea(int[] height) {
    int left = 0 ;
    int right = height.length - 1;
        int max_area = 0;
    while(left < right) {
        int area = Math.min(height[left],height[right]+ (right - left));
         max_area = Math.max(max_area,area);
        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }
    return max_area;

    }
}
