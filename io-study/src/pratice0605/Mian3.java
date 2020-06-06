package pratice0605;

import java.util.Scanner;

public class Mian3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean boo = false;
        while (sc.hasNext()) {
            int app = sc.nextInt();
            if (app % 8 == 0) {
                System.out.println(app / 8);
                boo = true;
            } else {
                for (int i = app / 8; i >= 0; i--) {
                    if ((app - i * 8) % 6 == 0) {
                        System.out.println(i + (app - i * 8) / 6);
                        boo = true;
                        break;
                    }
                }
                if (boo == false) {
                    System.out.println(-1);
                }
            }
        }
    }
}
