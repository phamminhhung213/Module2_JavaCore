package CaseStudy_Module2.Commons;

import CaseStudy_Module2.Models.Employee;

import java.util.ArrayList;
import java.util.Stack;


public class FileCabinet {
    public static Stack<Employee> addFileEmployment() {
        ArrayList<Employee> listEmployee;
        listEmployee = FunFileCSVEmployee.getFileCSVToListEmployee();
        Stack<Employee> listFile = new Stack<Employee>();
        for (int i = 0; i <listEmployee.size(); i++) {
            listFile.push(listEmployee.get(i));
        }
        return listFile;

    }

}
