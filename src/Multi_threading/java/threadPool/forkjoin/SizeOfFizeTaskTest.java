package Multi_threading.java.threadPool.forkjoin;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class SizeOfFizeTaskTest {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        SizeOfFizeTask system = new SizeOfFizeTask("C:/Windows");
        SizeOfFizeTask apps = new SizeOfFizeTask("C:/Program Files");
        SizeOfFizeTask documents = new SizeOfFizeTask("C:/Documents And Settings");

        pool.execute(system);
        pool.execute(apps);
        pool.execute(documents);

        do {
            System.out.printf("******************************************\n");
            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
            System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
            System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
            System.out.printf("******************************************\n");

            try {
                TimeUnit.SECONDS.sleep(5);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }


        }while ((!system.isDone())||(!apps.isDone())||(!documents.isDone()));
        pool.shutdown();
        System.out.printf("Size of Windows: %d bytes \n", system.join());
        System.out.printf("Size of Apps: %d bytes \n", apps.join());
        System.out.printf("Size of Documents: %d bytes \n", documents.join());

    }

}