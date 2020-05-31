package lesson9;

import sun.util.calendar.LocalGregorianCalendar;

import java.util.Date;
import java.util.concurrent.PriorityBlockingQueue;

public class MyScheduledThreadPool {
    //员工
    private Thread[] threads;//可以去掉,直接在构造方法中new就可以了
    //仓库
    private PriorityBlockingQueue<MyTimerTask> queue = new PriorityBlockingQueue<>();
    public MyScheduledThreadPool(int capacity) {
        threads = new Thread[capacity];
        for (int i = 0; i < capacity; i++) {
            threads[i] = new MyTimer(queue);
            threads[i].start();
        }
    }
    //执行定时任务的方法:任务,延迟时间(毫秒),间隔时间
    public void schedule(Runnable runnable, long delay, long period) {
        MyTimerTask task  = new MyTimerTask(runnable,new Date().getTime() + delay, period);
        queue.put(task);

    }
    //员工
    private static class MyTimer extends Thread {
        private PriorityBlockingQueue<MyTimerTask> queue;
        public MyTimer(PriorityBlockingQueue<MyTimerTask> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    MyTimerTask task = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //定时任务
    private static class MyTimerTask implements Runnable, Comparable<MyTimerTask>{

        private Runnable runnable;
        private long next;//下次执行时间
        private long period;//间隔时间
        public MyTimerTask(Runnable runnable, long next, long period) {
            this.next = next;
            this.period = period;
        }

        @Override
        public void run() {
            runnable.run();
        }

        @Override
        public int compareTo(MyTimerTask o) {
            return Long.compare(next, o.next);
        }
    }
}
