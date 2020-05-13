package B1_NgonNguLapTrinhJava.TH.UCLN;

import java.util.Scanner;

public class UCLN {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.println("Enter a: ");
        int a = kb.nextInt();
        System.out.println("Enter b: ");
        int  b = kb.nextInt();

        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0)
            System.out.println("No greatest common factor");
        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        System.out.println("Greatest common factor: " + a);

    }
}
