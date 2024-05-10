package Multi_threading.java.synchronizedd;

public class WorkingThread extends Thread {

    private  ShareMemory shareMemory;
    private String threadName;

    public WorkingThread(ShareMemory shareMemory,String threadName) {
        this.threadName = threadName;
        this.shareMemory = shareMemory;
    }
    @Override
    public void run() {
        super.run();

        shareMemory.printData(threadName);
    }
}
