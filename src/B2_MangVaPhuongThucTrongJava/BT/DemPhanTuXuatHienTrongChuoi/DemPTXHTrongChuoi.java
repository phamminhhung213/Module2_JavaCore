package B2_MangVaPhuongThucTrongJava.BT.DemPhanTuXuatHienTrongChuoi;

import java.util.Scanner;

public class DemPTXHTrongChuoi {
    public static int demSoLanXuatHienTrongChuoi(String str , char x) {
        int count=0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)==x) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);
        String str1;
        char c;
        System.out.println("Nhập vào 1 chuổi");
        str1 = kb.nextLine();
        System.out.println("Nhập vào ký tự cần tìm trong chuổi");
        c=kb.nextLine().charAt(0);
        System.out.println(demSoLanXuatHienTrongChuoi(str1,c));


    }
}
