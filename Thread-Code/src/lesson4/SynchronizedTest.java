package lesson4;

public class SynchronizedTest {
    private Object object = new Object();
    private static Object T = SynchronizedTest.class;
    public static synchronized void t1() throws InterruptedException {
        Thread.sleep(9999999999l);
    }

    public synchronized  void t2() throws InterruptedException {
        Thread.sleep(9999999999l);
    }

    public void t3() throws InterruptedException {
        synchronized (object) {
            Thread.sleep(9999999999l);
        }
    }

    public void t4() throws InterruptedException {
        synchronized (T) {
            Thread.sleep(9999999999l);
        }
    }

    public static void main(String[] args) {
        //t2方法在不同线程中执行时 是否有同步互斥
//        new Thread(() -> {
//            try {
//                new SynchronizedTest().t2();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        new Thread(() -> {
//            try {
//                new SynchronizedTest().t2();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();


        //直接使用枚举类
        Thread.State state = Thread.State.NEW;
        for (Thread.State state1 : Thread.State.values() ) {
            System.out.println(state1);
        }
    }
}
