package B2_MangVaPhuongThucTrongJava.BT.GopMang;

import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        int size1;
        Scanner kb = new Scanner(System.in);
        System.out.println("nhập vào số phần tử của mảng 1");
        size1 = kb.nextInt();
        kb.nextLine();

        String[] arr1 = new String[size1];
        for (int i = 0; i <size1; i++) {
            System.out.println("nhập vào vị trí thứ  "+(i+1) + ":");
            arr1[i] = kb.nextLine();
        }
        System.out.println("nhập vào số phần tử của mảng 2");
        int size2 = kb.nextInt();
        kb.nextLine();
        String[] arr2 = new String[size2];
        for (int i = 0; i < size2; i++) {
            System.out.println("nhập vào vị trí thứ  "+(i+1) + ":");
            arr2[i] = kb.nextLine();
        }
        String[] arr = new String[size1 + size2];
        for (int i=0;i<arr1.length;i++){
            arr[i]=arr1[i];
        }
        for (int i=0;i<arr2.length;i++){
            arr[size1]=arr2[i];
            size1++;
        }

        String str="";
        for (String item:arr){
            str+=item+" ";
        }
        System.out.println("Mảng sau khi gộp:"+str);

    }
}
