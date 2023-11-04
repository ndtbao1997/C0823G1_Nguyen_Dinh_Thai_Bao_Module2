package case_study_2.furama_resort.untils.validate;

import java.util.regex.Pattern;

public class FacilityInforExample {
    private static final String SERVICE_CODE_REGEX = "^SV(VL|HO|RO)-\\d{4}$";

    public static boolean validateServiceCode(String serviceCode) {
        return Pattern.matches(SERVICE_CODE_REGEX, serviceCode);
    }
    public static boolean validateUsableArea(Double usableArea) {
        return usableArea >= 30;
    }

    public static boolean validateRentalCosts(Double rentalCosts) {
        return rentalCosts > 0;
    }

    public static boolean validateMaxPeople(Integer maxPeople) {
        return maxPeople > 0 && maxPeople < 20;
    }

    public static boolean validateNumberOfFloors(Integer numberOfFloors) {
        return numberOfFloors > 0;
    }

    public static boolean validateSwimmingPoolArea(Double swimmingPoolArea) {
        return swimmingPoolArea >= 30;
    }
}
