package ss17_io_binary_file_serialization.exec.product_manager_binary_file.utils.validate.check_information;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InformationExample {
    private static final String NAME_REGEX = "^[A-Za-z\\s]+.*$";
    private static final String MANUFACTURER_REGEX = "^[A-Za-z0-9]+\\s*?.*$";
    private static final String DESCRIBE = "^[A-Za-z0-9]+\\s*?.*$";
    public static boolean validateName(String regex){
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return !matcher.matches();
    }
    public static boolean validateManufacturer(String regex){
        Pattern pattern = Pattern.compile(MANUFACTURER_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return !matcher.matches();
    }
    public static boolean validateDescripe(String regex){
        Pattern pattern = Pattern.compile(DESCRIBE);
        Matcher matcher = pattern.matcher(regex);
        return !matcher.matches();
    }
}
