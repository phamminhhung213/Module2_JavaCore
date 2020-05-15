package Test.Casestudy_Module2_JavaCore.Models;

import java.util.Scanner;

public abstract class Services {
    public static Scanner kb = new Scanner(System.in);
    private String id;
    private String tenDichVu;
    private double dienTichSuDung;
    private int soLuongNguoiToiDa;
    private String kieuThue;


    public void addServices() {

    }



    public Services() {
    }

    public Services(String id, String tenDichVu, double dienTichSuDung, int soLuongNguoiToiDa, String kieuThue) {
        this.id = id;
        this.tenDichVu = tenDichVu;
        this.dienTichSuDung = dienTichSuDung;
        this.soLuongNguoiToiDa = soLuongNguoiToiDa;
        this.kieuThue = kieuThue;
    }



    public static Scanner getKb() {
        return kb;
    }

    public static void setKb(Scanner kb) {
        Services.kb = kb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public double getDienTichSuDung() {
        return dienTichSuDung;
    }

    public void setDienTichSuDung(double dienTichSuDung) {
        this.dienTichSuDung = dienTichSuDung;
    }

    public int getSoLuongNguoiToiDa() {
        return soLuongNguoiToiDa;
    }

    public void setSoLuongNguoiToiDa(int soLuongNguoiToiDa) {
        this.soLuongNguoiToiDa = soLuongNguoiToiDa;
    }

    public String getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(String kieuThue) {
        this.kieuThue = kieuThue;
    }
}
