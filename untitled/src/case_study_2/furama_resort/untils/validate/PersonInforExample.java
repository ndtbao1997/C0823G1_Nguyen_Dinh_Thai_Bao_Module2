package case_study_2.furama_resort.untils.validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonInforExample {
    private static final String NAME_REGEX = "^[a-zA-Z\\s]+.*$";
    private static final String DATE_OF_BIRTH_REGEX = "^(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((18|19|20|21)\\d\\d)$";
    private static final String NUMBER_CMND1_REGEX = "^\\d{9}$";
    private static final String NUMBER_CMND2_REGEX = "^\\d{12}$";
    private static final String PHONE_NUMBER_REGEX = "^0\\d{9}$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String EMPLOYEE_CODE_REGEX = "^NV-\\d{4}$";
    private static final String CUSTOMER_CODE_REGEX = "^KH-\\d{4}$";
    public static boolean validateName(String name){
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    public static boolean validateNumberCmnd(String numberCMND){
        Pattern pattern1 = Pattern.compile(NUMBER_CMND1_REGEX);
        Matcher matcher1 = pattern1.matcher(numberCMND);
        Pattern pattern2 = Pattern.compile(NUMBER_CMND2_REGEX);
        Matcher matcher2 = pattern2.matcher(numberCMND);
        return matcher1.matches() || matcher2.matches();
    }
    public static boolean validateDateOfBirth(String dateOfBirth){
        Pattern pattern = Pattern.compile(DATE_OF_BIRTH_REGEX);
        Matcher matcher = pattern.matcher(dateOfBirth);
        if (matcher.matches()){
            return checkAge(dateOfBirth);
        }
        return false;
    }

    private static boolean checkAge(String dateOfBirth) {
        String[] age = dateOfBirth.split("/");
        int day = Integer.parseInt(age[0]);
        int month = Integer.parseInt(age[1]);
        int year = Integer.parseInt(age[2]);
        if (2023 - year >= 19){
            return true;
        } else if (2023 - year == 18){
            if (11 > month){
                return true;
            } else if (11 == month){
                return 30 >= day;
            }
        }
        return false;
    }
    public static boolean validatePhoneNumber(String phoneNumber){
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    public static boolean validateMail(String mail){
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(mail);
        return matcher.matches();
    }
    public static boolean validateEmployeeCode(String employeeCode){
        Pattern pattern = Pattern.compile(EMPLOYEE_CODE_REGEX);
        Matcher matcher = pattern.matcher(employeeCode);
        return matcher.matches();
    }
    public static boolean validateEmployeeWage(Integer wage){
        return wage >= 0;
    }
    public static boolean validateCustomerCode(String customerCode){
        return Pattern.matches(CUSTOMER_CODE_REGEX,customerCode);
    }
}
