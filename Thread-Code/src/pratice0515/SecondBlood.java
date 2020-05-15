package pratice0515;

public class SecondBlood {
//    //main 每一个进程至少有一个线程存在 即主线程
//    public static void main(String[] args) {
//        //new Thread 创建线程
//        new Thread(new Runnable() {
//            @Override
//            //run() 使线程变为运行态 系统调度线程 线程处于运行态的时候 执行的代码
//            public void run() {
//                try {
//                    Thread.sleep(999999999999l);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, "第一滴血").start();
//        //start()使线程由创建态-->就绪态 启动一个线程 申请系统调度并运行
//    }


//    //在子线程中让线程阻塞
//    public static void main(String[] args) {
//         new Thread(new Runnable() {
//             @Override
//             public void run() {
//                 try {
//                     Thread.sleep(9999999l);
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }
//             }
//         }, "第二滴血").start();
//    }

//    //子线程和main线程都阻塞
//    public static void main(String[] args) throws InterruptedException {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(99999l);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, "第二滴血").start();
//        Thread.sleep(9999999999l);
//    }

//    //main线程调用run方法
//    public static void main(String[] args) {
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(99999l);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.run();
//    }

    //main和子线程同时运行
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("第一滴血");
            }
        }).start();
        System.out.println("main");
    }
}
