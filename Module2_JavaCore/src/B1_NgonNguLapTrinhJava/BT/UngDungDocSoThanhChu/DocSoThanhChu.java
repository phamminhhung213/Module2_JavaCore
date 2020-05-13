package B1_NgonNguLapTrinhJava.BT.UngDungDocSoThanhChu;

import java.util.Scanner;

public class DocSoThanhChu {


    public static void main(String[] args) {
            while(true) {
                Scanner kb = new Scanner(System.in);
                System.out.println("Nhập vào số cần kiểm tra");
                int number = kb.nextInt();
                String s = String.valueOf(number);
                switch(s.length()) {
                    case 1:
                        System.out.println(docSoCo1ChuSo(number));
                        break;
                    case 2:
                        System.out.println(docHaiChuSo(number));
                        break;
                    case 3:
                        System.out.println(docBaChuSo(number));
                }
            }
        }

        public static String docSoCo1ChuSo(int so) {
            String ketQua = "";
            switch(so) {
                case 0:
                    ketQua = "Không";
                    break;
                case 1:
                    ketQua = "một";
                    break;
                case 2:
                    ketQua = "Hai";
                    break;
                case 3:
                    ketQua = "Ba";
                    break;
                case 4:
                    ketQua = "Bốn";
                    break;
                case 5:
                    ketQua = "Năm";
                    break;
                case 6:
                    ketQua = "Sáu";
                    break;
                case 7:
                    ketQua = "Bảy";
                    break;
                case 8:
                    ketQua = "Tám";
                    break;
                case 9:
                    ketQua = "Chín";
            }

            return ketQua;
        }

        public static String docHaiChuSo(int so) {
            String[] mang = new String[]{"Không", "Một", "Hai", "Ba", "Bốn", "Năm", "Sáu", "Bảy", "Tám", "chín"};
            int chuc = so / 10;
            int donVi = so % 10;
            String ketQua = "";
            if (chuc == 1) {
                if (donVi == 0) {
                    ketQua = "mười";
                } else if (donVi == 5) {
                    ketQua = "mười lăm";
                } else {
                    ketQua = "mười " + mang[donVi];
                }
            } else if (chuc == 0) {
                ketQua = mang[donVi];
            } else if (donVi == 1) {
                ketQua = mang[chuc] + " mốt";
            } else if (donVi == 5) {
                ketQua = mang[chuc] + " lăm";
            } else if (donVi == 0) {
                ketQua = mang[chuc] + " mươi";
            } else {
                ketQua = mang[chuc] + " " + mang[donVi];
            }

            return ketQua;
        }

        public static String docBaChuSo(int so) {
            String[] mang = new String[]{"Không", "Một", "Hai", "Ba", "Bốn", "Năm", "Sáu", "Bảy", "Tám", "chín"};
            int tram = so / 100;
            int chuc = so % 100 / 10;
            int donVi = so % 10;
            int soHangChuc = so % 100;
            String ketQua = "";
            if (tram == 0) {
                ketQua = "Không hợp lệ";
            } else if (chuc == 0 && donVi == 0) {
                ketQua = mang[tram] + " trăm";
            } else if (chuc == 0 && donVi != 0) {
                ketQua = mang[tram] + " trăm linh " + mang[donVi];
            } else {
                ketQua = mang[tram] + " trăm " + docHaiChuSo(soHangChuc);
            }

            return ketQua;
        }

}

