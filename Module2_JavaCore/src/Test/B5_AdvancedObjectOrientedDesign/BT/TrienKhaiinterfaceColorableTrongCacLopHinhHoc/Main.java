package Test.B5_AdvancedObjectOrientedDesign.BT.TrienKhaiinterfaceColorableTrongCacLopHinhHoc;



public class Main {
    public static void main(String[] args) {
        Shape shape[] = new Shape[3];
        shape[0] = new Circle();
        shape[1] = new Rectangle();
        shape[2] = new Square();

        for (Shape shape1 : shape) {
            if (shape1 instanceof Square) {
//                Colorable colorable = ((Square)shape1);  // Nặc danh
//                colorable.howToColor();
              ((Square) shape1).howToColor();
            }
            System.out.println(shape1);
        }


    }
}
