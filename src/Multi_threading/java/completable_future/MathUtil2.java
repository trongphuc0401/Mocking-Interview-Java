package Multi_threading.java.completable_future;

public class MathUtil2 {

    public static String getMailInfo() {
        return "Your email content";
    }

    public static boolean sendMail() {
        System.out.println("Send mail: completed");
        return true;
    }

    public static void logging() {
        System.out.println("Log: Send mail at " + System.currentTimeMillis());
    }
}
