package B2_MangVaPhuongThucTrongJava.BT.TinhTongCacSoO1Cot;

import java.util.Scanner;

public class TongCacSoOMotCot {
    public static int [][] mang2Chieu() {
        Scanner kb = new Scanner(System.in);
        int a, b;
        do {
            System.out.println("Nhập vào số dòng của mảng ");
            a = kb.nextInt();
            System.out.println("Nhập vào cột của mảng ");
            b = kb.nextInt();
            if (a > 5 || b > 5 || a < 0 || b < 0) {
                System.out.println("cột và dòng của mảng nhỏ hơn 5 và lớn hơn 1");
            }
        } while (a > 5 || b > 5 || a < 0 || b < 0);

        int arr[][] = new int[a][b];
        System.out.println("Nhập vào số phần tử của mảng 2 chiều");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.println("arr[" + i + "] [" + j + "] = ");
                arr[i][j] = kb.nextInt();
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int arr2[][];
        int sum = 0;
        arr2 = mang2Chieu();
        for (int i = 0; i < arr2.length; i++) {
            sum += arr2[0][i];
        }
        System.out.println("tổng cột của mảng 2 chiều là:"+sum);
    }
}
