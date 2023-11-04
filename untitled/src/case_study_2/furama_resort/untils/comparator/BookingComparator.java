package case_study_2.furama_resort.untils.comparator;

import case_study_2.furama_resort.model.booking_contract.Booking;

import java.util.Comparator;
import java.util.Objects;

public class BookingComparator implements Comparator<Booking> {

    @Override
    public int compare(Booking o1, Booking o2) {
        String[] str1 = o1.getRentalStartDate().split("/");
        String[] str2 = o2.getRentalStartDate().split("/");
        String[] str3 = o1.getRentalEndDate().split("/");
        String[] str4 = o2.getRentalEndDate().split("/");
        if (Integer.parseInt(str1[2]) != Integer.parseInt(str2[2])){
            return Integer.compare(Integer.parseInt(str1[2]), Integer.parseInt(str2[1]));
        } else {
            if (Integer.parseInt(str1[1]) != Integer.parseInt(str2[1])){
                return Integer.compare(Integer.parseInt(str1[1]), Integer.parseInt(str2[1]));
            }else {
                if (Integer.parseInt(str1[0]) != Integer.parseInt(str2[0])){
                    return Integer.compare(Integer.parseInt(str1[0]), Integer.parseInt(str2[0]));
                } else {
                    if (Integer.parseInt(str3[2]) != Integer.parseInt(str4[2])){
                        return Integer.compare(Integer.parseInt(str3[2]), Integer.parseInt(str4[2]));
                    } else {
                        if (Integer.parseInt(str3[1]) != Integer.parseInt(str4[1])){
                            return Integer.compare(Integer.parseInt(str3[1]), Integer.parseInt(str4[1]));
                        } else {
                            return Integer.compare(Integer.parseInt(str3[2]), Integer.parseInt(str4[2]));
                        }
                    }
                }
            }
        }
    }
}
