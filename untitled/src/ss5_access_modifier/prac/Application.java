package ss5_access_modifier.prac;

public class Application {
    public static String language = "aaa";
    static{
        language = "bbbb";
    }

    public static void main(String[] args) {
        System.out.println(Application.language);
    }
}
