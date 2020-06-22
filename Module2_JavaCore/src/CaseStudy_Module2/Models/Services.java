package CaseStudy_Module2.Models;

import java.util.Scanner;

import CaseStudy_Module2.Commons.Kb;

public abstract class Services {
    public static Scanner kb = new Scanner(System.in);

    private String id;
    private String tenDichVu;
    private double dienTichSuDung;
    private double chiPhiThue;
    private int soLuongNguoiToiDa;
    private String kieuThue;

    private String RegexName = "^[A-Z][a-z]+$";


    protected void addServices() {
        this.setTenDichVu(Kb.strString("Nhập vào tên dịch vụ: ", "Tên dịch vụ không đúng định dạng mời nhập lại: ", RegexName));
        do {

            this.setDienTichSuDung(Kb.strDouble("Nhập vào diện tích sử dụng ", "Diện tích sử dụng không đúng định dạng mời nhập lại:"));
            if (this.dienTichSuDung < 30) {
                System.out.println("Nhập số lớn hơn 30");
            }

        } while (this.dienTichSuDung < 30);
        do {

            this.setChiPhiThue(Kb.strDouble("Nhập vào chi phí thuê ", "Chi phí thuê không đúng định dạng mời nhập lại: "));
            if (this.chiPhiThue < 0) {
                System.out.println("Chỉ phí thuê không thể âm mời nhập lại ");
            }

        } while (this.chiPhiThue < 0);
        do {
            this.setSoLuongNguoiToiDa(Kb.strInt("Nhập vào số lượng người tối đa: ", "Không đúng đinh dạng mời nhập lại:"));
            if (this.soLuongNguoiToiDa < 0 || this.soLuongNguoiToiDa > 20) {
                System.out.println(" 0 <Số Lượng<20 ");
            }
        } while (this.soLuongNguoiToiDa < 0 || this.soLuongNguoiToiDa > 20);

        this.setKieuThue(Kb.strString("Nhập vào kiểu thuê: ", "Tên dịch vụ không đúng định dạng mời nhập lại: ", RegexName));

    }

    public Services() {
    }

    public Services(String id, String tenDichVu, double dienTichSuDung, double chiPhiThue, int soLuongNguoiToiDa, String kieuThue) {
        this.id = id;
        this.tenDichVu = tenDichVu;
        this.dienTichSuDung = dienTichSuDung;
        this.chiPhiThue = chiPhiThue;
        this.soLuongNguoiToiDa = soLuongNguoiToiDa;
        this.kieuThue = kieuThue;
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

    public double getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(double chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
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

    public abstract String showInfor();


}

