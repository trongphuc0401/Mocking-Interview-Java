package AtCoder;

import java.util.*;
class ExtendedABC{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] c1 = s.toCharArray();
        char[] c2 = s.toCharArray();
        Arrays.sort(c1);
        System.out.println(Arrays.equals(c1,c2)?"Yes":"No");
    }
}