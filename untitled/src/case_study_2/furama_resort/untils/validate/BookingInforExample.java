package case_study_2.furama_resort.untils.validate;

import java.util.regex.Pattern;

public class BookingInforExample {
    private static final String DATE_REGEX = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((18|19|20|21)\\d\\d)$";
    private static final String SOME_CONTRACTS_REGEX = "^\\d{5}$";

    public static boolean validateSomeContracts(String someContracts) {
        return Pattern.matches(SOME_CONTRACTS_REGEX, someContracts);
    }

    public static boolean validateRentalDate(String rental1, String rental2) {
        return (Pattern.matches(DATE_REGEX, rental1) && checkRentalDate(rental1, rental2));
    }

    public static boolean checkRentalDate(String rental1, String rental2) {
        String[] rental2Arr = rental2.split("/");
        String[] rental1Arr = rental1.split("/");
        if (Integer.parseInt(rental1Arr[2]) > Integer.parseInt(rental2Arr[2])) {
            return true;
        } else if (Integer.parseInt(rental1Arr[2]) == Integer.parseInt(rental2Arr[2])) {
            if (Integer.parseInt(rental1Arr[1]) > Integer.parseInt(rental2Arr[1])) {
                return true;
            } else if (Integer.parseInt(rental1Arr[1]) == Integer.parseInt(rental2Arr[1])) {
                return Integer.parseInt(rental1Arr[0]) >= Integer.parseInt(rental2Arr[0]);
            }
        }
        return false;
    }
}
