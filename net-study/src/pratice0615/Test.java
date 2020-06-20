package pratice0615;

public class Test {
    public void add(Byte b) {
        b = b++;
    }

    public static void main(String[] args) {
//        Byte a = 127;
//        Byte b = 127;
//        Test test = new Test();
//        test.add(++a);
//        System.out.print(a + " ");
//        test.add(b);
//        System.out.print(b + " ");
//        String str1 = "hello";
//        String str2 = "he" + new String("llo");
//        System.out.println(str1 == str2);
        int i = 0;
        for (out('A'); out('B') && (i < 2); out('C')) {
            i++;
            System.out.println('D');
        }
    }
    public int[] exchangeAB(int[] AB) {
        AB[0] = AB[1] ^ AB[0];
        AB[1] = AB[1] ^ AB[0];
        AB[0] = AB[1] ^ AB[0];
        return AB;


    }

    static boolean out(char c) {
        System.out.println(c);
        return true;
    }

}
