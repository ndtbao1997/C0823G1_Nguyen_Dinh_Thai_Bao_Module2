package case_study_2.furama_resort.untils.validate;

import java.util.regex.Pattern;

public class FacilityInforExample {
    private static final String SERVICE_CODE_REGEX = "^SV(VL|HO|RO)-\\d{4}$";
    private static final String SERVICE_NAME_REGEX = "^[a-zA-Z\\s]+.*$";
    private static final String ROOM_STANDARDS_REGEX = "^[a-zA-Z\\s]+.*$";

    public static boolean validateServiceCode(String serviceCode) {
        return Pattern.matches(SERVICE_CODE_REGEX, serviceCode);
    }

    public static boolean validateServiceName(String serviceName) {
        return Pattern.matches(SERVICE_NAME_REGEX, serviceName);
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

    public static boolean validateRoomStandards(String roomStandards) {
        return Pattern.matches(ROOM_STANDARDS_REGEX, roomStandards);
    }

    public static boolean validateNumberOfFloors(Integer numberOfFloors) {
        return numberOfFloors > 0;
    }

    public static boolean validateSwimmingPoolArea(Double swimmingPoolArea) {
        return swimmingPoolArea >= 30;
    }
}
