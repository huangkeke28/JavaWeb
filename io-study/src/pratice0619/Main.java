package pratice0619;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int count = 0;
            int N = sc.nextInt();
            float[] array = new float[N];
            for (int i = 0; i < N; i++) {
                array[i] = sc.nextFloat();
            }
            float aim = sc.nextInt();
            for (int i = 0; i < N; i++) {
                if (aim == array[i]) {
                    count++;
                }
            }
            System.out.println(count);
        }


    }
}
