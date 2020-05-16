package lesson2;

public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("Thread baby");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.join(5000);//可以调整传入参数:不传 1秒 5秒 分别观察结果
        System.out.println("main");
    }
}
