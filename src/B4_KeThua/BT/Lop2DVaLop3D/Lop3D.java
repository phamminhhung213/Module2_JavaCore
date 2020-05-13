package B4_KeThua.BT.Lop2DVaLop3D;

public class Lop3D extends Lop2D {
    private float z = 0.0f;

    Lop3D() {

    }

    Lop3D(float z) {
        this.z = z;
    }

    public Lop3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        float Array[] = new float[3];
        Array = super.getXY();
        Array[2] = getZ();
        return Array;
    }

    @Override
    public String toString() {
        return "Lop3D{" +
                "z=" + z +
                '}'
                +"x"
                +super.getX()
                +"y"
                +super.getY();
    }
}
