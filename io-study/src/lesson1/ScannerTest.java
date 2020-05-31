package lesson1;

import java.util.Scanner;

public class ScannerTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //假设接受的输入位:
        //4
        //3 1 10 31
        //hasNextXXX()和nextXXX()读取到io数据直到满足条件(空格符和换行符),否则阻塞等待
        //io流只能操作一次 hasNextXXX()不操作只判断
        while (sc.hasNextInt()) {
            int num = sc.nextInt();//读取到io数据知道满足条件,否则阻塞等待
            for (int i = 0; i < num; i++) {
                int data = sc.nextInt();
                System.out.println(data);
            }
        }
    }
}
