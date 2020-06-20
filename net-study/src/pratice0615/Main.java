package pratice0615;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int row = sc.nextInt();
//        String c = sc.next();
//        int col = row / 2;
//        int[][] array = new int[row][col];
//        for (int i = 0; i < row; i++) {
//
//        }
    }

    public String AddLongInteger(String addend, String augend) {
        Long x = Long.valueOf(addend);
        Long y = Long.valueOf(augend);
        Long z = x + y;
        return String.valueOf(z);
    }
}
