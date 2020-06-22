package CaseStudy_Module2.Controllers;

import CaseStudy_Module2.Commons.*;
import CaseStudy_Module2.Models.*;


import java.util.*;

public class MainControllers {
    private static ArrayList<Villa> listVilla = new ArrayList<Villa>();
    private static ArrayList<House> listHouse = new ArrayList<House>();
    private static ArrayList<Room> listRoom = new ArrayList<Room>();
    public static ArrayList<Customer> listCustomer = new ArrayList<Customer>();
    public static ArrayList<Customer> listBooking = new ArrayList<Customer>();
    private static String content = "";
    private static String errMes = "";
    public static Scanner kb = new Scanner(System.in);

    public static void displayMainMenu() {
        System.out.println("\n1. Add New Services: " +
                "\n2.	Show Services" +
                "\n3.	Add New Customer" +
                "\n4.	Show Information of Customer" +
                "\n5.	Add New Booking" +
                "\n6.	Add new employee" +
                "\n7.	Show Information of Employee" +
                "\n8.   Show information of customer bought ticket." +
                "\n9.   " +
                "\n10.	Exit"
        );
        switch (kb.nextInt()) {
            case 1:
                addNewServies();
                break;
            case 2:
                showServices();
                backDisplayMainMenu();
                break;

            case 3:
                addNewCustomer();
                backDisplayMainMenu();
                break;
            case 4:
                showInformationOfCustomer();
                backDisplayMainMenu();
                break;
            case 5:
                addNewBooking();
                backDisplayMainMenu();
                break;
            case 6:
                addNewEmployee();
                backDisplayMainMenu();
                break;
            case 7:
                showInfomationEmployee();
                backDisplayMainMenu();
                break;
            case 8:
                showInformationOfCustomerBoughtTicket();
                break;
            case 9:
                break;
            case 10:
                System.exit(0);
                break;
            default:
                System.out.println("False");
                backDisplayMainMenu();
        }
    }

    private static void backDisplayMainMenu() {
        System.out.println("\nEnrer để tiếp tục :");
        kb.nextLine();
        System.out.println("\n-----------------");
        displayMainMenu();
    }

    private static void addNewServies() {
        System.out.println("\n-----------------");
        System.out.println("\n1. Add New Villa" +
                "\n2.	Add New House" +
                "\n3.	Add New Room" +
                "\n4.	Back to menu" +
                "\n5.	Exit" + "\n"

        );

        switch (kb.nextInt()) {
            case 1:
                addNewVilla();
                break;
            case 2:
                addNewHouse();
                break;
            case 3:
                addNewRoom();
                break;
            case 4:
                displayMainMenu();
                System.out.println("\n-----------------");
                break;
            case 5:
                System.exit(0);
                System.out.println("\n-----------------");
                break;
            default:
                System.out.println("False");
                backDisplayMainMenu();
        }
    }

    private static void showServices() {
        System.out.println("\n1.	Show all Villa" +
                "\n2.	Show all House" +
                "\n3.	Show all Room" +
                "\n4.	Show All Name Villa Not Duplicate" +
                "\n5.	Show All Name House Not Duplicate" +
                "\n6.	Show All Name Name Not Duplicate" +
                "\n7.	Back to menu" +
                "\n8.	Exit"
        );
        switch (kb.nextInt()) {
            case 1:
                ShowAllVilla();
                break;
            case 2:
                ShowAllHouse();
                break;
            case 3:
                ShowAllRoom();
                break;
            case 4:
                ShowAllNameVilla();
                break;
            case 5:
                ShowAllNameHouse();
                break;
            case 6:
                ShowAllNameRoom();
                break;
            case 7:
                displayMainMenu();
                break;
            case 8:
                System.exit(0);
                break;
            default:
                System.out.println("False");
                backDisplayMainMenu();

        }

        System.out.println("Nhấn Enter để tiếp tục");
        kb.nextLine();
        displayMainMenu();

    }

    private static void addNewVilla() {
//        ArrayList<Villa> listVilla = new ArrayList<Villa>();
        ArrayList<Villa> listVilla = FunFileCSVVilla.getFileCSVToListVilla();
        Services villa = new Villa();
        //    villa.setId(UUID.randomUUID().toString().replace("-",""));
        ((Villa) villa).AddNewViila();
        listVilla.add((Villa) villa);
        FunFileCSVVilla.writeVillaToFileCSV(listVilla);
        displayMainMenu();
    }

    private static void addNewHouse() {
        ArrayList<House> listHouse = FunFileCSVHouse.getFileCSVToListHouse();
        Services house = new House();
        ((House) house).addNewHouse();
        listHouse.add((House) house);
        FunFileCSVHouse.writeHouseToFileCSV(listHouse);
        displayMainMenu();

    }

    private static void addNewRoom() {
        ArrayList<Room> listRoom = FunFileCSVRoom.getFileCSVToListRoom();
        Services room = new Room();
        ((Room) room).addNewRoom();
        listRoom.add((Room) room);
        FunFileCSVRoom.writeRoomToFileCSV(listRoom);
        displayMainMenu();

    }

    public static void ShowAllVilla() {
        ArrayList<Villa> listVilla = FunFileCSVVilla.getFileCSVToListVilla();
        for (Villa villa : listVilla) {
            System.out.println("-------------------");
            System.out.println(villa.showInfor());
            System.out.println("-------------------");
        }
        kb.nextLine();

    }

    public static void ShowAllHouse() {
        ArrayList<House> listHouse = FunFileCSVHouse.getFileCSVToListHouse();
        for (House house : listHouse) {
            System.out.println("-------------------");
            System.out.println(house.showInfor());
            System.out.println("-------------------");
        }
        kb.nextLine();
    }

    public static void ShowAllRoom() {
        ArrayList<Room> listRoom = FunFileCSVRoom.getFileCSVToListRoom();
        for (Room room : listRoom) {
            System.out.println("-------------------");
            System.out.println(room.showInfor());
            System.out.println("-------------------");
        }
        kb.nextLine();
    }


    public static void ShowAllNameVilla() {
        TreeSet<String> treeSetVilla = new TreeSet<>();
        ArrayList<Villa> listVilla = FunFileCSVVilla.getFileCSVToListVilla();
        for (Villa villa : listVilla) {
            treeSetVilla.add(villa.getTenDichVu());
        }
        for (String str : treeSetVilla) {
            System.out.println(str);
        }
        kb.nextLine();
    }

    public static void ShowAllNameHouse() {
        TreeSet<String> listTreesetHouse = new TreeSet<>();
        ArrayList<House> listHouse = FunFileCSVHouse.getFileCSVToListHouse();
        for (House house : listHouse) {
            listTreesetHouse.add(house.getTenDichVu());
        }
        for (String str : listTreesetHouse) {
            System.out.println(str);

        }
        kb.nextLine();
    }

    public static void ShowAllNameRoom() {
        TreeSet<String> listTreesetRoom = new TreeSet<>();
        ArrayList<Room> listRoom = FunFileCSVRoom.getFileCSVToListRoom();
        for (Room room : listRoom) {
            listTreesetRoom.add(room.getTenDichVu());
        }
        for (String str : listTreesetRoom) {
            System.out.println(str);
        }
        kb.nextLine();

    }

    public static void showInformationOfCustomer() {
        ArrayList<Customer> listCustomer = FunFileCSVCustomer.getFileCSVToListCustomer();
        // listCustomer.sort(new SortName());
        Collections.sort(listCustomer, new SortName());
        for (Customer customer : listCustomer) {
            System.out.println("-------------------");
            System.out.println(customer.showInfor());
            System.out.println("-------------------");

        }
        kb.nextLine();
    }

    public static void addNewCustomer() {
        ArrayList<Customer> listCustomer = FunFileCSVCustomer.getFileCSVToListCustomer();
        Customer customer = new Customer();
        customer.AddNewCustomer();
        listCustomer.add(customer);
        FunFileCSVCustomer.writeCustomerToFileCSV(listCustomer);
        displayMainMenu();
    }

    public static void addNewBooking() {
        listBooking = FunFileCSVBooking.getFileCSVToListBooking();
        listCustomer = FunFileCSVCustomer.getFileCSVToListCustomer();
        Collections.sort(listCustomer, new SortName());
        int i = 1;
        for (Customer cus : listCustomer) {
            System.out.println("\n----------------------------------");
            System.out.println("no: " + i);
            System.out.println(cus.showInfor());
            System.out.println("\n----------------------------------");
            i++;
        }
        System.out.println("Choose Customer Booking");
        Customer customer = listCustomer.get(kb.nextInt() - 1);
        System.out.println("\n1.Booking Villa." +
                "\n2.Booking House" +
                "\n3.Booking Room");
        System.out.println("Choose Services booking");
        int choose = kb.nextInt();
        switch (choose) {
            case 1:
                i = 1;
                listVilla = FunFileCSVVilla.getFileCSVToListVilla();
                for (Villa villa : listVilla) {
                    System.out.println("\n---------------------------------");
                    System.out.println("No: " + i);
                    System.out.println(villa.showInfor());
                    System.out.println("\n---------------------------------");
                    i++;
                }
                System.out.println("Choose villa Booking ");
                Villa villa = listVilla.get(kb.nextInt() - 1);
                customer.setServiceUsageProperties(villa);
                break;
            case 2:
                i = 1;
                listHouse = FunFileCSVHouse.getFileCSVToListHouse();
                for (House house : listHouse) {
                    System.out.println("\n---------------------------------");
                    System.out.println("No: " + i);
                    System.out.println(house.showInfor());
                    System.out.println("\n---------------------------------");
                    i++;
                }
                System.out.println("Choose house Booking ");
                House house = listHouse.get(kb.nextInt() - 1);
                customer.setServiceUsageProperties(house);

                break;
            case 3:
                i = 1;
                listRoom = FunFileCSVRoom.getFileCSVToListRoom();
                for (Room room : listRoom) {
                    System.out.println("\n---------------------------------");
                    System.out.println("No: " + i);
                    System.out.println(room.showInfor());
                    System.out.println("\n---------------------------------");
                    i++;
                }
                System.out.println("Choose room Booking ");
                Room room = listRoom.get(kb.nextInt() - 1);
                customer.setServiceUsageProperties(room);

                break;
            default:
                backDisplayMainMenu();
                break;
        }
//        listBooking=FuncReadFileCSV.getFileCSVToListBooking();
        listBooking.add(customer);
        FunFileCSVBooking.writeBookingToFileCSV(listBooking);
    }
public static void addNewEmployee() {
    Employee employee = new Employee();
    kb.nextLine();
    System.out.println("Nhập vào id nhân viên");
    employee.setIdNhanVien(kb.nextLine());
    System.out.println("Nhập vào tên nhân viên");
    employee.setTenNhanVien(kb.nextLine());
    System.out.println("Nhập vào tuổi :");
    employee.setTuoi(kb.nextInt());
    kb.nextLine();
    System.out.println("Nhập vào địa chỉ:");
    employee.setDiaChi(kb.nextLine());
    ArrayList<Employee> listEmployee = FunFileCSVEmployee.getFileCSVToListEmployee();
    listEmployee.add(employee);
    FunFileCSVEmployee.writeEmployeeToFileCSV(listEmployee);
    System.out.println("\nAdd Employee for: " + employee.getIdNhanVien() + "Successfully!!");
    kb.nextLine();
    backDisplayMainMenu();

}
public static void showInfomationEmployee() {
    ArrayList<Employee> listEmployee = FunFileCSVEmployee.getFileCSVToListEmployee();

//        for (Employee employee : listEmployee) {
    System.out.println("\n-----------------------");
    Map<String, Employee> map = new HashMap<>();
    map.put("001", listEmployee.get(0));
    map.put("002", listEmployee.get(1));
    map.put("003", listEmployee.get(2));
    map.put("004", listEmployee.get(3));
    map.put("005", listEmployee.get(4));
    map.put("006", listEmployee.get(5));
    map.put("007", listEmployee.get(6));
    map.put("008", listEmployee.get(7));
    map.put("009", listEmployee.get(8));
    map.put("010", listEmployee.get(9));
    Set<String> set = map.keySet();
    for (String key : set) {
        System.out.println("\n-----------------------");
        System.out.println("id:" + key + "\n" + map.get(key));
        System.out.println("\n-----------------------");
    }
    System.out.println("\n-----------------------");
    kb.nextLine();
    backDisplayMainMenu();
}
public static void showInformationOfCustomerBoughtTicket() {
    ArrayList<Customer> listCustomer = FunFileCSVCustomer.getFileCSVToListCustomer();
    int i = 1;
    for (Customer cus : listCustomer) {
        System.out.println("\n----------------------------------");
        System.out.println("no: " + i);
        System.out.println(cus.showInfor());
        System.out.println("\n----------------------------------");
        i++;
    }
    System.out.println("Choose Customer Booking");
    int count = listCustomer.size();
    Queue<Customer> queue = new LinkedList<>();
    do {
        int nhap = kb.nextInt();
        count--;
        queue.add(listCustomer.get(nhap-1));
        System.out.println("choose Customer continue  ");
    } while (count != 0);
    System.out.println("-------------------------------------");
    System.out.println("show information of Customer bought ticket");
    for (Customer item : queue) {
        System.out.println(item.showInfor());
        System.out.println("----------------------------------------");
    }
}
}


