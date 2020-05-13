package B2_MangVaPhuongThucTrongJava.BT.XoaPTKhoiMang;

import java.util.Scanner;


public class XoaPTKhoiMang {
    public static int[] xoaPTMang(int[] arr, int x) {
        int[] arr1 = new int[arr.length];
        boolean check = false;
        for (int i = 0; i < arr.length; i++) {
            if (x == arr[i]) {
                arr1[i] = arr[i + 1];
                i++;
                check = true;
            }
            if (check)
                arr1[i - 1] = arr[i];
            else
                arr1[i] = arr[i];

        }
        return arr1;
    }

    public static int[] enterArray(int size) {
        Scanner kb = new Scanner(System.in);
        int[] Array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("vị trí thứ  [" + i + "] :");
            Array[i] = kb.nextInt();
        }
        return Array;

    }

    public static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int size1 = 2;
        int x;

        System.out.println("Nhập vào chiều dài mảng 1:");
        size1 = kb.nextInt();

        int[] Array1;
        int[] Array2;
        Array1 = enterArray(size1);

        System.out.println("Nhập vào số cần xóa:");
        x = kb.nextInt();

        Array2 = xoaPTMang(Array1, x);

        System.out.println("Mảng hiện tại là:");
        showArray(Array2);
    }
}
