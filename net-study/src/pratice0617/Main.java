package pratice0617;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int input= sc.nextInt();
            sc.nextLine();
            getString(input);
        }
        sc.close();
    }

    private static void getString(int input) {
        int curNum = input * (input - 1) + 1;
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < input; i++) {
            if (i == input - 1) {
                sBuffer.append(curNum);
            } else {//2 3 + 5
                sBuffer.append(curNum + "+");
            }
            curNum += 2;
        }
        System.out.println(sBuffer);
    }
}
