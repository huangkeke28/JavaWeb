package pratice0615;

public class Main1 {
    public static void main(String[] args) {
        String s1 = "sd" + "ds";
        String s2 = new String(s1);
        if (s1.equals(s2)) {
            System.out.println(1);
        }
        if (s1 == s2) {
            System.out.println(2);
        }
    }
}
