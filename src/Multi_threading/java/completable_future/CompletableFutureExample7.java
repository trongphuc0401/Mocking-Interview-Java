package Multi_threading.java.completable_future;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class User {
    String userId;

    public User(String userId) {
        this.userId = userId;
    }
}

class UserService {
    public static User getUserDetails(String userId) {
        return  new User(userId);
    }
}

class CreditRatingService{
    public static Double getCreditRating(User user) {
        return Double.parseDouble(user.userId);
    }
}

class ApiUlti {
    public static CompletableFuture<User> getUsersDetail(String userId) {
        return CompletableFuture.supplyAsync(() -> {
            return UserService.getUserDetails(userId);
        });
    }
    public static CompletableFuture<Double> getCreditRating(User user) {
        return CompletableFuture.supplyAsync(() -> {
                return CreditRatingService.getCreditRating(user);
        });
    }

}

public class CompletableFutureExample7 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<Double> flattened = ApiUlti.getUsersDetail("1")
                .thenCompose(user -> ApiUlti.getCreditRating(user));
        System.out.println(flattened.get());
    }
}
