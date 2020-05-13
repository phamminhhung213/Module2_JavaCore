package B5_AdvancedObjectOrientedDesign.BT.TrienKhaiInterfaceResizeableChoCacLopHinhHoc;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
       // System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);
//
//        circle = new Circle(3.5, "indigo", false);
//        System.out.println(circle);


        circle.resize(2);
        System.out.println(circle);
    }
}
