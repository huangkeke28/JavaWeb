package lesson5;

public class Sington2 {
    //双重校验锁的单例模式
//    public volatile static Sington2 SINGTON4;
//    private Sington2(){};
//    public static Sington2 getInstance4() {
//        if (SINGTON4 == null) {
//            synchronized (Sington2.class) {
//                if (SINGTON4 == null) {
//                    SINGTON4 = new Sington2();
//                    //分配内存空间
//                    //初始化对象
//                    //对象赋值给变量(变量引用)
//                }
//            }
//        }
//        return SINGTON4;
//    }
//    public volatile static Sington2 SINGTON4;
//    private Sington2(){};
//    public static Sington2 getInstance4() {
//        if (SINGTON4 == null) {
//            synchronized (Sington2.class) {
//                if (SINGTON4 == null) {
//                    SINGTON4 = new Sington2();
//                }
//            }
//        }
//    }
}
