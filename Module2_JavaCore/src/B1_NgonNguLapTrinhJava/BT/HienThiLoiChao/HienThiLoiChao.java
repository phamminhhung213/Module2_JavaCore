package B1_NgonNguLapTrinhJava.BT.HienThiLoiChao;

import java.sql.SQLOutput;
import java.util.Scanner;

public class HienThiLoiChao {
    public static void main(String[] args) {
        System.out.println("Enter your name : ");
        Scanner kb = new Scanner(System.in);

        String name = kb.nextLine();
        System.out.println("Hello: " +name);
    }
}
