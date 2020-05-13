package B2_MangVaPhuongThucTrongJava.BT.ThemPhanTuVaoMang;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static Scanner kb = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Nhập vào số phần tử của mảng");
        int n = kb.nextInt();
        int [] arr = new int [n];
        System.out.print("Nhập các phần tử của mảng: \n");
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.print("Nhập phần tử k = ");
        int k = kb.nextInt();
        System.out.print("Nhập vào vị trí cần chèn ");
        int a = kb.nextInt();
        System.out.printf("\nChèn phần tử vào mảng.", k);
        arr = insert(arr, a,k);
        System.out.print("\nMảng sau khi chèn: ");
        show(arr);

    }
    public static int [] insert(int [] arr, int a , int k) {
        int j=0;
        int arr1[] = new int[arr.length+1];
        for (int i = 0; i < arr.length;i++) {
            if (i==a-1) {
                arr1[j] =k;
                j++;
            }
            arr1[j] = arr[i];
            j++;
    }
        return arr1;
    }
    public static void show(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
