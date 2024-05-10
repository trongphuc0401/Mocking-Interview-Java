package Multi_threading.java.synchronizedd.atm;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    public static void main(String[] args) {
        final Customer c = new Customer();

        Thread t1  = new Thread() {
            public void run() {
                c.withdraw(2000);
            }
        };
        t1.start();

        Thread t2 = new Thread() {
            public void run() {
                c.deposit(500);

                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                c.deposit(3000);
            }
        };
        t2.start();

    }

}