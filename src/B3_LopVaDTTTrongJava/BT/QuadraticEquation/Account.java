package B3_LopVaDTTTrongJava.BT.QuadraticEquation;

import java.util.Scanner;

public class Account {
    private double a, b, c;
    Account() {
    }
    Account(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public void setABC(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }
    public double getC() {
        return c;
    }
    public double getDiscriminant() {
        return this.b * this.b - 4 * this.a * this.c;
    }

    public double getRoot1() {
        if (getDiscriminant() > 0) {
            return (-this.b + Math.sqrt(getDiscriminant())) / 2 * this.a;
        } else return 0;
    }
    public double getRoot2() {
        if (getDiscriminant() > 0) {
            return (-this.b - Math.sqrt(getDiscriminant())) / 2 * this.a;
        } else return 0;
    }
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Nhập vào a");
        double a = kb.nextDouble();
        System.out.println("Nhập vào b");
        double b = kb.nextDouble();
        System.out.println("Nhập vào c");
        double c = kb.nextDouble();
        Account quadraticEquation = new Account();
        quadraticEquation.setABC(a, b, c);

        if (quadraticEquation.getDiscriminant() > 0) {
            System.out.print("Phương trình có 2 nghiệm phân biệt  " + quadraticEquation.getRoot1() + "  và  " + quadraticEquation.getRoot2());
        } else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("phương trình có 1 nghiện duy nhất" + (-b / 2 * a));
        } else {
            System.out.println("Phương trình có 1 nghiệm");
        }
    }
}
