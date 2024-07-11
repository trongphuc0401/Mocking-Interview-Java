package LeetCode;

/**
 * _1108 -
 *
 * @param
 * @return
 * @throws
 */
public class _1108 {
    public static String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }

    public static void main(String[] args) {
        String address = "1.1.1.1";
        System.out.println(defangIPaddr(address));

    }
}
