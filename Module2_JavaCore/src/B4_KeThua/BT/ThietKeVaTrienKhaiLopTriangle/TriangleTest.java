package B4_KeThua.BT.ThietKeVaTrienKhaiLopTriangle;

import B4_KeThua.TH.HeCacDTHinhHoc.Shape;

import java.util.Scanner;

public class TriangleTest {
        public static void main(String[] args) {
            Scanner kb = new Scanner(System.in);
            Shape triangle = new Triangle();
            //System.out.println(triangle);

            // triangle = new Triangle(2,5,6);
            System.out.println("Nhập side1");
            ((Triangle)triangle).setSide1(kb.nextDouble());
            System.out.println("Nhập side2");
            ((Triangle)triangle).setSide2(kb.nextDouble());
            System.out.println("Nhập side3");
            ((Triangle)triangle).setSide3(kb.nextDouble());
            kb.nextLine();
            System.out.println("Nhập color");
            triangle.setColor(kb.nextLine());

            System.out.println(triangle);
        }

}
