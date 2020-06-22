package CaseStudy_Module2.Commons;

import CaseStudy_Module2.Models.House;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FunFileCSVHouse {
    public static final String COMMA_DELIMITER = ",";
    public static final String NEW_LINE_SEPARATOR = "\n";
    public static final String fileNameHouse = "src/CaseStudy_Module2/Data/House.csv";
    public static final String FILE_HEADER_HOUSE = "id,tenDichVu,dienTichSuDung,chiPhiThue,soLuongNguoiToiDa,kieuThue,tieuChuanPhong,moTaTienNghiKhac,soTang";

    public static void writeHouseToFileCSV(ArrayList<House> listHouse) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNameHouse);
            fileWriter.append(FILE_HEADER_HOUSE);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (House house : listHouse) {
                fileWriter.append(house.getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getTenDichVu());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getDienTichSuDung()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getChiPhiThue()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getSoLuongNguoiToiDa()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getKieuThue()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getTieuChuanPhong());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getMoTaTienNghiKhac());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getSoTang()));
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

    public static ArrayList<House> getFileCSVToListHouse() {
        BufferedReader br = null;
        ArrayList<House> listHouse = new ArrayList<House>();
        Path path = Paths.get(fileNameHouse);

        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(fileNameHouse);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            br = new BufferedReader(new FileReader(fileNameHouse));
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("id")) {
                    continue;
                }
                House house = new House();
                house.setId(splitData[0]);
                house.setTenDichVu(splitData[1]);
                house.setDienTichSuDung(Double.parseDouble(splitData[2]));
                house.setChiPhiThue(Double.parseDouble(splitData[3]));
                house.setSoLuongNguoiToiDa(Integer.parseInt(splitData[4]));
                house.setKieuThue(splitData[5]);
                house.setTieuChuanPhong(splitData[6]);
                house.setMoTaTienNghiKhac(splitData[7]);
                house.setSoTang(Integer.parseInt(splitData[8]));
                listHouse.add(house);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return listHouse;

        }
    }

}


