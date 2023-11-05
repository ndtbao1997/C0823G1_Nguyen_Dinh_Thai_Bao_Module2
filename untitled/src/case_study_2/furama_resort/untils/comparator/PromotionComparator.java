package case_study_2.furama_resort.untils.comparator;

import case_study_2.furama_resort.model.person.Customer;

import java.util.Comparator;

public class PromotionComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        String[] str1 = o1.getBookingDate().split("/");
        String[] str2 = o2.getBookingDate().split("/");
        if (Integer.parseInt(str1[2]) != Integer.parseInt(str2[2])) {
            return Integer.compare(Integer.parseInt(str1[2]), Integer.parseInt(str2[2]));
        } else if (Integer.parseInt(str1[1]) != Integer.parseInt(str2[1])) {
            return Integer.compare(Integer.parseInt(str1[1]), Integer.parseInt(str2[1]));
        } else {
            return Integer.compare(Integer.parseInt(str1[0]), Integer.parseInt(str2[0]));
        }
    }
}
