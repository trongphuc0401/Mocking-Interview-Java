package LeetCode;


/*
* Bài này thì cơ bản sẽ có các chuỗi trong đó có chứa số 0 nhiệm vụ của mình là di chuyển các số 0
* vào vị trị cuối :)))) chà chà căng nhaaa ko biết phải làm sao nữa
*
* thì theo gợi ý (hint) thì sử dụng phương pháp two pointer để di chuyển vị trí :))) oki để test thử
* */


public class _283 {

    public void moveZeroes(int[] nums) {
        int i = 0 ;
        int j = 0;

        if (nums.length == 0 || nums.length ==1) return ;
        while( i < nums.length){
            if(nums[i] == 0){

               int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }else {
                i++;
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};

        _283 obj = new _283();
        obj.moveZeroes(nums);
        System.out.println(nums);
    }


}
