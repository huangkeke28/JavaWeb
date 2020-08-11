import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String s = "";
            String res = "";
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c >= '0' && c <= '9') {
                    s += c;
                } else {
                    s = "";
                }
                if (res.length() < s.length()) {
                    res = s;
                }
            }
            System.out.println(res);
        }
    }
}
