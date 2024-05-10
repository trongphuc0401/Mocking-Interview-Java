package Multi_threading.java.synchronizedd;

import static org.junit.jupiter.api.Assertions.*;

class ShareMemoryTest {






    public static void main(String[] args) {
        ShareMemory sm = new ShareMemory();
        WorkingThread thread1 = new WorkingThread(sm,"Thread 1");
        WorkingThread thread2= new WorkingThread(sm,"Thread 2");
        WorkingThread thread3 = new WorkingThread(sm,"Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

}