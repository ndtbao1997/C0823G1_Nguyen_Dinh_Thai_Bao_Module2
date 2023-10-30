package ss18_string_regex.exec.name_class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameClassExample {
    private static final String NAME_CLASS_REGEX = "^[CAP]\\d{4}[GHIK]$";
    public boolean validate(String regex){
        Pattern pattern = Pattern.compile(NAME_CLASS_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return  matcher.matches();
    }
}
