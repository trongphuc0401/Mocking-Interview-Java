package Multi_threading.java.threadPool.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.jupiter.api.Assertions.*;

class SizeOfFileActionTest {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        final AtomicLong sizeWindows = new AtomicLong();
        final AtomicLong sizeApps = new AtomicLong();
        final AtomicLong sizeDocuments = new AtomicLong();

        SizeOfFileAction system = new SizeOfFileAction("C:/Windows",sizeWindows);
        SizeOfFileAction apps = new SizeOfFileAction("C:/Program Files",sizeApps);
        SizeOfFileAction documents = new SizeOfFileAction("C:/Documents And Settings",sizeDocuments);

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
        System.out.printf("Size of Windows: %d bytes \n", sizeWindows.get());
        System.out.printf("Size of Apps: %d bytes \n", sizeApps.get());
        System.out.printf("Size of Documents: %d bytes \n", sizeDocuments.get());

    }
}