package Multi_threading.java.threadPool.forkjoin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.RecursiveTask;

public class SizeOfFizeTask extends RecursiveTask<Long> {

    private static final long serialVersionUID  =-196522408291343951L;

    private final File file;

    public SizeOfFizeTask(final String fileName) {
        this(new File(fileName));
    }
    public SizeOfFizeTask(final File file) {
        this.file = Objects.requireNonNull(file);
    }

    @Override
    protected Long compute() {

        if (file.isFile()) {
            return file.length();
        }

        final List<SizeOfFizeTask> tasks = new ArrayList<>();
        final File[] children  = file.listFiles();
        if (children !=  null) {
            for (final File child : children) {
                final SizeOfFizeTask task  = new SizeOfFizeTask(child);
                task.fork();
                tasks.add(task);
            }
        }
        long size  = 0 ;
        for (final SizeOfFizeTask task : tasks) {
            size += task.join();
        }
        return size;
    }
}
