package ss18_string_regex.exec.name_class;

public class NameClassExampleTest {
    public static void main(String[] args) {
        NameClassExample nameClassExample = new NameClassExample();
        String[] nameClass = new String[]{"C0223G", "A0323K", "M0318G", "P0323A"};
        for (String string : nameClass) {
            System.out.println(nameClassExample.validate(string));
        }
    }
}
