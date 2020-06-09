package pratice0608;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            String[] strings = input.split(" ");
            int[] arr = new int[strings.length];
            for (int i = 0; i < strings.length; i++) {
                arr[i] = Integer.valueOf(strings[i]);
            }
            int num = arr[0];
            int count = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == num) {
                    count++;
                } else if (count > 0){
                    count--;
                } else {
                    num = arr[i];
                }
            }
            System.out.println(num);
        }
    }
}
