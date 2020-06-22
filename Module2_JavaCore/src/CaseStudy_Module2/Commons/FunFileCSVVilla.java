package CaseStudy_Module2.Commons;

import CaseStudy_Module2.Models.Villa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Format;
import java.util.ArrayList;
import java.util.Arrays;

public class FunFileCSVVilla {
    public static final String COMMA_DELIMITER = ",";
    public static final String NEW_LINE_SEPARATOR = "\n";
    public static final String fileNameVilla = "src/CaseStudy_Module2/Data/Villa.csv";

    public static final String FILE_HEADER_VILLA = "id,tenDichVu,dienTichSuDung,chiPhiThue,soLuongNguoiToiDa,kieuThue,tieuChuanPhong,moTaTienNghiKhac,dienTichHoBoi,soTang";

    public static void writeVillaToFileCSV(ArrayList<Villa> listVilla) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNameVilla);
            fileWriter.append(FILE_HEADER_VILLA);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Villa villa : listVilla) {
                fileWriter.append(villa.getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getTenDichVu());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getDienTichSuDung()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getChiPhiThue()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getSoLuongNguoiToiDa()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getKieuThue()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getTieuChuanPhong());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getMoTaTienNghiKhac());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getDienTichHoBoi()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getSoTang()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }


        } catch (Exception ex) {
            System.out.println("Erros in file CSVFileWrite !!!");
//            try {
//                fileWriter.flush();
//                fileWriter.close();
//            } catch (Exception ex1) {
//                System.out.println("Erros when flush or close");
//
//            }
        }
        finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception ex) {
                System.out.println("Erros when flush or close");

            }
        }

    }

    public static ArrayList<Villa> getFileCSVToListVilla() {
        BufferedReader br = null;
        ArrayList<Villa> listVilla = new ArrayList<Villa>();
        Path path = Paths.get(fileNameVilla);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(fileNameVilla);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            br = new BufferedReader(new FileReader(fileNameVilla));
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("id")) {
                    continue;
                }
                Villa villa = new Villa();
                villa.setId(splitData[0]);
                villa.setTenDichVu(splitData[1]);
                villa.setDienTichSuDung(Double.parseDouble(splitData[2]));
                villa.setChiPhiThue(Double.parseDouble(splitData[3]));
                villa.setSoLuongNguoiToiDa(Integer.parseInt(splitData[4]));
                villa.setKieuThue(splitData[5]);
                villa.setTieuChuanPhong(splitData[6]);
                villa.setMoTaTienNghiKhac(splitData[7]);
                villa.setDienTichHoBoi(Double.parseDouble(splitData[8]));
                villa.setSoTang(Integer.parseInt(splitData[9]));
                listVilla.add(villa);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return listVilla;

        }
    }

}
