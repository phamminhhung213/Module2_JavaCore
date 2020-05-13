package B1_NgonNguLapTrinhJava.TH.TienLaiChoVay;

import java.util.Scanner;

public class TienLaiChoVay {
    public static void main(String[] args) {
        double money = 1.0;
        int month = 1;
        double interset_rate = 1.0;

        Scanner kb = new Scanner(System.in);
        System.out.println("Money: ");
        money = kb.nextDouble();
        System.out.println("Time (month): ");
        month = kb.nextInt();
        System.out.println("Interest rate: ");
        interset_rate = kb.nextDouble();

        double total_interset = 0;
        for (int i = 0; i < month; i++) {
            total_interset = money * (interset_rate / 100) / 12 * month;
        }

        System.out.println("Total interset: " + total_interset);
    }
}
