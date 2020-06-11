package pratice0610;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //输入一个整数,求n!末尾有多少个0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int input = sc.nextInt();
            System.out.println(result(input));
        }
    }

    private static int fib(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fib(n - 1);
    }
    private static int result(int input) {
        int sum = fib(input);
        int count = 0;
        while (sum % 10 == 0) {
            count++;
            sum /= 10;
            if (sum == 10) {
                count++;
                break;
            }
        }
        return count;
    }
}
