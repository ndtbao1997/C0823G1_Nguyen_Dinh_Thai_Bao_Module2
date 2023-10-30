package ss18_string_regex.exec.phone_number;

public class PhoneNumberExampleTest {
    public static void main(String[] args) {
        PhoneNumberExample phoneNumberExample = new PhoneNumberExample();
        String[] phoneNumber = new String[]{"(84)-(0978489648)", "(a8)-(22222222)", "(84)-(22b22222)", "(84)-(9978489648)"};
        for (String phone : phoneNumber) {
            System.out.println(phoneNumberExample.validate(phone));
        }
    }
}
