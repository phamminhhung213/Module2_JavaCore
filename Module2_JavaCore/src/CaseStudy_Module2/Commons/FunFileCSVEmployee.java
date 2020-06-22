package CaseStudy_Module2.Commons;

import CaseStudy_Module2.Models.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class FunFileCSVEmployee {
    public static final String COMMA_DELIMITER = ",";
    public static final String NEW_LINE_SEPARATOR = "\n";
    public static final String fileNameEmployee = "src/CaseStudy_Module2/Data/Employee.csv";
    public static final String FILE_HEADER_EMPLOYEE = "idNhanVien,tenNhanVien,tuoi,diaChi";

    public static void writeEmployeeToFileCSV(ArrayList<Employee> listEmployee) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileNameEmployee);
            fileWriter.append(FILE_HEADER_EMPLOYEE);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Employee employee : listEmployee) {
                fileWriter.append(employee.getIdNhanVien());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(employee.getTenNhanVien());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(employee.getTuoi()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(employee.getDiaChi());
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

    public static ArrayList<Employee> getFileCSVToListEmployee() {
        BufferedReader br = null;
        ArrayList<Employee> listEmployee = new ArrayList<Employee>();
        Path path = Paths.get(fileNameEmployee);

        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(fileNameEmployee);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        try {
            String line;
            br = new BufferedReader(new FileReader(fileNameEmployee));
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("idNhanVien")) {
                    continue;
                }
                Employee employee = new Employee();
                employee.setIdNhanVien(splitData[0]);
                employee.setTenNhanVien(splitData[1]);
                employee.setTuoi(Integer.parseInt(splitData[2]));
                employee.setDiaChi((splitData[3]));

                listEmployee.add(employee);

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return listEmployee;

        }
    }
}
