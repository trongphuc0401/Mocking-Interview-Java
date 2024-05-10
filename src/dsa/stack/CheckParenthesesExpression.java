package dsa.stack;

public class CheckParenthesesExpression {
    public static boolean isBalanced(String exp) {
        boolean flag = true;
        int count   = 0;

        for(int i =0; i< exp.length(); i++) {
            if (exp.charAt(i) =='(') {
                count++;
            }else {
                count--;
            }
            if (count < 0) {
                flag = false;
                break;
            }
        }
        if (count != 0) {
            flag = false;
        }
        return  flag;
    }

    public static void main(String[] args) {
        String exp = "()()";

        if (isBalanced(exp)) {
            System.out.println("Balanced");
        }else
            System.out.println("Not Balanced");
    }
}
