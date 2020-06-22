package CaseStudy_Module2.Models;

import java.util.HashMap;

public class Employee {
    private static HashMap<String, Employee> employees = new HashMap<String, Employee>();

    private String idNhanVien;
    private String tenNhanVien;
    private int tuoi;
    private String diaChi;

    public Employee() {

    }

    public Employee(String idNhanVien, String tenNhanVien, int tuoi, String diaChi) {
        this.idNhanVien = idNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.tuoi = tuoi;
        this.diaChi = diaChi;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idNhanVien='" + idNhanVien + '\'' +
                ", tenNhanVien='" + tenNhanVien + '\'' +
                ", tuoi=" + tuoi +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}
