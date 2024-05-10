package Test;

public class UsingStaticExample {

    private static String subject;

    static {
        System.out.println("Khối static được gọi");
    }

    static {
        subject = "Khối static (static blocks)";
    }

    UsingStaticExample () {
        System.out.println("hàm main() được gọi");
        System.out.println("Subject = " + subject);
    }

    public static void main(String[] args) {
        UsingStaticExample ex1 = new UsingStaticExample();
    }
}
