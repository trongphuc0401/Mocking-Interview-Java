package Multi_threading.java;

public class Settings extends Thread {

    private Thread t;
    private String name;

    public Settings( String name) {
        this.name = name;

        System.out.println("Creating "+ name);
    }


    @Override
    public void run() {
        super.run();
        System.out.println("Thread is runing.............."+ name);
        try{
            for (int i = 4 ;i> 0 ; i--) {
                System.out.println("Thread: " + name + ", " + i);
                Thread.sleep(5000);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread "+name+" interrupted");
        }
        System.out.println("Done");

    }

    public void start() {
        System.out.println("Starting "+name);

        if (t == null){
            t =  new Thread(this,name);
            t.start();
        }
    }



    public static void main(String[] args) {
        Settings t1 = new Settings("Thread 1");
        t1.start();
        Settings t2 = new Settings("Thread 2");
        t2.start();
    }
}
