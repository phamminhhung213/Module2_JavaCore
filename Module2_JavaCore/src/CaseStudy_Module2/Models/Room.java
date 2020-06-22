package CaseStudy_Module2.Models;

import CaseStudy_Module2.Commons.Kb;

public class Room extends Services {
    private String dichVuMienPhiDiKem;
    String RegexIDRoom = "^SVRO-[\\d]{4}$";
    String RegexDVMPDK = "^[massage][karaoke][food][drink][car]$";

    public void addNewRoom() {
        super.setId(Kb.strString("Nhập vào ID: ", "Nhập nhập sai định dạng xin nhập lại :", this.RegexIDRoom));
        super.addServices();
        this.setDichVuMienPhiDiKem(Kb.strString("Nhập vào dịch vụ miễn phí đi kèm : massage, karaoke, food, drink, car", "Không đúng định dạng mời nhập lại", RegexDVMPDK));
    }

    public Room() {
    }

    public Room(String dichVuMienPhiDiKem) {
        this.dichVuMienPhiDiKem = dichVuMienPhiDiKem;
    }

    public Room(String id, String tenDichVu, double dienTichSuDung, double chiPhiThue, int soLuongNguoiToiDa, String kieuThue, String dichVuMienPhiDiKem) {
        super(id, tenDichVu, dienTichSuDung, chiPhiThue, soLuongNguoiToiDa, kieuThue);
        this.dichVuMienPhiDiKem = dichVuMienPhiDiKem;
    }

    public String getDichVuMienPhiDiKem() {
        return dichVuMienPhiDiKem;
    }

    public void setDichVuMienPhiDiKem(String dichVuMienPhiDiKem) {
        this.dichVuMienPhiDiKem = dichVuMienPhiDiKem;
    }

    @Override
    public String showInfor() {
        return "\n ID Service: " + super.getId()
                + "\n Tên dịch vụ: " + super.getTenDichVu()
                + "\n Diện tích sử dụng: " + super.getDienTichSuDung()
                + "\n Chi phí thuê: " + super.getChiPhiThue()
                + "\n Số lượng người tối đa: " + super.getSoLuongNguoiToiDa()
                + "\n Kiểu thuê: " + super.getKieuThue()
                + "\n Dịch vụ miễn khí đi kèm: " + this.getDichVuMienPhiDiKem();
    }
}
