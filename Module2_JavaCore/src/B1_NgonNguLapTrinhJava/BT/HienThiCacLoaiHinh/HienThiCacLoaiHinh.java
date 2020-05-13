package B1_NgonNguLapTrinhJava.BT.HienThiCacLoaiHinh;


import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static Scanner kb = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;
        while (choice != 0) {
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle top-left");
            System.out.println("3. Print the square triangle top-right");
            System.out.println("4. Print the square triangle botton-left");
            System.out.println("5. Print the square triangle botton-right");
            System.out.println("6. Print isosceles triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = kb.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(" Print the rectangle");
                   HinhChuNhat();
                    break;
                case 2:
                    System.out.println("Print the square triangle top-left");
                    TopLeft();
                    break;
                case 3:
                    System.out.println("Print the square triangle top-right");
                    topRight();
                    break;
                case 4:
                    System.out.println("Print the square triangle botton-left");
                    bottonLeft();
                    break;
                case 5:
                    System.out.println("Print the square triangle botton-right");
                    bottonRight();
                    break;
                case 6:
                    System.out.println("Print isosceles triangle top");
                    isoscelesTriangleTop();
                    break;
                case 7:
                    System.out.println("Print isosceles triangle botton");
                    isoscelesTriangleBotton();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }

    }



    public static void HinhChuNhat(){
        int dai;
        int rong;
        System.out.println("Nhập vào chiều dài:");
        dai = kb.nextInt();
        System.out.println("Nhập vào chiều rộng");
        rong = kb.nextInt();
        int num = 1;
        while (num <= rong) {
            for (int i = 1; i <= dai; i++) {
                System.out.print("*");
            }
            System.out.println();
            num++;
        }
        kb.nextLine();
        kb.nextLine();

;
    }
    public static void bottonLeft() {
        System.out.println("Enter the number of rows: ");
        int n=kb.nextInt();
        int i, j;

        for(i=0; i<n; i++)
        {
            for(j=0; j<=i; j++)
            {
                System.out.print( " * ");
            }
            System.out.println();
        }
        kb.nextLine();
        kb.nextLine();
    }

    public static void bottonRight() {
        System.out.println("Enter the number of rows: ");
        int n=kb.nextInt();
        int i, j;
        for(i=0; i<n; i++)
        {
            for(j=2*(n-i); j>=0; j--)
            {
                System.out.print(" ");
            }
            for(j=0; j<=i; j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        kb.nextLine();
        kb.nextLine();
    }

    public static void TopLeft() {
        System.out.println("Enter the number of rows: ");
        int rows = kb.nextInt();
        for (int i= rows-1; i>=0 ; i--)
        {
            for (int j=0; j<=i; j++)
            {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
        kb.nextLine();
        kb.nextLine();
    }
    public static void topRight() {
        System.out.println("Enter the number of rows: ");
        int rows = kb.nextInt();
        for (int i= rows; i>= 1; i--)
        {
            for (int j=rows; j>i;j--)
            {
                System.out.print(" ");
            }
            for (int k=1;k<=i;k++)
            {
                System.out.print("*");
            }
            System.out.println("");
        }
        kb.nextLine();
        kb.nextLine();
    }
    public static void isoscelesTriangleTop() {
        int i,j,n;

        System.out.println("Enter the number of rows: ");
        n = kb.nextInt();

        for(i=1;i<=n;i++)
        {
            for(j=i;j<=n;j++)
            {
                System.out.print(" ");
            }
            for(j=1;j<=i;j++)
            {
                System.out.print("* ");
            }
            System.out.println("");
        }
        kb.nextLine();
        kb.nextLine();
    }
    public static void isoscelesTriangleBotton() {
        System.out.println("Enter the number of rows: ");
        int rows = kb.nextInt();
        for (int i= 0; i<= rows-1 ; i++)
        {
            for (int j=0; j<=i; j++)
            {
                System.out.print(" ");
            }
            for (int k=0; k<=rows-1-i; k++)
            {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
        kb.nextLine();
        kb.nextLine();
    }

}







