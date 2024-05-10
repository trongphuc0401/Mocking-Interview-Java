package Multi_threading.java.completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample5 {
    public static void main(String[] args) throws  InterruptedException , ExecutionException {
        CompletableFuture.supplyAsync(() -> {
            return MathUtil2.getMailInfo();
        }).thenAccept(content -> {
            System.out.println("Mail content: " + content);
        });

        CompletableFuture.supplyAsync(() -> {
            return MathUtil2.sendMail();
        }).thenRun(() -> {
            MathUtil2.logging();
        });
    }
}
