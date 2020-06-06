package pratice0605;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s1 = scanner.next();
            String s2 = scanner.next();
            delete(s1, s2);
        }
    }

    private static void delete(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s2.length(); i++) {
            set.add(s2.charAt(i));
        }
        for (int i = 0; i < s1.length(); i++) {
            if (set.contains(s1.charAt(i))) {
                continue;
            } else {
                stringBuilder.append(s1.charAt(i));
            }
        }
        System.out.println(stringBuilder);
    }
}
