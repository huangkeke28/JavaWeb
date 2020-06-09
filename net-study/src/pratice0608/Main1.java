package pratice0608;

import com.sun.org.apache.xerces.internal.xs.XSNamedMap;
import com.sun.xml.internal.bind.unmarshaller.DOMScanner;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    //使用集合类
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Map<Integer, Integer> map = new HashMap<>();
            String[] strings = scanner.nextLine().split(" ");
            for (int i = 0; i < strings.length; i++) {
                int s = Integer.valueOf(strings[i]);
                if (map.containsKey(s)) {
                    map.put(s,map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() >= strings.length / 2) {
                    System.out.println(entry.getKey());
                }
            }
        }

    }
}
