package B2_MangVaPhuongThucTrongJava.BT.IllegalTriangleException;

import java.util.Scanner;

public class IllegalTriangleException {
    public static int canhTamGiac(String a) {
        Scanner kb = new Scanner(System.in);
        boolean check = false;
        int n=0;
        while (!check) {
            System.out.println("Nhap so :");
            String str = kb.nextLine();
            if (str.trim().equals("")) {
                System.out.println("Ban nhap chuoi rong, xin vui long nhap lai.");
                continue;
            }

            try {
                n = Integer.parseInt(str);
            } catch (NumberFormatException ex) {
                System.out.println("Ban nhap chuoi khong hop le, xin vui long chi nhap so.");
                continue;
            }
            if (n < 0) {
                System.out.println("nhập số lớn hơn 0");

                check = false;
            }
            return n;
        }

        return n;
    }

    public static void main(String[] args) {
        int a = canhTamGiac("Nhap a");
        int b = canhTamGiac("Nhap b");
        int c = canhTamGiac("Nhap c");
        if (((a + b) < c) || ((a + c) < b) || ((c + b) < a)) {
            System.out.println("không phải là  tam giác ");
        } else {
            System.out.println("là tam giác");
        }
    }
}
