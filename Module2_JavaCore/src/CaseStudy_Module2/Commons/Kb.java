package CaseStudy_Module2.Commons;

import java.util.Calendar;
import java.util.Scanner;

public class Kb {
    private static Scanner kb = new Scanner(System.in);

    public static String strString(String str, String strE, String pattern) {
        String strReturn;
        boolean inputError = false;
        do {
            if (inputError) {
                System.out.println(strE);
            }
            System.out.print(str);
            strReturn = (String) kb.nextLine();
            inputError = true;
        }
        while (!strReturn.matches(pattern));
        return strReturn;
    }

    public static String strString(String str) {
        System.out.print(str);
        return kb.nextLine();
    }

    public static int strInt(String str, String strE) {
        String Regex = "^[\\d]+$";
        int IntReturn;
        String StrReturn;
        boolean inputError = false;
        do {
            if (inputError) {
                System.out.println(strE);
            }
            System.out.println(str);
            StrReturn = kb.nextLine();
            inputError = true;

        } while (!StrReturn.matches(Regex));
        IntReturn = Integer.parseInt(StrReturn);
        return IntReturn;
    }

    public static double strDouble(String str, String strE) {

        String Regex = "^[\\d]+[.]{1}[\\d]+|[\\d]+$";
        double DoubleReturn;
        String StrReturn;
        boolean inputError = false;
        do {
            if (inputError) {
                System.out.println(strE);
            }
            System.out.println(str);
            StrReturn = kb.nextLine();
            inputError = true;

        } while (!StrReturn.matches(Regex));
        DoubleReturn = Double.parseDouble(StrReturn);
        return DoubleReturn;
    }
    public static String strString(String str, String strE, String pattern, boolean irrespectiveUpperLower){
        String strReturn;
        if(irrespectiveUpperLower) {
            boolean inputError = false;
            do {
                if (inputError) {
                    System.out.println(strE);
                }
                System.out.print(str);
                strReturn = kb.nextLine().toLowerCase();

                inputError = true;
            }
            while (!strReturn.matches(pattern));
            return strReturn.substring(0,1).toUpperCase().concat(strReturn.substring(1));
        }
        else return Kb.strString(str,strE,pattern);
    }
    public static String birthdayException(String str, String strE) {
        String regexDate="^[\\d]{2}/[\\d]{2}/[\\d]{4}";
        boolean birthday = false;
        String strBirthday=null;
        while (!birthday) {
            birthday = true;
            strBirthday = Kb.strString(str, strE, regexDate);
            int yearBrithday = Integer.parseInt(strBirthday.substring(6,10));
            int monthBrithday = Integer.parseInt(strBirthday.substring(3,4));
            int dateBrithday = Integer.parseInt(strBirthday.substring(0,1));
            if (yearBrithday > 1900) {
                Calendar dateNew = Calendar.getInstance();
                dateNew.add(Calendar.YEAR, -18);
                if (dateNew.get(Calendar.YEAR) > yearBrithday) {
                    continue;
                }else if (dateNew.get(Calendar.YEAR) == yearBrithday && dateNew.get(Calendar.MONTH) > monthBrithday){
                    continue;
                } else if(dateNew.get(Calendar.MONTH) == monthBrithday && dateNew.get(Calendar.DATE) > dateBrithday){
                    continue;
                }
            }
            birthday = false;
            System.out.println(strE);
        }
        return strBirthday;
    }



}
