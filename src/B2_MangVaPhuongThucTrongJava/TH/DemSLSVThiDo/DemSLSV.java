package B2_MangVaPhuongThucTrongJava.TH.DemSLSVThiDo;

import java.util.Scanner;

public class DemSLSV {
    public static void main(String[] args) {
        int size;
        int [] arr;
        Scanner kb = new Scanner(System.in);
        do {
            System.out.println("Nhập vào số lượng sinh viên: ");
            size = kb.nextInt();
            if (size > 30 || size<0) {
                System.out.println("số lượng sinh viên không vượt quá 30");
            }
        } while (size>30 || size<0);
        arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("nhập vào điểm của học sinh thứ "+(i+1) + ":");
            arr[i] = kb.nextInt();
        }
        int count =0;
        System.out.println("danh sách");
        for (int j=0;j<arr.length;j++) {
            System.out.print(arr[j] + "\t");
            if (arr[j]>=5 && arr[j]<=10) {
                count ++;
            }

        }
        System.out.println("\n số học sinh qua kỳ thi là: "+count);
    }

}
