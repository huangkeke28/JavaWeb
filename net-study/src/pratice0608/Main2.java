package pratice0608;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] strings = scanner.nextLine().split(" ");
            int[] arr = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                arr[i] = Integer.parseInt(strings[i]);
            }
            if ((arr[0] + arr[1]) != (arr[2] - arr[3])) {
                System.out.println("No");
            } else {
                System.out.println(arr[0] + (arr[1] + arr[3]) / 2  + " " + (arr[1] + arr[3]) / 2 +
                        " " + (arr[3] - (arr[1] + arr[3]) / 2));
            }

        }
    }
}
