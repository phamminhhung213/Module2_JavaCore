package Test.Casestudy_Module2_JavaCore.Commons;

import java.util.Scanner;
import java.util.regex.Pattern;

public class FuncValidation {
    private static String regex = "";
    private static Scanner scanner;

    //khong co flag
    public static <T> T checkValidate(String content, String errMes, String regex) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println(content);
                T inputValue;
                inputValue = (T) scanner.nextLine();
                if (inputValue.toString().matches(regex)) {
                    return (T) inputValue;
                } else {
                    System.out.println(errMes);
                }
            } catch (Exception e) {
                System.out.println(errMes);
                FuncValidation.checkValidate(content, errMes, regex);
            }
        }
    }
    //co flag
    public static <T> T checkValidate(String content, String errMes, String regex, Integer flag) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println(content);
                T inputValue;
               inputValue = (T) scanner.nextLine();
                if (Pattern.compile(regex,flag).matcher(inputValue.toString()).find()) {
                    return (T) inputValue;
                } else {
                    System.out.println(errMes);
                }
            } catch (Exception e) {
                System.out.println(errMes);
                FuncValidation.checkValidate(content, errMes, regex,flag);
            }
        }
    }

    //Check name validate
    public static boolean checkNameService(String str) {
        regex = "^[A-Z][a-z]+$";
        return str.matches(regex);
    }

    //check Number double

    public static double checkValidateNumberDouble(String content, String errMes) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println(content);
                return scanner.nextDouble();
            } catch (Exception e) {
                System.out.println(errMes);
            }
        }
    }

    public static int checkValidateNumberInt(String content, String errMes) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println(content);
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println(errMes);
            }
        }
    }
}
