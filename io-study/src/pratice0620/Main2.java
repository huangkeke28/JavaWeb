package pratice0620;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            PrintIndex(array, n);

        }
    }

    private static void PrintIndex(int[] arr, int count) {
        int[] A = new int[2];
        for (int i = 0; i < count; i++) {
            if (i == 0) {
                A[0] = -1;
            }
            if (i == count - 1) {
                A[1] = -1;
            }
            int j = 1;
            while (j >= 0 && j < count - 1) {
                j -= 1;
                if (j >= 0) {
                    if (arr[i] > arr[j]) {
                        A[0] = j;
                        break;
                    }
                }
            }
            j = 1;
            while (j >= 0 && j < count - 1) {
                j += 1;
                if (j <= count - 1) {
                    if (arr[i] > arr[j]) {
                        A[1] = j;
                        break;
                    }
                } else {
                    A[1] = -1;
                }
            }
            System.out.println(A[0] + " " + A[1]);
        }
    }
}