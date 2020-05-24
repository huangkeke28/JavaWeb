package lesson4;

public class SynchronizedDemo {
    //1.静态方法上
    public static synchronized void test1() {

    }

    public static void test1_2() {
        synchronized (SynchronizedDemo.class) {

        }
    }
    //2.实例方法上
    public synchronized void test2() {

    }
    public void test2_1() {
        synchronized (this) {
            
        }
    }
    //3.同步代码块上
    public static void main(String[] args) {
        Object o = new Object();
        //1.对象锁:每个对象有对象头,包含锁
        //2.synchronized获取对象锁的操作
             //a).申请对象锁
             //b).进入代码块里面执行代码,退出代码块归还对象锁
             //c).申请失败:线程进入一个同步队列中阻塞
             // -JVM管理synchronized竞争失败线程,由运行态转变为阻塞态的方式,
        // 将线程放到一个同步队列的数据结构中,对象锁再次可用的时候,将
        //所有竞争这个对象锁失败的线程唤醒(阻塞态变为被唤醒)
        synchronized (o) {

        }
    }
}
