package Test.B5_AdvancedObjectOrientedDesign.BT.TrienKhaiInterfaceResizeableChoCacLopHinhHoc;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
//        System.out.println(square);
//
//        square = new Square(2.3);
//        System.out.println(square);

        square = new Square(5.8, "yellow", true);
        System.out.println(square);

      square.resize(Math.random()*101);
        System.out.println(square);
    }
}
