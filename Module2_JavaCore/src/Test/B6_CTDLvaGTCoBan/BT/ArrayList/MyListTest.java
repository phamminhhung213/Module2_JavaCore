package Test.B6_CTDLvaGTCoBan.BT.ArrayList;

public class MyListTest {
    public static class Student {
        private int id;
        private String name;
        public Student() {
        }
        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student a = new Student(1, "Quoc");
        Student b = new Student(2, "Hung");
        Student c = new Student(3, "Thong");
        Student d = new Student(4, "Cuong");
        Student e = new Student(5, "Hoa");
        Student f = new Student(6, "Tan");
        MyList<Student> studentMyList = new MyList<>();
        MyList<Student> newStudentMyList = new MyList<>();
        studentMyList.add(a);
        studentMyList.add(b);
        studentMyList.add(c);
        studentMyList.add(d);
        studentMyList.add(2,e);
//        for (int i = 0; i < studentMyList.size(); i++) {
//            Student student = (Student)studentMyList.elements[i];
//            System.out.println(student.getId());
//            System.out.println(student.getName());
//        }
//        System.out.println(studentMyList.size());
//        studentMyList.clear();
//        System.out.println(studentMyList.size());
        System.out.println(studentMyList.get(3).getId());
        System.out.println(studentMyList.get(3).getName());
        System.out.println(studentMyList.indexOf(b));
        System.out.println(studentMyList.contains(f));
        newStudentMyList = studentMyList.clone();
        System.out.println(newStudentMyList);
//        for (int i = 0; i < newStudentMyList.size(); i++) {
//            Student student = (Student)newStudentMyList.elements[i];
//            System.out.print(student.getId()+"\t");
//            System.out.println(student.getName());
//        }
        newStudentMyList.remove(1);
        for (int i = 0; i < newStudentMyList.size(); i++) {
            Student student = (Student)newStudentMyList.elements[i];
            System.out.print(student.getId()+"\t");
            System.out.println(student.getName());
        }





    }
}
