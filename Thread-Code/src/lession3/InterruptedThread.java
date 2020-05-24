package lession3;

public class InterruptedThread {
    public volatile static boolean IS_STOP;
    public static void main(String[] args) throws InterruptedException {
        //在子线程sleep阻塞的时候中断它
//        Thread thread = new Thread(() -> {
//            try {
//                while(!Thread.interrupted()) {//判断当前线程是否被中断了
//                    System.out.println(Thread.currentThread().getName());
//                    Thread.sleep(1000000000);//sleep操作时,也可以中断,是以抛异常的方式
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        thread.start();
//        Thread.sleep(3000);
//        thread.interrupt();

//        Thread thread = new Thread(() -> {
//            while (!Thread.interrupted()) {
//                try {
//                    System.out.println(Thread.currentThread().getName());
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();
//        Thread.sleep(3000);
//        thread.interrupted() ;

        //1. 线程初始时中断便标志位为false
        //2. 调用线程的interpurted方法 该线程的中断标志位为true
        //3. 如果线程处于阻塞态,中断抛出InterruptedException异常,会重置线程的中断标志位
//        Thread thread = new Thread(() -> {
//            while (!Thread.interrupted()) {
//                try {
//                    System.out.println(Thread.currentThread().getName());
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();
//        Thread.sleep(3000);
//        thread.interrupt();

        //第三段代码作用:Thread.interrupted()的作用
//        Thread thread = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                //Thread.interrupted():返回当前的中断标志位并重置标志位
//                //(1). boolean tmp = isInterrupted
//                //(2). isInterrupted  = false;
//                //(3). return tmp;
//                System.out.println(Thread.interrupted());
//            }
//        });
//        thread.start();
//        thread.interrupt();

        //线程对象 isInterrupted()作用 只返回中断标志位 不做任何修改
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });
        thread.start();
        thread.interrupt();
    }
    
}
