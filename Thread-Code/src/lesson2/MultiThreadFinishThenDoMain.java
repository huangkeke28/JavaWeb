package lesson2;

//同时运行多个线程,等所有线程执行完毕 在执行后面的方法
public class MultiThreadFinishThenDoMain {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            final int j = i;
            Thread thread = new Thread(() -> {
                System.out.println(j);
            });
            thread.start();
            threads[i] = thread;
        }
        for (int i = 0; i < 20; i++) {
            threads[i].join();
        }

        System.out.println("main");
    }
}
