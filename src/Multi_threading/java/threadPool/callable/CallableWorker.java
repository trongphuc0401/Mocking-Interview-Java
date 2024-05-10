package Multi_threading.java.threadPool.callable;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableWorker implements Callable {

    private int num ;
    private Random random;

    public CallableWorker(int num) {
        this.num = num;
        this.random = new Random();
    }

    @Override
    public Object call() throws Exception {
        Thread.sleep(random.nextInt(10) * 1000);
        int result = num * num;
        System.out.println("Complete "+ num);


        return result;
    }
}
