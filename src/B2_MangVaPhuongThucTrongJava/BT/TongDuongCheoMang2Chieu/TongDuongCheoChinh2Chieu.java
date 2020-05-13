package B2_MangVaPhuongThucTrongJava.BT.TongDuongCheoMang2Chieu;

import java.util.Scanner;

public class TongDuongCheoChinh2Chieu {

    public static int[][] mang2Chieu() {
        Scanner kb = new Scanner(System.in);
        int cot;
        int dong;
        do {
            System.out.println("Nhập vào số dòng của mảng 2 chiều:");
            dong = kb.nextInt();
            System.out.println("Nhập vào số cột của mảng 2 chiều:");
            cot = kb.nextInt();
            if (cot != dong || cot < 0 || dong < 0) {
                System.out.println("Mảng 2 chiều không hợp lệ");
            }
        } while (cot != dong || cot < 0 || dong < 0);
        int arr[][] = new int[cot][dong];
        System.out.println("Nhập vào số phần tử của mảng 2 chiều");
        for (int i = 0; i < cot; i++) {
            for (int j = 0; j < dong; j++) {
                System.out.println("arr[" + i + "] [" + j + "] = ");
                arr[i][j] = kb.nextInt();
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int[][] arr2;
        int sum = 0;
        arr2 = mang2Chieu();
        for (int j = 0; j < arr2.length; j++) {
            sum += arr2[j][j];
        }
        System.out.println("Tổng đường chéo chính mảng 2 chiều: " + sum);
    }
}
