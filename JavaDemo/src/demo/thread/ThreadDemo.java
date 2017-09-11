package demo.thread;

/**
 * Created by wim on 2017/9/9.
 */
public class ThreadDemo extends Thread{

    private int count = 5;



    @Override
    synchronized public void run() {
        super.run();
        String threadName = Thread.currentThread().getName();
//        System.out.println("name==" + threadName);
        count--;
        System.out.println(threadName + " == " + count);
    }



    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        Thread threadA = new Thread(threadDemo, "A");
        Thread threadB = new Thread(threadDemo, "B");
        Thread threadC = new Thread(threadDemo, "C");
        Thread threadD = new Thread(threadDemo, "D");
        Thread threadE = new Thread(threadDemo, "E");
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        threadE.start();
        System.out.println("main name=="+Thread.currentThread().getName());
    }
}
