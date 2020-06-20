package pratice0618;

public class Pratice {
    public static void main(String[] args) {
        int a = 10;
        double b = 3.14;
        System.out.println('A' + a + b);
    }
    public int addAB(int A, int B) {
        if (B != 0) {
            int a = A^B;
            int b = (A&B) << 1;
            return addAB(a, b);   //0000000111   111
                                  //0000100000
        } else {
            return A;
        }
    }
}
