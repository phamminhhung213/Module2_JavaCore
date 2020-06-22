package CaseStudy_Module2.Models;

import CaseStudy_Module2.Commons.Kb;

import java.util.Scanner;

public class Customer  {
    Scanner kb = new Scanner(System.in);
    private String tenKhachHang;
    private String ngaySinh;
    private String gioiTinh;
    private String soCMND;
    private String SDT;
    private String email;
    private String loaiKhach;
    private String diaChi;
    private Services serviceUsageProperties;

    private String regexFullNameCustomer = "^([A-Z][a-z]*[\\s])*[A-Z][a-z]*$";
    private String regexEmailCustomer = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
    private String regexGenderCustomer = "^(male)|(female)|(unknow)$";
    private String regexIdCardCustomer = "^([\\d]{3}[\\s]){2}[\\d]{3}$";
    private String regexNumphoneNumberCustomer = "^[0][\\d]{9}$";

    public  void AddNewCustomer() {
        this.setTenKhachHang(Kb.strString("nhập vào tên khách hàng: ", "Tên Khách hàng phải in hoa ký tự đầu tiên trong mỗi từ.", this.regexFullNameCustomer));
        this.setNgaySinh(Kb.birthdayException("Nhập vào ngày tháng năm sinh khách hàng: ", "Năm sinh phải >1900 và nhỏ hơn năm hiện tại 18 năm, đúng định dạng dd/mm/yyyy"));
        this.setSoCMND(Kb.strString("nhập vào sô CMND khách hàng: ", "Id Card phải có 9 chữ số và theo định dạng XXX XXX XXX.", this.regexIdCardCustomer));
        this.setGioiTinh(Kb.strString("nhập vào giới tính của khách hàng: ", "Cần nhập vào giới tính là male, female or Unknow.", this.regexGenderCustomer, true));
        this.setSDT(Kb.strString("nhập số điện thoại khách hàng: ", "Bạn cần nhập số điện thoại gồm 10 số bắt đầu là 0.", this.regexNumphoneNumberCustomer));
        this.setEmail(Kb.strString("nhập vào email của khách hàng: ", "Email phải đúng định dạng abc@abc.abc.", this.regexEmailCustomer));
        this.setLoaiKhach(Kb.strString("nhập vào loại khách: "));
        this.setDiaChi(Kb.strString("nhập vào địa chỉ khách hàng: "));
    }
    public Customer() {
    }

    public Scanner getKb() {
        return kb;
    }

    public void setKb(Scanner kb) {
        this.kb = kb;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoaiKhach() {
        return loaiKhach;
    }

    public void setLoaiKhach(String loaiKhach) {
        this.loaiKhach = loaiKhach;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Services getServiceUsageProperties() {
        return serviceUsageProperties;
    }

    public void setServiceUsageProperties(Services serviceUsageProperties) {
        this.serviceUsageProperties = serviceUsageProperties;
    }

    public String getRegexFullNameCustomer() {
        return regexFullNameCustomer;
    }

    public void setRegexFullNameCustomer(String regexFullNameCustomer) {
        this.regexFullNameCustomer = regexFullNameCustomer;
    }

    public String getRegexEmailCustomer() {
        return regexEmailCustomer;
    }

    public void setRegexEmailCustomer(String regexEmailCustomer) {
        this.regexEmailCustomer = regexEmailCustomer;
    }

    public String getRegexGenderCustomer() {
        return regexGenderCustomer;
    }

    public void setRegexGenderCustomer(String regexGenderCustomer) {
        this.regexGenderCustomer = regexGenderCustomer;
    }

    public String getRegexIdCardCustomer() {
        return regexIdCardCustomer;
    }

    public void setRegexIdCardCustomer(String regexIdCardCustomer) {
        this.regexIdCardCustomer = regexIdCardCustomer;
    }

    public String getRegexNumphoneNumberCustomer() {
        return regexNumphoneNumberCustomer;
    }

    public void setRegexNumphoneNumberCustomer(String regexNumphoneNumberCustomer) {
        this.regexNumphoneNumberCustomer = regexNumphoneNumberCustomer;
    }

    public String showInfor() {
        return "\n Tên khách hàng: " + this.getTenKhachHang()
                + "\n Ngày sinh : " + this.getNgaySinh()
                + "\n Giới tính: " + this.getGioiTinh()
                + "\n Số CMND: " + this.getSoCMND()
                + "\n Số điện thoại: " + this.getSDT()
                + "\n Email: " + this.getEmail()
                + "\n Loại khách hàng: " + this.getLoaiKhach()
                + "\n Dịa chỉ: " + this.getDiaChi();

    }
}
