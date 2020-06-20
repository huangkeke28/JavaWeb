package pratice0619;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int group = sc.nextInt();
        while (group > 0) {
            group--;
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] array = new int[2 * n];
            for (int i = 0; i < array.length; i++) {
                array[i] = sc.nextInt();
            }
            int right = array.length - 1;
            int left = right / 2;
            int[] newArray = new int[2 * n];
            for (int i = 0; i < 2 * n; i++) {
                if (i % 2 == 0) {
                    newArray[i] = array[right];
                    right--;
                } else {
                    newArray[i] = array[left];
                    left--;
                }
            }
            int i = 0;
            int j = newArray.length - 1;
            while (i < j) {
                int tmp = newArray[i];
                newArray[i] = newArray[j];
                newArray[j] = tmp;
                i++;
                j--;
            }
        }
    }
}
