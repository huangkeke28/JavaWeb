package lesson1;

public class FirstBlood {
    public static void main(String[] args) throws InterruptedException {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(999999999l);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"第一滴血").start();
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(999999999l);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"第一滴血");
//        thread.run();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("第一滴血");
            }
        },"第一滴血").start();
        System.out.println("main");
    }

}
