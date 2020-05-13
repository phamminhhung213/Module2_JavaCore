package B5_AdvancedObjectOrientedDesign.TH.TrienKhaiInterfaceComparableChoCacLopHinhHoc;

import java.util.Arrays;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[] circles  = new ComparableCircle[3];
        circles [0] = new ComparableCircle(3.5);
        circles [1] = new ComparableCircle();
        circles [2] = new ComparableCircle(3.8,"indigo",false);

        System.out.println("sắp xếp comparable");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
        Arrays.sort(circles);

        System.out.println("Sau khi sắp xếp:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }


    }

    }


