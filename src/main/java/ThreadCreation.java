import java.util.concurrent.TimeUnit;

public class ThreadCreation {
    public static void main(String[] args) {
        new FirstTask();
        Thread t = new FirstTask();
        // With the following technique you have more control over the thread
        t.start();
        new SecondTask();
        // This is the most used technique as task definition is separate from thread related code. Please use this.
        Thread t1 = new Thread(new ThirdTask());
        t1.start();
    }
}

class FirstTask extends Thread {
    private static int count = 0;
    private int id;
    @Override
    public void run() {
        for(int i = 0 ;i < 10; i++) {
            System.out.println("<" + id + "> TICK TICK : " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public FirstTask(){
        this.id = ++count;
        this.start();
    }
}

class SecondTask implements Runnable {
    /*
    Useful in scenarios where one needs fire and forget type of threads since there is no way
    one can capture the reference to the thread with this technique.
    Ex: When you want to invalidate applications's cache at regular intervals
     */

    private static int count = 0;
    private int id;
    @Override
    public void run() {
        for(int i = 0 ;i < 10; i++) {
            System.out.println("<" + id + "> TICK TICK : " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public SecondTask(){
        this.id = ++count;
        new Thread(this).start();
    }
}

class ThirdTask implements Runnable {
    /*
    Useful in scenarios where one needs fire and forget type of threads since there is no way
    one can capture the reference to the thread with this technique.
    Ex: When you want to invalidate applications's cache at regular intervals
     */

    private static int count = 0;
    private int id;
    @Override
    public void run() {
        for(int i = 0 ;i < 10; i++) {
            System.out.println("<" + id + "> TICK TICK : " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public ThirdTask(){
        this.id = ++count;
    }
}
