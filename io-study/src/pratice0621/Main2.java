package pratice0621;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int count = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        //char[] arrays = input.toCharArray();
        for (int i = 0; i <= input.length() - count; i++) {
            char[] chars = input.substring(i,i + count).toCharArray();
            int numbers = 0;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == 'G' || chars[j] == 'C') {
                    numbers++;
                }
            }
            map.put(input.substring(i,i+count),numbers);
        }
        int arr[] = new int[input.length() - count];
        for (Map.Entry<String, Integer> maps : map.entrySet()) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = maps.getValue();
            }
        }
        Arrays.sort(arr);
        for (Map.Entry<String, Integer> mapss : map.entrySet()) {
            if (mapss.getValue() == arr[arr.length - 1]) {
                System.out.println(mapss.getKey());
                break;
            }
        }
    }
}
