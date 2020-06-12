package pratice0612;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //现根据N得到他的有多少位 采用递归的形式
        int K = locationCount(N);
        //创建一个数组保存每位数
        //循环往这个数组中存元素
        int index = 0;
        String line = String.valueOf(N);
        char[] arrays = line.toCharArray();
        int[] array = new int[K];
        for (int i = 0; i < K; i++) {
            arrays[index++] = arrays[i];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer counts = map.get(array[i]);
            if (counts == null) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], counts++);
            }
        }
        int[] array2 = new int[K];
        int index2 = 0;
        for (Map.Entry<Integer, Integer> maps : map.entrySet()) {
            array2[index2++] = maps.getKey();
        }
        Arrays.sort(array2);
        for (int i = 0; i < K; i++) {
            System.out.println(array2[i] + ":" + map.get(array2[i]));
        }
    }


    private static int div(int n) {
        int ret = 1;
        for (int i = 1; i < n; i++) {
            ret *= 10;
        }
        return ret;
    }


    private static int locationCount(int n) {
        if (n <= 9) {
            return 1;
        }
        return 1 + locationCount(n / 10);
    }
}
