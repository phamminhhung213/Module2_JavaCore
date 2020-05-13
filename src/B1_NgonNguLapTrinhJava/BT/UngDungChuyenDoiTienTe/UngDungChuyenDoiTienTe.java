package B1_NgonNguLapTrinhJava.BT.UngDungChuyenDoiTienTe;

import java.util.Scanner;


public class UngDungChuyenDoiTienTe {
    public static void main(String[] args) {
        System.out.println("Ứng dụng chuyển đổi tiền tệ ");
        Scanner kb = new Scanner(System.in);
        double rate = 23000;
        System.out.println("Nhập vào USD :");
        double usd = kb.nextDouble();
        double vnd = rate * usd;
        System.out.println("Số tiền sau khi chuyển đổi là : " +vnd);

    }
}
