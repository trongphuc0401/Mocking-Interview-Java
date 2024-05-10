package LeetCode;

public class _231 {

    public boolean isPowerOfTwo(int n) {
        return (int) (Math.ceil((Math.log(n)/Math.log(2)))) == (int) (Math.floor((Math.log(n)/Math.log(2))));
    }

}
