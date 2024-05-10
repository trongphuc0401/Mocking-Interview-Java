package Multi_threading.java.synchronizedd.deadlock;

import static org.junit.jupiter.api.Assertions.*;

class DeadlockThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Object obj1 = new String("obj1");
        Object obj2 = new String("obj2");
        Object obj3 = new String("obj3");



        Thread t1 = new Thread(new DeadlockThread(obj1,obj2),"Thread 1");
        Thread t2 = new Thread(new DeadlockThread(obj2,obj3),"Thread 2");
        Thread t3 = new Thread(new DeadlockThread(obj3,obj1),"Thread 3");

        t1.start();
        Thread.sleep(1000);

        t2.start();
        Thread.sleep(1000);

        t3.start();

    }

}