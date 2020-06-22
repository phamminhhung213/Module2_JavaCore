package CaseStudy_Module2.Commons;

import CaseStudy_Module2.Models.Room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FunFileCSVRoom {
    public static final String COMMA_DELIMITER = ",";
    public static final String NEW_LINE_SEPARATOR = "\n";
    public static final String fileNameRoom = "src/CaseStudy_Module2/Data/Room.csv";
    public static final String FILE_HEADER_ROOM = "id,tenDichVu,dienTichSuDung,chiPhiThue,soLuongNguoiToiDa,kieuThue,DichVuMienPhiDiKem";

    public static void writeRoomToFileCSV(ArrayList<Room> listRoom) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNameRoom);
            fileWriter.append(FILE_HEADER_ROOM);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Room room : listRoom) {
                fileWriter.append(room.getId());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(room.getTenDichVu());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(room.getDienTichSuDung()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(room.getChiPhiThue()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(room.getSoLuongNguoiToiDa()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(room.getKieuThue()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(room.getDichVuMienPhiDiKem()));
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

    public static ArrayList<Room> getFileCSVToListRoom() {
        BufferedReader br = null;
        ArrayList<Room> listRoom = new ArrayList<Room>();
        Path path = Paths.get(fileNameRoom);


        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(fileNameRoom);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            br = new BufferedReader(new FileReader(fileNameRoom));
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("id")) {
                    continue;
                }
                Room room = new Room();
                room.setId(splitData[0]);
                room.setTenDichVu(splitData[1]);
                room.setDienTichSuDung(Double.parseDouble(splitData[2]));
                room.setChiPhiThue(Double.parseDouble(splitData[3]));
                room.setSoLuongNguoiToiDa(Integer.parseInt(splitData[4]));
                room.setKieuThue(splitData[5]);
                room.setDichVuMienPhiDiKem(splitData[6]);
                listRoom.add(room);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return listRoom;

        }
    }

}
