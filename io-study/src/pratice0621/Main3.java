package pratice0621;

public class Main3 {
    public static void main(String[] args) {
        long sumRich = 0;
        long sumStranger = 0;
        for (int i = 1; i <= 30; i++) {
            sumRich += 10;
            sumStranger = sumStranger + (long)Math.pow(2, i - 1);
        }
        System.out.println(sumRich + " " + sumStranger);
    }
}
