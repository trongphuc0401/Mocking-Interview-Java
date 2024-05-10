package Multi_threading.java.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.*;

public class WorkingHardTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 1 ; i<= 10 ;i++) {
            Runnable worker = new WorkingHard("" + i );

            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
            // Running ...
        }

        System.out.println("Finished all threads");
    }
}