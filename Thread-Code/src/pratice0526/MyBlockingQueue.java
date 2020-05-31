package pratice0526;

/**
 * 阻塞式队列:
 * 1)基于数组的循环队列实现
 * 2)提供一个队列,取元素消费时,队列为空,阻塞等待
 * 队列为满,生产时,阻塞等待
 */
public class MyBlockingQueue<T> {

    //模拟使用自定义式阻塞队列
    public static void main(String[] args) {
        MyBlockingQueue<Integer> myBlockingQueue = new MyBlockingQueue(100);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        synchronized (myBlockingQueue) {
                            myBlockingQueue.put(1);
                            System.out.println("存放面包+1："+myBlockingQueue.getSize());
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        synchronized (myBlockingQueue) {
                            Integer integer = myBlockingQueue.take();
                            System.out.println("消费面包-1："+myBlockingQueue.getSize());
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }

    private Object[] table;
    private int takeIndex;
    //取元素时的索引
    private int putIndex;
    private int size;

    public synchronized void put(T element) throws InterruptedException {
        while (size == table.length) {
            wait();
        }
        table[putIndex] = element;
        putIndex = (putIndex + 1) % table.length;
        size++;
        notifyAll();
        Thread.sleep(500);
    }

    public synchronized int getSize() {
        return size;
    }
    public synchronized T take() throws InterruptedException {
        while (size == 0) {
            wait();
        }
        Object element = table[takeIndex];
        takeIndex = (takeIndex + 1) % table.length;
        size--;
        notifyAll();
        Thread.sleep(500);
        return (T)element;
    }
    public MyBlockingQueue(int capacity) {
        this.table = new Object[capacity];
    }

}
