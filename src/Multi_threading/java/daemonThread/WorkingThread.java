package Multi_threading.java.daemonThread;

public class WorkingThread implements Runnable {


    @Override
    public void run() {
        while(true) {
            processSomthing();
        }
    }

    private void processSomthing() {
        try {
            System.out.println("Processing working thread");

            Thread.sleep(1);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws  InterruptedException{
        Thread dt = new Thread(new WorkingThread(),"My Non-Daemon Thread");
        dt.setDaemon(false); //  true to able Daemon
        dt.start();

        Thread.sleep(10000);
        System.out.println("Done");
    }
}
