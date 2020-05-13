package B1_NgonNguLapTrinhJava.TH.KTNamNhuan;

import java.util.Scanner;

public class KTNamNhuan {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the year: ");
        int year = kb.nextInt();

        if((year % 4 != 0 || year %100 ==0) && year %400 !=0)
            System.out.println(year + " không phải năm nhuận");
        else
            System.out.println(year + " là năm nhuận");

    }
}
