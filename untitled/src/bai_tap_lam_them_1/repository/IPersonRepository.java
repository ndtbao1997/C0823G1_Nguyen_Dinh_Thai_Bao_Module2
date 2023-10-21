package bai_tap_lam_them_1.repository;

public interface IPersonRepository {
    void addStudent(String id, String name, String dateOfBirth, String gender, String className, int scores);
    void addTeacher(String id, String name, String dateOfBirth, String gender, String level);
    void removeStudent(String id);
    void removeTeacher(String id);
    void displayStudents();
    void displayTeacher();
}
