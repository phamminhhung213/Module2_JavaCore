package CaseStudy_Module2.Commons;
import CaseStudy_Module2.Models.Customer;
import CaseStudy_Module2.Models.Villa;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FunFileCSVBooking {
    public static final String COMMA_DELIMITER = ",";
    public static final String NEW_LINE_SEPARATOR = "\n";
    public static final String fileNameBooking = "src/CaseStudy_Module2/Data/Booking.csv";
    public static final String FILE_HEADER_BOOKING = "hoTenKhachHang,ngaySinh,gioiTinh,soCMND,SDT,email,loaiKhach,diaChi";

    public static void writeBookingToFileCSV(ArrayList<Customer> listCustomer) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNameBooking);
            fileWriter.append(FILE_HEADER_BOOKING);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Customer customer : listCustomer) {
                fileWriter.append(customer.getTenKhachHang());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getNgaySinh());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getGioiTinh());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getSoCMND());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getSDT());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getEmail());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getLoaiKhach());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getDiaChi());
                fileWriter.append(COMMA_DELIMITER);

                //------------------------------------------

                fileWriter.append(customer.getServiceUsageProperties().getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getServiceUsageProperties().getTenDichVu());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(customer.getServiceUsageProperties().getDienTichSuDung()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(customer.getServiceUsageProperties().getChiPhiThue()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(customer.getServiceUsageProperties().getSoLuongNguoiToiDa()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(customer.getServiceUsageProperties().getKieuThue()));
                fileWriter.append(NEW_LINE_SEPARATOR);



            }


        } catch (Exception ex) {
            System.out.println("Erros in file CSVFileWrite !!!");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception ex) {
                System.out.println("Erros when flush or close");

            }
        }

    }

    public static ArrayList<Customer> getFileCSVToListBooking() {
        BufferedReader br = null;
        ArrayList<Customer> listCustomer = new ArrayList<Customer>();
        Path path = Paths.get(fileNameBooking);

        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(fileNameBooking);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            br = new BufferedReader(new FileReader(fileNameBooking));
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("hoTenKhachHang")) {
                    continue;
                }
                Customer customer = new Customer();
                customer.setTenKhachHang(splitData[0]);
                customer.setNgaySinh(splitData[1]);
                customer.setGioiTinh(splitData[2]);
                customer.setSoCMND(splitData[3]);
                customer.setSDT(splitData[4]);
                customer.setEmail(splitData[5]);
                customer.setLoaiKhach(splitData[6]);
                customer.setDiaChi(splitData[7]);

                Villa villa = new Villa();
                villa.setId(splitData[8]);
                villa.setTenDichVu(splitData[9]);
                villa.setDienTichSuDung(Double.parseDouble(splitData[10]));
                villa.setChiPhiThue(Double.parseDouble(splitData[11]));
                villa.setSoLuongNguoiToiDa(Integer.parseInt(splitData[12]));
                villa.setKieuThue(splitData[13]);
                customer.setServiceUsageProperties(villa);

                listCustomer.add(customer);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return listCustomer;

        }
    }

}
