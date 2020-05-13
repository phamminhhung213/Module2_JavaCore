package B4_KeThua.BT.LopCircleVaLopCylinder;

public class Cylinder extends Circle {
    private double chieucao=1.0;

    public Cylinder() {
    }

    public Cylinder(double chieucao) {
        this.chieucao = chieucao;
    }

    public Cylinder(double radius, String color, double chieucao) {
        super(radius, color);
        this.chieucao = chieucao;
    }
    public double getTheTich() {
        return super.getRadius()*super.getArea() *this.chieucao* Math.PI;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "chieucao=" + chieucao +
                '}'
                +"thể tích hình trụ"
                +getTheTich();
    }
}
