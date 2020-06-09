package pratice0607;

import java.util.Scanner;

public class Main {
    static int count = 0;//表示有多少种
    static int[] arr; // 表示口袋
    static int n; //表示物品的种类

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            n = input.nextInt();
            arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = input.nextInt();
            }
        }
        count(40, n);
        System.out.println(count);
    }

    private static void count(int s, int n) {
        if (s == 0) {
            count++;
        }
        if (s <= 0 || s > 0 && n < 0) {
            return;
        }
        count(s - arr[n], n - 1);
        count(s, n -1);
    }
}
