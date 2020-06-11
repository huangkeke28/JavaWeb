package pratice0610;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int input = sc.nextInt();
            String str = String.valueOf(input);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            System.out.println(stringBuilder.reverse());
        }
    }
}
