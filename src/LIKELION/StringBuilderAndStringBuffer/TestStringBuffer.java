package LIKELION.StringBuilderAndStringBuffer;

/**
 * TestStringBuffer -
 *
 * @param
 * @return
 * @throws
 */
public class TestStringBuffer implements Runnable {

    static StringBuilder str = new StringBuilder();

    @Override
    public void run() {

        for(int i = 0 ; i < 1000 ; i++) {
            str.append(Thread.currentThread().getName()).append(" ");
        }

    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new TestStringBuffer(),"Thread 1");
        Thread thread2 = new Thread(new TestStringBuffer(),"Thread 2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {

        }
        System.out.println(str);
    }
}
