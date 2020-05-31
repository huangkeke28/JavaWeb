package pratice0526;

/**
 * 同时执行打印ABC
 * 循环打印共计十次
 * 思路:
 * 每个线程循环10次打印A B C
 * 每次打印后,等待其余线程打印完,再次往下执行
 */
public class SequencePrint {
    public static void main(String[] args) {
        print();
    }

    public static void print() {
        for (int i = 0; i < Print.ARRAY.length ; i++) {
            new Thread(new Print(i)).start();
        }
    }

    private static class Print implements Runnable {

        private int idx;
        public static String[] ARRAY = {"A", "B", "C", "D", "E"};
        private static int INDEX;

        public Print(int idx) {
            this.idx = idx;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    synchronized(ARRAY) {
                        while (idx != INDEX) {
                            ARRAY.wait();
                        }
                        System.out.print(ARRAY[idx]);
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

    public static void print2() {
        Thread t1 = new Thread(new Print2("A"));
        Thread t2 = new Thread(new Print2("B"));
        Thread t3 = new Thread(new Print2("C"));
        t1.start();
        t2.start();
        t3.start();
    }
    private static class Print2 implements Runnable {
        private String coment;
        private static String[] ARRAY = {"A", "B", "C"};
        private static int INDEX;

        public Print2(String coment) {
            this.coment = coment;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    synchronized (ARRAY) {
                        while (!ARRAY[INDEX].equals(coment)) {
                            ARRAY.wait();
                        }
                        System.out.println(coment);
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
