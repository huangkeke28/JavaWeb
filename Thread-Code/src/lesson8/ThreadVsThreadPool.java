package lesson8;

import java.util.concurrent.*;

public class ThreadVsThreadPool {
    public static void main(String[] args) {
        /**
         * 1. 没有用线程,来送快递
         */
        System.out.println("送到北京");//模拟送快递,有可能送快递比较耗时
        System.out.println("送到上海");
        System.out.println("处理自己的业务");
        /**
         * 2. 使用手动创建线程,来送快递
         */

        new Thread(() -> {
            System.out.println("送快递到北京");
        }).start();
        new Thread(() -> {
            System.out.println("送快递到上海");
        }).start();
        System.out.println("处理自己的业务");
        /**
         * 3. 使用JDK的线程池来送快递
         */
        //创建线程池对象: 开了一家送快递公司,专门处理送快递的任务
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                4,//核心线程数:快递公司员工(正式工)---线程
                10,//最大线程数:总员工(正式工 + 零时工) --- 线程
                //临时工 + 时间:正式员工数量不够处理任务时,就招聘临时工来干活,在临时工超过最大空闲时间就解雇
                60,//空闲时间数
                TimeUnit.SECONDS,//时间单位
                new ArrayBlockingQueue<>(1000),//阻塞队列:快递公司的仓库--- 存放线程的容器
//                new ThreadFactory() {
//                    @Override
//                    public Thread newThread(Runnable r) {//线程的工厂类:快递公司招聘标准---创建线程的方式
//                        return new Thread(r);
//                    }
//                },

                //拒接策列:又接受到新的快递单,但此时仓库容量已经不够存放包裹了
                //new ThreadPoolExecutor.AbortPolicy()
                //new ThreadPoolExecutor.CallerRunsPolicy()
                //new ThreadPoolExecutor.DiscardOldestPolicy()
                new ThreadPoolExecutor.DiscardPolicy()
        );
        pool.execute(() -> {//创建了一个送快递的任务,把快递包裹交给快递公司
            System.out.println("送快递到北京");
        });
        pool.execute(() -> {
            System.out.println("送快递到上海");
        });
        System.out.println("做自己的事");
        //单线程池:只有一个正式工,没有临时工,仓库是无边界的
        ExecutorService pool2 = Executors.newSingleThreadExecutor();
        //固定大小的线程池:只有给定数量的正式工,没有临时工,仓库是无边界的
        ExecutorService pool3 = Executors.newFixedThreadPool(3);
        //缓冲的线程池:只有临时工,没有正式工,临时工数量不限,空闲时间60s
        ExecutorService pool5 = Executors.newCachedThreadPool();
        //计划任务线程池:给定数量的正式工,没有临时工.使用自己的创建线程的方式(定时任务线程)
        ExecutorService pool4 = Executors.newScheduledThreadPool(4);
    }
}
