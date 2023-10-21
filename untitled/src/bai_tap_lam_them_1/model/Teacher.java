package bai_tap_lam_them_1.model;

public class Teacher extends Person{
    private String level = "Cao đẳng";
    public Teacher(){}

    public Teacher(String level) {
        this.level = level;
    }

    public Teacher(String id, String name, String dateOfBirth, String gender, String level) {
        super(id, name, dateOfBirth, gender);
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "level='" + level + '\'' + ", " + super.toString() +
                "} " ;
    }
}
