package LeetCode;

public class _58 {

    public static void lengthOfLastWord(String s) {
        int count  = 0;
        String[] parts = s.split(" ");
        String lastWord = parts[parts.length -1 ];
        for (int i = 0; i< lastWord.length();i++) {
                count ++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        _58 object = new _58();

        String s =  "Hey this is test string";
        object.lengthOfLastWord(s);
    }
}
