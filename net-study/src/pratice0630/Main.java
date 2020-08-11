package pratice0630;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] xuefen = new double[n];
        for (int i = 0; i < n; i++) {
            xuefen[i] = sc.nextInt();
        }
        double[] chengji = new double[n];
        for (int i = 0; i < n; i++) {
            chengji[i] = sc.nextInt();
        }
        double summ = 0.00;
        for (int i = 0; i < n; i++) {
            summ += xuefen[i];
        }
        double result = 0.00;
        double sum = 0.00;
        for (int i = 0; i < n; i++) {
            double cur = chengji[i];
            if (cur >= 90 && cur <= 100) {
                sum += 4.0 * xuefen[i];
            } else if (cur >= 85 && cur <= 89) {
                sum += 3.7 * xuefen[i];
            } else if (cur >= 82 && cur <= 84) {
                sum += 3.3 * xuefen[i];
            } else if (cur >= 78 && cur <= 81) {
                sum += 3.0 * xuefen[i];
            } else if (cur >= 75 && cur <= 77) {
                sum += 2.7 * xuefen[i];
            } else if (cur >= 72 && cur <= 74) {
                sum += 2.3 * xuefen[i];
            } else if (cur >= 68 && cur <= 71) {
                sum += 2.0 * xuefen[i];
            } else if (cur >= 64 && cur <= 67) {
                sum += 1.5 * xuefen[i];
            } else if (cur >= 60 && cur <= 63) {
                sum += 1.0 * xuefen[i];
            } else if (cur < 60) {
                sum += 0.1 * xuefen[i];
            }
        }
        result = sum / summ;
        System.out.println(String.format("%d.2f", result));
    }
}
