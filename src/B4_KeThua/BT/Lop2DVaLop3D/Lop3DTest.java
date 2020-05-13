package B4_KeThua.BT.Lop2DVaLop3D;

import java.util.Scanner;

public interface Lop3DTest {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Lop2D lop3D = new Lop3D();
        System.out.println("Nhập vào x , y");
        lop3D.setXY(6,8);
        System.out.println("Nhập vào z");
        ((Lop3D)lop3D).setZ(5);
        System.out.println(lop3D);

    }





}
