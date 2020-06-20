package pratice0618;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int count1 = 1;
        int count2 = 1;
        while (count1 <= 100000) {
            if (input % 1000000007 == 0 || 1000000007 % input == 0) {
                break;
            }
            input = input * 4 + 3;
            count1++;
        }
        while (count2 <= 100000) {
            if (input % 1000000007 == 0 || 1000000007 % input == 0) {
                break;
            }
            input = input * 8 + 7;
            count2++;
        }
        int output = count1 > count2 ? count2 : count1;
        if (output == 100001) {
            System.out.println(-1);
        } else {
            System.out.println(output);
        }
    }
}
