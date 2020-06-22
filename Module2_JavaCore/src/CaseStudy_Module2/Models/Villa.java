package CaseStudy_Module2.Models;


import CaseStudy_Module2.Commons.Kb;

public class Villa extends Services {

    private String tieuChuanPhong;
    private String moTaTienNghiKhac;
    private double dienTichHoBoi;
    private int soTang;
    private String RegexIDVilla = "^SVVL-[\\d]{4}$";
    private String RegexTCPVilla = "^[A-Z][a-z]+$";

    public void AddNewViila() {
        super.setId(Kb.strString("Nhập vào ID: ", "Nhập nhập sai định dạng xin nhập lại :", RegexIDVilla));
        super.addServices();
        setTieuChuanPhong(Kb.strString("Nhập vào tiêu chuẩn phòng: ", "Tiêu chuẩn phòng sai định dạng mời nhập lại: ", RegexTCPVilla));
        this.setMoTaTienNghiKhac(Kb.strString("Nhập mô tả tiện nghi khác"));
        do {
            setDienTichHoBoi(Kb.strDouble("Nhập vào diện tích hồ bơi: ", "Diện tích hồ bơi sai định dạng mời nhập lại:"));
            if (dienTichHoBoi < 30) {
                System.out.println("Diện tích hồ bơi phải lớn hơn 30 mời nhập lại: ");
            }
        } while (dienTichHoBoi < 30);
        do {
            setSoTang(Kb.strInt("Nhập vào diện tích hồ bơi: ", "Diện tích hồ bơi sai định dạng mời nhập lại:"));
            if (soTang < 0) {
                System.out.println("Số tầng phải là số nguyên dương: ");
            }
        } while (soTang < 0);


    }

    public Villa() {
    }

    public Villa(String tieuChuanPhong, String moTaTienNghiKhac, double dienTichHoBoi, int soTang) {
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghiKhac = moTaTienNghiKhac;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    public Villa(String id, String tenDichVu, double dienTichSuDung, double chiPhiThue, int soLuongNguoiToiDa, String kieuThue, String tieuChuanPhong, String moTaTienNghiKhac, double dienTichHoBoi, int soTang) {
        super(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue);
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaTienNghiKhac = moTaTienNghiKhac;
        this.dienTichHoBoi = dienTichHoBoi;
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

    public double getDienTichHoBoi() {
        return dienTichHoBoi;
    }

    public void setDienTichHoBoi(double dienTichHoBoi) {
        this.dienTichHoBoi = dienTichHoBoi;
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
                + "\n Diện tích hồ bơi: " + this.getDienTichHoBoi()
                + "\n Số tầng: " + this.getSoTang();
    }


}
