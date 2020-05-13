package B1_NgonNguLapTrinhJava.BT.HienThi20SoNTDauTien;

import java.util.Scanner;

public class HienThi20SoNTDauTien {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Nhập vào số lượng số nguyên tố cần in ra : ");
        int m = kb.nextInt();
        int num = 0;
        int count = 0;

        while (count < m) {
            if (isPrimeNumber(num)) {
                System.out.println(num);
                count++;
            }
            num++;
        }
    }

    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
