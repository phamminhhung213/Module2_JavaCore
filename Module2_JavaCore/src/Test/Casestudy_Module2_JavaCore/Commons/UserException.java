package Test.Casestudy_Module2_JavaCore.Commons;

public class UserException extends Exception {
    public UserException(String s) {
        super(s);
    }

    public static void genderException(String a) throws Exception, UserException {
        if (!a.trim().toLowerCase().equals("male") && !a.trim().toLowerCase().equals("female") && !a.trim().toLowerCase().equals("unknown")) {
            throw new UserException("Chi duoc nhap male,female,unknown");
        }
    }

    public static void nameException(String a) throws Exception, UserException {
        String regex = "^([A-Z][a-z]+ ?)+$";
        if (!a.matches(regex)) {
            throw new UserException("Nhap chu dau ghi hoa, cac chu sau ghi thuong");
        }
    }

    //    public static void idException(String a) throws Exception, UserException {
//        String regex = "^[0-9]{9}$";
//        if (!a.matches(regex)) {
//            throw new UserException("ID phai co 9 so.");
//        }
//    }
    public static void idException(String a) throws UserException {
        String regex = "^[0-9]{9}$";
        if (!a.matches(regex)) {
            throw new UserException("ID phai co 9 so.");
        }
    }
                                                    // DUNG HINH //
}
