package lesson6;

/**
 * 1.面包师傅有5个,可以一直生产面包,每次生产3个
 * 2.消费者有20个,可以一直消费面包,每次消费面包1个
 * 3.面包库存的上限100个
 */
public class SignalTest {
    //库存
    private static int SUM;


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                while (true) {
                    synchronized (SignalTest.class) {
                        if (SUM + 3 > 100) {
                            try {
                                SignalTest.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            SUM += 3;
                            System.out.println(Thread.currentThread().getName() +
                                    "生产了面包, 库存" + SUM);
                            SignalTest.class.notify();
                        }
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "面包师傅" + i).start();
        }

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                while (true) {
                    synchronized (SignalTest.class) {
                        if (SUM == 0) {
                            try {
                                SignalTest.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            SUM--;
                            SignalTest.class.notify();
                        }
                    }

                }
            }).start();
        }
    }
}
