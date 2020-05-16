package lesson2;

public class DaemoTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() ->{
            try {
                Thread.sleep(9999999l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "第一滴血");
        thread.setDaemon(true);
        thread.start();
    }
}
