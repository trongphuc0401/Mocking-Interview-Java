package Multi_threading.java.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample4 {
    public static final int NUMBER = 5;

    public static void main(String[] args) throws InterruptedException , ExecutionException {

        CompletableFuture<Integer> times = CompletableFuture.supplyAsync(() -> {

            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e) {

                throw  new IllegalStateException(e);
            }
            return MathUtil.times(NUMBER,2);
        });

        CompletableFuture<Boolean> greetingFuture = times.thenApply(n -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            return MathUtil.squared(n);
        }).thenApply(n -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            return MathUtil.isEven(n);
        });
        System.out.println(greetingFuture.get()); //
    }
}
