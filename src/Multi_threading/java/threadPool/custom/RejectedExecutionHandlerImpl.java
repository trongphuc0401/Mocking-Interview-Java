package Multi_threading.java.threadPool.custom;

import java.util.concurrent.ThreadPoolExecutor;

public class RejectedExecutionHandlerImpl implements java.util.concurrent.RejectedExecutionHandler {



    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(r.toString() +" is rejected");
    }
}
