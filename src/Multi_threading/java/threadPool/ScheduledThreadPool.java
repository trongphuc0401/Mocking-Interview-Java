package Multi_threading.java.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {


    private static final int NUM_OF_THREAD = 2;
    private static final int INITIAL_DELAY = 1;
    private static final int DELAY = 3;

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(NUM_OF_THREAD);

        for (int i = 1 ; i <=5 ;  i++) {

            Runnable worker = new WorkingHard("" + i);
            executor.scheduleWithFixedDelay(worker,INITIAL_DELAY,DELAY, TimeUnit.SECONDS);
        }
        executor.awaitTermination(10,TimeUnit.SECONDS);
        executor.shutdown();

        // Wait until all threads are finish
        while (!executor.isTerminated()) {
            // Running ...
        }

        System.out.println("Finished all threads");
    }
}
