package pratice0620;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                Integer count = map.get(array[i]);
                if (count == null) {
                    map.put(array[i], 1);
                } else {
                    map.put(array[i], count+1);
                }
            }
            int arr[] = new int[2];
            int i = 0;
            for (Map.Entry<Integer, Integer> map1 : map.entrySet()) {
                if (map1.getValue() % 2 != 0) {
                    arr[i++]  = map1.getKey();
                }
            }
            if (arr[0] < arr[1]) {
                System.out.println(arr[0] + " " + arr[1]);
            } else {
                System.out.println(arr[1] + " " + arr[0]);
            }
        }


    }
}
