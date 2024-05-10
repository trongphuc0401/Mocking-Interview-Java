package Multi_threading.java.threadPool.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

public class CallableWorkerTest {

    public static void main(String[] args) {
        List<Future<Integer>> list = new ArrayList<>();

        ExecutorService executor = Executors.newFixedThreadPool(5);

        Callable<Integer> callable;

        Future<Integer> future;

        for (int i = 1; i <= 10 ; i++) {
            callable  = new CallableWorker(i);

            future = executor.submit(callable);

            list.add(future);
        }

        executor.shutdown();

        while (!executor.isTerminated()) {

        }

        int sum  = 0;

        for (Future<Integer> f: list) {
            try {
                sum += f.get();
            }catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finished all threads: ");
        System.out.println("Sum all = " + sum);
    }
}