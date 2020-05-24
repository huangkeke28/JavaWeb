package lesson5;

import javax.sql.DataSource;

/**
 * 单例:在某些场景下,需要获取同一个对象
 */

public class Sington {
    //饿汉式:在类加载的时候就创建对象
    public static Sington SINGTON = new Sington();
    //类加载在JVM内部执行,保证线程间同步互斥
    private Sington() {

    }
    public static Sington getInstance() {
        return SINGTON;
    }


    //懒汉式
    public static Sington SINGTON2;
    //省略构造方法
    public static Sington getInstance2() {
        if (SINGTON2 == null) {
            SINGTON2 = new Sington();
        }
        return SINGTON2;
    }
}
