package pratice0611;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(getResult(sc.nextInt()));
    }

    private static int getResult(int N) {
        int i = 0, flag1 = 0, flag2 = 0;
        for (;;i++) {
            flag2 = fibo(i);
            if (flag2 > N) {
                break;
            }
            flag1 = flag2;
        }
        return N - flag1 > flag2 - N ? flag2 - N : N - flag1;
    }

    private static int fibo(int i) {
        if (i == 0 || i == 1) {
            return  i;
        } else {
            return fibo(i - 1) + fibo(i -2);
        }
    }
}
