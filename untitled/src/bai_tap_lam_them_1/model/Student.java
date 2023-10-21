package bai_tap_lam_them_1.model;

public class Student extends Person{
    private String className = "C0823G1";
    private int scores = 5;
    public Student(){}

    public Student(String className, int scores) {
        this.className = className;
        this.scores = scores;
    }

    public Student(String id, String name, String dateOfBirth, String gender, String className, int scores) {
        super(id, name, dateOfBirth, gender);
        this.className = className;
        this.scores = scores;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Student{" +
                "className='" + className + '\'' +
                ", scores=" + scores + ", " +super.toString() +
                "} ";
    }
}
