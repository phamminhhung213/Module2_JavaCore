package B2_MangVaPhuongThucTrongJava.TH.DaoNguocCacPhanTuTrongMang;

import java.util.Random;
import java.util.Scanner;

public class daoNguocMang {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner kb1 = new Scanner(System.in);
        Random kb = new Random();

        do {
            System.out.println("Nhập vào kích thước mảng");
            size = kb1.nextInt();
            if (size > 20 || size < 0) {
                System.out.println("Số phần tử của mảng không hợp lệ");
            }
        } while (size > 20 || size < 0);
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = kb.nextInt();
            System.out.print(array[i] + "\t");
        }
        for (int j = 0; j < array.length / 2; j++) {
            int temp = array[j];
            array[j] = array[size - 1 - j];
            array[size - 1 - j] = temp;
        }
        System.out.println();
        System.out.println("Mảng sau khi sắp xếp");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}