package pratice0611;

public class Test {
//    public static void main(String[] args) {
//        StringBuffer a = new StringBuffer("A");
//        StringBuffer b = new StringBuffer("B");
//        operator(a,b);
//        System.out.println(a + ";" + b);
//    }
//
//    private static void operator(StringBuffer x, StringBuffer y) {
//        x.append(y);
//        y = x;
//    }

    public int add(int a, int b) {
        try {
            return a + b;
        } catch (Exception e) {
            System.out.println("catch语句块");
        } finally {
            System.out.println("finall语句块");
        }
        return 0;
    }

    public static void main(String[] args) {
//        Test test = new Test();
//        System.out.println("和是" + test.add(9, 34));
//        byte b1 = 1, b2 = 2, b3, b6;
//        final byte b4 = 4, b5 = 6;
//        b6 = b4 + b5;
//        b3 = (byte) (b1 + b2);
//        System.out.println(b3 + b6);

        Object o = new Object() {
            public boolean equals(Object obj) {
                return true;
            }
        };
        System.out.println(o.equals("Fred"));
    }

}
