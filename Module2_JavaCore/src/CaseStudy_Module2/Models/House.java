package CaseStudy_Module2.Models;

import CaseStudy_Module2.Commons.Kb;

public class House extends Services {
    private String tieuChuanPhong;
    private String moTaTienNghiKhac;
    private int soTang;
    private String RegexIDHouse = "^SVHO-[\\d]{4}$";
    private String RegexTCPHouse = "^[A-Z][a-z]+$";

    public void addNewHouse() {
        super.setId(Kb.strString("Nhập vào ID: ", "Nhập nhập sai định dạng xin nhập lại :", this.RegexIDHouse));
        super.addServices();
        this.setTieuChuanPhong(Kb.strString("Nhập vào tiêu chuẩn phòng: ", "Tiêu chuẩn phòng sai định dạng mời nhập lại: ", this.RegexTCPHouse));
        this.setMoTaTienNghiKhac(Kb.strString("Nhập vào mô tả tiện nghi khác"));
        do {
            setSoTang(Kb.strInt("Nhập vào diện tích hồ bơi: ", "Diện tích hồ bơi sai định dạng mời nhập lại:"));
            if (this.soTang < 0) {
                System.out.println("Số tầng phải là số nguyên dương: ");
            }
        } while (this.soTang < 0);


    }

    public House() {

    }

    public House(String tieuChuanPhong, String moTaTienNghiKhac, int soTang) {
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghiKhac = moTaTienNghiKhac;
        this.soTang = soTang;
    }

    public House(String id, String tenDichVu, double dienTichSuDung, double chiPhiThue, int soLuongNguoiToiDa, String kieuThue, String tieuChuanPhong, String moTaTienNghiKhac, int soTang) {
        super(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghiKhac = moTaTienNghiKhac;
        this.soTang = soTang;
    }

    public String getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public String getMoTaTienNghiKhac() {
        return moTaTienNghiKhac;
    }

    public void setMoTaTienNghiKhac(String moTaTienNghiKhac) {
        this.moTaTienNghiKhac = moTaTienNghiKhac;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    @Override
    public String showInfor() {
        return "\n ID Service: " + super.getId()
                + "\n Tên dịch vụ: " + super.getTenDichVu()
                + "\n Diện tích sử dụng: " + super.getDienTichSuDung()
                + "\n Chi phí thuê: " + super.getChiPhiThue()
                + "\n Số lượng người tối đa: " + super.getSoLuongNguoiToiDa()
                + "\n Kiểu thuê: " + super.getKieuThue()
                + "\n Tiêu chuẩn phòng: " + this.getTieuChuanPhong()
                + "\n Mô tà tiện nghi khác: " + this.getMoTaTienNghiKhac()
                + "\n Số tầng: " + this.getSoTang();
    }
}
