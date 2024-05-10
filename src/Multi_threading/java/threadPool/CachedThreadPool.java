package Multi_threading.java.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 1 ; i <=10 ;  i++) {

            Runnable worker = new WorkingHard("" + i);
            executor.execute(worker);
            Thread.sleep(400);
        }
        executor.shutdown();

        // Wait until all threads are finish
        while (!executor.isTerminated()) {
            // Running ...
        }

        System.out.println("Finished all threads");
    }
}
