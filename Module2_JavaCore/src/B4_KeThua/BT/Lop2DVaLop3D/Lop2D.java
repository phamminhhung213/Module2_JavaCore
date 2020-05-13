package B4_KeThua.BT.Lop2DVaLop3D;

public class Lop2D {
    private float x = 0.0f;
    private float y = 0.0f;

    Lop2D() {
    }

    Lop2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        float Array[] = new float[2];
        Array[0]=getX();
        Array[1]=getY();
        return Array;

    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Lop2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}
