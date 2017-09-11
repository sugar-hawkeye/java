package demo.thread;

/**
 * Created by wim on 2017/9/9.
 */
public class RunnableDemo implements Runnable {

    @Override
    public void run() {
        System.out.println("name == " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        RunnableDemo runnableDemo = new RunnableDemo();
        Thread thread = new Thread(runnableDemo);
        thread.start();

        System.out.println("main name == " + Thread.currentThread().getName());
    }
}
