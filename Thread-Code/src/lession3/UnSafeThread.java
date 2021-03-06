package lession3;

public class UnSafeThread {

    private static int SUM;

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    SUM++;
                }
            }).start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();//当前线程由运行态转为就绪态
        }
        System.out.println(SUM);
    }


}