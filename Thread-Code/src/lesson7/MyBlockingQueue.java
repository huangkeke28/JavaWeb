package lesson7;

import org.omg.CORBA.OBJ_ADAPTER;

/**
 * 阻塞式队列
 * (1) 基于数组的循环队列实现
 * (2) 提供一个队列,取元素消费的时候,如果队列为空,阻塞等待,如果队列满了
 * 存元素生产的时候,阻塞等待
 *
 */
public class MyBlockingQueue<T> {
    //模拟使用自定义阻塞式队列
//    public static void main(String[] args) {
//        MyBlockingQueue queue = new MyBlockingQueue(capacity);
//        for (int i = 0; i < 5; i++) {
//            new Thread(() -> {
//                //模拟生产面包
//                queue.put();
//            }).start();
//        }
//
//        for (int i = 0; i < 20; i++) {
//            new Thread(() -> {
//                queue.take();
//            }).start();
//        }
//    }
    private Object[] table;
    private int takeIndex;
    private int putIndex;
    private int size;

    public MyBlockingQueue(int capacity) {
        table = new Object[capacity];
    }

    public synchronized void put(T element) {
        try {
            if (putIndex == table.length) {
                wait();
            }
            table[putIndex] = element;
            putIndex = (putIndex + 1) % table.length;
            size++;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized T take() throws InterruptedException {
        while (size == 0) {
            wait();
        }
        Object element = table[takeIndex];
        takeIndex = (takeIndex + 1) % takeIndex;
        size--;
        notifyAll();
        return (T)element;
    }
}
