package Multi_threading.java.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        // intialising count down latch by 3, as it will wait for 3 threads to
        // finish execution

        final CountDownLatch latch = new CountDownLatch(3);


        Thread service1 = new Thread(new ServiceOne(latch));
        Thread service2 = new Thread(new ServiceTwo(latch));
        Thread service3 = new Thread(new ServiceThree(latch));

        service1.start();
        service2.start();
        service3.start();

        try {
            System.out.println("Waiting for 3 services have started ... ");
            latch.await();
            System.out.println("Starting main Thread ... ");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Done!!!");
    }
}
