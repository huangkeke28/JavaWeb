package pratice0611;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Set<Integer> set = new HashSet<>();
            int input = sc.nextInt();
            for (int i = 0; i < 1000000; i++) {
                set.add(Fib(i));
            }
            System.out.println(finds(set,input));
        }
    }

    private static int finds(Set<Integer> set, int input) {
        int count1 = 0;
        int count2 = 0;
        int x = input;
        int y = input;
        while (!set.contains(x)) {
            x++;
            count1++;
        }
        while (!set.contains(y)) {
            y--;
            count2++;
        }
        return count1 > count2 ? count2 : count1;

    }

    private static int Fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fib(n - 1) + Fib(n - 2);
    }
}
