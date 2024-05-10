package Multi_threading.java.threadPool;

import Multi_threading.java.synchronizedd.WorkingThread;

public class WorkingHard implements Runnable {

    private String task;

    public WorkingHard(String task)  {
        this.task = task;
    }
    @Override
    public void run() {

        System.out.println("Thread start with name: " + Thread.currentThread().getName() + "starting "+ task );
        processing();
        System.out.println(Thread.currentThread().getName() + "Finished");


    }
    private void processing() {
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
