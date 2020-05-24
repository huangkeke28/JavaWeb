package lesson7;

import java.awt.font.NumericShaper;

/**
 * 三个线程
 * 第一个只能打印A,第二个只能打印B,第三个只能打印C
 * 打印结果ABC
 */
public class SequencePrint {
    private volatile static char[] Number = {'A', 'B', 'C'};
    public static void main(String[] args) throws InterruptedException {
//        Thread t1 = new Thread(() -> {
//            System.out.print("A");
//        });
//        Thread t2 = new Thread(() -> {
//            System.out.println("B");
//        });
//        Thread t3 = new Thread(() -> {
//            System.out.println("C");
//        });
//        t1.start();
//        t2.start();
//        t3.start();
        Print2();
    }
    public static void Print1() {
        Thread t1 = new Thread(new Print("A" ,null));
        Thread t2 = new Thread(new Print("B",t1));
        Thread t3 = new Thread(new Print("C",t2));
        t1.start();
        t2.start();
        t3.start();
    }


    private static class Print implements Runnable{
        private String content;
        private Thread t;
        public Print(String content, Thread t) {
            this.content = content;
            this.t = t;
        }

        @Override
        public void run() {
            try {
                if (t != null) {
                    t.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(content);
        }
    }
    public static void Print2() {
        for (int i = 0; i < Print2.ARRAY.length; i++) {
            new Thread(new Print2(i)).start();
        }
    }

    private static class Print2 implements Runnable {
        private int idx;
        public static String ARRAY[] = {"A", "B", "C"};
        private static int INDEX;

        public Print2(int idx) {
            this.idx = idx;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    synchronized (ARRAY) {
                        while (!ARRAY[INDEX].equals(idx)) {
                            ARRAY.wait();
                        }
                        System.out.print(idx);
                        if (INDEX == ARRAY.length - 1) {
                            System.out.println();
                        }
                        INDEX = (INDEX + 1) % ARRAY.length;
                        ARRAY.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
