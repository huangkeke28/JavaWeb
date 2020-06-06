package practice0601;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n;
//        while (sc.hasNext()) {
//            n = sc.nextInt();
//            System.out.println(swap(n));
//        }
        System.out.println(Drint(9));
    }

    private static int Drint(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2 || n == 3) {
            return 1;
        }
        return n / 3 + Drint(n / 3 + n % 3);
    }

    private static int swap(int n) {
        int bottle = n;
        int yu, result, x = 0;
        while (bottle > 2) {
            result = bottle / 3;
            yu = bottle % 3;
            bottle = result + yu;
            x += result;
            if (bottle == 2) {
                x += 1;
                break;
            }
        }
        return x;
    }

    public int count(int[] A, int n) {
        int count = 0;
        for (int i = n  - 1; i >= n; i++) {
            int base = A[i];
            for (int j = 0; j < i; j++) {
                if (A[j] > base) {
                    count++;
                }
            }
        }
        return count;
    }
}
