package ss5_AccessModifier.exec.ClassJava;

public class Students {
    private String name = "Join";
    private String classes = "C02";
    Students(){
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "name : " + this.name + ". " + "classes : " + this.classes;
    }
}
