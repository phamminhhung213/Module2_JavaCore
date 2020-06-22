package CaseStudy_Module2.Commons;

import CaseStudy_Module2.Models.Customer;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class SortName implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getTenKhachHang().compareTo(o2.getTenKhachHang());
    }

}
